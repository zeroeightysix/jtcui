package me.zeroeightsix.jtcui.manager;

import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.Point;
import me.zeroeightsix.jtcui.component.Component;

import java.util.ArrayList;

import static me.zeroeightsix.jtcui.JTC.getParentUp;
import static me.zeroeightsix.jtcui.JTC.getRealPosition;

/**
 * Created by 086 on 4/10/2018.
 */
public class ShiftingRenderManager implements RenderManager {

    JTC theJTC;

    public ShiftingRenderManager(JTC theJTC) {
        this.theJTC = theJTC;
    }

    @Override
    public void renderRecursive(Component component) {
        Pair<ArrayList<Component>, ArrayList<Component>> pair = new Pair<>(new ArrayList<>(), new ArrayList<>());
        populateRenderPair(pair, component);
        for (int i = 0; i < pair.key.size(); i++) {
            Component a = pair.key.get(i);
            Component b = pair.value.get(i);
            if (a != b) {
                int at = pair.key.indexOf(b);
                pair.key.remove(a);
                pair.key.add(at, a);
            }
        }

        for (Component c : pair.key) {
            Point point = getRealPosition(c);
            theJTC.render.translate(point.getX(), point.getY());
            theJTC.getComponentHandle(c).draw(c);
            theJTC.render.translate(-point.getX(), -point.getY());
        }
    }

    private void populateRenderPair(Pair<ArrayList<Component>, ArrayList<Component>> pair, Component component) {
        pair.key.add(component);
        pair.value.add(getParentUp(component, theJTC.getComponentHandle(component).getRenderLevel(component)));
        if (component.getChildren() != null) {
            for (Component c : component.getChildren()) populateRenderPair(pair, c);
        }
    }

    private class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}
