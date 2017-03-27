package br.edu.ufcg.computacao.si1.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Listagem de todas as constantes usadas em todo o Back End
 * @author Rafael
 *
 */
public class Constantes {

	//Geral
	public static final String TIPOS = "tipos";
	public static final String ANUNCIOS = "anuncios";
	public static final String MENSAGEM = "mensagem";
	public static final String USUARIO = "usuario";
	public static final String CADASTRO_ANUNCIO_SUCESSO = "Anúncio cadastrado com sucesso!";
	public static final String PESSOA_FISICA = "USER";
	public static final String PESSOA_JURIDICA = "COMPANY";
	public static final String ERROR = "error";
	public final static DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
	
	//AnuncioForm
	public static final String[] TIPOS_USUARIO_FISICO = new String[] {"movel", "imovel"};
	public static final String[] TIPOS_USUARIO_JURIDICO = new String[] {"movel", "imovel", "emprego", "serviço"};
	public static final String TITULO_NULO = "O titulo não pode ser nulo.";
	public static final String TITULO_VAZIO = "O titulo não pode esta vazio.";
	public static final String TITULO_TAMANHO = "O titulo deve ter entre 6 e 100 caracters";
	public static final String PRECO_VAZIO = "O preco não pode ser nulo.";
	public static final String PRECO_VALOR_INVALIDO = "O preço minimo é 0.1 para um anúncio.";
	public static final String TIPO_VAZIO = "Escolha um tipo para o anúncio.";
	
	//UsuarioForm
	public static final String NOME_NULO = "O nome não pode ser nulo.";
	public static final String NOME_VAZIO = "O nome não pode ser vazio.";
	public static final String NOME_TAMANHO = "O nome deve ter entre 2 e 100 caracters";
	public static final String EMAIL_VAZIO = "O email não pode ser vazio.";
	public static final String SENHA_NULO = "A senha não pode ser nulo.";
	public static final String SENHA_TAMANHO = "A senha deve ter entre 4 e 16 caracteres.";
	
	
	//AnuncioFactory
	public static final String ANUNCIO_MOVEL = "movel";
	public static final String ANUNCIO_IMOVEL = "imovel";
	public static final String ANUNCIO_EMPREGO = "emprego";
	public static final String ANUNCIO_SERVICO = "serviço";
	
	//UsuarioFactory
	public static final int ID_PESSOA_FISICA = 1;
	public static final int ID_PESSOA_JURIDICA = 2;
	
	//CadastroController
	public static final String ROTA_CADASTRAR_USUARIO = "/cadastrar-se";
	public static final String CADASTRO = "cadastro";
	public static final String CADASTRO_USUARIO_SUCESSO = "Usuario cadastrado com sucesso!";
	public static final String EMAIL_EM_USO = "Este email já esta em uso!";
	public static final String REDIRECIONAR_CADASTRO = "redirect:/cadastrar-se";
	
	//AnuncioController
	public static final String ROTA_CADASTRAR_ANUNCIO = "/user/cadastrar/anuncio";
	public static final String VIEW_CADASTRAR_ANUNCIO = "user/cadastrar_anuncio";
	public static final String ROTA_LISTAR_ANUNCIO = "/user/listar/anuncios";
	public static final String VIEW_LISTAR_ANUNCIO = "user/listar_anuncios";
	public static final String ROTA_COMPRAR_ANUNCIO = "/user/comprar/anuncio";
	public static final String REDIRECIONAR_LISTA_ANUNCIO = "redirect:/user/listar/anuncios";
	public static final String REDIRECIONAR_CADASTRO_ANUNCIO = "redirect:/user/cadastrar/anuncio";
	
	//CompanyAnuncioController
	public static final String ROTA_CADASTRAR_ANUNCIO_COMPANY = "/company/cadastrar/anuncio";
	public static final String VIEW_CADASTRAR_ANUNCIO_COMPANY = "company/cadastrar_anuncio";
	public static final String ROTA_LISTAR_ANUNCIO_COMPANY = "/company/listar/anuncios";
	public static final String VIEW_LISTAR_ANUNCIO_COMPANY = "company/listar_anuncios";
	public static final String ROTA_COMPRAR_ANUNCIO_COMPANY = "/company/comprar/anuncio";
	public static final String REDIRECIONAR_LISTA_ANUNCIO_COMPANY = "redirect:/company/listar/anuncios";
	public static final String REDIRECIONAR_CADASTRO_ANUNCIO_COMPANY = "redirect:/company/cadastrar/anuncio";
	
	//ErrorPagesController
	public static final String ROTA_404 = "/404";
	public static final String ROTA_403 = "/403";
	public static final String ROTA_500 = "/500";
	public static final String ERRO_404 = "error/404";
	public static final String ERRO_403 = "error/403";
	public static final String ERRO_500 = "error/500";
	
	//WebPagesController
	public static final String ROTA_INICIAL = "/";
	public static final String VIEW_INDEX = "index";
	public static final String ROTA_LOGIN = "/login";
	public static final String VIEW_LOGIN = "login";
	public static final String ROTA_USUARIO_FISICO = "/user";
	public static final String VIEW_USUARIO_FISICO = "user/index";
	public static final String ROTA_USUARIO_JURIDICO = "/company";
	public static final String VIEW_USUARIO_JURIDICO = "company/index";
	
	//Anuncio
	public static final String ID = "_id";
	public static final String TITULO = "titulo";
	public static final String DATA_CRIACAO = "data_criacao";
	public static final String PRECO = "preco";
	public static final String NOTA = "nota";
	public static final String TIPO = "tipo";
	public static final String USUARIO_EMAIL = "usuario_email";
	public static final String ANUNCIOEMPREGO = "AnuncioEmprego";
	public static final String ANUNCIOIMOVEL = "AnuncioImovel";
	public static final String ANUNCIOMOVEL = "AnuncioMovel";
	public static final String ANUNCIOSERVICO = "AnuncioServico";
	
	//CustomAuthenticationSuccessHandler
	public static final String ERRO_AO_REDIRECIONAR = "Não foi possível redirecionar para";
	
	//SecurityConfiguration
	public static final String ERRO_LOCALIZAR_USUARIO = "Não foi possível localizar o usuário";
	
	
}
