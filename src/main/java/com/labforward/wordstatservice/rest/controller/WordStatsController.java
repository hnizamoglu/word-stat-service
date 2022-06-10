package com.labforward.wordstatservice.rest.controller;

import com.labforward.wordstatservice.domain.service.WordStatService;
import com.labforward.wordstatservice.rest.dto.Response;
import com.labforward.wordstatservice.rest.dto.WordStatRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/word-stats")
public class WordStatsController {

    private final WordStatService wordStatService;

    public WordStatsController(WordStatService wordStatService) {
        this.wordStatService = wordStatService;
    }

    @PostMapping("/similarity")
    public ResponseEntity<?> getFrequency(@RequestBody WordStatRequest req){
        Response resp = new Response();
        resp.setData(wordStatService.getWordSimilarityInSentence(
                req.getNotebookEntry(),
                req.getWord()));
        return new ResponseEntity<>(resp,
                HttpStatus.OK);
    }
}
