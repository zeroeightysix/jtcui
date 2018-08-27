package me.zeroeightsix.jtcui.layout.layouts;

/**
 * A self-sizing aligned layout with spacing in between its components.
 *
 * @author 086
 * @see Spaced
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
