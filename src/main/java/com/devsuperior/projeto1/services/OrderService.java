package com.devsuperior.projeto1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.projeto1.entities.Order;

@Service
public class OrderService {

	@Autowired
	private ShippingService shippingService;
	
	public double total(Order order) {
		double ship = shippingService.shipment(order.getBasic());
		return order.getBasic() - (order.getBasic() * order.getDiscount() / 100.0) + ship;
	}
}