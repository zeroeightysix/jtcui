package me.zeroeightsix.jtcui;

import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.component.Container;
import me.zeroeightsix.jtcui.component.SimpleContainer;
import me.zeroeightsix.jtcui.exception.JTCMissingHandleException;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.JTCMouseHandler;
import me.zeroeightsix.jtcui.handle.MouseHandler;
import me.zeroeightsix.jtcui.handle.RenderHandler;
import me.zeroeightsix.jtcui.layout.layouts.FixedLayout;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 086 on 23/04/2018.
 */
public class JTC {

    public final MouseHandler mouse;
    public final RenderHandler render;
    private final Container rootComponent = new JTCRootComponent();
    private final HashMap<Class<? extends Component>, ComponentHandle> classComponentHandleHashMap = new HashMap<>();
    private final HashMap<Component, ComponentHandle> componentHandleHashMap = new HashMap<>();

    /**
     * Create a new JTC object using the default handlers
     */
    public JTC(RenderHandler render) {
        this.render = render;
        mouse = new JTCMouseHandler();
    }

    /**
     * Create a new JTC object using your own handlers
     * @param mouse
     */
    public JTC(RenderHandler render, MouseHandler mouse) {
        this.render = render;
        this.mouse = mouse;
    }

    /**
     * Render the current scene
     */
    public void render() {
        this.render.render(this);
    }

    /**
     * Install a component handle by class
     * @param clazz
     * @param handle
     * @param <T>
     */
    public <T extends Component> void install(Class<? extends T> clazz, ComponentHandle<? extends T> handle) {
        classComponentHandleHashMap.put(clazz, handle);
    }

    /**
     * Install a component handle for one specific component
     * @param component
     * @param handle
     * @param <T>
     */
    public <T extends Component> void install(T component, ComponentHandle<T> handle) {
        componentHandleHashMap.put(component, handle);
    }

    public ComponentHandle getComponentHandle(Component component) {
        ComponentHandle handle = component.getHandle();
        if (handle == null) {
            handle = componentHandleHashMap.get(component);
            if (handle == null) {
                handle = classComponentHandleHashMap.get(component.getClass());
                if (handle == null) {
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
        return handle;
    }

    /**
     * Get the root component of this JTC instance
     * @return
     */
    public Container getRootComponent() {
        return rootComponent;
    }

    private class JTCRootComponent extends SimpleContainer {
        private final ComponentHandle handle;

        public JTCRootComponent() {
            super(0,0);
            setLayout(new FixedLayout());
            handle = new ComponentHandle() {
                @Override
                public void draw(Component component) {

                }

                @Override
                public int getDefaultWidth(Component component) {
                    return 0;
                }

                @Override
                public int getDefaultHeight(Component component) {
                    return 0;
                }
            };
        }

        @Override
        public ComponentHandle getHandle() {
            return handle;
        }
    }
}
