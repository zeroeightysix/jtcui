package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.component.Container;

/**
 * @author 086
 */
public abstract class AbstractLayout implements Layout {

    private Component updating = null;

    public static Fat getFat(Component component) {
        return (component instanceof Container) ? ((Container) component).getFat() : Fat.NO_FAT;
    }

    @Override
    public void update(Component component) {
        if (component == updating) return;
        this.updating = component;
        organise(component);
        size(component);
        this.updating = null;
    }

    protected Space getSlimSpace(Component component) {
        return component.getSpace().withoutFat();
    }

}
