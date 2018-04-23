package me.zeroeightsix.jtcui;

import me.zeroeightsix.jtcui.component.Container;
import me.zeroeightsix.jtcui.component.SimpleContainer;
import me.zeroeightsix.jtcui.handle.JTCMouseHandler;
import me.zeroeightsix.jtcui.layout.FixedLayout;

/**
 * Created by 086 on 23/04/2018.
 */
public class JTC {

    public final JTCMouseHandler mouse;
    private final Container rootComponent = new JTCRootComponent();

    /**
     * Create a new JTC object using the default handlers
     */
    public JTC() {
        mouse = new JTCMouseHandler(this);
    }

    /**
     * Create a new JTC object using your own handlers
     * @param mouse
     */
    public JTC(JTCMouseHandler mouse) {
        this.mouse = mouse;
    }

    private class JTCRootComponent extends SimpleContainer {
        public JTCRootComponent() {
            super(0,0,null);
            setLayout(new FixedLayout());
        }
    }
}
