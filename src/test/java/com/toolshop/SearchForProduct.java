package com.toolshop;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class SearchForProduct extends UIInteractions {
    @Test
    public void searchByKeyword(){
        openUrl("https://practicesoftwaretesting.com/");

        // Enter "Saw" in the search field
        $("#search-query").typeAndEnter("saw");

        // Count the number of products
        List<String> displayProducts
                = findAll(".card-title")
                .textContents().stream().map(titleValue -> titleValue.strip())
                .toList();

        //assertThat(displayProducts).contains("Wood Saw", "Circular Saw");

    }
}
