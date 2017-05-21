package unaLata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LineaDeLata {
	private int longMayor = 0;
	private int longMayorSec = 0;
	private int posLongMayor = 0;
	private int posLongMayorSec = 0;
	private String cadena;
	private String path;
	
	
	public LineaDeLata(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path+".in"));
		this.path = path;
		cadena = new String(sc.nextLine());
		cadena = cadena.replaceAll(" ", "");
		sc.close();
	}
	
	public void resolver() {
		posLongMayor = cadena.indexOf('G');
		int auxPos;
		int i = 0;
		int j;
		int x;
		int aux;
		while(cadena.indexOf('G') != -1 && cadena.charAt(i) == 'G' && i < cadena.length()) {
			i++;
		}
		longMayor = i - posLongMayor;
		while(i < cadena.length() && cadena.indexOf('G',i) != -1) {
			j = 0;
			posLongMayorSec = cadena.indexOf('G',i);
			x = posLongMayorSec+i;
			while(cadena.indexOf('G',x) != -1 && cadena.charAt(x) == 'G' && i < cadena.length()) {
				j++;
//				i++;
				x++;
			}
			if(posLongMayor < posLongMayorSec) {
				aux = posLongMayor;
				posLongMayor = posLongMayorSec;
				posLongMayorSec = aux;
				longMayorSec = longMayor;
				longMayor = x - posLongMayor;
			} else {
				longMayorSec = x - posLongMayorSec;
			}
			i = x;
		}
	}
	
	public void mostrarSolucion() {
		System.out.println(posLongMayor + " " + longMayor);
		System.out.println(posLongMayorSec + " " + longMayorSec);
	}
	
	
	public void resolve() {
		int j = 0;
		int pos = cadena.indexOf('G');
		while(pos!= -1) {
			j = pos + 1;
			while(j < cadena.length() && cadena.charAt(j) == 'G') {
				j++;
			}
			if(longMayor < j-pos) {
				longMayorSec = longMayor;
				posLongMayorSec = posLongMayor;
				longMayor = j-pos;
				posLongMayor = pos;
			} else if(longMayorSec < j-pos) {
				longMayorSec = j-pos;
				posLongMayorSec = pos;
			}
			pos = cadena.indexOf('G', j);
		}
	}
	
	public void imprimirResultado() throws IOException {
		PrintWriter pr = new PrintWriter(new FileWriter(path+".out"));
		pr.println(cadena.length());
		pr.println(longMayor);
		pr.println(longMayorSec);
		if(posLongMayor  > posLongMayorSec) {
			pr.print(posLongMayor - longMayorSec - posLongMayorSec);
		} else {
			pr.print(posLongMayorSec - longMayor - posLongMayor);
		}
		pr.close();
	}
	
}
