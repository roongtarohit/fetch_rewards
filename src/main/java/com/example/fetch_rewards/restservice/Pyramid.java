package com.example.fetch_rewards.restservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pyramid {

    private String word;
    private boolean result;
    private String error;

    public Pyramid(final String word) {
        this.word = word;
        this.error = "";
    }

    // GENERATING JSON STRING
    @Override
    public String toString() {
        return "{" +
                "\"word\":\"" + word + '\"' +
                ",\"result\":" + result +
                ",\"error\":\"" + error + '\"' +
                '}';
    }

    // GENERATING HASH CODE
    @Override
    public int hashCode() {
        final int booleanValue = (result)?31:63;
        return word.hashCode() + error.hashCode() + booleanValue;
    }
}
