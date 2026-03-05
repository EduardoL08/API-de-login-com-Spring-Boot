package br.com.eduardo.projeto_api_loguin.Repository;

import br.com.eduardo.projeto_api_loguin.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InterfaceUsuario extends JpaRepository<Usuario, Integer> {

}
