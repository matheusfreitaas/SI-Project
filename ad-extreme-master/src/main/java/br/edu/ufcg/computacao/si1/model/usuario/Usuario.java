package br.edu.ufcg.computacao.si1.model.usuario;

import org.springframework.security.core.authority.AuthorityUtils;

import javax.persistence.*;

/**
 * Classe para o objeto Usuário
 * @author Rafael
 *
 */
@Entity(name = "Usuario")
@Table(name = "tb_usuario")
public class Usuario extends org.springframework.security.core.userdetails.User{
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @Column
    private String nome;
    
    @Column(unique = true)
    private String email;
    
    @Column
    private String senha;
    
    @Column
    private String role;
    
    @Column
    private double credito;
    
    @Column
    private double debito;

    /**
     * Construtor default
     */
    public Usuario() {
        super("default", "default", AuthorityUtils.createAuthorityList("USER"));
    }

    /**
     * Construtor do objeto
     * @param nome Nome do usuário
     * @param email Email do usuário
     * @param senha Senha do usuário
     * @param role Tipo do usuário
     */
    public Usuario(String nome, String email, String senha, String role) {

        super(email, senha, AuthorityUtils.createAuthorityList(role));

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.credito = 0;
        this.debito = 0;
    }

    /**
     * Retorna o id do usuário
     * @return Id do usuário
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o id do usuário
     * @param id Novo id do usuário
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o nome do usuário
     * @return Nome do usuário
     */
    public String getNome() {
        return nome;
    }

    /**
     * Modifica o nome do usuário
     * @param nome Novo nome do usuário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o email do usuário
     * @return Email do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * Modifica o email do usuário
     * @param email Novo email do usuário
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna a senha o usuário
     * @return Senha do usuário
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Modifica a senha do usuário
     * @param senha Nova senha do usuário
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Retorna o tipo do usuário
     * @return Tipo do usuário
     */
    public String getRole() {
        return role;
    }

    /**
     * Modifica o tipo de usuário
     * @param role Novo tipo do usuário
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    /**
     * Retorna o saldo credor do usuário
     * @return Credito do usuário
     */
    public double getCredito() {
		return credito;
	}

    /**
     * Modifica o saldo credor do usuário
     * @param credito Novo crédito do usuario
     */
	public void setCredito(double credito) {
		this.credito = credito;
	}

	/**
	 * Retorna o saldo debito do usuário
	 * @return Debito do usuário
	 */
	public double getDebito() {
		return debito;
	}

	/**
	 * Modifica o debito do usuário
	 * @param debito Novo débito do usuario
	 */
	public void setDebito(double debito) {
		this.debito = debito;
	}

	@Override
    public String toString() {
        return "Usuario{" +
                "_id=" + id +
                ", nome='" + nome + '\'' +
                ", email=" + email +
                ", role=" + role +
                ", credito=" + credito +
                ", debito=" + debito +
                '}';
    }

}
