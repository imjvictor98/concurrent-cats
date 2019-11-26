package dona.maria;

public class Main_DonaMaria {
	public static void main(String[] args) {
		Tigela tigela = new Tigela(50);
		Maria donaMaria = new Maria("Maria", tigela);
		 
		for (int i = 0; i < 12; i += 1) {
			new Thread(donaMaria).start();
			new Thread(new Gato(
					   "Gatinho " + (i + 1), 
					   tigela, 
					   donaMaria
					)	
					  )
			.start();
		}
		
	}
}

















