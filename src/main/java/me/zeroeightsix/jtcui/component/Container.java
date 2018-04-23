package me.zeroeightsix.jtcui.component;

import java.util.Collection;
import java.util.List;

/**
 * Created by 086 on 23/04/2018.
 */
public interface Container extends Component {

    List<Component> add(Component component);
    List<Component> addAll(Collection<Component> components);

}
