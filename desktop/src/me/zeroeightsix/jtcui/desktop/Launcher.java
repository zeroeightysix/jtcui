package me.zeroeightsix.jtcui.desktop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.JTCBuilder;
import me.zeroeightsix.jtcui.component.DirectionalSpacedContainer;
import me.zeroeightsix.jtcui.component.HBox;
import me.zeroeightsix.jtcui.component.Pane;
import me.zeroeightsix.jtcui.component.SimpleContainer;
import me.zeroeightsix.jtcui.desktop.component.Button;
import me.zeroeightsix.jtcui.desktop.component.Label;
import me.zeroeightsix.jtcui.desktop.component.Window;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.layout.Alignment;
import me.zeroeightsix.jtcui.layout.layouts.CenteredLayout;
import me.zeroeightsix.jtcui.layout.layouts.FixedSelfSizingLayout;
import me.zeroeightsix.jtcui.layout.layouts.SelfSizingLayout;

import java.util.concurrent.atomic.AtomicInteger;

public class Launcher extends ApplicationAdapter {

	public static OrthographicCamera camera;

	private JTC jtc;

	@Override
	public void create () {
	    camera = new OrthographicCamera();
	    camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

	    jtc = JTCBuilder.builder(new GuiRenderer()).build();
	    // For testing purposes
        jtc.input = new DebugInputHandler(jtc);

        jtc.install(DirectionalSpacedContainer.class, ComponentHandle.EMPTY_HANDLE);

	    Gdx.input.setInputProcessor(new InputProcessor(jtc));

        Pane pane = new Pane(new CenteredLayout(SelfSizingLayout.Type.EXPANDING), Fat.NO_FAT);

        HBox hBox = new HBox(SelfSizingLayout.Type.EXPANDING);
		hBox.getHLayout().setSpacing(5);
		hBox.getHLayout().setAlignment(Alignment.TOP_LEFT);

        AtomicInteger count = new AtomicInteger(0);
		Button button1 = new Button("Next Alignment");
		button1.setOnAction(simpleComponent -> {
		    if (count.get() >= Alignment.values().length-1) count.set(-1);
		    hBox.getHLayout().setAlignment(Alignment.values()[count.addAndGet(1)]);
		    hBox.getHLayout().organise(hBox);
        });
        hBox.getChildren().add(button1);

        Label label = new Label("Hello world!");
        hBox.getChildren().add(label);

        SimpleContainer root = new SimpleContainer();
		root.setLayout(new FixedSelfSizingLayout(SelfSizingLayout.Type.EXPANDING));

		pane.getChildren().add(hBox);
		Window window = new Window(10, 10, 250, 150, "Window", 20, 5);
		window.getChildren().add(pane);

		root.getChildren().add(window);
        jtc.getRootComponent().getChildren().add(root);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
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
