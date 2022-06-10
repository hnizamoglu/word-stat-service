package com.labforward.wordstatservice.domain.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LexicoUtilsTest {

    @ParameterizedTest
    @MethodSource("generateLexicoTestParameters")
    public void splitWords_Success(String sentence, List<String> expected){
        List<String> result = LexicoUtils.splitToWords(sentence);
        assertThat(result)
                .hasSameElementsAs(expected);

    }

    private static Stream<Arguments> generateLexicoTestParameters(){
        return Stream.of(
                Arguments.of("Word Words Wor word", Arrays.asList("Word","Words","Wor","word")),
                Arguments.of("word", Collections.singletonList("word")),
                Arguments.of("", Collections.emptyList()),
                Arguments.of(null, Collections.emptyList())
        );
    }
}