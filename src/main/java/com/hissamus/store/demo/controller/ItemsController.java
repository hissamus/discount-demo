package com.hissamus.store.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hissamus.store.demo.model.Items;
import com.hissamus.store.demo.model.User;
import com.hissamus.store.demo.service.ItemService;
import com.hissamus.store.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class ItemsController {
	public static final Logger logger = LoggerFactory.getLogger(ItemsController.class);
	 
    @Autowired
    private ItemService itemService;
    
    @GetMapping(value = "/items/{type}")
    public ResponseEntity<List<Items>> findByType(@PathVariable("type") String type) {
        List<Items> items = itemService.findByType(type);
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Items>>(items, HttpStatus.OK);
    }

}
