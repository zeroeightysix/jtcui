package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.component.Container;

/**
 * Abstract implementation of {@link Layout}.
 *
 * @author 086
 */
public abstract class AbstractLayout implements Layout {

    public static Fat getFat(Component component) {
        return (component instanceof Container) ? ((Container) component).getFat() : Fat.NO_FAT;
    }

    protected Space getSlimSpace(Component component) {
        return component.getSpace().withoutFat();
    }

}
