package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;
import me.zeroeightsix.jtcui.layout.layouts.Layout;

import java.util.List;

/**
 * Created by 086 on 23/04/2018.
 */
public interface Component {

    int getX();
    int getY();
    int getWidth();
    int getHeight();
    int getMinimumWidth();
    int getMinimumHeight();
    void setX(int x);
    void setY(int y);
    void setWidth(int width);
    void setHeight(int height);
    void setMinimumWidth(int width);
    void setMinimumHeight(int height);

    Component getParent();
    List<Component> getChildren();
    Layout getLayout();
    ComponentHandle getHandle();
    List<MouseHandler> getMouseHandlers();

    void setParent(Component component);
    void setLayout(Layout layout);

    Component explore(int x, int y);

}
