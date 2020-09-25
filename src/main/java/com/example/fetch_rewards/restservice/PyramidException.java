package com.example.fetch_rewards.restservice;

public class PyramidException extends Exception {

    PyramidException(final String message) {
        super(message);
    }

    PyramidException(final String message, final Exception e) {
        super(message, e);
    }

    PyramidException(final Exception e) {
        super(e);
    }

}
