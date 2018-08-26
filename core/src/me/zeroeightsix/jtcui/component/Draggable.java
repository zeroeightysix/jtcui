package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.Space;

/**
 * Marks a component as a draggable component
 *
 * @author 086
 */
public interface Draggable {

    /**
     * @return The space where the user may 'grab' this component in order to drag it around where the origin equals the origin of the component itself
     */
    Space getDragSpace();

}
