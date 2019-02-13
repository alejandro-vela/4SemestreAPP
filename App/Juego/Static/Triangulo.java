package game;

public class Triangulo {
	
		private int altura;
		private int base;
		private static int area;
		private String tipo;
		
		public Triangulo(int atura, int base, String tipo) {
			super();
			this.altura = atura;
			this.base = base;
			
			this.tipo = tipo;
		}
	
		
		public int getAltura() {
			return altura;
		}
		public void setAltura(int atura) {
			this.altura = atura;
		}
		public int getBase() {
			return base;
		}
		public void setBase(int base) {
			this.base = base;
		}
		public static int getArea() {
			return area;
		}
		public static void setArea(int area) {
			Triangulo.area = area;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		
		
}