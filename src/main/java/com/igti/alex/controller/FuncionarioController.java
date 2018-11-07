package com.igti.alex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igti.alex.dto.FuncionarioDTO;
import com.igti.alex.service.FuncionarioService;

@RestController
@RequestMapping("/{apiPath}/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping(value = "/calcularAumento")
	public String calcularAumento() {
		return funcionarioService.calculateSalary();
	}

	@GetMapping(value = "/list")
	public List<FuncionarioDTO> retornaListaFuncionarios() {
		return funcionarioService.findFuncionarioWithDependentes();
	}
}
