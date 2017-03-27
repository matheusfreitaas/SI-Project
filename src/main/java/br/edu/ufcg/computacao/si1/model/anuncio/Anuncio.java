package br.edu.ufcg.computacao.si1.model.anuncio;

import javax.persistence.*;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.util.Constantes;

import java.util.Date;

/**
 * Classe abstrata para o objeto Anuncio
 * @author Rafael
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Anuncio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = Constantes.ID, nullable = false, unique = true)
    private Long _id;

    @Column(name = Constantes.TITULO, nullable = false)
    private String titulo;

    @Column(name = Constantes.DATA_CRIACAO, nullable = false)
    private Date dataDeCriacao;

    @Column(name = Constantes.PRECO, nullable = false)
    private double preco;

    @Column(name = Constantes.TIPO, nullable = false)
    private String tipo;
    
    @ManyToOne
    @JoinColumn(name= Constantes.USUARIO_ID)
    private Usuario usuario;
    
    /**
     * Construtor do objeto
     * @param titulo Título do anúncio
     * @param preco Preco do anúncio
     * @param tipo Tipo do anúncio
     * @param emailUsuario Email do criador do anúncio
     */
    public Anuncio(String titulo, double preco, String tipo, Usuario dono) {
        this.titulo = titulo;
        this.dataDeCriacao = new Date();
        this.preco = preco;
        this.tipo = tipo;
        this.usuario = dono;
    }

    /**
     * Construtor default
     */
    public Anuncio() {
        titulo = "";
        dataDeCriacao = new Date();
        preco = 0;
        tipo = "";
    }

    /**
     * Retorna o id do anuncio
     * @return Id do anuncio
     */
    public Long getId() {
        return _id;
    }

    /**
     * Modifica o id do anuncio
     * @param _id id a ser colocado no anuncio
     */
    public void setId(Long _id) {
        this._id = _id;
    }

    /**
     * Retorna o título do anúncio
     * @return Titulo do anúncio
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Modifica o título do anúncio
     * @param titulo Novo titulo do anúncio
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Retorna a data de criação do anúncio
     * @return Data de criação do anúncio
     */
    public String getDataDeCriacao() {
        return Constantes.DATE_FORMAT.format(dataDeCriacao);
    }

    /**
     * Modifica a data de criação do anúncio
     * @param dataDeCriacao Nova data de criação do anúncio
     */
    public void setDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    /**
     * Retorna o preco do anúncio
     * @return Preco do anúncio
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Modifica o preco do anúncio
     * @param preco Novo preco do anúncio
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Retorna o tipo do anúncio
     * @return Tipo do anúncio
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Modifica o tipo do anúncio
     * @param tipo Novo tipo do anúncio
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna o criador do anúncio
     * @return Email do criador do anúncio
     */
    public Usuario getUsuario() {
		return this.usuario;
	}

    /**
     * Modifica o criador do anúncio
     * @param email Novo email do criador do anúncio
     */
	public void setUsuario(Usuario novoDono) {
		this.usuario = novoDono;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anuncio)) return false;

        Anuncio anuncio = (Anuncio) o;

        if (Double.compare(anuncio.getPreco(), getPreco()) != 0) return false;
        if (!getId().equals(anuncio.getId())) return false;
        if (!getTitulo().equals(anuncio.getTitulo())) return false;
        if (!getDataDeCriacao().equals(anuncio.getDataDeCriacao())) return false;
        return getTipo().equals(anuncio.getTipo());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId().hashCode();
        result = 31 * result + getTitulo().hashCode();
        result = 31 * result + getDataDeCriacao().hashCode();
        temp = Double.doubleToLongBits(getPreco());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getTipo().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "_id=" + _id +
                ", titulo='" + titulo + '\'' +
                ", dataDeCriacao=" + getDataDeCriacao() +
                ", preco=" + preco +
                ", tipo='" + tipo + '\'' + "Dono: "+usuario.getNome()+
                '}';
    }
}
