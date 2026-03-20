package br.com.eduardo.projeto_api_loguin.Model;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@Table(name = "usuarios")
@JsonPropertyOrder({"id", "nome", "email", "senha", "telefone"})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "O nome é obrigatorio!")
    @Size(min = 3 , message = "Nome deve ter no mínimo 3 caracteres" )
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Email(message = "Insira um email valido!")
    @NotBlank(message = "O email é obrigatorio!")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotBlank(message = "A senha é obrigatorio")
    @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
    private String senha;

    @NotBlank(message = "O telefone é obrigatorio")
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;
}
