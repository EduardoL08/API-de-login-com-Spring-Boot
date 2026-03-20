package br.com.eduardo.projeto_api_loguin.Service;

import br.com.eduardo.projeto_api_loguin.DTO.UsuarioDTO;
import br.com.eduardo.projeto_api_loguin.Model.Usuario;
import br.com.eduardo.projeto_api_loguin.Repository.InterfaceUsuario;
import br.com.eduardo.projeto_api_loguin.Security.Token;
import br.com.eduardo.projeto_api_loguin.Security.TokenUtil;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private InterfaceUsuario repository;
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(InterfaceUsuario repository, BCryptPasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> listarUsuario(){
        List<Usuario> lista = repository.findAll();
        return lista;
    }
    public Usuario criarUser(Usuario usuario){
        String encoder = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }
    public Usuario editarUser(Usuario usuario){
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }
    public boolean deletarUser(Integer id){
        repository.deleteById(id);
        return true;
    }
    public Token gerarToken( UsuarioDTO usuarioDTO) {

        Usuario usuario = repository.findByEmail(usuarioDTO.getEmail());

        if (usuario == null){
            return null;
        }

        if(!passwordEncoder.matches(usuarioDTO.getSenha(), usuario.getSenha())){
            return null;
        }
        String token = TokenUtil.createToken(usuario);

        return new Token(token);
    }
}
