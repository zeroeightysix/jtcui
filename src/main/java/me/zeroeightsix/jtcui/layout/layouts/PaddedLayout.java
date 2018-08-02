package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.layout.Padding;

/**
 * @author 086
 */
public class PaddedLayout extends FixedLayout implements Padded {

    Padding padding = Padding.NO_PADDING;

    @Override
    public Padding getPadding() {
        return padding;
    }

    @Override
    public void setPadding(Padding padding) {
        this.padding = padding;
    }

}
