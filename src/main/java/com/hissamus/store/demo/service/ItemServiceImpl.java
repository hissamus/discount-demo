package com.hissamus.store.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hissamus.store.demo.model.Items;
import com.hissamus.store.demo.repository.ItemsRepository;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemsRepository itemsRepository;

	@Override
	public List<Items> getAllItems() {
		return itemsRepository.findAll();
	}

	@Override
	public List<Items> findByType(String type) {
		// TODO Auto-generated method stub
		return itemsRepository.findByType(type).stream().filter(Objects::nonNull).collect(Collectors.toList());
	}
}
