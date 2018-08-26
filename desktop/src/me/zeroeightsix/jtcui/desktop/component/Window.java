package me.zeroeightsix.jtcui.desktop.component;

import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.component.BorderedContainer;
import me.zeroeightsix.jtcui.component.Draggable;

/**
 * @author 086
 */
public class Window extends BorderedContainer implements Draggable {

    Space dragSpace;

    public Window(int titleHeight, int borderThickness) {
        this(0, 0, 0, 0, titleHeight, borderThickness);
    }

    public Window(int x, int y, int width, int height, int titleHeight, int borderThickness) {
        super(x, y, width, height, new Fat(borderThickness, borderThickness, borderThickness + titleHeight, borderThickness));
        dragSpace = new Space(this, 0, 0, width, titleHeight);
        dragSpace.widthProperty().bind(getSpace().widthProperty());
    }

    @Override
    public Space getDragSpace() {
        return dragSpace;
    }

}
