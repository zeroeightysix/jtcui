package me.zeroeightsix.jtcui.component;

/**
 * A labeled component is one which has text bound to it, usually for use in rendering.
 *
 * @author 086
 */
public interface Labeled {

    /**
     * @return The text for this component
     */
    String getText();

    /**
     * @param text The new text for this component
     */
    void setText(String text);

    /**
     * @return Whether or not this component should wrap its text when rendered
     */
    boolean isWrapping();

    /**
     * Sets whether or not this component should wrap its text when rendered
     * @param wrapping The new value for wrapping
     * @see Labeled#isWrapping()
     */
    void setWrapping(boolean wrapping);

}
