package me.zeroeightsix.jtcui.layout.layouts;

/**
 * @author 086
 */
public class SpacedLayout extends GrowingLayout implements Spaced {

    int spacing;

    @Override
    public int getSpacing() {
        return spacing;
    }

    @Override
    public void setSpacing(int spacing) {
        this.spacing = spacing;
    }

}
