package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.Fat;

/**
 * A component with {@link Fat} and that is expected to have a non-null value for {@link Component#getChildren()}
 *
 * @author 086
 */
public interface Container extends Component {

    /**
     * @return The fat for this container
     */
    Fat getFat();

}
