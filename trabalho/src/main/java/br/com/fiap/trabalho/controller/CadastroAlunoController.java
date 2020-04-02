package br.com.fiap.trabalho.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.trabalho.dto.AlunoDTO;
import br.com.fiap.trabalho.service.AlunoService;

@RestController
@RequestMapping("cadastro")
public class CadastroAlunoController {

	@Autowired
	private AlunoService alunoService;

	@PutMapping
	public AlunoDTO save(@RequestBody AlunoDTO alunoDTO) {
		return alunoService.save(alunoDTO);
	}

	@GetMapping("/aluno/todos")
	public List<AlunoDTO> getAll() {
		return alunoService.getAll();
	}

	@GetMapping("/aluno/{id}")
	public Optional<AlunoDTO> getById(@PathVariable Integer id) {
		return alunoService.getById(id);
	}
	
	@GetMapping("/aluno/nome/{nome}")
	public List<AlunoDTO> getByName(@PathVariable String nome) {
		return alunoService.getByName(nome);
	}

	@DeleteMapping("/aluno/{id}")
	public @ResponseBody void delete(@PathVariable Integer id) {
		alunoService.delete(id);
	}
}
