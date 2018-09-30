package me.zeroeightsix.jtcui.handle;

import me.zeroeightsix.jtcui.component.Component;

/**
 * A handle for a component
 *
 * @author 086
 */
public interface ComponentHandle<T extends Component> {

    ComponentHandle<Component> EMPTY_HANDLE = new ComponentHandle<Component>() {
        @Override
        public void draw(Component component) {}
        @Override
        public void onMouse(Component component, MouseHandler.MouseAction action, int x, int y, int button) {}
        @Override
        public void onScroll(Component component, int scrolled, int x, int y) {}

        @Override
        public int getRenderLevel(Component component) {
            return 0;
        }
    };

    void draw(T component);
    void onMouse(T component, MouseHandler.MouseAction action, int x, int y, int button);
    void onScroll(T component, int scrolled, int x, int y);

    int getRenderLevel(Component component);
}
