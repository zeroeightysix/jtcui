package me.zeroeightsix.jtcui.desktop.handle;

import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.handle.EmptyComponentHandle;

/**
 * Created by 086 on 21/10/2018.
 */
public class ColouredComponentHandle<S extends Component> extends EmptyComponentHandle<S> {

    private final float r;
    private final float g;
    private final float b;

    public ColouredComponentHandle(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public void draw(S component) {
        SimpleHandle.drawBox(component.getSpace(), r, g, b);
    }

}
