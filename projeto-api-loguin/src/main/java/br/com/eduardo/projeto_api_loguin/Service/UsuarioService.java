package br.com.eduardo.projeto_api_loguin.Service;

import br.com.eduardo.projeto_api_loguin.Model.Usuario;
import br.com.eduardo.projeto_api_loguin.Repository.InterfaceUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private InterfaceUsuario repository;

    public UsuarioService(InterfaceUsuario repository){
        this.repository = repository;

    }

    public List<Usuario> listarUsuario(){
        List<Usuario> lista = repository.findAll();
        return lista;
    }
    public Usuario criarUser(Usuario usuario){
        Usuario userNovo = repository.save(usuario);
        return userNovo;
    }
    public Usuario editarUser(Usuario usuario){
        Usuario dadosNovos = repository.save(usuario);
        return dadosNovos;
    }

    public boolean deletarUser(Integer id){
        repository.deleteById(id);
        return true;
    }
}
