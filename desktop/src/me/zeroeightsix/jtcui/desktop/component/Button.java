package me.zeroeightsix.jtcui.desktop.component;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20;
import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.component.SimpleComponent;
import me.zeroeightsix.jtcui.desktop.Fonts;
import me.zeroeightsix.jtcui.desktop.Launcher;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;
import org.lwjgl.opengl.GL11;

/**
 * @author 086
 */
@JTC.Install(Button.ButtonHandle.class)
public class Button extends SimpleComponent {

    private static GlyphLayout layout = new GlyphLayout();
    Texture icon = null;

    public Button(String text) {
        this(0, 0, text);
        getRequirements().setMinimumWidth(36);
    }

    public Button(int x, int y, String text) {
        this(x, y, 0, 0, text);
    }

    public Button(int x, int y, int width, int height, String text) {
        super(x, y, width, height, text.toUpperCase());
    }

    public void updateSizes() {
        layout.setText(Fonts.robotoCondensedBold, getText());
        getRequirements().setMinimumWidth((int) layout.width + (getIcon() == null ? 32 : 36));
    }

    public Texture getIcon() {
        return icon;
    }

    public void setIcon(Texture icon) {
        this.icon = icon;
    }

    @Override
    public void setText(String text) {
        super.setText(text);
        updateSizes();
        if (getSpace().widthProperty().get() < getRequirements().getMinimumWidth()) getSpace().widthProperty().set(getRequirements().getMinimumWidth());
        if (getSpace().heightProperty().get() < getRequirements().getMinimumHeight()) getSpace().heightProperty().set(getRequirements().getMinimumHeight());
    }

    public static class ButtonHandle implements ComponentHandle<Button> {

        ImmediateModeRenderer20 renderer = new ImmediateModeRenderer20(false, true, 0);

        @Override
        public void draw(Button component) {
//            renderer.setProjectionMatrix(Launcher.camera.combined);
            int width = (int) component.getSpace().widthProperty().get();
            int height = (int) component.getSpace().heightProperty().get();
//            renderer.setColor(.4f, .121f, 1, 1);
            renderer.begin(Launcher.camera.combined, GL20.GL_TRIANGLE_FAN);
            renderer.color(1, 1, 1, 1);
            renderer.vertex(8, 0, 0);
            renderer.color(1, 1, 1, 1);
            renderer.vertex(width - 8, 0, 0);
            renderer.color(1, 1, 1, 1);
            renderer.vertex(width, 8, 0);
            renderer.end();

            Fonts.draw(Fonts.robotoCondensedBold, component.getText(), 10, 10);
        }

        @Override
        public void onMouse(Button component, MouseHandler.MouseAction action, int x, int y, int button) {

        }

        @Override
        public void onScroll(Button component, int scrolled, int x, int y) {

        }
    }

}
