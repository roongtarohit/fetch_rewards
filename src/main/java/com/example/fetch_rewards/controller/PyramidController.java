package com.example.fetch_rewards.controller;

import com.example.fetch_rewards.restservice.Pyramid;
import com.example.fetch_rewards.restservice.PyramidException;
import com.example.fetch_rewards.restservice.PyramidService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PyramidController.BASE_URL)
public class PyramidController {

    public static final String BASE_URL = "api/v1/pyramid";

    // TO HANDLE GET PATH REQUEST
    @GetMapping("/{word}")
    public Pyramid pyramidPathVariable(@PathVariable final String word) {
        return generateResponse(word);
    }

    // TO HANDLE GET PARAMETER REQUEST
    @GetMapping
    public Pyramid pyramidGetRequest(@RequestParam(value = "word", defaultValue = "") final String word) {
        return generateResponse(word);
    }

    // TO HANDLE POST REQUEST -- BY DEFAULT REQUIRED IS SET TRUE
    @PostMapping
    public Pyramid pyramidPostRequest(@RequestBody final String word) {
        return generateResponse(word);
    }

    private Pyramid generateResponse(final String word) {
        final Pyramid response = new Pyramid(word);
        final PyramidService service = new PyramidService(response.getWord());
        try {
            response.setResult(service.isPyramid());
        } catch (PyramidException e) {
            response.setResult(Boolean.FALSE);
            response.setError(e.getMessage());
        }
        return response;
    }

}
