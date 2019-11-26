package dona.maria;

import java.util.Random;

public class Tigela {
	private int qtdRacao;
	
	public int getQtdRacao() {
		return qtdRacao;
	}

	public synchronized void setQtdRacao(int qtdRacao) {
		this.qtdRacao = qtdRacao;
	}

	public Tigela(int qtdRacao) {
		setQtdRacao(qtdRacao);
	}
	
	synchronized void encherTigela(int qtdReposicao) {
		setQtdRacao(qtdReposicao);
		this.notifyAll();
	}
	
	synchronized void decrementarTigela(Gato g) {
		int random = Math.abs((new Random().nextInt(20)) + 1);
		int racao = getQtdRacao() - random;
		
		if (random > getQtdRacao())
			racao = getQtdRacao();
		
		System.out.println("\n∞∞∞ Ração no pote -> " + getQtdRacao());
		System.out.printf("\n--> O [%s] está comendo. Ele comeu %d grãos, PAAAAZ!", g.getNome(), random);
		
		setQtdRacao(racao);
		
		
	}
	

	
	

}
