package com.example.MamazonBack.Model.Entity;



import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity
public class Item {
	
	@Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;
     
    @ManyToMany
    @JoinTable(
        name = "Item_Panier", 
        joinColumns = @JoinColumn(name = "ITEM_ID"), 
        inverseJoinColumns = @JoinColumn(name = "PANIER_ID")
    )
    private Set<Panier> paniers;
    private String name;
    private String photo;
    private float price;
    private int quantity;
    private String category;


public Set<Panier> getPaniers() {
		return paniers;
	}
	public void setPaniers(Set<Panier> paniers) {
		this.paniers = paniers;
	}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}


}
