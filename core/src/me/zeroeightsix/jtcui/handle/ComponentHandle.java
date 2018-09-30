package me.zeroeightsix.jtcui.handle;

import me.zeroeightsix.jtcui.component.Component;

/**
 * A handle for a component
 *
 * @author 086
 */
public interface ComponentHandle<T extends Component> {

    EmptyComponentHandle EMPTY_HANDLE = new EmptyComponentHandle();

    void draw(T component);
    void onMouse(T component, MouseHandler.MouseAction action, int x, int y, int button);
    void onKey(T component, KeyHandler.KeyAction action, int key, char keyChar);
    void onScroll(T component, int scrolled, int x, int y);

    int getRenderLevel(T component);
}
