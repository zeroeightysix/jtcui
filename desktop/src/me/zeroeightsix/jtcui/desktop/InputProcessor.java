package me.zeroeightsix.jtcui.desktop;

import com.badlogic.gdx.Gdx;
import me.zeroeightsix.jtcui.JTC;
import me.zeroeightsix.jtcui.handle.MouseHandler;

/**
 * @author 086
 */
public class InputProcessor implements com.badlogic.gdx.InputProcessor {

    private final JTC jtc;
    private int button;

    public InputProcessor(JTC jtc) {
        this.jtc = jtc;
    }

    @Override
    public boolean keyDown(int keycode) {
        // TODO: Keyboard events
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        // TODO: Keyboard events
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        // TODO: Keyboard events
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        jtc.mouse.onMouse(MouseHandler.MouseAction.DOWN, screenX, screenY, button);
        this.button = button;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        jtc.mouse.onMouse(MouseHandler.MouseAction.RELEASE, screenX, screenY, button);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        jtc.mouse.onMouse(MouseHandler.MouseAction.DRAG, screenX, screenY, button);
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        jtc.mouse.onMouse(MouseHandler.MouseAction.MOVE, screenX, screenY, button);
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        jtc.mouse.onScroll(amount, Gdx.input.getX(), Gdx.input.getY());
        return true;
    }

}
