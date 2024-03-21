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

import com.example.MamazonBack.Model.Entity.Panier;
import com.example.MamazonBack.Service.PanierService;

@RestController
@RequestMapping("/paniers")
public class PanierController {
	@Autowired
private PanierService panierService;
	
	@GetMapping
	public List<Panier> getAllPanier(){
		return this.panierService.getAllPanier();
	}
	
	@GetMapping("/{id}")
	public Panier getPanierById(@PathVariable Long id) {
		return this.panierService.getPanierById(id);
	}
	
	@PostMapping
	public Panier createPanier(@RequestBody Panier panier) {
		return this.panierService.createPanier(panier);
	}
	
	@PutMapping("/{id}")
	public Panier updatePanierById(@PathVariable Long id, @RequestBody Panier panier) {
		return this.panierService.updatePanier(id, panier);
	}
	@DeleteMapping("/{id}")
	public void deletePanierById(@PathVariable Long id) {
		this.panierService.deletePanierById(id);
	}
	
	
}
