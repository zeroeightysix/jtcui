package me.zeroeightsix.jtcui.exception;

import me.zeroeightsix.jtcui.component.Component;

/**
 * Thrown when JTC tried to interact with the handler for a component but could not find one
 *
 * @author 086
 */
public class JTCMissingHandleException extends RuntimeException {
    JTCMissingHandleException(String message) {
        super(message);
    }

    public JTCMissingHandleException(Component component) {
        this("No handle installed for " + component.getClass().getCanonicalName());
    }
}
