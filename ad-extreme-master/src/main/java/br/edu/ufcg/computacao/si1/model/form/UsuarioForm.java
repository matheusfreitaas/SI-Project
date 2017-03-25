package br.edu.ufcg.computacao.si1.model.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ufcg.computacao.si1.util.Constantes;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Formulário para a criação de um usuário
 * @author Rafael
 *
 */
public class UsuarioForm {
	
    @NotNull(message = Constantes.NOME_NULO)
    @NotEmpty(message = Constantes.NOME_VAZIO)
    @Size(min = 2, max = 100, message = Constantes.NOME_TAMANHO)
    private String nome;
    
    @NotEmpty(message = Constantes.EMAIL_VAZIO)
    @Email
    private String email;
    
    @NotNull(message = Constantes.SENHA_NULO)
    @NotEmpty
    @Size(min = 4, max = 16, message = Constantes.SENHA_TAMANHO)
    private String senha;
    
    @NotNull
    private Integer role;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
