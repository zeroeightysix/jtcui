package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.layout.Alignment;

/**
 * @author 086
 */
public abstract class AlignedSpacedLayout extends AlignedLayout implements Spaced {

    private double spacing;

    public AlignedSpacedLayout(Type type) {
        super(type);
    }

    @Override
    public double getSpacing() {
        return spacing;
    }

    @Override
    public void setSpacing(double spacing) {
        this.spacing = spacing;
    }

}
