package termometro;

import java.util.Arrays;

public class Termometro {

	
	private int mes;
	private float temperaturas[];
	
	private float maxima;
	private float minima;
	private float media;
	private float maximaDiasPares;
	private float mediaDiasImpares;
	private float minimaQuincena1;
	private float minimaQuincena2;
	
	
	
	public Termometro(int mes) {

		this.mes = mes;
		establecerDiasMes(mes);
		rellenarTemperaturas(mes);
		
		// calcular las estadisticas
		calculosEstadisticos();
	}


	
	
	private void calculosEstadisticos() {
		
		this.maxima = -1000;
		this.maximaDiasPares = -1000;
		this.minima = 1000;
		float suma = 0;
		float sumaImpares = 0;
		float diasImpares = 0;
		minimaQuincena1 = 1000;
		minimaQuincena2 = 1000;

		
		for(int i=0;i<temperaturas.length;i++) {
			
			// minimas por quincenas
			if((i<=14) && (temperaturas[i]<minimaQuincena1)) {
				minimaQuincena1 = temperaturas[i]; 
			}
			else if((i>=15) && (temperaturas[i]<minimaQuincena2)) {
				minimaQuincena2 = temperaturas[i];
			}
			
			// maxima del mes
			if(temperaturas[i]>this.maxima) {
				this.maxima = temperaturas[i];
			}
			// minima del mes
			if(temperaturas[i]<this.minima) {
				this.minima = temperaturas[i];
			}
			// suma de temperaturas para la media
			suma += temperaturas[i];
			
			// calculos estadísticos avanzados que me solicitan
			if(i%2!=0) {
				
				// miramos los días pares
				if(temperaturas[i]>maximaDiasPares) {
					maximaDiasPares = temperaturas[i];
				}
			}
			else {

				// miramos los días impares la media de temperatura
				mediaDiasImpares = 0;
				sumaImpares += temperaturas[i]; 
				diasImpares++;
			}
		}
		this.media = suma / temperaturas.length;
		mediaDiasImpares = sumaImpares/diasImpares;
	}



	public float getMaximaDiasPares() {
		return maximaDiasPares;
	}
	
	
	public float getMediaDiasImpares() {
		
		return mediaDiasImpares;
	}
	
	

	public float getMinima() {
		
		// crear una variable y ponerle un valor grande
		float minima = 1000;
		// buscar los valores de temperatura
		for(int i=0;i<temperaturas.length;i++) {
			// compararlos con el min
			// si es menor guardo la nueva min
			if(temperaturas[i]<minima) {
				
				minima = temperaturas[i];
			}
		}
		// devuelvo la min
		return minima;
	}
	
	
	

	
	public float getMedia() {
		
		// crear una variable para sumar todos los valores
		float suma = 0;
		// recorro el vector sumando los valores
		for(int i=0;i<temperaturas.length;i++) {

			suma += temperaturas[i];
		}
		// devuelvo la media
		return suma/temperaturas.length;
	}	
	
	
	
	
	public float getMaxima() {
		
		// crear una variable y ponerle un valor pequeño
		float maxima = -1000;
		// buscar los valores de temperatura
		for(int i=0;i<temperaturas.length;i++) {
			// compararlos con el max
			// si es mayor guardo la nueva max
			if(temperaturas[i]>maxima) {
				
				maxima = temperaturas[i];
			}
		}
		// devuelvo la max
		return maxima;
	}
	
	
	
	
	



	private void rellenarTemperaturas(int mes) {
		
		for(int i=0;i<temperaturas.length;i++) {
			
			switch(mes) {
			
				case 12,1,2: 
					temperaturas[i] = (float)(Math.random()*18-5);
					break;
				case 3,4,5: 
					temperaturas[i] = (float)(Math.random()*14+2);
					break;
				case 6,7,8: 
					temperaturas[i] = (float)(Math.random()*16+13);
					break;
				case 9,10,11: 
					temperaturas[i] = (float)(Math.random()*15+8);
					break;
			}
		}
	}

	

	
	
	private void establecerDiasMes(int mes) {
		switch(mes) {
		
			case 1,3,5,7,8,10,12:
				temperaturas = new float[31];
				break;
			case 4,6,9,11:
				temperaturas = new float[30];
				break;
			case 2:
				temperaturas = new float[28];
				break;
			default:
				temperaturas = new float[31];
				this.mes = 31;
				break;
		}
	}

	
	
	
	@Override
	public String toString() {
		return "Termometro [" + Arrays.toString(temperaturas) + "]\n"
				+ "max ("+maxima+")\n"
				+ "min ("+minima+")\n"
				+ "media ("+media+")";
	}




	public float getMinQuincena(int quincena) {
		
		if(quincena == 1) {
			return minimaQuincena1;
		}
		else return minimaQuincena2;
	}
	
	
}
