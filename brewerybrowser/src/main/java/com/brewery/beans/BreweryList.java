package com.brewery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class BreweryList {
    private List<Brewery> breweries;

    public BreweryList() {
        breweries = new ArrayList<>();
    }
}
