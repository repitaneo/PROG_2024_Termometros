package termometro;

import java.util.Arrays;

public class Termometro {

	
	private int mes;
	private float temperaturas[];
	
	private float maxima;
	private float minima;
	private float media;
	
	
	
	public Termometro(int mes) {

		this.mes = mes;
		establecerDiasMes(mes);
		rellenarTemperaturas(mes);
		
		// calcular las estadisticas
		calculosEstadisticos();
	}


	
	
	private void calculosEstadisticos() {
		
		this.maxima = -1000;
		this.minima = 1000;
		float suma = 0;
		
		for(int i=0;i<temperaturas.length;i++) {
			
			if(temperaturas[i]>this.maxima) {
				this.maxima = temperaturas[i];
			}
			if(temperaturas[i]<this.minima) {
				this.minima = temperaturas[i];
			}
			suma += temperaturas[i];
		}
		this.media = suma / temperaturas.length;
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
	
	
}
