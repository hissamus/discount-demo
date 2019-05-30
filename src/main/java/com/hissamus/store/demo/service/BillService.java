package com.hissamus.store.demo.service;

import com.hissamus.store.demo.model.Bill;

public interface BillService {

	Bill checkout(String username,String[] items);
}
