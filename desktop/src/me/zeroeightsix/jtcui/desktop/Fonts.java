package me.zeroeightsix.jtcui.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author 086
 */
public class Fonts {

    private static SpriteBatch batch = new SpriteBatch();

    public static BitmapFont robotoCondensedBold = new BitmapFont(Gdx.files.internal("robotocondensedbold.fnt"), Gdx.files.internal("robotocondensedbold.png"), true);

    public static void draw(BitmapFont font, String text, int x, int y) {
        batch.setProjectionMatrix(Launcher.camera.combined);
        batch.begin();
        font.draw(batch, text, x, y);
        batch.end();
    }

}
