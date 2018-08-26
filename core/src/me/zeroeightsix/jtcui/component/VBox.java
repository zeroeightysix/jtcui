package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.component.BorderedContainer;
import me.zeroeightsix.jtcui.layout.layouts.SelfSizingLayout;
import me.zeroeightsix.jtcui.layout.layouts.VerticalLayout;

/**
 * @author 086
 */
public class VBox extends DirectionalSpacedContainer {

    private VerticalLayout layout;

    public VBox() {
        this(Fat.NO_FAT);
    }

    public VBox(Fat fat) {
        this(fat, SelfSizingLayout.Type.PACKING);
    }

    public VBox(Fat fat, SelfSizingLayout.Type type) {
        super(fat);
        setLayout(layout = new VerticalLayout(type));
    }

    public void setSpacing(double spacing) {
        getVLayout().setSpacing(spacing);
    }

    public double getSpacing() {
        return getVLayout().getSpacing();
    }

    public VerticalLayout getVLayout() {
        return layout;
    }

}
