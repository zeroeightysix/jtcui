package me.zeroeightsix.jtcui.component;

import me.zeroeightsix.jtcui.Fat;

/**
 * @author 086
 */
abstract class BaseContainer extends SimpleComponent implements Container {

    BaseContainer() {
    }

    BaseContainer(int x, int y) {
        super(x, y);
    }

    BaseContainer(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public Fat getFat() {
        return Fat.NO_FAT;
    }

}
