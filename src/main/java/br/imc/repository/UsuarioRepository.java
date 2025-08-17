package br.imc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.imc.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Você pode adicionar métodos personalizados aqui, como:

	//findByEmail(String email);
}
