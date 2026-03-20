package br.com.eduardo.projeto_api_loguin.Controller;

import br.com.eduardo.projeto_api_loguin.DTO.UsuarioDTO;
import br.com.eduardo.projeto_api_loguin.Model.Usuario;
import br.com.eduardo.projeto_api_loguin.Security.Token;
import br.com.eduardo.projeto_api_loguin.Service.UsuarioService;
import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class usuarioController {

    private UsuarioService usuarioService;

    public usuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuarios (){
        return ResponseEntity.status(200).body(usuarioService.listarUsuario());
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario){
        return ResponseEntity.status(201).body(usuarioService.criarUser(usuario));
    }

    @PutMapping
    public ResponseEntity<Usuario> editarUsuario(@Valid @RequestBody Usuario usuario){
        return ResponseEntity.status(200).body(usuarioService.editarUser(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuario(@PathVariable Integer id) {
        usuarioService.deletarUser(id);
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Token> logar(@Valid @RequestBody UsuarioDTO usuarioDTO){

        Token token = usuarioService.gerarToken(usuarioDTO);
        if (token != null){
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(403).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String errosMessage = error.getDefaultMessage();
            errors.put(fieldName, errosMessage);
        });
        return errors;
    }

}
