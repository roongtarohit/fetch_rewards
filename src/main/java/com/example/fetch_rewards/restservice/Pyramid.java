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
    }

    @Override
    public String toString() {
        return String.format("%s#%s#%s", word, result, error);
    }

    @Override
    public int hashCode() {
        final int booleanValue = (result)?31:63;
        return word.hashCode() + error.hashCode() + booleanValue;
    }
}
