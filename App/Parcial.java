import java.io.*;
public class parcial {
	public static void main(String[] args)throws IOException {

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		data Tercer_data;
		Tercer_data=data.diez;
		data Septimo_data;
		Septimo_data = data.para;
		System.out.println(Tercer_data);
		System.out.println(Septimo_data);


		String [][] matriz;

		
		matriz = new String[2][2];

		for (int i=0;i<2;i++ ) {
			for (int j=0;j<2;j++ ) {
			System.out.println("digite el valor para la posicion"+"["+i+"]"+"["+j+"]");
			String valor= entrada.readLine();	

			matriz [i][j]=valor;
			}		
		}
		for (int i=0;i<2;i++ ) {
			for (int j=0;j<2;j++ ) {
			System.out.print(matriz [i][j]+" ");
			}		
			System.out.println(" ");
		}
		System.out.println(" ");

		System.out.println(matriz[0][1]);
		System.out.println(matriz[1][1]);

	}

	enum
		data{estos,son,diez,datos,usando,enums,para,el,parcial,noche}
}