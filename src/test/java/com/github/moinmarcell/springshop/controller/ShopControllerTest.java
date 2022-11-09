package com.github.moinmarcell.springshop.controller;

import com.github.moinmarcell.springshop.model.Order;
import com.github.moinmarcell.springshop.model.Product;
import com.github.moinmarcell.springshop.repository.OrderRepository;
import com.github.moinmarcell.springshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

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
    @Autowired
    private OrderRepository orderRepository;

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
        mvc.perform(post("/shop/products/addProduct")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                        {
                                        "name": "Birne",
                                        "id": "1"      
                                        }
                                        """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                        "name": "Birne",
                        "id": "1"
                        }
                        """));
    }

    @Test
    @DirtiesContext
    void getOrder() throws Exception {
        orderRepository.list().add(new Order("8", Collections.emptyList()));
        mvc.perform(get("/shop/orders/8"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                {
                                "id": "8",
                                "products": []
                                                                
                                }
                                """

                ));

    }

    @Test
    void addOrder() throws Exception {
        mvc.perform(post("/shop/orders/addorder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                     []
                                     
                                """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                        "id": "1",
                        "products": []
                        }
                        """));
    }
}


