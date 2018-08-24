package me.zeroeightsix.jtcui.component;

import java.util.function.Consumer;

/**
 * @author 086
 */
public class SimpleComponent extends BaseComponent implements Toggleable, Labeled, Actionable<SimpleComponent> {
    private Consumer<SimpleComponent> action;
    private String text;
    private boolean textWrapping = true;
    private boolean enabled;

    SimpleComponent() {
    }

    SimpleComponent(int x, int y) {
        super(x, y);
    }

    SimpleComponent(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public SimpleComponent(String text) {
        this.text = text;
    }

    public SimpleComponent(int x, int y, String text) {
        super(x, y);
        setText(text);
    }

    public SimpleComponent(int x, int y, int width, int height, String text) {
        super(x, y, width, height);
        setText(text);
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void setOnAction(Consumer<SimpleComponent> action) {
        this.action = action;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean isWrapping() {
        return textWrapping;
    }

    @Override
    public void setWrapping(boolean wrapping) {
        this.textWrapping = wrapping;
    }
}
