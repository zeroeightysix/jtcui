package me.zeroeightsix.jtcui.desktop.handle;

import me.zeroeightsix.jtcui.desktop.Fonts;
import me.zeroeightsix.jtcui.desktop.component.Label;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;

/**
 * Created by 086 on 26/09/2018.
 */
public class LabelHandle implements ComponentHandle<Label> {
    @Override
    public void draw(Label component) {
        Fonts.draw(Fonts.robotoCondensedBold, component.getText(), 0, 0);
    }

    @Override
    public void onMouse(Label component, MouseHandler.MouseAction action, int x, int y, int button) {

    }

    @Override
    public void onScroll(Label component, int scrolled, int x, int y) {

    }
}
