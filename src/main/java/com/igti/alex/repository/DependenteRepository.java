package com.igti.alex.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.igti.alex.model.Dependente;

@Transactional
public interface DependenteRepository extends CrudRepository<Dependente, Integer>  {

}
