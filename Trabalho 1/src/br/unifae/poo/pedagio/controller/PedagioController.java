package br.unifae.poo.pedagio.controller;

import br.unifae.poo.pedagio.models.Comercial;
import br.unifae.poo.pedagio.models.Pedagio;
import br.unifae.poo.pedagio.models.UtilitarioPasseio;
import br.unifae.poo.pedagio.repository.PedagioRepository;

public class PedagioController { 
	//Cria um novo pedagio
	private PedagioRepository repository = new PedagioRepository(); 

	public boolean add(Pedagio pedagio) {

		return repository.add(pedagio);

	}

	public Pedagio getById(int codigo) {

		if (codigo != 0){
			//Retorna os pedagio a partir do codigo
			for (Pedagio pedagio : repository.getPedagios()) {
				if (pedagio.getCodigo() == codigo)
					return pedagio;
			}
		}
		return null;
	}
	//verifica se o pedagio está vazio
	public boolean isNull() {
		for (Pedagio pedagio : repository.getPedagios()){
			if (pedagio == null)
				return true;
		}

		return false;
	}
	// Faz a insercao dos veiculos da categoria Passeio
	public boolean addUtilitarioPasseio(Pedagio pedagio,
			UtilitarioPasseio veiculo) {
		return repository.addUtilitarioPasseio(pedagio, veiculo);
	}
	// Faz a insercao dos veiculos da categoria Comercial
	public boolean addComercial(Pedagio pedagio, Comercial veiculo) {
		return repository.addComercial(pedagio, veiculo);
	}
	//Retorna todos os dados dos pedagios
	public Pedagio[] getAll() {
		return repository.getPedagios();
	}

}
