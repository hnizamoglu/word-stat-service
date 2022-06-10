package com.labforward.wordstatservice.domain.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LexicoUtils {
    public static List<String> splitToWords(String sentence){
        // todo: add logic for punctuation marks
        if(sentence == null || "".equals(sentence.trim())) return Collections.emptyList();
        return Arrays.asList(sentence.split(" "));
    }
}
