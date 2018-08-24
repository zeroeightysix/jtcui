package me.zeroeightsix.jtcui.layout;

/**
 * Created by 086 on 23/04/2018.
 */
public class Grow {

    public static final Grow NO_GROW = new Grow(-1);

    private float modifier;

    private Grow(float modifier) {
        this.modifier = modifier;
    }

    public float getModifier() {
        return modifier;
    }

    public void setModifier(float modifier) {
        this.modifier = modifier;
    }

}
