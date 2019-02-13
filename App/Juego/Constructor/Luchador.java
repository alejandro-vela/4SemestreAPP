package game;

public class Luchador {
	
		private int vida;
			private int fuerza;
			private String nombre = "makio";
			
		    public Luchador(String nombre,int vida, int fuerza){
		    		this.nombre = nombre;
		    		this.vida = vida;
		    		this.fuerza = fuerza;
		    		
		    }    	   
			public String getNombre() {
				return nombre;
			}
			public void setNombre(String nombre) {
				this.nombre = nombre ;
			}        
			public int getVida() {
				return vida;
			}
			public void setVida(int vida) {
				this.vida = vida ;
			} 
			public int getFuerza() {
				return fuerza;
			}
			public void setFuerza(int fuerza) {
				this.fuerza = fuerza ;
			}
}
