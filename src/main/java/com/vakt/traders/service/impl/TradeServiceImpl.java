package com.vakt.traders.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vakt.traders.entity.TradeEntity;
import com.vakt.traders.model.TradeModel;
import com.vakt.traders.repository.TradeRepository;
import com.vakt.traders.service.TradeService;

@Service
public class TradeServiceImpl implements TradeService{
	
	@Autowired
	private TradeRepository itemRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Environment env;
	
	/**
	 * Get all item listings
	 */
	@Override
	public List<TradeEntity> getAllItems() {
		List<TradeEntity> persons = itemRepository.findAll();
		return persons;
	}

	/**
	 * Create item listing
	 */
	@Override
	public void saveItem(List<TradeModel> items) {
		List<TradeEntity> entities = new ArrayList<>();
		items.stream().forEach(item -> {
			TradeEntity ent = new TradeEntity();
			BeanUtils.copyProperties(item, ent);
			entities.add(ent);
		});
		itemRepository.saveAll(entities);
	}

	/**
	 * Get item listing by Id with currency converted to GBP
	 */
	@Override
	public List<TradeEntity> getItemById(Long itemId) {
		Optional<TradeEntity> optEmp = itemRepository.findById(itemId);
		List<TradeEntity> output = new ArrayList<>();
		TradeEntity obj = optEmp.isPresent() ? optEmp.get() : null;
		if(Objects.isNull(obj)) {
			return output;
		}
		if(obj.getCurrency() != "GBP") {
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>(headers);
	    String url = env.getRequiredProperty("currency.url") + obj.getCurrency() + "_GBP";
	    String str = restTemplate.exchange(
	    		url, HttpMethod.GET, entity, String.class).getBody();
	    String[] str1 = str.split(":");
	    String pass = str1[1].replaceAll("}", "");
	    obj.setPrice(obj.getPrice() * Double.parseDouble(pass));
	    obj.setCurrency("GBP");
		}
		output.add(obj);
		  return output;
	}

	/**
	 * Delete item listing by Id
	 */
	@Override
	public void deleteItemById(Long personId) {
		itemRepository.deleteById(personId);
	}

	/**
	 * Update item listing
	 */
	@Override
	public void updateItem(TradeEntity person) {
		itemRepository.save(person);
	}

}
