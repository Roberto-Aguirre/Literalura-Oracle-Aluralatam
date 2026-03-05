package com.literalura.rias.entities.DTOS;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Result {
        private Integer id;
        private String title;
        private List<AuthorResponse> authors;
        private List<String> languages;
        private Integer download_count;

    }
