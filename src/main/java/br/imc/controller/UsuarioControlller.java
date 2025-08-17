package br.imc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.imc.model.Usuario;
import br.imc.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlller {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
		
	
	// Get: Listar todos os usuários
	@GetMapping
	public List<Usuario> listaTodos() {
		return usuarioRepository.findAll();
	}
	
	// Get: Por ID 
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());	
		
	}
	
	// Post: Cadastrar novo usuário
	// Esse função aqui ela cria encima já existente: Exemplo: 1, 2 e 3.
	@PostMapping
	public Usuario criar(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	//Put: Atualizar usuáiro
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Integer id, @RequestBody Usuario usuarioAtualizado) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			Usuario usuarioExistente = optional.get();
			usuarioExistente.setNome(usuarioAtualizado.getNome());
			usuarioExistente.setEmail(usuarioAtualizado.getEmail());
			usuarioExistente.setDataNascimento(usuarioAtualizado.getDataNascimento());
			usuarioExistente.setSexo(usuarioAtualizado.getSexo());
			usuarioExistente.setAltura(usuarioAtualizado.getAltura());
			return ResponseEntity.ok(usuarioRepository.save(usuarioExistente));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
		

}





















