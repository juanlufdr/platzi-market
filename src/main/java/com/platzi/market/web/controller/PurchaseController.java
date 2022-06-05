package com.platzi.market.web.controller;


import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    };

    @GetMapping("/{clientId}")
    public ResponseEntity<Optional<List<Purchase>>> getByClient(@PathVariable("clientId") String clientId) {
        return new ResponseEntity<>(purchaseService.getByClient(clientId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}