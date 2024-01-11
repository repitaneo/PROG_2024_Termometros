package termometro;

public class Termometro {

	
	private int mes;
	private float temperaturas[];
	
	
	
	public Termometro(int mes) {

		this.mes = mes;
		establecerDiasMes(mes);
		rellenarTemperaturas(mes);
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

}
