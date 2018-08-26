package me.zeroeightsix.jtcui.desktop.handle;

/**
 * @author 086
 */

import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20;
import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.desktop.Launcher;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import org.lwjgl.opengl.GL11;

public abstract class SimpleHandle<T extends Component> implements ComponentHandle<T> {

    ImmediateModeRenderer20 renderer = new ImmediateModeRenderer20(false, true, 0);

    @Override
    public void draw(T component) {
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
}
