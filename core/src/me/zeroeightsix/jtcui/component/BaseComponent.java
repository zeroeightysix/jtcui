package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.Requirements;
import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;
import me.zeroeightsix.jtcui.layout.layouts.Layout;

import java.util.ArrayList;
import java.util.List;

/**
 * A basic implementation of {@link Component}
 *
 * @author 086
 * @see SimpleComponent
 * @see SimpleContainer
 */
public class BaseComponent implements Component {

    private final Space space;
    private final Requirements requirements;

    private Component parent;
    private Layout layout;
    private final ArrayList<MouseHandler> mouseHandlers = new ArrayList<>();

    public BaseComponent() {
        this(0, 0);
    }

    public BaseComponent(int x, int y) {
        this(x, y, 0, 0);
    }

    public BaseComponent(int x, int y, int width, int height) {
        this(x, y, width, height, 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public BaseComponent(int x, int y, int width, int height, int minWidth, int minHeight, int maxWidth, int maxHeight) {
        space = new Space(this, x, y, width, height);
        requirements = new Requirements(minWidth, minHeight, maxWidth, maxHeight);
    }

    @Override
    public Space getSpace() {
        return space;
    }

    @Override
    public Requirements getRequirements() {
        return requirements;
    }

    @Override
    public Component getParent() {
        return parent;
    }

    @Override
    public Component explore(double x, double y) {
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
