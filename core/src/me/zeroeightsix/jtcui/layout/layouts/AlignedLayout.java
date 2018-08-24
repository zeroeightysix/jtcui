package me.zeroeightsix.jtcui.layout.layouts;

import me.zeroeightsix.jtcui.layout.Alignment;

/**
 * @author 086
 */
public abstract class AlignedLayout extends SelfSizingLayout implements Aligned {

    private Alignment alignment;

    AlignedLayout(Type type) {
        this(type, Alignment.TOP_LEFT);
    }

    private AlignedLayout(Type type, Alignment alignment) {
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
