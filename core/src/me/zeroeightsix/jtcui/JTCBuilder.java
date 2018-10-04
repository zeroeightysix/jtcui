package me.zeroeightsix.jtcui;

import me.zeroeightsix.jtcui.handle.JTCInputHandler;
import me.zeroeightsix.jtcui.handle.InputHandler;
import me.zeroeightsix.jtcui.handle.RenderHandler;
import me.zeroeightsix.jtcui.manager.RecursiveRenderManager;

/**
 * @author 086
 */
public class JTCBuilder {

    private RenderHandler renderHandler;
    private InputHandler inputHandler = null;

    JTCBuilder(RenderHandler renderHandler) {
        this.renderHandler = renderHandler;
    }

    public static JTCBuilder builder(RenderHandler renderHandler) {
        return new JTCBuilder(renderHandler);
    }

    public JTCBuilder withRenderHandler(RenderHandler renderHandler) {
        this.renderHandler = renderHandler;
        return this;
    }

    public JTCBuilder withInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        return this;
    }

    public JTC build() {
        JTC jtc = new JTC();
        jtc.render = renderHandler;
        jtc.input = inputHandler == null ? new JTCInputHandler(jtc) : inputHandler;
        jtc.renderManager = new RecursiveRenderManager(jtc);
        return jtc;
    }

}
