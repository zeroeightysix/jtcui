package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.Fat;

/**
 * A component with a border, where its children are not supposed to be.
 *
 * @author 086
 */
public class BorderedContainer extends SimpleContainer {

    /**
     * The fat for this container
     *
     * @see Fat
     * @see Container#getFat()
     */
    private final Fat fat;

    public BorderedContainer(Fat fat) {
        this(0, 0, 0, 0, fat);
    }

    public BorderedContainer(int x, int y, int width, int height, Fat fat) {
        super(x, y, width, height);
        this.fat = fat;
    }

    @Override
    public Fat getFat() {
        return fat;
    }

}
