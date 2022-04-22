package SoulCode.Servicos.Controllers;


import java.net.URI;
import java.util.List;

import SoulCode.Servicos.Repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import SoulCode.Servicos.Models.Funcionario;
import SoulCode.Servicos.Services.FuncionarioService;


@CrossOrigin 
@RestController 
@RequestMapping("servicos")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService funcionarioService;

	@Autowired
	FuncionarioRepository funcionarioRepository;;
	
	@GetMapping("/funcionario")
	public List<Funcionario> mostrarTodosFuncionarios(){
		List<Funcionario> funcionarios = funcionarioService.mostrarTodosFuncionarios();
		return funcionarios;
	}
	
	@GetMapping("/funcionario/{idFuncionario}")
	public ResponseEntity<Funcionario> mostrarUmFuncionario(@PathVariable Integer idFuncionario){
		if (!funcionarioRepository.existsById(idFuncionario)){
			ResponseEntity.notFound().build();
		}
		Funcionario funcionario = funcionarioService.mostrarUmFuncionario(idFuncionario);
		return ResponseEntity.ok().body(funcionario);
	}


	@DeleteMapping("/funcionario/{idFuncionario}")
	public ResponseEntity<Funcionario> deletarUmFuncionario(@PathVariable Integer idFuncionario){
		if (!funcionarioRepository.existsById(idFuncionario)){
			ResponseEntity.notFound().build();
		}
		funcionarioRepository.deleteById(idFuncionario);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/funcionario")
	public ResponseEntity<Funcionario> inserirFuncionario(@RequestBody Funcionario funcionario){
		// nessa linha 44, o novo funcionário já é salvo no banco de dados e já é criado o seu id
		funcionario = funcionarioService.inserirFuncionario(funcionario);
		URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(funcionario.getIdFuncionario()).toUri();
		return ResponseEntity.created(novaUri).build();
	}
	
	@PutMapping("/funcionario/{idFuncionario}")
	public ResponseEntity<Funcionario> editarFuncionario(@PathVariable Integer idFuncionario,
										@RequestBody Funcionario funcionario){
		funcionario.setIdFuncionario(idFuncionario);
		funcionario = funcionarioService.editarFuncionario(funcionario);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("funcionario/{idFuncionario}")
	public ResponseEntity<Void> excluirFuncionario(@PathVariable Integer idFuncionario){
		funcionarioService.excluirFuncionario(idFuncionario);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/findByNome")
	public List<Funcionario> findByNome(@RequestParam("nome") String nome){
		List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);
		return funcionarios;
	}


	@GetMapping("/findByIdFuncionarioAndNome")
	public Funcionario findByIdFuncionarioAndNome(@RequestParam("id") Integer id,@RequestParam("nome") String nome){
		Funcionario funcionarios = funcionarioRepository.findByIdFuncionarioAndNome(id, nome);
		return funcionarios;
	}

	@GetMapping("/findByIdFuncionarioAndEmail")
	public Funcionario findByIdFuncionarioAndEmail(@RequestParam("id") Integer id,@RequestParam("email") String email){
		Funcionario funcionarios = funcionarioRepository.findByIdFuncionarioAndEmail(id, email);
		return funcionarios;
	}
}
