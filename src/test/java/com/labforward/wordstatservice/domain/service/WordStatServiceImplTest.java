package com.labforward.wordstatservice.domain.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WordStatServiceImplTest {

    WordStatService wordStatService = new WordStatServiceImpl();

    @ParameterizedTest
    @MethodSource("generateSimilarityParameters")
    void getWordSimilarityInSentence(WordStatServiceTestParameter param) {

        WordSimilarityResult actual =
                wordStatService.getWordSimilarityInSentence(param.givenSentence,param.givenWord);

        assertThat(actual)
                .as("result header check")
                .isNotNull()
                .hasFieldOrPropertyWithValue("frequency",param.expectedFrequency);

        assertThat(actual.getWords())
                .as("result list check")
                .hasSameElementsAs(param.expectedWordList);
    }

    private static Stream<Arguments> generateSimilarityParameters(){
        return Stream.of(
                Arguments.of(new WordStatServiceTestParameter(
                        "Word Words Wor word",
                        "Word",
                        1,
                        Arrays.asList("Words","Wor","word"))),

                Arguments.of(new WordStatServiceTestParameter(
                        "Word Word Word word",
                        "Word",
                        3,
                        Arrays.asList("word"))),

                Arguments.of(new WordStatServiceTestParameter(
                        "",
                        "",
                        0,
                        Collections.emptyList())),

                Arguments.of(new WordStatServiceTestParameter(
                        null,
                        null,
                        0,
                        Collections.emptyList()))
        );
    }

    static class WordStatServiceTestParameter {
        String givenSentence;
        String givenWord;
        int expectedFrequency;
        List<String> expectedWordList;

        public WordStatServiceTestParameter(String givenSentence,
                                            String givenWord,
                                            int expectedFrequency,
                                            List<String> expectedWordList) {
            this.givenSentence = givenSentence;
            this.givenWord = givenWord;
            this.expectedFrequency = expectedFrequency;
            this.expectedWordList = expectedWordList;
        }
    }
}