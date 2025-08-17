package br.imc.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import br.imc.model.Usuario;
import br.imc.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioWebController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Get Lista todos os usuários na página HTML
	@GetMapping
	public String listarUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "usuarios/lista"; // vai procurar em templates/usuários/list.html
	}
	
	// Get formulário para novno usuário
	@GetMapping("/novo")
	public String exibirFormularioCadastro(Model model) {
		model.addAttribute("usuario", new Usuario());
		  return "usuarios/formulario";
	}
	// Post salvar usuário
	@PostMapping
	public String salvarUsuario(@ModelAttribute Usuario usuario) {
		usuarioRepository.save(usuario);
		return "redirect:/usuarios";
	}
	
	// Get editar usuários existente
	@GetMapping("/editar/{id}")
	public String editarUsuario(@PathVariable Integer id, Model model) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido" + id));
		model.addAttribute("usuario", usuario);
		return "usuarios/formulario";
	}	
	
	// Get deletar usuário
	@GetMapping("deletar/{id}")
	public String deletarUsuario(@PathVariable Integer id) {
		usuarioRepository.deleteById(id);
		return "Redirect:/usuarios";
	}
	
	
	
	
	
	
	
	
}
