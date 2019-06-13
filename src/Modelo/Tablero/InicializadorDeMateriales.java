package Modelo.Tablero;

import Modelo.Materiales.*;

public class InicializadorDeMateriales {

	public PosicionadorRandom posicionador;

	public InicializadorDeMateriales(Tablero unTablero) {
		posicionador = new PosicionadorRandom(unTablero);
	}

	public void inicializarMateriales() {
		inicializarMaterialMadera(8);
		inicializarMaterialMetal(4);
		inicializarMaterialPiedra(6);
		inicializarMaterialDiamante(2);
	}

	private void inicializarMaterialMadera(int cant) {
		for (int i = 0; i < cant; i++) {
			Madera madera = new Madera();
			posicionador.crearPosicionRandomYAgregarElemento(madera);
		}
	}
	private void inicializarMaterialMetal(int cant) {
		for (int i = 0; i < cant; i++) {
			Metal metal = new Metal();
			posicionador.crearPosicionRandomYAgregarElemento(metal);
		}
	}
	private void inicializarMaterialDiamante(int cant) {
		for (int i = 0; i < cant; i++) {
			Diamante diamante = new Diamante();
			posicionador.crearPosicionRandomYAgregarElemento(diamante);
		}
	}
	private void inicializarMaterialPiedra(int cant) {
		for (int i = 0; i < cant; i++) {
			Piedra piedra = new Piedra();
			posicionador.crearPosicionRandomYAgregarElemento(piedra);
		}
	}
}
