package com.example.MamazonBack.Model.Entity;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Panier {
    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;
    
    @OneToOne(mappedBy="panier")
    private User user;
    
    @ManyToMany(mappedBy = "paniers")  
    private Set<Item> paniers = new LinkedHashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Item> getPaniers() {
		return paniers;
	}

	public void setPaniers(Set<Item> paniers) {
		this.paniers = paniers;
	}

	
    
    
  
}
