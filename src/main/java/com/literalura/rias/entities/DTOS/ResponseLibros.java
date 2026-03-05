package com.literalura.rias.entities.DTOS;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ResponseLibros {
    @JsonProperty("count")
    private Integer count;
    private String next;
    private String previous;
    private List<Result> results;
    

}
