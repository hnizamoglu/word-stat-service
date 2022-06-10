package com.labforward.wordstatservice.it;

import com.labforward.wordstatservice.domain.service.WordSimilarityResult;
import com.labforward.wordstatservice.rest.dto.Response;
import com.labforward.wordstatservice.rest.dto.WordStatRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WordStatIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @DisplayName("Word Stat Controller IT")
    @Test
    public void testWordStatSimilarity_Success(){
        WordStatRequest req =  new WordStatRequest();
        req.setNotebookEntry("Word Word Word word");
        req.setWord("word");
        ResponseEntity<Response> resp = restTemplate.postForEntity("/api/word-stats/similarity",req, Response.class);

        assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(resp.getBody())
                .isNotNull()
                .hasFieldOrProperty("data");

        assertThat(resp.getBody().getData())
                .hasFieldOrPropertyWithValue("frequency",1)
                .extracting(WordSimilarityResult::getWords).asList()
                .hasSameElementsAs(Arrays.asList("Word"));
    }
}
