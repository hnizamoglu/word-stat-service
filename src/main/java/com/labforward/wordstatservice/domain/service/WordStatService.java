package com.labforward.wordstatservice.domain.service;

import java.util.List;

public interface WordStatService {
    WordSimilarityResult getWordSimilarityInSentence(String sentence, String word);
}
