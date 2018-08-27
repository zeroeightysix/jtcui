package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.Space;

/**
 * @author 086
 */
public abstract class AbstractDraggable extends BorderedContainer implements Draggable {
    private final Space dragSpace;

    public boolean dragging = false;
    public double dragX;
    public double dragY;

    public AbstractDraggable(int dragSpaceX, int dragSpaceY, int dragSpaceWidth, int dragSpaceHeight) {
        this(Fat.NO_FAT, dragSpaceX, dragSpaceY, dragSpaceWidth, dragSpaceHeight);
    }

    public AbstractDraggable(Fat fat, int dragSpaceX, int dragSpaceY, int dragSpaceWidth, int dragSpaceHeight) {
        super(fat);
        this.dragSpace = createDSpace(dragSpaceX, dragSpaceY, dragSpaceWidth, dragSpaceHeight);
    }

    public AbstractDraggable(int x, int y, int width, int height, Fat fat, int dragSpaceX, int dragSpaceY, int dragSpaceWidth, int dragSpaceHeight) {
        super(x, y, width, height, fat);
        this.dragSpace = createDSpace(dragSpaceX, dragSpaceY, dragSpaceWidth, dragSpaceHeight);
    }

    private Space createDSpace(int dragSpaceX, int dragSpaceY, int dragSpaceWidth, int dragSpaceHeight) {
        Space dragSpace = new Space(this, dragSpaceX, dragSpaceY, dragSpaceWidth, dragSpaceHeight);
        dragSpace.widthProperty().bind(getSpace().widthProperty());
        return dragSpace;
    }

    @Override
    public Space getDragSpace() {
        return dragSpace;
    }
}
