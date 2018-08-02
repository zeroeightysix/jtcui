package me.zeroeightsix.jtcui.desktop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.JTCBuilder;

public class Launcher extends ApplicationAdapter {

	private Viewport viewport;
	private OrthographicCamera camera;

	private JTC jtc;

	@Override
	public void create () {
	    camera = new OrthographicCamera();
	    camera.setToOrtho(true);
	    viewport = new ScreenViewport(camera);

	    jtc = JTCBuilder.builder(new GuiRenderer()).build();
	    Gdx.input.setInputProcessor(new InputProcessor(jtc));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		jtc.renderRecursive();

//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
        viewport.update(width, height);
        camera.update();
	}
}
