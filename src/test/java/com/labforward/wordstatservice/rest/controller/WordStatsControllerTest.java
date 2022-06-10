package com.labforward.wordstatservice.rest.controller;

import com.labforward.wordstatservice.domain.service.WordSimilarityResult;
import com.labforward.wordstatservice.domain.service.WordStatService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WordStatsController.class)
class WordStatsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WordStatService wordStatService;

    @Test
    void getFrequency_Success() throws Exception {
        String sentence = "asdf asdfg asde";
        String word = "asdf";
        String jsonQuery = "{\"notebookEntry\":\""+sentence+"\",\"word\":\""+word+"\"}";
        WordSimilarityResult result = new WordSimilarityResult(1, Arrays.asList("asdf","asde"));

        Mockito.when(wordStatService.getWordSimilarityInSentence(sentence,word)).thenReturn(result);

        mockMvc.perform(
                post("/api/word-stats/similarity")
                        .content(jsonQuery)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.systemTime",is(notNullValue())))
                .andExpect(jsonPath("$.data",is(notNullValue())))
                .andExpect(jsonPath("$.data.frequency",is(1)))
                .andExpect(jsonPath("$.data.words",contains("asdf","asde")));
        verify(wordStatService,times(1)).getWordSimilarityInSentence(sentence,word);
    }
}