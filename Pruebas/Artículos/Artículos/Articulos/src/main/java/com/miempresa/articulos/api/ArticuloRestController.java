package com.miempresa.articulos.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miempresa.articulos.entity.Articulo;
import com.miempresa.articulos.service.IArticuloService;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloRestController {
	@Autowired
	private IArticuloService articuloService;
	
	@GetMapping("/listado")
	public List<Articulo> getAllArticulos() {
		return articuloService.getAllArticulos();
	}
	
	@GetMapping("/listado/id/{id}")
	public Articulo getArticuloById(@PathVariable Long id) {
		return articuloService.getArticuloById(id);
	}
	
	@GetMapping("/listado/{categoria}")
	public List<Articulo> getArticuloByCategoria(@PathVariable String categoria) {
		List<Articulo> articulos = articuloService.getAllArticulos();
		List<Articulo> articulosFiltrados = new ArrayList<>();
		for(Articulo articulo : articulos) {
			if(articulo.getCategoria().equalsIgnoreCase(categoria)) {
				articulosFiltrados.add(articulo);
			}
		}
		return articulosFiltrados;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void deleteById(@PathVariable Long id) {
		articuloService.deleteById(id);
	}
	
	@PutMapping("/editar")
	public void editarArticulo(@RequestBody Articulo articulo) {
		articuloService.updateArticulos(articulo);
	}
	
	@PostMapping("/publicar")
	public void publicarArticulo(@RequestBody Articulo articulo) {
		articuloService.updateArticulos(articulo);
	}
}
