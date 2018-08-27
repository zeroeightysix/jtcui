package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.layout.Alignment;

/**
 * A self-sizing layout that implements {@link Aligned}.
 *
 * @author 086
 */
public abstract class AlignedLayout extends SelfSizingLayout implements Aligned {

    private Alignment alignment;

    public AlignedLayout(Type type) {
        this(type, Alignment.TOP_LEFT);
    }

    public AlignedLayout(Type type, Alignment alignment) {
        super(type);
        this.alignment = alignment;
    }

    @Override
    public Alignment getAlignment() {
        return alignment;
    }

    @Override
    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

}
