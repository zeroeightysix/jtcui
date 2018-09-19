package me.zeroeightsix.jtcui.desktop.component;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.component.SimpleComponent;
import me.zeroeightsix.jtcui.desktop.Fonts;
import me.zeroeightsix.jtcui.desktop.handle.SimpleHandle;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;

/**
 * @author 086
 */
@JTC.Install(Button.ButtonHandle.class)
public class Button extends SimpleComponent {

    private boolean isPressed = false;
    private int textWidth;

    private static GlyphLayout glyphLayout = new GlyphLayout();
    Texture icon = null;

    public Button(String text) {
        this(0, 0, text);
        getRequirements().setMinimumHeight(20);
        updateSizes();
        getMouseHandlers().add(new MouseHandler() {
            @Override
            public void onMouse(MouseAction action, int x, int y, int button) {
                if (action == MouseAction.DOWN) getAction().accept(Button.this);
            }

            @Override
            public void onScroll(int scrolled, int x, int y) {

            }
        });
    }

    public Button(int x, int y, String text) {
        this(x, y, 0, 0, text);
    }

    public Button(int x, int y, int width, int height, String text) {
        super(x, y, width, height, text);
    }

    public void updateSizes() {
        glyphLayout.setText(Fonts.robotoCondensedBold, getText());
        getRequirements().setMinimumWidth(glyphLayout.width + 20);
        if (getSpace().widthProperty().get() < getRequirements().getMinimumWidth()) getSpace().widthProperty().set(getRequirements().getMinimumWidth());
        if (getSpace().heightProperty().get() < getRequirements().getMinimumHeight()) getSpace().heightProperty().set(getRequirements().getMinimumHeight());
        textWidth = (int) glyphLayout.width;
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
    }

    public static class ButtonHandle implements ComponentHandle<Button> {

        @Override
        public void draw(Button component) {
            int red = component.isPressed ? 0 : 1;
            SimpleHandle.drawBox(component.getSpace(), red, .8f, .8f);

            Button.glyphLayout.setText(Fonts.robotoCondensedBold, component.getText());
            Fonts.draw(Fonts.robotoCondensedBold, component.getText(), (int) (component.getSpace().widthProperty().get() / 2 - component.textWidth / 2), 5);
        }

        @Override
        public void onMouse(Button component, MouseHandler.MouseAction action, int x, int y, int button) {
            switch (action) {
                case DOWN:
                    component.isPressed = true;
                    break;
                case RELEASE:
                    component.isPressed = false;
                    break;
            }
        }

        @Override
        public void onScroll(Button component, int scrolled, int x, int y) {

        }
    }

}
