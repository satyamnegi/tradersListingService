package com.vakt.traders.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TradeModel {

	private Long id;
	
	private String name;
	
	private String desc;
	
	private double price;
	
	private String currency;
	
}
