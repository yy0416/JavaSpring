package com.example.MamazonBack.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MamazonBack.Model.Entity.Item;
import com.example.MamazonBack.Model.Repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRp;
	
	public List<Item> getAllItems() {
		return this.itemRp.findAll();
	}
	
	public Item getItemById(Long id) {
		return this.itemRp.findById(id).get();
	}
	
	public Item createItem(Item item) {
		return this.itemRp.save(item);
	}

	public Item updateItemById(Long id, Item item) {
		Item it = this.itemRp.findById(id).get();
		it.setName(item.getName());
		it.setCategory(item.getCategory());
		it.setPhoto(item.getPhoto());
		it.setPrice(item.getPrice());
		it.setQuantity(item.getQuantity());
		return this.itemRp.save(it);
	}
	
	public void deleteById(Long id) {
		this.itemRp.deleteById(id);
	}
	
}
