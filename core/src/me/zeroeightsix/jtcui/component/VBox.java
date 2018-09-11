package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.component.BorderedContainer;
import me.zeroeightsix.jtcui.layout.layouts.HorizontalLayout;
import me.zeroeightsix.jtcui.layout.layouts.SelfSizingLayout;
import me.zeroeightsix.jtcui.layout.layouts.VerticalLayout;

/**
 * A container that vertically organises its children
 *
 * @author 086
 * @see VBox
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

    public VBox(SelfSizingLayout.Type type) {
        super(Fat.NO_FAT);
        setLayout(layout = new VerticalLayout(type));
    }

    /**
     * @param spacing The new space between components in this container
     */
    public void setSpacing(double spacing) {
        getVLayout().setSpacing(spacing);
    }

    /**
     * @return The space between components in this container
     */
    public double getSpacing() {
        return getVLayout().getSpacing();
    }

    /**
     * @return The {@link VerticalLayout} this VBox depends on
     */
    public VerticalLayout getVLayout() {
        return layout;
    }

}
