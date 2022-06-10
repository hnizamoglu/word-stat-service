package com.labforward.wordstatservice.domain.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class WordSimilarityResult {
    private int frequency;
    private List<String> words;
}
