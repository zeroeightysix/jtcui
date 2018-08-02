package me.zeroeightsix.jtcui.component;

/**
 * @author 086
 */
public interface Labeled {

    String getText();
    void setText(String text);

    boolean isWrapping();
    void setWrapping(boolean wrapping);

}
