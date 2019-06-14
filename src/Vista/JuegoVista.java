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
	private Botonera botonera;


	public Juego getJuego() { return juego;};
	public MediaPlayer getMusica() { return musica;};
	public Pane getcontenedorJuego() { return contenedorJuego;};

	public void empezarJuego(Stage stage){

	    this.contenedorJuego = new Pane();
		this.juego = new Juego(11,20);
		this.musica = reproducirCancion("media/audio/minecraft.mp3/", 1.0);
		this.botonera = new Botonera();

	    Scene escenaJuego = new Scene(contenedorJuego, 1920, 1080);

	    actualizarTodo();
	    escenaJuego.setOnKeyPressed(e -> {
	    	if (e.getCode() == KeyCode.ESCAPE) { stage.close();}
		    if (e.getCode() == KeyCode.W) { botonera.moverArriba(); }
		    if (e.getCode() == KeyCode.S) { botonera.moverAbajo();}
			if (e.getCode() == KeyCode.A) { botonera.moverIzquierda();}
		    if (e.getCode() == KeyCode.D) { botonera.moverDerecha();}
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

	private void actualizarBotonesVista() { botonera.actualizarBotones(this); }


}
