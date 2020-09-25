package com.example.fetch_rewards.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.example.fetch_rewards.restservice.Pyramid;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PyramidController.class)
class PyramidControllerTest {

    private static final String EMPTY_INPUT_ERROR = "EMPTY INPUT";
    private static final String NO_INPUT_ERROR = "NO INPUT";
    private static final String INVALID_INPUT_ERROR = "INVALID INPUT";
    public static final String BASE_URL = "/api/v1/pyramid";

    @Autowired
    private MockMvc mvc;

    @Test
    void pyramidPathVariable_ReturnsTrue() throws Exception {

        final String word = "banana";
        final String URL = String.format("%s/%s",BASE_URL,word);
        final Pyramid expectedResult = new Pyramid(word);
        expectedResult.setResult(Boolean.TRUE);

        mvc.perform(get(URL)).andExpect(content().string(expectedResult.toString()));
    }

    @Test
    void pyramidPathVariable_ReturnsFalse() throws Exception {

        final String word = "bananan";
        final String URL = String.format("%s/%s",BASE_URL,word);
        final Pyramid expectedResult = new Pyramid(word);
        expectedResult.setResult(Boolean.FALSE);

        mvc.perform(get(URL)).andExpect(content().string(expectedResult.toString()));
    }

    @Test
    void pyramidPathVariable_OnNoInputReturnsFalse() throws Exception {

        final String word = "";
        final String URL = String.format("%s/%s",BASE_URL,word);
        final Pyramid expectedResult = new Pyramid(word);
        expectedResult.setResult(Boolean.FALSE);
        expectedResult.setError(NO_INPUT_ERROR);

        mvc.perform(get(URL)).andExpect(content().string(expectedResult.toString()));
    }

    @Test
    void pyramidPathVariable_OnEmptyStringReturnsFalse() throws Exception {

        final String word = " ";
        final String URL = String.format("%s/%s",BASE_URL,word);
        final Pyramid expectedResult = new Pyramid(word);
        expectedResult.setResult(Boolean.FALSE);
        expectedResult.setError(EMPTY_INPUT_ERROR);

        mvc.perform(get(URL)).andExpect(content().string(expectedResult.toString()));
    }

    @Test
    void pyramidPathVariable_OnInvalidStringReturnsFalse() throws Exception {

        final String word = "Rohit1";
        final String URL = String.format("%s/%s",BASE_URL,word);
        final Pyramid expectedResult = new Pyramid(word);
        expectedResult.setResult(Boolean.FALSE);
        expectedResult.setError(INVALID_INPUT_ERROR);

        mvc.perform(get(URL)).andExpect(content().string(expectedResult.toString()));
    }

    @Test
    void pyramidGetRequest_ReturnsTrue() throws Exception {

        final String word = "banana";
        final String URL = String.format("%s?word=%s",BASE_URL,word);
        final Pyramid expectedResult = new Pyramid(word);
        expectedResult.setResult(Boolean.TRUE);

        mvc.perform(get(URL)).andExpect(content().string(expectedResult.toString()));
    }

    @Test
    void pyramidGetRequest_ReturnsFalse() throws Exception {

        final String word = "bananan";
        final String URL = String.format("%s?word=%s",BASE_URL,word);
        final Pyramid expectedResult = new Pyramid(word);
        expectedResult.setResult(Boolean.FALSE);

        mvc.perform(get(URL)).andExpect(content().string(expectedResult.toString()));
    }

    @Test
    void pyramidGetRequest_OnNoInputReturnsFalse() throws Exception {

        final String word = "";
        final String URL = String.format("%s?word=%s",BASE_URL,word);
        final Pyramid expectedResult = new Pyramid(word);
        expectedResult.setResult(Boolean.FALSE);
        expectedResult.setError(NO_INPUT_ERROR);

        mvc.perform(get(URL)).andExpect(content().string(expectedResult.toString()));
    }

    @Test
    void pyramidGetRequest_OnEmptyStringReturnsFalse() throws Exception {

        final String word = " ";
        final String URL = String.format("%s?word=%s",BASE_URL,word);
        final Pyramid expectedResult = new Pyramid(word);
        expectedResult.setResult(Boolean.FALSE);
        expectedResult.setError(EMPTY_INPUT_ERROR);

        mvc.perform(get(URL)).andExpect(content().string(expectedResult.toString()));
    }

    @Test
    void pyramidGetRequest_OnInvalidStringReturnsFalse() throws Exception {

        final String word = "Rohit1";
        final String URL = String.format("%s?word=%s",BASE_URL,word);
        final Pyramid expectedResult = new Pyramid(word);
        expectedResult.setResult(Boolean.FALSE);
        expectedResult.setError(INVALID_INPUT_ERROR);

        mvc.perform(get(URL)).andExpect(content().string(expectedResult.toString()));
    }

    @Test
    void pyramidPostRequest_ReturnsTrue() throws Exception {

        final String word = "banana";
        final Pyramid expectedResult = new Pyramid(word);
        expectedResult.setResult(Boolean.TRUE);

        mvc.perform(post(BASE_URL)
                .content(word)
                .contentType(MediaType.TEXT_PLAIN))
            .andExpect(content().string(expectedResult.toString()));
    }

    @Test
    void pyramidPostRequest_ReturnsFalse() throws Exception {

        final String word = "bananan";
        final Pyramid expectedResult = new Pyramid(word);
        expectedResult.setResult(Boolean.FALSE);

        mvc.perform(post(BASE_URL)
                .content(word)
                .contentType(MediaType.TEXT_PLAIN))
            .andExpect(content().string(expectedResult.toString()));
    }

    @Test
    void pyramidPostRequest_OnEmptyStringReturnsFalse() throws Exception {

        final String word = " ";
        final Pyramid expectedResult = new Pyramid(word);
        expectedResult.setResult(Boolean.FALSE);
        expectedResult.setError(EMPTY_INPUT_ERROR);

        mvc.perform(post(BASE_URL)
                .content(word)
                .contentType(MediaType.TEXT_PLAIN))
            .andExpect(content().string(expectedResult.toString()));
    }

    @Test
    void pyramidPostRequest_OnInvalidStringReturnsFalse() throws Exception {

        final String word = "Rohit1";
        final Pyramid expectedResult = new Pyramid(word);
        expectedResult.setResult(Boolean.FALSE);
        expectedResult.setError(INVALID_INPUT_ERROR);

        mvc.perform(post(BASE_URL)
                .content(word)
                .contentType(MediaType.TEXT_PLAIN))
            .andExpect(content().string(expectedResult.toString()));
    }

}