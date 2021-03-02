package com.vakt.traders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vakt.traders.entity.TradeEntity;
import com.vakt.traders.model.TradeModel;
import com.vakt.traders.service.TradeService;


@RestController
@CrossOrigin(origins="*") 
public class TradeController {
	
	@Autowired
	private TradeService itemService;
	
	@GetMapping("/api/getAllItems")
	 public List<TradeEntity> getAllItems() {
	  List<TradeEntity> employees = itemService.getAllItems();
	  return employees;
	 }
	  
	 @GetMapping("/api/getItemById/{itemId}")
	 public List<TradeEntity> getItemById(@PathVariable(name="itemId")Long itemId) {
	  return itemService.getItemById(itemId);
	 }
	  
	 @PostMapping("/api/saveItem")
	 public void saveItem(@RequestBody List<TradeModel> items){
		 itemService.saveItem(items);
	  System.out.println("Item Saved Successfully");
	 }
	  
	 @DeleteMapping("/api/deleteItem/{ItemId}")
	 public void deletePersonById(@PathVariable(name="ItemId")Long itemId){
		 itemService.deleteItemById(itemId);
	  System.out.println("Item Deleted Successfully");
	 }
	  
	 @PostMapping("/api/updateItemById/{itemId}")
	 public void updateEmployee(@RequestBody TradeEntity item,
	   @PathVariable(name="itemId")Long itemId){
		 List<TradeEntity> emp = itemService.getItemById(itemId);
	  if(emp.get(0) != null){
		  itemService.updateItem(item);
	  }
	   
	 }

}
