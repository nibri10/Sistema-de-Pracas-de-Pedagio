package br.unifae.poo.pedagio.models;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.SimpleFormatter;

/**
 * Esta classe é o modelo pai dos demais tipos de veiculos, ela não deve ser
 * instanciada ela serve apenas para modelo
 * 
 * @author Vinicius Ricardo Zoqueti
 *  @author Nicolas
 */
public abstract class Veiculo {

	// A placa é a identificação do veiculo
	private String placa;
	// A Data serve para identificar o dia em que o veiculo passou pela
	// praça de pedagio
	private String data;
	// A Hora serve para identificar o momento do dia em que o veiculo passou
	// pela praça de pedagio
	private String hora;
	// Valor tributado ao condutor ao passar com o veiculo pelo pedagio
	private double valorPago;

	/**
	 * este construtor é responsavel por alimentar o objeto com as informações
	 * necessarias/obrigatorias
	 * 
	 * @param placa
	 */

	public Veiculo(String placa) {
		this.placa = placa;
		this.hora = NowTime();
		this.data = NowDate();
	}

	/**
	 * Este metodo foi contruido para ser implementada atraves de Overide em
	 * situação que forem exigidos calculos, ele foi colocado na classe pai para
	 * que o uso se torne obrigatorio em ambos os veiculos.
	 * 
	 * @param valor
	 */
	public void calculaValor(double valor) {

		this.valorPago = valor;

	}

	/**
	 * este metodo recupera o valor que foi pago pelo condutor ao passar com o
	 * veiculo pelo pedagio, tal valor é calculado automaticamente atraves de
	 * valores dos demais atributos e implemntações de classes filhas
	 * 
	 * @return
	 */
	public double getValorPago() {
		return valorPago;
	}

	/**
	 * Este metodo recupera a placa do veiculo que é a identificação de cada
	 * automovél.
	 * 
	 * @return
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * este metodo recupera a data em que o veiculo passou pelo pedagio, o valor
	 * deste atributo não deve ser informado, uma vez que é capturado pelo
	 * propio sistema.
	 * 
	 * @return
	 */
	public String getData() {
		return data;
	}

	/**
	 * este metodo recupera a hora em que o veiculo passou pelo pedagio, o valor
	 * deste atributo não deve ser informado, uma vez que é capturado pelo
	 * propio sistema.
	 * 
	 * @return
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * Este metodo é responsavel por pegar a hora atual do sistema e retorna-la
	 * já no padrão hora/minuto/segundo
	 * 
	 * @return
	 */
	private String NowTime() {
		// pega a hora do sistema
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		// formata a hora em hora/minuto/segundo
		SimpleDateFormat out = new SimpleDateFormat("HH:mm:ss");
		return out.format(calendar.getTime());
	}

	/**
	 * Este metodo é responsavel por pegar a data do sistema e retorna-la já
	 * formatada no dia/mes/ano
	 * 
	 * @return
	 */
	private String NowDate() {
		// pega a data do sistema
		LocalDate local = LocalDate.now();
		// formata a data no padrão dia/mes/ano
		return local.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("Placa: ").append(this.placa).append("\t");
		builder.append("Data: ").append(this.data).append("\t");
		builder.append("Horário: ").append(this.hora).append("\t");
		builder.append("Valor Pago: ").append(this.valorPago);
		
		return builder.toString();
	}

}