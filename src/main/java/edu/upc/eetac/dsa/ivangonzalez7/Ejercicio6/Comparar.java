package edu.upc.eetac.dsa.ivangonzalez7.Ejercicio6;

import java.io.*;

public class Comparar {

	public static void main(String[] arg) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea;
		double mayor = 0;
		String nombre = null;
		
		String fichero = System.getProperty("user.dir")
				+ "/Resources/registro.txt";

		try {
			archivo = new File(fichero);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
		}

		catch (FileNotFoundException e) {

			System.out.println("Archivo no encontrado");
		}

		try {

			while ((linea = br.readLine()) != null) {
				String[] resultado = linea.split(" ");

				if (mayor < Double.parseDouble(resultado[3])) {
					mayor = Double.parseDouble(resultado[3]);
					nombre = resultado[2];
				}

				linea = br.readLine();
			}
			System.out.println("El archivo de mayor tama�o es: " + nombre);
		}

		catch (IOException e)

		{
			throw new RuntimeException(e);
		}

	}
}
