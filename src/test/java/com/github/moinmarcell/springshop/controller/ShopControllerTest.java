package com.github.moinmarcell.springshop.controller;

import com.github.moinmarcell.springshop.model.Product;
import com.github.moinmarcell.springshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ShopControllerTest {
    /*
    Aufgabe:
    ToDo Schreibt Integrationstests für den ShopController
    Todo Wer die ersten 2 Methoden fertig hat, schreibt bitte Endpunkte für die anderen Servicemethoden
    ...und testet die dann
     */
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void getAllProducts_whenNoProductsInDB_thenReturnEmptyList() throws Exception {
        // Wir wollen die Endpunkte des ShopControllers testen
        // Z.B.
        // www.unser-shop.de/shop/products

        // Gewünschtes Ergebnis: []
        // D.h. eine leere Liste

        mvc.perform(get("/shop/products"))
                .andExpect(status().isOk())
                // Wir erwarten ein JSON
                // = Ein Textformat um Objekte darzustellen
                // Wir nutzen die drei Anführungsstiche,
                // um einen String über mehrere Zeile darzustellen

                // Es ist KEIN JSON
                // ... wir _benutzen_ es aber für JSON
                .andExpect(content().json(
                        """
                                []
                                """));
    }

    @Test
    void getProduct() throws Exception {
        productRepository.list().add(new Product("Birne", "1"));
        mvc.perform(get("/shop/products/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                {
                                "name": "Birne",
                                "id": "1"
                                }
                                                                """));

    }

    @Test
    void addProduct() throws Exception {
        productRepository.add().
    }
}


