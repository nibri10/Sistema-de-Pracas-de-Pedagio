package br.unifae.poo.pedagio.models;

import br.unifae.poo.pedagio.constants.Values;

public class Pedagio {
	// esta variavel é responsavel por armazenar o ultimo codigo que foi gerado
	// ao
	// se inserir um registro de pedagio, para que o codigo nunca se repita,
	// ele é estatico devido a ele pertencer a classe não ao objeto.
	private static int ultimoCodigo;
	// esta variavel é responsavel pela identificação unica de cada registro .
	private int codigo;
	// esta variavel é responsavel por armazenar o nome de cada praça de
	// pedagio.
	private String nome;
	// esta variavel é responsavel por armazenar o local aonde se encontra a
	// praça(o edereço).
	private String local;
	// esta variavel é responsavel por defiinir o valor a ser cobrado por eixo
	// naquela praça de pedagio
	private double valorEixo;
	// Este vetor é responsavel por armazenar os veiculos dos tipos
	// utilitarios/passeio
	private UtilitarioPasseio[] utilitarioPasseio = new UtilitarioPasseio[Values.NUMERO_MAX_VEICULOS];
	// Este vetor é responsavel por armazenar os veiculos do tipo Comercial
	private Comercial[] comercial = new Comercial[Values.NUMERO_MAX_VEICULOS];
	// esta variavel identifica quantos veiculos dos tipos Utilitario/Passeio já
	// foram armazenados
	// no objeto para que não ultrapasse o limite de vetor "utilitarioPasseio"
	private int qtdUtilitarioPasseio = 0;
	// esta variavel identifica quantos veiculos do tipo Comercial já foram
	// armazenados
	// no objeto para que não ultrapasse o limite de vetor "comercial"
	private int qtdComercial = 0;

	/**
	 * Este contrutor armazena as inforções obrigatorias do objeto pedagio
	 * 
	 * @param nome
	 * @param local
	 * @param valorEixo
	 */
	public Pedagio(String nome, String local, double valorEixo) {
		this.codigo = ++ultimoCodigo;// acrescenta um novo codigo impedindo que
										// ele se repita
		this.nome = nome;// nome da praça
		this.local = local;// local aonde a praça de pedagio se encontra
		this.valorEixo = valorEixo;// valor cobrado por eixo
	}

	/**
	 * Este metodo é responsavel por adicionar veiculos dos tipos
	 * Utilitario/Passeio ao objeto pedagio.
	 * 
	 * @param veiculo
	 * @return
	 */
	public boolean addUtilitarioPasseio(UtilitarioPasseio veiculo) {
		// o metodo abaixo esta passando o valor por eixo para ser calculado o
		// total a se pagar
		veiculo.calculaValor(valorEixo);

		// a condição abaixo é responsavel por verificar se ainda existem
		// espaços livres no vetor
		if (utilitarioPasseio.length > qtdUtilitarioPasseio) {
			utilitarioPasseio[qtdUtilitarioPasseio] = veiculo;
			qtdUtilitarioPasseio++;
			return true;
		}
		return false;

	}

	/**
	 * Este metodo é responsavel por adicionar veiculos do tipo Comercial ao
	 * objeto pedagio.
	 * 
	 * @param veiculo
	 * @return
	 */

	public boolean addComercial(Comercial veiculo) {
		// o metodo abaixo esta passando o valor por eixo para ser calculado o
		// total a se pagar
		veiculo.calculaValor(valorEixo);
		// a condição abaixo é responsavel por verificar se ainda existem
		// espaços livres no vetor
		if (comercial.length > qtdComercial) {
			comercial[qtdComercial] = veiculo;
			qtdComercial++;
			return true;
		}
		return false;
	}

	/**
	 * Este metodo é responsavel por recuperar o codigo atribuido ao objeto
	 * pedagio
	 * 
	 * @return
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Este metodo é responsavel por recuperar o nome atribuido ao objeto
	 * pedagio
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Este metodo é responsavel por recuperar o local(Endereço) atribuido ao
	 * objeto pedagio
	 * 
	 * @return
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * Este metodo é responsavel por recuperar o valor por eixo atribuido ao
	 * objeto pedagio
	 * 
	 * @return
	 */
	public double getValorEixo() {
		return valorEixo;
	}

	/**
	 * Recupera todos os veiculos Utilitario/Passeio que foram registrados no
	 * objeto
	 * 
	 * @return
	 */
	public UtilitarioPasseio[] getUtilitarioPasseio() {
		return utilitarioPasseio;
	}

	/**
	 * Recupera todos os veiculos Comerciais que foram registrados no objeto
	 * 
	 * @return
	 */
	public Comercial[] getComercial() {
		return comercial;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("Código: ").append(String.valueOf(this.codigo))
				.append("\t");
		builder.append("Local: ").append(this.local).append("\n");
		

		return builder.toString();
	}

}
