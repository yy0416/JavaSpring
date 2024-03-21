package com.example.MamazonBack.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MamazonBack.Model.Entity.Panier;
import com.example.MamazonBack.Model.Repository.PanierRepository;

@Service
public class PanierService {
	@Autowired
	private PanierRepository panierRp;
	
	public List<Panier> getAllPanier(){
		return this.panierRp.findAll();
	}
	
	public Panier getPanierById(Long id) {
		return this.panierRp.findById(id).get();
	}
	
	public Panier createPanier(Panier panier) {
		return this.panierRp.save(panier);
	}
	
	public Panier updatePanier(Long id,Panier panier) {
		Panier pn = this.panierRp.findById(id).get();
		pn.setPaniers(panier.getPaniers());
		return this.panierRp.save(pn);
	}
	
	public void deletePanierById(Long id) {
		this.panierRp.deleteById(id);
	} 

}
