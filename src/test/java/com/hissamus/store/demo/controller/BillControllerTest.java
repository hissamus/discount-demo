package com.hissamus.store.demo.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hissamus.store.demo.model.Bill;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(value = { "classpath:application.properties" })
public class BillControllerTest {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private BillController controller;

	@Test
	public void actionTest_Employee() throws Exception {
		String[] items = { "furniture", "clothes" };
		ResponseEntity<Bill> responseEntityBill = controller.action("ashok", items);
		Assert.assertNotNull(responseEntityBill);
		Bill bill = responseEntityBill.getBody();

		Assert.assertEquals(30.0, bill.getDiscount(),0);
		Assert.assertEquals("ashok", bill.getUserName());
		Assert.assertEquals(2, bill.getItems().size());
		Assert.assertEquals("User is an employee", bill.getDescription());

	}

	@Test
	public void actionTest_Affilated_User() throws Exception {
		String[] items = { "furniture", "clothes" };
		ResponseEntity<Bill> responseEntityBill = controller.action("abhishek", items);
		Assert.assertNotNull(responseEntityBill);
		Bill bill = responseEntityBill.getBody();

		Assert.assertEquals(10.0, bill.getDiscount(),0);
		Assert.assertEquals("abhishek", bill.getUserName());
		Assert.assertEquals(2, bill.getItems().size());
		Assert.assertEquals("User is an affliated", bill.getDescription());
	}

	@Test
	public void actionTest_2PlusYearOld_User() throws Exception {
		String[] items = { "furniture", "clothes" };
		ResponseEntity<Bill> responseEntityBill = controller.action("rohit", items);
		Assert.assertNotNull(responseEntityBill);
		Bill bill = responseEntityBill.getBody();

		Assert.assertEquals(2.0, bill.getDiscount(),0);
		Assert.assertEquals("rohit", bill.getUserName());
		Assert.assertEquals(2, bill.getItems().size());
		Assert.assertEquals("User is more than 2 year old customer", bill.getDescription());
	}

	@Test
	public void actionTest_new_User() throws Exception {
		String[] items = { "furniture", "clothes" };
		ResponseEntity<Bill> responseEntityBill = controller.action("sumeet", items);
		Assert.assertNotNull(responseEntityBill);
		Bill bill = responseEntityBill.getBody();

		Assert.assertEquals(0.0, bill.getDiscount(),0);
		Assert.assertEquals("sumeet", bill.getUserName());
		Assert.assertEquals(2, bill.getItems().size());
		Assert.assertEquals("User is a new customer", bill.getDescription());

	}
}
