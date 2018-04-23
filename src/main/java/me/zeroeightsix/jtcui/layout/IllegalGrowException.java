package me.zeroeightsix.jtcui.layout;

import me.zeroeightsix.jtcui.layout.layouts.Layout;

/**
 * Created by 086 on 23/04/2018.
 */
public class IllegalGrowException extends IllegalArgumentException {
    public IllegalGrowException(Layout layout, Grow grow) {
        super(String.format("Layout %s does not support grow %s", layout, grow));
    }
}
