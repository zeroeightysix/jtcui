package me.zeroeightsix.jtcui.exception;

import me.zeroeightsix.jtcui.component.Component;

/**
 * Created by 086 on 23/05/2018.
 */
public class JTCMissingHandleException extends RuntimeException {
    JTCMissingHandleException(String message) {
        super(message);
    }

    public JTCMissingHandleException(Component component) {
        this("No handle installed for " + component.getClass().getCanonicalName());
    }
}
