package com.brewery;

import com.brewery.beans.Brewery;
import com.brewery.beans.BreweryList;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BreweryRestController {

    private final static String BREWERY_ENDPOINT = "https://api.openbrewerydb.org/breweries";

    private List<Brewery> listOfBreweries;


    public BreweryRestController() {
        listOfBreweries = callBreweryExternalEndpoint().getBreweries();
    }


    @GetMapping("/states")
    public List<String> getStates() {
        return listOfBreweries.stream().map(Brewery::getState).distinct().collect(Collectors.toList());
    }

    @GetMapping("/breweries")
    public List<Brewery> getBreweries(){
        return listOfBreweries;
    }

    private BreweryList callBreweryExternalEndpoint() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BREWERY_ENDPOINT);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<Brewery[]> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                Brewery[].class);

        return new BreweryList(Arrays.asList(response.getBody()));
    }

}
