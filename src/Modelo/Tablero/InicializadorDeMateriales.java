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

	//La cantidad de materiales en el mapa depende de su tamaño.
	public void inicializarMateriales() {
		inicializarMaterial(()->new Madera(),(int) (tablero.getAltura()*tablero.getAltura()*0.05)); //5%
		inicializarMaterial(()->new Piedra(),(int) (tablero.getAltura()*tablero.getAltura()*0.02)); //2%
		inicializarMaterial(()->new Metal(),(int) (tablero.getAltura()*tablero.getAltura()*0.01)); //1%
		inicializarMaterial(()->new Diamante(),(int) (tablero.getAltura()*tablero.getAltura()*0.005)); //0.5%
	}

	private void inicializarMaterial(Supplier<Material> unMaterial,int cant) {
		for (int i = 0; i < cant; i++) {
			posicionador.crearPosicionRandomYAgregarElemento(unMaterial.get());
		}
	}
}
