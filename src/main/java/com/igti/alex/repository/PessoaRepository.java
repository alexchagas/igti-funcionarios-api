package com.igti.alex.repository;

import org.springframework.data.repository.CrudRepository;

import com.igti.alex.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer>  {

}
