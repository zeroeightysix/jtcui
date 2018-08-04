package me.zeroeightsix.jtcui.desktop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.JTCBuilder;
import me.zeroeightsix.jtcui.desktop.component.Button;
import me.zeroeightsix.jtcui.desktop.component.VBox;
import me.zeroeightsix.jtcui.handle.JTCMouseHandler;

public class Launcher extends ApplicationAdapter {

	public static OrthographicCamera camera;

	private JTC jtc;

	private VBox vBox;
	private Button button;

	@Override
	public void create () {
	    camera = new OrthographicCamera();
	    camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

	    jtc = JTCBuilder.builder(new GuiRenderer()).build();

	    // For testing purposes
        jtc.mouse = new JTCMouseHandler(jtc) {
            @Override
            public void onMouse(MouseAction action, int x, int y, int button) {
                super.onMouse(action, x, y, button);
                if (action == MouseAction.DOWN)
                    jtc.update();
            }
        };

	    Gdx.input.setInputProcessor(new InputProcessor(jtc));

        vBox = new VBox(new Fat(5, 5, 5, 5));
		button = new Button("Button");
		vBox.getChildren().add(button);
        jtc.getRootComponent().getChildren().add(vBox);
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
