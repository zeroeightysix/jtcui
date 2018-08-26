package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.layout.layouts.HorizontalLayout;
import me.zeroeightsix.jtcui.layout.layouts.SelfSizingLayout;

/**
 * A container that horizontally organises its children
 *
 * @author 086
 * @see VBox
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

    /**
     * @param spacing The new space between components in this container
     */
    public void setSpacing(double spacing) {
        getHLayout().setSpacing(spacing);
    }

    /**
     * @return The space between components in this container
     */
    public double getSpacing() {
        return getHLayout().getSpacing();
    }

    /**
     * @return The {@link HorizontalLayout} this HBox depends on
     */
    public HorizontalLayout getHLayout() {
        return layout;
    }

}
