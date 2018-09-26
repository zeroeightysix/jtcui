package me.zeroeightsix.jtcui.component;

/**
 * Created by 086 on 26/09/2018.
 */
public abstract class AbstractLabel extends SimpleComponent {

    public AbstractLabel() {
        this(0,0);
    }

    public AbstractLabel(int x, int y) {
        this(x, y, 0, 0);
    }

    public AbstractLabel(int x, int y, int width, int height) {
        this(x, y, width, height, "");
    }

    public AbstractLabel(String text) {
        this(0, 0, text);
    }

    public AbstractLabel(int x, int y, String text) {
        this(x, y, 0, 0, text);
    }

    public AbstractLabel(int x, int y, int width, int height, String text) {
        super(x, y, width, height, text);
    }

    @Override
    public void setText(String text) {
        super.setText(text);
        updateSize();
    }

    public abstract void updateSize();

}
