package me.zeroeightsix.jtcui.component;

import java.util.function.Consumer;

/**
 * @author 086
 */
interface Actionable<T extends Component> {

    void setOnAction(Consumer<T> consumer);

}
