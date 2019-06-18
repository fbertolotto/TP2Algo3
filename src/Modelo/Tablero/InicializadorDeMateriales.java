package Modelo.Tablero;

import Modelo.Materiales.*;
import java.util.function.Supplier;

public class InicializadorDeMateriales {

	public PosicionadorRandom posicionador;
	public Tablero tablero;

	public InicializadorDeMateriales(Tablero unTablero) {
		tablero = unTablero;
		posicionador = new PosicionadorRandom(unTablero);
	}

	public void inicializarMateriales() {
		inicializarMaterial(()->new Madera(),(int) (tablero.getAltura()*tablero.getAltura()*0.01));
		inicializarMaterial(()->new Piedra(),(int) (tablero.getAltura()*tablero.getAltura()*0.007));
		inicializarMaterial(()->new Metal(),(int) (tablero.getAltura()*tablero.getAltura()*0.003));
		inicializarMaterial(()->new Diamante(),(int) (tablero.getAltura()*tablero.getAltura()*0.0005));
	}

	private void inicializarMaterial(Supplier<Material> unMaterial,int cant) {
		for (int i = 0; i < cant; i++) {
			posicionador.crearPosicionRandomYAgregarElemento(unMaterial.get());
		}
	}
}
