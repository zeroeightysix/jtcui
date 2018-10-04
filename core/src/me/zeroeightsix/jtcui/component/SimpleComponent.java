package me.zeroeightsix.jtcui.component;

import java.util.function.Consumer;

/**
 * A basic component with implementations for {@link Toggleable}, {@link Labeled} and {@link Actionable}
 *
 * @see BaseComponent
 * @see SimpleContainer
 * @author 086
 */
public class SimpleComponent extends BaseComponent implements Toggleable, Labeled, Actionable<SimpleComponent> {
    private boolean enabled;
    Consumer<SimpleComponent> action = simpleComponent -> {};
    String text = "";
    boolean textWrapping = true;

    public SimpleComponent() {
    }

    public SimpleComponent(int x, int y) {
        super(x, y);
    }

    public SimpleComponent(int x, int y, int width, int height) {
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

    protected Consumer<SimpleComponent> getAction() {
        return action;
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
