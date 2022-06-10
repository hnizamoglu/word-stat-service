package com.labforward.wordstatservice.rest.dto;

import lombok.Data;

@Data
public class WordStatRequest {
    private String notebookEntry;
    private String word;
}
