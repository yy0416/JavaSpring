package com.example.MamazonBack.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MamazonBack.Model.Entity.Item;
import com.example.MamazonBack.Service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@GetMapping
	public List<Item> getAllItems(){
		return this.itemService.getAllItems();
	}

	@GetMapping("/{id}")
	public Item getItemById(@PathVariable Long id) {
		return this.itemService.getItemById(id);
	}
	
	@PostMapping
	public Item createItems(@RequestBody Item item) {
		return this.itemService.createItem(item);
	}
	
	@PutMapping("/{id}")
	public Item updateItemsById(@PathVariable Long id, @RequestBody Item item) {
		return this.itemService.updateItemById(id, item);
	}
	
	@DeleteMapping("/{id}")
	public void deleteItemById(@PathVariable Long id) {
		 this.itemService.deleteById(id);
	}
}
