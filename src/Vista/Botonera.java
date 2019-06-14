package Vista;

import Controlador.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Botonera {

	private Button botonArriba;
	private Button botonAbajo;
	private Button botonIzquierda;
	private Button botonDerecha;

	private Button crearBoton(Pane contenedor,int x,int y,String icon,int scale,int corrimientoX,int corrmientoY) {
		Button boton = new Button(icon);
		boton.setScaleX(scale);
		boton.setLayoutX(x + corrimientoX);
		boton.setLayoutY(y + corrmientoY);
		contenedor.getChildren().add(boton);
		return boton;
	}

	public void actualizarBotones(JuegoVista juego) {

		Pane contenedor = juego.getcontenedorJuego();

		Button botonArriba = crearBoton(contenedor,1760,480,"↑",2,30,0);
		ControladorMoverJugadorArriba arriba = new ControladorMoverJugadorArriba(juego);
		botonArriba.setOnAction(arriba);
		this.botonArriba = botonArriba;

		Button botonAbajo = crearBoton(contenedor,1760,480,"↓",2,30,50);
		ControladorMoverJugadorAbajo abajo = new ControladorMoverJugadorAbajo(juego);
		botonAbajo.setOnAction(abajo);
		this.botonAbajo = botonAbajo;

		Button botonDerecha = crearBoton(contenedor,1760,480,"→",2,60,25);
		ControladorMoverJugadorDerecha derecha = new ControladorMoverJugadorDerecha(juego);
		botonDerecha.setOnAction(derecha);
		this.botonDerecha = botonDerecha;

		Button botonIzquierda = crearBoton(contenedor,1760,480,"←",2,0,25);
		ControladorMoverJugadorIzquierda izquierda = new ControladorMoverJugadorIzquierda(juego);
		botonIzquierda.setOnAction(izquierda);
		this.botonIzquierda = botonIzquierda;

		Button Botoncrafteo = new BotonCrafteo();
		contenedor.getChildren().add(Botoncrafteo);
		ControladorAbrirCrafteo controladorAbrirCrafteo = new ControladorAbrirCrafteo(Botoncrafteo, contenedor);
		Botoncrafteo.setOnAction(controladorAbrirCrafteo);

		Button BotondelVolumen = new BotonVolumen();
		contenedor.getChildren().add(BotondelVolumen);
		ControladorVolumen controladorVolumen = new ControladorVolumen(BotondelVolumen, contenedor, juego.getMusica());
		BotondelVolumen.setOnAction(controladorVolumen);

	}

	public void moverArriba() { this.botonArriba.fire(); }
	public void moverAbajo() { this.botonAbajo.fire(); }
	public void moverDerecha() { this.botonDerecha.fire(); }
	public void moverIzquierda() { this.botonIzquierda.fire(); }
}
