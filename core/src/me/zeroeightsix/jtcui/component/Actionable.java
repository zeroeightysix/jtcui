package me.zeroeightsix.jtcui.component;

import java.util.function.Consumer;

/**
 * A actionable component is one which has an action bound to it which is ran when the user interacts with the component.
 *
 * @author 086
 */
public interface Actionable<T extends Component> {

    /**
     * Sets the action the component runs upon interaction
     *
     * @param action The action
     */
    void setOnAction(Consumer<T> action);

}
