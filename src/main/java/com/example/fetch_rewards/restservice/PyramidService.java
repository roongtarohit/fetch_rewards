package com.example.fetch_rewards.restservice;

import java.util.Arrays;

public class PyramidService {

    private static final String EMPTY_INPUT_ERROR = "EMPTY INPUT";
    private static final String NO_INPUT_ERROR = "NO INPUT";
    private static final String INVALID_INPUT_ERROR = "INVALID INPUT";
    private final String word;

    public PyramidService(final String word) {
        this.word = word;
    }

    public boolean isPyramid() throws PyramidException {

        // RETURN FALSE ON EMPTY STRING
        if(word == null || word.length() == 0) {
            throw new PyramidException(NO_INPUT_ERROR);
        }

        if (word.trim().length() == 0) {
            throw new PyramidException(EMPTY_INPUT_ERROR);
        }

        // LETTERS ARE ALPHABETS
        final int[] freq = new int[26];

        // TRIMMING AND CONVERTING WORD TO LOWERCASE
        final char[] wordCharSet = word.trim().toLowerCase().toCharArray();

        try {
            for (final char ch : wordCharSet) {
                freq[ch - 'a']++;
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            // THIS MEANS STRING CONTAINS LETTER OTHER THAN ALPHABETS
            throw new PyramidException(INVALID_INPUT_ERROR);
        }

        // SORTING THE ARRAY BY FREQ VALUE TO VALIDATE
        Arrays.sort(freq);

        // CHECKING THE PYRAMID CONDITION
        for(int i=25; i>0; i--) {
            if(freq[i] == 0) {
                break;
            }
            if((freq[i]-1) != freq[i-1]) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;

    }

}
