package me.zeroeightsix.jtcui.desktop.component;

import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20;
import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.component.BorderedContainer;
import me.zeroeightsix.jtcui.desktop.Launcher;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;
import me.zeroeightsix.jtcui.layout.layouts.HorizontalLayout;
import me.zeroeightsix.jtcui.layout.layouts.SelfSizingLayout;
import me.zeroeightsix.jtcui.layout.layouts.VerticalLayout;
import org.lwjgl.opengl.GL11;

/**
 * @author 086
 */
@JTC.Install(HBox.VBoxHandle.class)
public class HBox extends BorderedContainer {

    public HBox() {
        this(Fat.NO_FAT);
    }

    public HBox(Fat fat) {
        super(fat);
        setLayout(new HorizontalLayout(SelfSizingLayout.Type.PACKING));
        getSpace().widthProperty().set(100);
        getSpace().heightProperty().set(100);
    }

    public static class VBoxHandle implements ComponentHandle<HBox> {

        ImmediateModeRenderer20 renderer = new ImmediateModeRenderer20(false, true, 0);

        @Override
        public void draw(HBox component) {
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
        public void onMouse(HBox component, MouseHandler.MouseAction action, int x, int y, int button) {

        }

        @Override
        public void onScroll(HBox component, int scrolled, int x, int y) {

        }
    }


}
