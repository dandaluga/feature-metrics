package com.daluga.feature.metrics.exception;

public class FeatureMetricRuntimeException extends RuntimeException {

    public FeatureMetricRuntimeException(String message) {
        super(message);
    }

    public FeatureMetricRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
