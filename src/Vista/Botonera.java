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
	private Button botonEquipada;
	private Button botonCambiarEquipada;

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

		Button Botoncrafteo = new BotonCrafteo();
		contenedor.getChildren().add(Botoncrafteo);
		ControladorAbrirCrafteo controladorAbrirCrafteo = new ControladorAbrirCrafteo(juego);
		Botoncrafteo.setOnAction(controladorAbrirCrafteo);
		this.botonCrafteo = Botoncrafteo;

		Button BotondelVolumen = new BotonVolumen();
		contenedor.getChildren().add(BotondelVolumen);
		ControladorVolumen controladorVolumen = new ControladorVolumen(BotondelVolumen, contenedor, juego.getMusica());
		BotondelVolumen.setOnAction(controladorVolumen);
		this.botonVolumen = BotondelVolumen;


		Button botonequipada = crearBoton(contenedor,1760,720,"Usar",1,20,0);
		ControladorUsarHerramienta Controladorboton = new ControladorUsarHerramienta(juego);
		botonequipada.setOnAction(Controladorboton);
		this.botonEquipada = botonequipada;

		Button botoncambiarequipada = crearBoton(contenedor,1760,720,"Cambiar",1,20,30);
		ControladorCambiarHerramienta Controladorbotoncambiar = new ControladorCambiarHerramienta(juego);
		botoncambiarequipada.setOnAction(Controladorbotoncambiar);
		this.botonCambiarEquipada = botoncambiarequipada;

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
		contenedor.getChildren().add(botonEquipada);
		contenedor.getChildren().add(botonCambiarEquipada);

	}

	public void moverArriba() { this.botonArriba.fire(); }
	public void moverAbajo() { this.botonAbajo.fire(); }
	public void moverDerecha() { this.botonDerecha.fire(); }
	public void moverIzquierda() { this.botonIzquierda.fire(); }
	public void usar() {this.botonEquipada.fire(); }
	public void abrircCafteo() {this.botonCrafteo.fire(); }
}
