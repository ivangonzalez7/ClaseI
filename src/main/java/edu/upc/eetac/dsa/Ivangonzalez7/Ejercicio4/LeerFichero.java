package edu.upc.eetac.dsa.Ivangonzalez7.Ejercicio4;

import java.io.*;
import java.util.*;
import java.text.*;

public class LeerFichero {
	public static void main(String[] arg) {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		int cont = 0;
		int caract;
		Date now = new Date();
		String fichero = System.getProperty("user.dir")
				+ "/Resources/registro.txt";
		try {
			archivo = new File(fichero);
			fr = new FileReader(archivo);
		}

		catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}

		try {
			br = new BufferedReader(fr);
			caract = br.read();
			while (caract != -1) {
				cont++;
				caract = br.read();
			}
			System.out.println("El archivo tiene " + cont + " caracteres");
		}

		catch (IOException e)

		{
			throw new RuntimeException(e);
		}

		String contenido;
		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String nombre = fichero.substring(24);
		contenido = fecha.format(now) + " " + nombre + " " + cont;

		File file = null;

		try {

			fichero = System.getProperty("user.dir")
					+ "/Resources/registro.txt";
			file = new File(fichero);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(contenido);
			bw.newLine();
			bw.close();
		}

		catch (IOException e) {
			e.printStackTrace();

		}

		finally {

			try {

				if (fr != null)
					fr.close();
			}

			catch (Exception e2) {
				throw new RuntimeException(e2);
			}

		}

	}
}
