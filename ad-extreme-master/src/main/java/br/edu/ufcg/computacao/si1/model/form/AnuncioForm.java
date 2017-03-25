package br.edu.ufcg.computacao.si1.model.form;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ufcg.computacao.si1.util.Constantes;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Formulário para a criação de um anúncio
 * @author Rafael
 *
 */
public class AnuncioForm {

    private final String[] tipos = Constantes.TIPOS_USUARIO_JURIDICO;
    
    private final String[] tiposUsuarioFisico = Constantes.TIPOS_USUARIO_FISICO;

    @NotNull(message = Constantes.TITULO_NULO)
    @NotEmpty(message = Constantes.TITULO_VAZIO)
    @Size(min = 6, max = 100, message = Constantes.TITULO_TAMANHO)
    private String titulo;
    
    @NotNull(message = Constantes.PRECO_VAZIO)
    @DecimalMin(value = "0.1", message = Constantes.PRECO_VALOR_INVALIDO)
    private Double preco;
    
    @NotEmpty(message = Constantes.TIPO_VAZIO)
    private String tipo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String[] getTipos() {
        return tipos;
    }

	public String[] getTiposUsuarioFisico() {
		return tiposUsuarioFisico;
	}
}

