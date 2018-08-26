package me.zeroeightsix.jtcui.layout;

/**
 * @author 086
 */
public class Grow {

    public static final Grow NO_GROW = new Grow(-1);

    float modifier;

    public Grow(float modifier) {
        this.modifier = modifier;
    }

    public float getModifier() {
        return modifier;
    }

    public void setModifier(float modifier) {
        this.modifier = modifier;
    }

}
