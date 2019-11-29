package modelo;

import java.util.Comparator;

public class CompararNumero implements Comparator <Personaje> {

	@Override
	public int compare(Personaje p1, Personaje p2) {
		return p1.getNumSuerte()-p2.getNumSuerte();
	}

}
