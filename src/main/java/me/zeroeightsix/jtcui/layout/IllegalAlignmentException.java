package me.zeroeightsix.jtcui.layout;

import me.zeroeightsix.jtcui.layout.layouts.Layout;

/**
 * Created by 086 on 23/04/2018.
 */
public class IllegalAlignmentException extends IllegalArgumentException {
    public IllegalAlignmentException(Layout layout, Alignment alignment) {
        super(String.format("Layout %s does not support alignment %s", layout, alignment));
    }
}
