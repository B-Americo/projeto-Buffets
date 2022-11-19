package model;

public class Cliente {

	private int id;
	private String nome;
	private String cpf;
	private int qtdConvidados = 0;
	private String sobremesa = "";
	private Double vrConvidados;
	private Double txSobremesa = 0.0;
	private int qtdGarcoes = 0;
	private Double txGarcoes = 0.0;
	private Double vrTotal = 0.0;
	private Double vrTeste = 0.0; 
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getQtdConvidados() {
		return qtdConvidados;
	}

	public void setQtdConvidados(int qtdConvidados) {
		this.qtdConvidados = qtdConvidados;
	}

	public String getSobremesa() {
		return sobremesa;
	}

	public void setSobremesa(String sobremesa) {
		this.sobremesa = sobremesa;
	}

	public Double getVrConvidados() {
		return vrConvidados;
	}

	public void setVrConvidados(Double vrConvidados) {
		this.vrConvidados = vrConvidados;
	}

	public Double getTxSobremesa() {
		return txSobremesa;
	}

	public void setTxSobremesa(Double txSobremesa) {
		this.txSobremesa = txSobremesa;
	}

	public Double getTxGarcoes() {
		return txGarcoes;
	}

	public void setTxGarcoes(Double txGarcoes) {
		this.txGarcoes = txGarcoes;
	}

	public int getQtdGarcoes() {
		return qtdGarcoes;
	}

	public void setQtdGarcoes(int qtdGarcoes) {
		this.qtdGarcoes = qtdGarcoes;
	}

	public Double getVrTotal() {
		return vrTotal;
	}

	public void setVrTotal(Double vrTotal) {
		this.vrTotal = vrTotal;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void calcConvidados(int calConvidados) {
		this.vrConvidados = calConvidados * 22.00;
	}

	
	 public void calcSobremesa() {
		 if(sobremesa.equals("Sim")){ 
			 	this.txSobremesa = (vrConvidados * 10)/100;
			 	System.out.println("Teste na texa sobremesa" + txSobremesa.toString());
		 	}else { 
		 		this.txSobremesa = 0.00; 
		 		} 
		 }
	 
	 
	// TESTE INICIO
	/*
	 * public void calcSobremesa() { if(this.sobremesa == "Sim") { this.txSobremesa
	 * = (vrConvidados * 10)/100; System.out.println("Sobremesa: " + sobremesa);
	 * }else if(this.sobremesa == "Não" || this.sobremesa == null) {
	 * 
	 * this.txSobremesa = 0.00; System.out.println("Sobremesa: " +
	 * sobremesa.toString()); }
	 * 
	 * 
	 * }
	 */

	// TESTE FIM
	public void calcQtdGarcoes(int calcQtdGarcoes) {
		if(calcQtdGarcoes == 0) {
			this.qtdGarcoes = 0;
		}
		else if(calcQtdGarcoes < 15) {
			this.qtdGarcoes = this.qtdGarcoes + 1;
		} else {
			this.qtdGarcoes = calcQtdGarcoes / 15;
			System.out.println("resultado da qtd garções" + qtdGarcoes);
		}
	}

	public void calcTaxGarcoes(int calcTaxGarcoes) {
		this.txGarcoes = calcTaxGarcoes * 250.00;
	}

	public void calcVrTotal() {
		this.vrTotal = vrConvidados + txGarcoes + txSobremesa;
	}

	// teste

	public Double getVrTeste() {
		return vrTeste;
	}

	public void setVrTeste(Double vrTeste) {
		this.vrTeste = vrTeste;
	}

	public void calcVrTeste() {
		String.format("%.2f", this.vrTeste = getVrTotal() + getVrTotal());
		System.out.println(this.vrTeste);
	}
	
	//teste de status
	
	
	
	public void verificarStatus() { 
		if(this.status == "Pendete"  || vrTotal == 0.0) {
				this.status = "Pendente";
	 } else this.status = "Aceita";
	
	}
	

	// fim teste

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", qtdConvidados=" + qtdConvidados
				+ ", sobremesa=" + sobremesa + ", vrConvidados=" + vrConvidados + ", txSobremesa=" + txSobremesa + "]";
	}

}
