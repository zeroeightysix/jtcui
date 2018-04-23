package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.layout.layouts.Layout;

import java.util.List;

/**
 * Created by 086 on 23/04/2018.
 */
public interface Component {

    Component getParent();
    void setParent(Component component);
    List<Component> getChildren();

    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
    int getWidth();
    int getHeight();
    void setWidth(int width);
    void setHeight(int height);

    Layout getLayout();
    void setLayout(Layout layout);

}
