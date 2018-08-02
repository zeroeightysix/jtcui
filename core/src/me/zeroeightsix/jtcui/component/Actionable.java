package me.zeroeightsix.jtcui.component;

import java.util.function.Consumer;

/**
 * @author 086
 */
public interface Actionable<T extends Component> {

    void setOnAction(Consumer<T> consumer);

}
