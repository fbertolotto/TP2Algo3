package Modelo.Juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Crafteo extends ArrayList {

	private ArrayList<String> receta;

	public Crafteo(List materiales) {
		receta = (ArrayList<String>) materiales;
	}

	@Override
	public int hashCode() {
		StringBuilder aux = new StringBuilder();
		for (String s : receta) {
			if(s == "") aux.append("*");
			else aux.append(s);
		}
		return Objects.hash(aux.toString());
	}

}
