package br.imc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.imc.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
