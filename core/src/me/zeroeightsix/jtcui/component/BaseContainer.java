package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.Fat;

/**
 * A basic implementation of {@link Container}
 *
 * @author 086
 * @see SimpleComponent
 * @see SimpleContainer
 */
abstract class BaseContainer extends SimpleComponent implements Container {

    public BaseContainer() {
    }

    public BaseContainer(int x, int y) {
        super(x, y);
    }

    public BaseContainer(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public Fat getFat() {
        return Fat.NO_FAT;
    }

}
