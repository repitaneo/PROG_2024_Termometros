package termometro;

public class Start {

	public static void main(String[] args) {


		Termometro termometro = new Termometro(6);
		System.out.println(termometro);
		System.out.println("------------------------------");
		
		System.out.println("la max es "+termometro.getMaxima());
		System.out.println("la min es "+termometro.getMinima());
		System.out.println("la media es "+termometro.getMedia());
		System.out.println("la max dias pares es "+termometro.getMaximaDiasPares());
		System.out.println("la media dias impares es "+termometro.getMediaDiasImpares());
		

	}

}
