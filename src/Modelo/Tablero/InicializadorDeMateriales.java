package Modelo.Tablero;

import Modelo.Materiales.*;

public class InicializadorDeMateriales {

	public PosicionadorRandom posicionador;

	public InicializadorDeMateriales(Tablero unTablero) {
		posicionador = new PosicionadorRandom(unTablero);
	}

	public void inicializarMateriales() {
		inicializarMaterial(new Madera(),8);
		inicializarMaterial(new Piedra(),6);
		inicializarMaterial(new Metal(),4);
		inicializarMaterial(new Diamante(),2);
	}

	private void inicializarMaterial(Madera unaMadera,int cant) {
		for (int i = 0; i < cant; i++) {
			Madera madera = new Madera();
			posicionador.crearPosicionRandomYAgregarElemento(madera);
		}
	}
	private void inicializarMaterial(Metal unMetal,int cant) {
		for (int i = 0; i < cant; i++) {
			Metal metal = new Metal();
			posicionador.crearPosicionRandomYAgregarElemento(metal);
		}
	}
	private void inicializarMaterial(Diamante unDiamante,int cant) {
		for (int i = 0; i < cant; i++) {
			Diamante diamante = new Diamante();
			posicionador.crearPosicionRandomYAgregarElemento(diamante);
		}
	}
	private void inicializarMaterial(Piedra unaPiedra,int cant) {
		for (int i = 0; i < cant; i++) {
			Piedra piedra = new Piedra();
			posicionador.crearPosicionRandomYAgregarElemento(piedra);
		}
	}
}
