package com.brewery.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Brewery {
    private Long id;
    private String name;

    @JsonProperty("website_url")
    private String websiteUrl;

    private String state;
    private String city;


}
