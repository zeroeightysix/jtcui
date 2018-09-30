package me.zeroeightsix.jtcui.handle;

import me.zeroeightsix.jtcui.component.Component;

/**
 * Created by 086 on 30/09/2018.
 */
public class EmptyComponentHandle<S extends Component> implements ComponentHandle<S> {
    @Override
    public void draw(S component) {
    }

    @Override
    public void onMouse(S component, MouseHandler.MouseAction action, int x, int y, int button) {
    }

    @Override
    public void onKey(S component, KeyHandler.KeyAction action, int key, char keyChar) {
    }

    @Override
    public void onScroll(S component, int scrolled, int x, int y) {
    }

    @Override
    public int getRenderLevel(S component) {
        return 0;
    }
}
