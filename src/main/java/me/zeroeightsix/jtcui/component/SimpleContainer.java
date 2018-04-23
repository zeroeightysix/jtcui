package me.zeroeightsix.jtcui.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by 086 on 23/04/2018.
 * <br>
 * A container backed by an ArrayList
 */
public class SimpleContainer extends SimpleComponent implements Container {

    List<Component> components = new ArrayList<>();

    public SimpleContainer(int x, int y, Component parent) {
        super(x, y, parent);
    }

    @Override
    public List<Component> getChildren() {
        return components;
    }

    @Override
    public List<Component> addAll(Collection<Component> components) {
        this.components.addAll(components);
        return this.components;
    }

    @Override
    public List<Component> add(Component component) {
        components.add(component);
        return components;
    }
}
