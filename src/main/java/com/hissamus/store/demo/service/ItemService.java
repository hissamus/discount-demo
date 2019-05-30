package com.hissamus.store.demo.service;

import java.util.List;

import com.hissamus.store.demo.model.Items;
import com.hissamus.store.demo.model.User;

public interface ItemService {

	List<Items> getAllItems();
	List<Items> findByType(String type);	
}
