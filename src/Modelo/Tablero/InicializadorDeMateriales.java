package Modelo.Tablero;

import Modelo.Materiales.*;
import java.util.function.Supplier;

public class InicializadorDeMateriales {

	public PosicionadorRandom posicionador;

	public InicializadorDeMateriales(Tablero unTablero) {
		posicionador = new PosicionadorRandom(unTablero);
	}

	public void inicializarMateriales() {
		inicializarMaterial(()->new Madera(),8);
		inicializarMaterial(()->new Piedra(),6);
		inicializarMaterial(()->new Metal(),4);
		inicializarMaterial(()->new Diamante(),2);
	}

	private void inicializarMaterial(Supplier<Material> unMaterial,int cant) {
		for (int i = 0; i < cant; i++) {
			posicionador.crearPosicionRandomYAgregarElemento(unMaterial.get());
		}
	}
}
