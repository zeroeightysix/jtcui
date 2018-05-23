package me.zeroeightsix.jtcui.handle;

/**
 * Created by 086 on 21/05/2018.
 */
public interface MouseHandler {

    void down(int x, int y, int button);
    void up(int x, int y, int button);
    void move(int x, int y, int button);

}
