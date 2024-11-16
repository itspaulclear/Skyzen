package com.miempresa.articulos.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.miempresa.articulos.entity.Articulo;

public interface IArticuloRepository extends PagingAndSortingRepository<Articulo, Long>,  JpaRepository<Articulo, Long>{
	Page<Articulo> findAllByCategoria(String categoria, Pageable page);
	Page<Articulo> findAll(Pageable pageable);
}
