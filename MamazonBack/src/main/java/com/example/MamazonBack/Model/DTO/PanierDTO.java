package com.example.MamazonBack.Model.DTO;

import java.util.Set;

import com.example.MamazonBack.Model.Entity.Item;

public class PanierDTO {
private Long id;
private Set<Item> liste;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Set<Item> getListe() {
	return liste;
}

public void setListe(Set<Item> liste) {
	this.liste = liste;
}


}
