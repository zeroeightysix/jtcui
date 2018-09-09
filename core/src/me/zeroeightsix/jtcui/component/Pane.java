package me.zeroeightsix.jtcui.component;

import javafx.scene.layout.Border;
import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.layout.layouts.Layout;

/**
 * @author 086
 */
public class Pane extends BorderedContainer {
    public Pane(Layout layout, Fat fat) {
        super(fat);
        setLayout(layout);
    }

    public Pane(Layout layout, int x, int y, int width, int height, Fat fat) {
        super(x, y, width, height, fat);
        setLayout(layout);
    }
}
