package me.zeroeightsix.jtcui.desktop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.JTCBuilder;
import me.zeroeightsix.jtcui.component.DirectionalSpacedContainer;
import me.zeroeightsix.jtcui.desktop.component.Button;
import me.zeroeightsix.jtcui.component.HBox;
import me.zeroeightsix.jtcui.desktop.handle.DBoxHandle;
import me.zeroeightsix.jtcui.layout.layouts.HorizontalLayout;

public class Launcher extends ApplicationAdapter {

	public static OrthographicCamera camera;

	private JTC jtc;

	@Override
	public void create () {
	    camera = new OrthographicCamera();
	    camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

	    jtc = JTCBuilder.builder(new GuiRenderer()).build();
	    // For testing purposes
        jtc.mouse = new DebugMouseHandler(jtc);

        jtc.install(DirectionalSpacedContainer.class, new DBoxHandle());

	    Gdx.input.setInputProcessor(new InputProcessor(jtc));

        HBox hBox = new HBox(new Fat(20, 5, 20, 5));
		((HorizontalLayout) hBox.getLayout()).setSpacing(5);
		hBox.getChildren().add(new Button("Button 1"));
		hBox.getChildren().add(new Button("Button 2"));
        jtc.getRootComponent().getChildren().add(hBox);
    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		jtc.renderRecursive();
	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();

		jtc.getRootComponent().getSpace().widthProperty().set(width);
		jtc.getRootComponent().getSpace().heightProperty().set(height);
	}
}
