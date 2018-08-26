package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.component.BorderedContainer;
import me.zeroeightsix.jtcui.layout.layouts.HorizontalLayout;
import me.zeroeightsix.jtcui.layout.layouts.SelfSizingLayout;

/**
 * @author 086
 */
public class HBox extends DirectionalSpacedContainer {

    private HorizontalLayout layout;

    public HBox() {
        this(Fat.NO_FAT);
    }

    public HBox(Fat fat) {
        this(fat, SelfSizingLayout.Type.PACKING);
    }

    public HBox(Fat fat, SelfSizingLayout.Type type) {
        super(fat);
        setLayout(layout = new HorizontalLayout(type));
    }

    public void setSpacing(double spacing) {
        getHLayout().setSpacing(spacing);
    }

    public double getSpacing() {
        return getHLayout().getSpacing();
    }

    public HorizontalLayout getHLayout() {
        return layout;
    }

}
