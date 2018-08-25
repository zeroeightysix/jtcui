package me.zeroeightsix.jtcui.desktop.component;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20;
import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.component.BorderedContainer;
import me.zeroeightsix.jtcui.desktop.Launcher;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;
import me.zeroeightsix.jtcui.layout.layouts.CenteredLayout;
import me.zeroeightsix.jtcui.layout.layouts.SelfSizingLayout;
import me.zeroeightsix.jtcui.layout.layouts.VerticalLayout;
import org.lwjgl.opengl.GL11;

/**
 * @author 086
 */
@JTC.Install(VBox.VBoxHandle.class)
public class VBox extends BorderedContainer {

    public VBox() {
        this(Fat.NO_FAT);
    }

    public VBox(Fat fat) {
        super(fat);
        setLayout(new VerticalLayout(SelfSizingLayout.Type.PACKING));
        getSpace().widthProperty().set(100);
        getSpace().heightProperty().set(100);
    }

    public static class VBoxHandle implements ComponentHandle<VBox> {

        ImmediateModeRenderer20 renderer = new ImmediateModeRenderer20(false, true, 0);

        @Override
        public void draw(VBox component) {
            float tX = Launcher.camera.position.x;
            float tY = Launcher.camera.position.y;
            int width = (int) component.getSpace().widthProperty().get();
            int height = (int) component.getSpace().heightProperty().get();
            renderer.begin(Launcher.camera.combined, GL11.GL_QUADS);
            renderer.color(.4f, .121f, 1, 1);
            renderer.vertex(tX, tY, 0);
            renderer.color(.4f, .121f, 1, 1);
            renderer.vertex(tX+width, tY, 0);
            renderer.color(.4f, .121f, 1, 1);
            renderer.vertex(tX+width, tY+height, 0);
            renderer.color(.4f, .121f, 1, 1);
            renderer.vertex(tX, tY+height, 0);
            renderer.end();
        }

        @Override
        public void onMouse(VBox component, MouseHandler.MouseAction action, int x, int y, int button) {

        }

        @Override
        public void onScroll(VBox component, int scrolled, int x, int y) {

        }
    }


}
