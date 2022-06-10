package com.labforward.wordstatservice;

import com.labforward.wordstatservice.rest.controller.WordStatsController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WordStatServiceApplicationTests {

    @Autowired
    WordStatsController wordStatsController;

    @DisplayName("Smoke Test")
    @Test
    void contextLoads() {
        assertThat(wordStatsController).isNotNull();
    }

}
