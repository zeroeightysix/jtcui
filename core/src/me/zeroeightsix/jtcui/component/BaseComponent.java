package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;
import me.zeroeightsix.jtcui.layout.layouts.Layout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 086 on 23/04/2018.
 */
public class BaseComponent implements Component {

    private int x, y, width, height, minimumWidth, minimumHeight;
    private Component parent;
    private Layout layout;
    private ArrayList<MouseHandler> mouseHandlers = new ArrayList<>();

    public BaseComponent() {
        this(0,0);
    }

    public BaseComponent(int x, int y) {
        setX(x);
        setY(y);
    }

    public BaseComponent(int x, int y, int width, int height) {
        this(x, y);
        setWidth(width);
        setHeight(height);
    }

    @Override
    public Component getParent() {
        return parent;
    }

    @Override
    public Component explore(int x, int y) {
        return this;
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
    public int getMinimumWidth() {
        return minimumWidth;
    }

    @Override
    public int getMinimumHeight() {
        return minimumHeight;
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
    public void setMinimumHeight(int minimumHeight) {
        this.minimumHeight = minimumHeight;
    }

    @Override
    public void setMinimumWidth(int minimumWidth) {
        this.minimumWidth = minimumWidth;
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

    @Override
    public ComponentHandle getHandle() {
        return null;
    }

    @Override
    public ArrayList<MouseHandler> getMouseHandlers() {
        return mouseHandlers;
    }

}
