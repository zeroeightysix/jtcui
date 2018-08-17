package me.zeroeightsix.jtcui;

import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.component.Container;
import me.zeroeightsix.jtcui.component.SimpleContainer;
import me.zeroeightsix.jtcui.exception.JTCMissingHandleException;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;
import me.zeroeightsix.jtcui.handle.RenderHandler;
import me.zeroeightsix.jtcui.layout.layouts.CenteredLayout;
import me.zeroeightsix.jtcui.layout.layouts.Layout;
import me.zeroeightsix.jtcui.layout.layouts.SelfSizingLayout;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Vector;

/**
 * Created by 086 on 23/04/2018.
 */
public class JTC {

    private static boolean updating = false;
    public MouseHandler mouse;
    public RenderHandler render;
    private final Container rootComponent = new JTCRootComponent();

    private final HashMap<Component, ComponentHandle> handleCache = new HashMap<>();
    private final HashMap<Class<? extends Component>, ComponentHandle> classComponentHandleHashMap = new HashMap<>();
    private final HashMap<Component, ComponentHandle> componentHandleHashMap = new HashMap<>();

    void setHandlers(RenderHandler render, MouseHandler mouse) {
        this.render = render;
        this.mouse = mouse;
    }

    /**
     * Request all components to be drawn in order
     */
    public void renderRecursive() {
        renderRecursive(getRootComponent());
        render.resetTranslation();
    }

    private void renderRecursive(Component component) {
        render.translate(component.getSpace().xProperty().get(), component.getSpace().yProperty().get());
        getComponentHandle(component).draw(component);
        if (component.getChildren() != null) {
            component.getChildren().forEach(this::renderRecursive);
        }
        render.translate(-component.getSpace().xProperty().get(), -component.getSpace().yProperty().get());
    }

    /**
     * Install a component handle by class
     *
     * @param clazz
     * @param handle
     * @param <T>
     */
    public <T extends Component> void install(Class<? extends T> clazz, ComponentHandle<? extends T> handle) {
        classComponentHandleHashMap.put(clazz, handle);
        handleCache.clear();
    }

    /**
     * Install a component handle for one specific component
     *
     * @param component
     * @param handle
     * @param <T>
     */
    public <T extends Component> void install(T component, ComponentHandle<T> handle) {
        componentHandleHashMap.put(component, handle);
        handleCache.clear();
    }

    public ComponentHandle getComponentHandle(Component component) {
        if (handleCache.containsKey(component)) return handleCache.get(component);

        ComponentHandle handle = component.getHandle();
        if (handle == null) {
            handle = componentHandleHashMap.get(component);
            if (handle == null) {
                handle = classComponentHandleHashMap.get(component.getClass());
                if (handle == null) {
                    if (component.getClass().isAnnotationPresent(Install.class)) {
                        Class<? extends ComponentHandle> handleClass = component.getClass().getAnnotation(Install.class).value();
                        try {
                            handle = handleClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        handle = classComponentHandleHashMap.entrySet().stream()
                                .filter(classComponentHandleEntry -> classComponentHandleEntry.getKey().isInstance(component))
                                .findAny()
                                .map(Map.Entry::getValue)
                                .orElse(null);
                        if (handle == null)
                            throw new JTCMissingHandleException(component);
                    }
                }
            }
        }
        handleCache.put(component, handle);
        return handle;
    }

    /**
     * Gets the x-position of this component relative to its highest parent
     * @param component
     * @return The x coordinate of the position found
     */
    public static int getRealX(Component component) {
        return getRealPosition(component).getX();
    }

    /**
     * Gets the y-position of this component relative to its highest parent
     * @param component
     * @return The y coordinate of the position found
     */
    public static int getRealY(Component component) {
        return getRealPosition(component).getY();
    }

    /**
     * Gets the position of this component relative to its highest parent
     * @param component
     * @return The position found
     */
    public static Point getRealPosition(Component component) {
        int x = 0, y = 0;
        while (component.getParent() != null) {
            x += component.getSpace().xProperty().get();
            y += component.getSpace().yProperty().get();
            component = component.getParent();
        }
        return new Point(x, y);
    }

    public static Component getRootParent(Component component) {
        while (component.getParent() != null) component = component.getParent();
        return component;
    }

    /**
     * Updates the root component
     */
    public void update() {
        update(getRootComponent());
    }

    public static void update(Component component) {
        if (updating) {
            return;
        }
        updating = true;
        deepUpdate(component);
        updating = false;
    }

    private static void deepUpdate(Component component) {
        Optional.ofNullable(component.getLayout()).ifPresent(layout -> layout.update(component));
        Optional.ofNullable(component.getChildren()).ifPresent(components -> components.forEach(JTC::deepUpdate));
    }

    /**
     * Get the root component of this JTC instance
     *
     * @return
     */
    public Container getRootComponent() {
        return rootComponent;
    }

    private class JTCRootComponent extends SimpleContainer {
        private final ComponentHandle handle;

        public JTCRootComponent() {
            super(0, 0);
            setLayout(new CenteredLayout(SelfSizingLayout.Type.EXPANDING));
            handle = new ComponentHandle() {
                @Override
                public void draw(Component component) {

                }

                @Override
                public void onMouse(Component component, MouseHandler.MouseAction action, int x, int y, int button) {

                }

                @Override
                public void onScroll(Component component, int scrolled, int x, int y) {

                }
            };
        }

        @Override
        public Component explore(double x, double y) {
            return exploreSelf(x, y);
        }

        @Override
        public ComponentHandle getHandle() {
            return handle;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Install {
        Class<? extends ComponentHandle> value();
    }

}
