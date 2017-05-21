package unaLata;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		LineaDeLata l1 = new LineaDeLata("06");
		//l1.resolver();
		l1.resolve();
		l1.mostrarSolucion();
		l1.imprimirResultado();
	}

}
