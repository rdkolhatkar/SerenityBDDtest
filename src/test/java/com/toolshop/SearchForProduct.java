package com.toolshop;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class SearchForProduct extends UIInteractions {
    @BeforeEach
    public void openSite(){
        openUrl("https://practicesoftwaretesting.com/");
    }
    @Test
    public void searchByKeyword(){
        // Enter "Saw" in the search field
        $("#search-query").typeAndEnter("saw");

        // Count the number of products
        List<String> displayProducts = getDisplayedProducts();
        assertThat(displayProducts).contains("Wood Saw", "Circular Saw");
    }

    @NotNull
    private List<String> getDisplayedProducts() {
        List<String> displayProducts
                = findAll(".card-title")
                .textContents().stream().map(titleValue -> titleValue.strip())
                .toList();
        return displayProducts;
    }

    @Test
    public void filterSearchResults(){
        var hammerCheckBox = $("#filters")
                .findBy("//label[contains(.,'Hammer')]/input");
        hammerCheckBox.click();
        boolean isChecked = Boolean.parseBoolean(hammerCheckBox.getAttribute("check"));
        assertThat(isChecked).isTrue();
        List<String> displayProducts = getDisplayedProducts();
        assertThat(displayProducts).allMatch(
                name -> name.toLowerCase().contains("hammer")
        );
    }

    @Test
    public void shouldSortByName(){
        var sortDropdown = $("[data-test=sort]");
        sortDropdown.select().byVisibleText("Name (A - Z)");
        waitFor(250).milliseconds();
        System.out.println(sortDropdown.getSelectedValues());
        List<String> displayedProducts = getDisplayedProducts();
        assertThat(displayedProducts).isSorted();

    }
}
