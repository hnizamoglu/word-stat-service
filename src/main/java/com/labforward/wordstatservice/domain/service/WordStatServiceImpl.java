package com.labforward.wordstatservice.domain.service;

import com.labforward.wordstatservice.domain.utils.LexicoUtils;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordStatServiceImpl implements WordStatService {

    /**
     * Checks the occurrence count of `word` inside `sentence` and
     * extracts similar words from `sentence` based on Levenshtein distance.
     * The words that have more than 1 distance is not counted as similar.
     * @param sentence sentence that will be looked in
     * @param word word that will be looked for
     * @return frequency and similar words
     */
    @Override
    public WordSimilarityResult getWordSimilarityInSentence(String sentence, String word) {
        List<String> words = LexicoUtils.splitToWords(sentence);
        List<String> result = new ArrayList<>();
        int frequency = 0;
        for(String s : words){
            if(s.equals(word)) {
                ++frequency;
                continue;
            }
            if(!result.contains(s) && LevenshteinDistance.getDefaultInstance().apply(s,word) < 2){
                result.add(s);
            }
        }
        return new WordSimilarityResult(frequency,result);
    }
}
