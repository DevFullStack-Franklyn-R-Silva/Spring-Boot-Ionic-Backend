package com.github.franklyn.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.franklyn.cursomc.domain.Produto;
import com.github.franklyn.cursomc.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto buscar(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElse(null);
	}
}
