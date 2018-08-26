package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.JTC;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A container backed by an ArrayList
 *
 * @see BaseContainer
 * @see SimpleComponent
 * @author 086
 */
public class SimpleContainer extends ExplorableContainer {

    private final List<Component> components = new ArrayList<Component>() {

        private void update() {
            JTC.update(JTC.getRootParent(SimpleContainer.this));
        }

        @Override
        public boolean add(Component component) {
            component.setParent(SimpleContainer.this);
            boolean ret = super.add(component);
            update();
            return ret;
        }

        @Override
        public void add(int i, Component component) {
            component.setParent(SimpleContainer.this);
            super.add(i, component);
            update();
        }

        @Override
        public boolean addAll(Collection<? extends Component> collection) {
            collection.forEach(o -> o.setParent(SimpleContainer.this));
            boolean ret = super.addAll(collection);
            update();
            return ret;
        }

        @Override
        public boolean addAll(int i, Collection<? extends Component> collection) {
            collection.forEach(o -> o.setParent(SimpleContainer.this));
            boolean ret = super.addAll(i, collection);
            update();
            return ret;
        }
    };

    public SimpleContainer() {
    }

    public SimpleContainer(int x, int y) {
        super(x, y);
    }

    public SimpleContainer(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public List<Component> getChildren() {
        return components;
    }

}
