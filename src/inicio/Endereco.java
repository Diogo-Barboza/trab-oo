package inicio;

public class Endereco {
	private String cep;
	private String pais;
	private String cidade;
	private String bairro;
	private String complemento;
	private int numero;
	private String estado;
	private String ponto_de_referencia;
	
	public Endereco(String cep, String pais, String cidade, String bairro, String complemento, int numero,
			String estado, String ponto_de_referencia) {
		super();
		this.cep = cep;
		this.pais = pais;
		this.cidade = cidade;
		this.bairro = bairro;
		this.complemento = complemento;
		this.numero = numero;
		this.estado = estado;
		this.ponto_de_referencia = ponto_de_referencia;
	}
	
	public void atualizarCEP(String cep) {
		this.cep = cep;
	}
	public void atualizarPais(String pais) {
		this.pais = pais;
	}
	public void atualizarCidade(String cidade) {
		this.cidade = cidade;
	}
	public void atualizarBairro(String bairro) {
		this.bairro = bairro;
	}
	public void atualizarComplemento(String complemento) {
		this.complemento = complemento;
	}
	public void atualizarNumero(int numero) {
		this.numero = numero;
	}
	public void atualizarEstado(String estado) {
		this.estado = estado;
	}
	public void atualizarReferencia(String referencia) {
		this.ponto_de_referencia = referencia;
	}
	
}
