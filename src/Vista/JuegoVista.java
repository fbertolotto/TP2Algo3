package Vista;

import Controlador.*;
import Modelo.Juego.Juego;
import Modelo.Posicionable.Posicionable;
import Vista.PosicionablesVista.PosicionableVista;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Collection;

import static Vista.Cancion.reproducirCancion;
import static Vista.Imagen.elegirImagenDeFondo;


public class JuegoVista {

	private Pane contenedorJuego;
	private Juego juego;
	private MediaPlayer musica;

	private Button botonArriba;
	private Button botonAbajo;
	private Button botonIzquierda;
	private Button botonDerecha;

	public Juego getJuego() { return juego;};
	public MediaPlayer getMusica() { return musica;};
	public Pane getcontenedorJuego() { return contenedorJuego;};

	public void empezarJuego(Stage stage){

	    this.contenedorJuego = new Pane();
		this.juego = new Juego(11,20);
		this.musica = reproducirCancion("media/audio/minecraft.mp3/", 1.0);

	    Scene escenaJuego = new Scene(contenedorJuego, 1920, 1080);

	    actualizarTodo();
	    escenaJuego.setOnKeyPressed(e -> {
	    	if (e.getCode() == KeyCode.ESCAPE) { stage.close();}
		    if (e.getCode() == KeyCode.W) { this.botonArriba.fire();}
		    if (e.getCode() == KeyCode.S) { this.botonAbajo.fire();}
			if (e.getCode() == KeyCode.A) { this.botonIzquierda.fire();}
		    if (e.getCode() == KeyCode.D) { this.botonDerecha.fire();}
	    });
	    stage.setScene(escenaJuego);
	    stage.setFullScreen(true);
	    stage.show();

    }

	public void actualizarTodo(){
		contenedorJuego.getChildren().clear();
		actualizarMapaVista();
		actualizarInventario();
		actualizarBotonesVista();
	}

	private void actualizarInventario() {
		new Grilla().mostrarGrilla(contenedorJuego, 560 ,1000, Color.RED, Color.ORANGE,80, 9,1);
		Collection<Posicionable> iventario = juego.getJugador().obtenerTodosLosElementos();
		for( Posicionable posicionable : iventario) new PosicionableVista(contenedorJuego, posicionable).mostrarPosicionable(560,1000);
	}

	private void actualizarMapaVista(){
		elegirImagenDeFondo("media/images/gamebackground.jpg/", contenedorJuego);
		new Grilla().mostrarGrilla(contenedorJuego, 0 ,0, Color.GREEN, Color.VIOLET, 80, 20,11);
		Collection<Posicionable> tablero = juego.obtenerTodosLosElementos();
		for( Posicionable posicionable : tablero) new PosicionableVista(contenedorJuego, posicionable).mostrarPosicionable(0,0);
	}

	private void actualizarBotonesVista(){

		Button botonArriba = crearBoton(1760,480,"↑",2,30,0);
		ControladorMoverJugadorArriba arriba = new ControladorMoverJugadorArriba(this);
		botonArriba.setOnAction(arriba);
		this.botonArriba = botonArriba;

		Button botonAbajo = crearBoton(1760,480,"↓",2,30,50);
		ControladorMoverJugadorAbajo abajo = new ControladorMoverJugadorAbajo(this);
		botonAbajo.setOnAction(abajo);
		this.botonAbajo = botonAbajo;


		Button botonDerecha = crearBoton(1760,480,"→",2,60,25);
		ControladorMoverJugadorDerecha derecha = new ControladorMoverJugadorDerecha(this);
		botonDerecha.setOnAction(derecha);
		this.botonDerecha = botonDerecha;

		Button botonIzquierda = crearBoton(1760,480,"←",2,0,25);
		ControladorMoverJugadorIzquierda izquierda = new ControladorMoverJugadorIzquierda(this);
		botonIzquierda.setOnAction(izquierda);
		this.botonIzquierda = botonIzquierda;


		Button Botoncrafteo = new BotonCrafteo();
		contenedorJuego.getChildren().add(Botoncrafteo);
		ControladorAbrirCrafteo controladorAbrirCrafteo = new ControladorAbrirCrafteo(Botoncrafteo, contenedorJuego);
		Botoncrafteo.setOnAction(controladorAbrirCrafteo);

		Button BotondelVolumen = new BotonVolumen();
		contenedorJuego.getChildren().add(BotondelVolumen);
		ControladorVolumen controladorVolumen = new ControladorVolumen(BotondelVolumen, contenedorJuego, musica);
		BotondelVolumen.setOnAction(controladorVolumen);
	}

	private Button crearBoton(int x,int y,String icon,int scale,int corrimientoX,int corrmientoY) {
		Button boton = new Button(icon);
		boton.setScaleX(scale);
		boton.setLayoutX(x + corrimientoX);
		boton.setLayoutY(y + corrmientoY);
		this.contenedorJuego.getChildren().add(boton);
		return boton;
	}
}
