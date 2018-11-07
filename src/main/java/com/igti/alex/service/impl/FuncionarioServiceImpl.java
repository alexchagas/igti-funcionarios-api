package com.igti.alex.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igti.alex.dto.DependenteDTO;
import com.igti.alex.dto.FuncionarioDTO;
import com.igti.alex.model.Dependente;
import com.igti.alex.model.Pessoa;
import com.igti.alex.repository.PessoaRepository;
import com.igti.alex.service.FuncionarioService;

@Service
@Transactional
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EntityManager entityManager;

	public String calculateSalary() {
		StringBuilder log = new StringBuilder();
		log.append("****Processo de Cálculo de Aumento Salarial - Iniciado em " + (new Date().toString()));
		log.append(System.lineSeparator());

		List<Pessoa> listAllPessoa = (List<Pessoa>) pessoaRepository.findAll();

		for (Pessoa pessoa : listAllPessoa) {
			try {
				Float novoPercentual = getNewPercentual(pessoa, log);
				if (novoPercentual > 1) {
					Float salarioAntigo = retornaSalario(pessoa);
					Float novoSalario = salarioAntigo * (novoPercentual);
					pessoa.setSalario(novoSalario);
					log.append("    Salário Antigo:[R$ " + salarioAntigo + "]");
					log.append("    Novo Salário  :[R$ " + novoSalario + "] = (" + salarioAntigo + " * "
							+ novoPercentual + " )");
//	            GravaDados(funcionario);
					log.append(System.lineSeparator());
				}
			} catch (Exception ex) {
				log.append("Erro ao processar funcionário " + pessoa.getId() + "/" + pessoa.getNome() + ":"
						+ ex.getMessage());
			}
		}
		return log.toString();
	}

	protected Float getNewPercentual(Pessoa pessoa, StringBuilder log) throws Exception {
		Float percentual = 1F;
		if (Ativo(pessoa) && atendeFaixaSalarial(pessoa)) {
			log.append(">   Processando dados do funcionário " + pessoa.getId() + ":" + pessoa.getNome());
			percentual += 0.1F;
			log.append("    Percentual Base: {percentual - 1}");

			int anosTrabalhados = retornaAnosTrabalhados(pessoa);
			log.append("    Anos trabalhados (Limitado a 3): {anosTrabalhados}");
			Float percentualAnos = (0.02F * anosTrabalhados);

			Float percentualCalculado = percentual + percentualAnos;
			log.append("    Percentual Final = (" + (percentual - 1) + " ) + ( " + percentualAnos + " ) = [("
					+ (percentualCalculado - 1) + " ) * 100}%]  ");
			percentual += percentualAnos;
		}
		return percentual;
	}

	protected int retornaAnosTrabalhados(Pessoa pessoa) {
		Calendar a = getCalendar(pessoa.getIniciocontrato());
		Calendar b = getCalendar(new Date());
		int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
		if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH)
				|| (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
			diff--;
		}
		return diff;
	}

	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance(Locale.US);
		cal.setTime(date);
		return cal;
	}

	protected Float retornaSalario(Pessoa pessoa) throws Exception {
		Float result = pessoa.getSalario();
		if (result < 0)
			throw new Exception("Cálculo bloqueado para salários negativos!");
		return result;
	}

	protected Boolean atendeFaixaSalarial(Pessoa pessoa) throws Exception {
		Float salario = retornaSalario(pessoa);
		return (salario >= 1000) && (salario < 5000);
	}

	protected Boolean Ativo(Pessoa pessoa) {
		return pessoa.getAtivo().equals("S");
	}

	public List<FuncionarioDTO> findFuncionarioWithDependentes() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p FROM Pessoa p ");
		sb.append("LEFT JOIN FETCH p.dependentes dependentes ");
		List<Pessoa> list = entityManager.createQuery(sb.toString(), Pessoa.class).getResultList();

		List<FuncionarioDTO> listFuncionarios = new ArrayList<FuncionarioDTO>();
		for (Pessoa pessoa : list) {
			FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
			funcionarioDTO.setDependentes(new ArrayList<DependenteDTO>());
			BeanUtils.copyProperties(pessoa, funcionarioDTO, null, "dependentes");
			for (Dependente dependente : pessoa.getDependentes()) {
				DependenteDTO dependenteDTO = new DependenteDTO();
				BeanUtils.copyProperties(dependente, dependenteDTO, null, "pessoa");
				dependenteDTO.setPessoa(pessoa.getId());
				funcionarioDTO.getDependentes().add(dependenteDTO);
			}
			BeanUtils.copyProperties(pessoa, funcionarioDTO, null, "dependentes");
			listFuncionarios.add(funcionarioDTO);
		}
		return listFuncionarios;
	}
}
