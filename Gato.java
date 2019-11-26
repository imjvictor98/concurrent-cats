package dona.maria;

import java.io.Serializable;

public class Gato implements Runnable, Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private Tigela t;
	private Maria donaMaria;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tigela getT() {
		return t;
	}

	public void setT(Tigela t) {
		this.t = t;
	}

	public Maria getDonaMaria() {
		return donaMaria;
	}

	public void setDonaMaria(Maria donaMaria) {
		this.donaMaria = donaMaria;
	}

	public Gato(String nome, Tigela tigela, Maria donaMaria) {
		setNome(nome);
		setT(tigela);
		setDonaMaria(donaMaria);
	}

	void miar() throws InterruptedException {
		System.out.printf("\nO [%s] está miando, QUERO COMERRRR!", this.nome);
		
		synchronized(t) {
			this.donaMaria.acordar();
			t.wait(); //não é o que o gato espera, mas o que ele está esperando
		}
		System.out.printf("\nA tigela foi reposta, avisem os gatos...");
	}
	
	void comer() throws InterruptedException {
		t.decrementarTigela(this);
		
		if (this.t.getQtdRacao() <= 0) {
			this.t.setQtdRacao(0);
			this.miar();
		}		
	}
	
	 void lavabo() throws InterruptedException { 
		 System.out.printf("\nO [%s] está no lavabo, Banhozinho!", this.nome);
		 Thread.sleep(2000);
	}

	@Override
	public void run() {
		while (true) {
			try {
				this.lavabo();
				this.comer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
