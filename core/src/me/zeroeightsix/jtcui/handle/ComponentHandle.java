package me.zeroeightsix.jtcui.handle;

import me.zeroeightsix.jtcui.component.Component;

/**
 * Created by 086 on 23/05/2018.
 */
@SuppressWarnings("EmptyMethod")
public interface ComponentHandle<T extends Component> {

    void draw(T component);

    void onMouse(T component, MouseHandler.MouseAction action, int x, int y, int button);

    void onScroll(T component, int scrolled, int x, int y);

}
