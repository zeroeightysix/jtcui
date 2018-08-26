package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.Fat;

/**
 * A container with borders for usage with directional layouts
 *
 * @author 086
 * @see VBox
 * @see HBox
 */
public class DirectionalSpacedContainer extends BorderedContainer {
    public DirectionalSpacedContainer(Fat fat) {
        super(fat);
    }

    public DirectionalSpacedContainer(int x, int y, int width, int height, Fat fat) {
        super(x, y, width, height, fat);
    }
}
