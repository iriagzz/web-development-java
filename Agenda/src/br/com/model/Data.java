package br.com.model;

public class Data {

	
	/* Singleton para que apenas um objeto seja instanciado! */
	private static Data instancia = null;

	public static Data getInstancia() {
		if (instancia == null) {
			instancia = new Data();
		}
		return instancia;
	}
	
	public void armazenarDados() {
		
	}
	
	
	

	
	
}
