package com.igti.alex.service;

import java.util.List;

import com.igti.alex.dto.FuncionarioDTO;

public interface FuncionarioService {

	public String calculateSalary();
	
	public List<FuncionarioDTO> findFuncionarioWithDependentes();
	
}
