package com.vakt.traders.service;

import java.util.List;

import com.vakt.traders.entity.TradeEntity;
import com.vakt.traders.model.TradeModel;

public interface TradeService {

	List<TradeEntity> getAllItems();

	void saveItem(List<TradeModel> items);

	List<TradeEntity> getItemById(Long itemId);

	void deleteItemById(Long itemId);

	void updateItem(TradeEntity item);
	

}
