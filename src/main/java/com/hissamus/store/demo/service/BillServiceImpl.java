package com.hissamus.store.demo.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hissamus.store.demo.model.Bill;
import com.hissamus.store.demo.model.Items;
import com.hissamus.store.demo.model.User;
import com.hissamus.store.demo.utils.ItemType;
import com.hissamus.store.demo.utils.UserType;



@Service
public class BillServiceImpl implements BillService {
	private static Logger logger = LoggerFactory.getLogger(BillServiceImpl.class);

	@Autowired
	private ItemService itemService;

	@Autowired
	private UserService userService;

	private static final int DISCOUNT_PER_HUNDRED = 5;

	@Override
	public Bill checkout(String username, String[] items) {

		Double discount = 0d;
		double totalDiscountedPrice = 0;
		Bill bill = new Bill();
		logger.info("calling userService.findByUsername(username) for user:" + username);
		Optional<User> optionalUser = Optional.ofNullable(userService.findByUsername(username));

		if (optionalUser.isPresent()) {
			logger.info(username + " is already a customer");
			User user = optionalUser.get();
			discount = calulateDiscount(user,bill);
		}

		for (Items item : getSelectedItems(items)) {
			totalDiscountedPrice = totalDiscountedPrice + getDiscountedPrice(item, discount);
		}

		totalDiscountedPrice = Math.round(totalDiscountedPrice - getDiscountBasedOnTotalAmount(totalDiscountedPrice));
		
		bill.setDiscount(discount);
		bill.setGrossBill(totalDiscountedPrice);
		bill.setItems(getSelectedItems(items));
		bill.setUserName(username);
		logger.info(bill.toString());
		return bill;
	}

	public double getDiscountedPrice(Items item, double discount) {
		Double cost = item.getCost().doubleValue();
		if (!item.getType().equalsIgnoreCase(ItemType.GROCERY.getValue()) && discount != 0) {
			logger.info("Cost calculated for item (not a grocery):" + item.getProduct() + " is=" + cost);
			return (cost - cost * discount / 100);
		}
		logger.info("Cost calculated for item " + item.getProduct() + " is=" + cost);
		return cost;
	}

	private double getDiscountBasedOnTotalAmount(double totalDiscountedPrice) {
		return Math.floor(totalDiscountedPrice / 100) * DISCOUNT_PER_HUNDRED;
	}

	private List<Items> getSelectedItems(String[] items) {
		logger.info("getSelectedItems(String[] items):" + Arrays.toString(items));
		List<Items> itemsList = new ArrayList<>();
		Stream<String> listStream = Arrays.stream(items);
		List<Items> allItems = itemService.getAllItems();
		logger.info("Get all items from db");
		allItems.stream().forEach(action -> logger.info(action.toString()));

		listStream.forEach(selectedItem -> {
			logger.info(selectedItem);
			itemsList.addAll(allItems.stream().filter(item -> item.getProduct().equalsIgnoreCase(selectedItem))
					.collect(Collectors.toList()));
		});
		logger.info("caluculated getSelectedItems(String[] items):");
		itemsList.stream().forEach(action -> logger.info(action.toString()));
		return itemsList;

	}

	private double calulateDiscount(User user,Bill bill) {
		double discount = 0d;
		if (user.isEmployee())
			{
			discount = UserType.EMPLOYEE.getValue();
			bill.setDescription("User is an employee");
			}
		else if (user.isAffliated())
			{
			discount = UserType.AFFILIATE.getValue();
			bill.setDescription("User is an affliated");
			}
		else {
			LocalDate twoYearPeriod = LocalDate.now().minusYears(2);
			logger.info("user.getDate().toLocalDate().toString():"+user.getDate().toLocalDate().toString()+":\ntwoYearPeriod="+twoYearPeriod.toString()+"\n Period.between(user.getDate().toLocalDate(), twoYearPeriod).getYears()=>"+Period.between(user.getDate().toLocalDate(), twoYearPeriod).getYears());
			if (Period.between(user.getDate().toLocalDate(), twoYearPeriod).getYears() > 2) {
				logger.info("user:" + user.getName() + " is 2year old customer so calulated discount is=" + discount);
				discount = UserType.OLD_CUSTOMER.getValue();
				bill.setDescription("User is more than 2 year old customer");
			}else
			{
				bill.setDescription("User is a new customer");
			}
			
		}

		logger.info("discount is set to" + discount);
		return discount;
	}

}
