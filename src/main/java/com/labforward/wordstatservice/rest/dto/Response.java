package com.labforward.wordstatservice.rest.dto;

import com.labforward.wordstatservice.domain.service.WordSimilarityResult;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Response {
    private LocalDateTime systemTime = LocalDateTime.now();
    private WordSimilarityResult data;
}
