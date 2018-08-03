package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.Fat;

/**
 * A component with a border, where its children aren't supposed to be. Something like a window.
 * @author 086
 */
public class BorderedContainer extends SimpleContainer {

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
