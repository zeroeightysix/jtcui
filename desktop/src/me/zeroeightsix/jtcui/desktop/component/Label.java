package me.zeroeightsix.jtcui.desktop.component;

import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.component.AbstractLabel;
import me.zeroeightsix.jtcui.desktop.Fonts;
import me.zeroeightsix.jtcui.desktop.handle.LabelHandle;

/**
 * Created by 086 on 26/09/2018.
 */
@JTC.Install(LabelHandle.class)
public class Label extends AbstractLabel {

    public Label() {
    }

    public Label(int x, int y) {
        super(x, y);
    }

    public Label(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Label(String text) {
        super(text);
    }

    public Label(int x, int y, String text) {
        super(x, y, text);
    }

    public Label(int x, int y, int width, int height, String text) {
        super(x, y, width, height, text);
    }

    private static GlyphLayout glyphLayout = new GlyphLayout();

    @Override
    public void updateSize() {
        glyphLayout.setText(Fonts.robotoCondensedBold, getText());
        getSpace().widthProperty().set(Math.max(getSpace().widthProperty().get(), glyphLayout.width));
        getSpace().heightProperty().set(Math.max(getSpace().heightProperty().get(), glyphLayout.height));
    }

}
