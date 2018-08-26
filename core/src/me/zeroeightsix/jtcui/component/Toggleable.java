package me.zeroeightsix.jtcui.component;

/**
 * A toggleable component is one which has a boolean state bound to it, defining whether or not it is toggled/enabled.
 *
 * @author 086
 */
public interface Toggleable {

    /**
     * @return Whether or not this component is enabled
     */
    boolean isEnabled();

    /**
     * @param enabled The new value for whether or not the component is enabled
     */
    void setEnabled(boolean enabled);

}
