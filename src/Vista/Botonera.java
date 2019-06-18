package Vista;

import Controlador.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Botonera {

	private Button botonArriba;
	private Button botonAbajo;
	private Button botonIzquierda;
	private Button botonDerecha;
	private Button botonVolumen;
	private Button botonCrafteo;
	private Button botonUsarHerramienta;
	private Button botonCambiarHerramienta;

	public Botonera(JuegoVista juego) {
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

		Button botoncrafteo = new BotonCrafteo();
		contenedor.getChildren().add(botoncrafteo);
		ControladorAbrirCrafteo controladorAbrirCrafteo = new ControladorAbrirCrafteo(juego);
		botoncrafteo.setOnAction(controladorAbrirCrafteo);
		this.botonCrafteo = botoncrafteo;

		Button botondelVolumen = new BotonVolumen();
		contenedor.getChildren().add(botondelVolumen);
		ControladorVolumen controladorVolumen = new ControladorVolumen(botondelVolumen, contenedor, juego.getMusica());
		botondelVolumen.setOnAction(controladorVolumen);
		this.botonVolumen = botondelVolumen;

		Button botonUsarHerramienta = new BotonUsarHerramienta();
		contenedor.getChildren().add(botonUsarHerramienta);
		ControladorUsarHerramienta controladorUsarHerramienta = new ControladorUsarHerramienta(juego);
		botonUsarHerramienta.setOnAction(controladorUsarHerramienta);
		this.botonUsarHerramienta = botonUsarHerramienta;

		Button botonCambiarHerramienta = new BotonCambiarHerramienta();
		contenedor.getChildren().add(botonCambiarHerramienta);
		ControladorCambiarHerramienta controladorCambiarHerramienta = new ControladorCambiarHerramienta(juego);
		botonCambiarHerramienta.setOnAction(controladorCambiarHerramienta);
		this.botonCambiarHerramienta = botonCambiarHerramienta;

	}

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
		contenedor.getChildren().add(botonIzquierda);
		contenedor.getChildren().add(botonDerecha);
		contenedor.getChildren().add(botonArriba);
		contenedor.getChildren().add(botonAbajo);
		contenedor.getChildren().add(botonVolumen);
		contenedor.getChildren().add(botonCrafteo);
		contenedor.getChildren().add(botonUsarHerramienta);
		contenedor.getChildren().add(botonCambiarHerramienta);

	}

	public void moverArriba() { this.botonArriba.fire(); }
	public void moverAbajo() { this.botonAbajo.fire(); }
	public void moverDerecha() { this.botonDerecha.fire(); }
	public void moverIzquierda() { this.botonIzquierda.fire(); }
	public void usar() {this.botonUsarHerramienta.fire(); }
	public void abrircCafteo() {this.botonCrafteo.fire(); }
}
