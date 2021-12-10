package com.github.franklyn.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.franklyn.cursomc.domain.Produto;
import com.github.franklyn.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Produto obj = produtoService.buscar(id);

		return ResponseEntity.ok().body(obj);
	}

}
