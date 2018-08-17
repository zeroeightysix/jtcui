package me.zeroeightsix.jtcui.desktop;

import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.component.Component;
import me.zeroeightsix.jtcui.handle.JTCMouseHandler;

import java.util.Collections;
import java.util.Optional;

/**
 * @author 086
 */
public class DebugMouseHandler extends JTCMouseHandler {
    public DebugMouseHandler(JTC theJTC) {
        super(theJTC);
    }

    @Override
    public void onMouse(MouseAction action, int x, int y, int button) {
        super.onMouse(action, x, y, button);
        if (action == MouseAction.DOWN) {
//            getJTC().update();
            System.out.println("=== JTC Map ===");
            map(getJTC().getRootComponent());
        }
    }

    private void map(Component component) {
        mapRec("", component);
    }

    private void mapRec(String prefix, Component component) {
        System.out.println(prefix + component.getClass().getSimpleName() + " " + component.getSpace().toString());
        Optional.ofNullable(component.getChildren()).ifPresent(components -> {
            final String p = String.join("", Collections.nCopies(prefix.length(), " ")) + "├ ";
            components.forEach(component1 -> mapRec(p, component1));
        });
    }

}
