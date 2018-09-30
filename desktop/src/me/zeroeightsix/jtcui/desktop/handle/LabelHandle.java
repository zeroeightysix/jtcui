package me.zeroeightsix.jtcui.desktop.handle;

import me.zeroeightsix.jtcui.desktop.Fonts;
import me.zeroeightsix.jtcui.desktop.component.Label;
import me.zeroeightsix.jtcui.handle.EmptyComponentHandle;

/**
 * Created by 086 on 26/09/2018.
 */
public class LabelHandle extends EmptyComponentHandle<Label> {
    @Override
    public void draw(Label component) {
        Fonts.draw(Fonts.robotoCondensedBold, component.getText(), 0, 0);
    }
}
