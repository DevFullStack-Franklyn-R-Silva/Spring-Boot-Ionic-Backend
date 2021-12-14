package com.github.franklyn.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.github.franklyn.cursomc.domain.Categoria;
import com.github.franklyn.cursomc.repositories.CategoriaRepository;
import com.github.franklyn.cursomc.services.exceptions.DateIntegrityException;
import com.github.franklyn.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return categoriaRepository.save(obj);
	}

	public void delete(Integer id) {
		try {
			find(id);
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DateIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
}
