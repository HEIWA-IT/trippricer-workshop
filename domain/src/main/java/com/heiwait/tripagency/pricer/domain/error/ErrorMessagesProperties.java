package com.heiwait.tripagency.pricer.domain.error;

import java.util.ResourceBundle;

public class ErrorMessagesProperties {
    private static final String FILENAME = "messages";
    private static final ResourceBundle rb = ResourceBundle.getBundle(FILENAME);

    private ErrorMessagesProperties() {
    }

    public static String getErrorMessageFromErrorCode(String errorCode) {
        return rb.getString(errorCode);
    }
}