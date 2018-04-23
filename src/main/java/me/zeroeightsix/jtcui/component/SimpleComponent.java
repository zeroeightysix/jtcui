package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.layout.layouts.Layout;
import me.zeroeightsix.jtcui.layout.layouts.ParentLayout;

import java.util.List;

/**
 * Created by 086 on 23/04/2018.
 */
public class SimpleComponent implements Component {

    private int x,y,width,height;
    private Component parent;
    private Layout layout;

    public SimpleComponent(int x, int y, Component parent) {
        setX(x);
        setY(y);
        setParent(parent);
        setLayout(new ParentLayout(getParent().getLayout()));
    }

    @Override
    public Component getParent() {
        return parent;
    }

    public void setParent(Component parent) {
        this.parent = parent;
    }

    @Override
    public List<Component> getChildren() {
        return null;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public Layout getLayout() {
        return layout;
    }

    @Override
    public void setLayout(Layout layout) {
        this.layout = layout;
    }
}
