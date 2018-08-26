package me.zeroeightsix.jtcui.desktop.handle;

import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20;
import me.zeroeightsix.jtcui.component.DirectionalSpacedContainer;
import me.zeroeightsix.jtcui.desktop.Launcher;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;
import org.lwjgl.opengl.GL11;

/**
 * @author 086
 */
public class DBoxHandle implements ComponentHandle<DirectionalSpacedContainer> {

    ImmediateModeRenderer20 renderer = new ImmediateModeRenderer20(false, true, 0);

    @Override
    public void draw(DirectionalSpacedContainer component) {
        float tX = Launcher.camera.position.x;
        float tY = Launcher.camera.position.y;
        int width = (int) component.getSpace().widthProperty().get();
        int height = (int) component.getSpace().heightProperty().get();
        renderer.begin(Launcher.camera.combined, GL11.GL_QUADS);
        renderer.color(.4f, .121f, 1, 1);
        renderer.vertex(tX, tY, 0);
        renderer.color(.4f, .121f, 1, 1);
        renderer.vertex(tX + width, tY, 0);
        renderer.color(.4f, .121f, 1, 1);
        renderer.vertex(tX + width, tY + height, 0);
        renderer.color(.4f, .121f, 1, 1);
        renderer.vertex(tX, tY + height, 0);
        renderer.end();
    }

    @Override
    public void onMouse(DirectionalSpacedContainer component, MouseHandler.MouseAction action, int x, int y, int button) {

    }

    @Override
    public void onScroll(DirectionalSpacedContainer component, int scrolled, int x, int y) {

    }

}
