package me.zeroeightsix.jtcui.desktop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import me.zeroeightsix.jtcui.Fat;
import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.JTCBuilder;
import me.zeroeightsix.jtcui.component.Container;
import me.zeroeightsix.jtcui.component.DirectionalSpacedContainer;
import me.zeroeightsix.jtcui.component.HBox;
import me.zeroeightsix.jtcui.desktop.component.Button;
import me.zeroeightsix.jtcui.desktop.component.Label;
import me.zeroeightsix.jtcui.desktop.component.Window;
import me.zeroeightsix.jtcui.desktop.handle.ColouredComponentHandle;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.layout.Alignment;
import me.zeroeightsix.jtcui.layout.layouts.FixedSelfSizingLayout;
import me.zeroeightsix.jtcui.layout.layouts.OriginLayout;
import me.zeroeightsix.jtcui.layout.layouts.SelfSizingLayout;

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
		jtc.install(HBox.class, new ColouredComponentHandle<>(1, 1, .6f));

		Gdx.input.setInputProcessor(new InputProcessor(jtc));

		Container root = jtc.getRootComponent();
        root.setLayout(new FixedSelfSizingLayout(SelfSizingLayout.Type.EXPANDING));

        Window window = new Window("A window", 20, 5);
        window.setLayout(new OriginLayout(SelfSizingLayout.Type.PACKING));

		HBox box = new HBox(Fat.of(5));
		box.getHLayout().setSpacing(10);
		Button button = new Button("A button");
		final int[] step = {0};
		button.setOnAction(simpleComponent -> {
			int s = (++step[0]) % Alignment.values().length;
			System.out.println(s);
			box.getHLayout().setAlignment(Alignment.values()[s]);
			box.getHLayout().organise(box);
			step[0] = s;
		});
		Label label = new Label("A label");
		box.getChildren().add(button);
		box.getChildren().add(label);

		window.getChildren().add(box);

		root.getChildren().add(window);
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
