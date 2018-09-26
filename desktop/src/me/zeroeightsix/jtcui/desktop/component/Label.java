package me.zeroeightsix.jtcui.desktop.component;

import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.component.SimpleComponent;
import me.zeroeightsix.jtcui.desktop.Fonts;
import me.zeroeightsix.jtcui.desktop.handle.LabelHandle;

/**
 * Created by 086 on 26/09/2018.
 */
@JTC.Install(LabelHandle.class)
public class Label extends SimpleComponent {

    private static GlyphLayout glyphLayout = new GlyphLayout();

    public Label() {
        this(0,0);
    }

    public Label(int x, int y) {
        this(x, y, 0, 0);
    }

    public Label(int x, int y, int width, int height) {
        this(x, y, width, height, "");
    }

    public Label(String text) {
        this(0, 0, text);
    }

    public Label(int x, int y, String text) {
        this(x, y, 0, 0, text);
    }

    public Label(int x, int y, int width, int height, String text) {
        super(x, y, width, height, text);
    }

    @Override
    public void setText(String text) {
        super.setText(text);
        updateSize();
    }

    public void updateSize() {
        glyphLayout.setText(Fonts.robotoCondensedBold, getText());
        getSpace().widthProperty().set(Math.max(getSpace().widthProperty().get(), glyphLayout.width));
        getSpace().heightProperty().set(Math.max(getSpace().heightProperty().get(), glyphLayout.height));
    }

}
