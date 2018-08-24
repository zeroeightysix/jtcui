package me.zeroeightsix.jtcui;

import me.zeroeightsix.jtcui.handle.JTCMouseHandler;
import me.zeroeightsix.jtcui.handle.MouseHandler;
import me.zeroeightsix.jtcui.handle.RenderHandler;

/**
 * Created by 086 on 23/05/2018.
 */
public class JTCBuilder {

    private RenderHandler renderHandler;
    private MouseHandler mouseHandler = null;

    private JTCBuilder(RenderHandler renderHandler) {
        this.renderHandler = renderHandler;
    }

    public static JTCBuilder builder(RenderHandler renderHandler) {
        return new JTCBuilder(renderHandler);
    }

    public JTCBuilder withRenderHandler(RenderHandler renderHandler) {
        this.renderHandler = renderHandler;
        return this;
    }

    public JTCBuilder withMouseHandler(MouseHandler mouseHandler) {
        this.mouseHandler = mouseHandler;
        return this;
    }

    public JTC build() {
        JTC jtc = new JTC();
        jtc.setHandlers(renderHandler, mouseHandler == null ? new JTCMouseHandler(jtc) : mouseHandler);
        return jtc;
    }

}
