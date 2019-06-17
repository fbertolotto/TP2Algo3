package Vista;

import Modelo.Juego.Juego;
import Modelo.Posicionable.Posicionable;
import Vista.PosicionablesVista.PosicionableVista;
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

	public void empezarJuego(Stage stage, Pane controlador){

	    this.contenedorJuego = controlador;
		this.juego = new Juego(11,20);
		this.musica = reproducirCancion("media/audio/minecraft.mp3/", 1.0);
		this.botonera = new Botonera(this);

	    actualizarTodo();
	    stage.getScene().setOnKeyPressed(e -> {
	    	if (e.getCode() == KeyCode.ESCAPE) { stage.close();}
		    if (e.getCode() == KeyCode.W) { botonera.moverArriba(); }
		    if (e.getCode() == KeyCode.S) { botonera.moverAbajo();}
			if (e.getCode() == KeyCode.A) { botonera.moverIzquierda();}
		    if (e.getCode() == KeyCode.D) { botonera.moverDerecha();}
			if (e.getCode() == KeyCode.SPACE) { }
	    });
    }

	public void actualizarTodo(){
		contenedorJuego.getChildren().clear();
		actualizarMapaVista();
		actualizarInventario();
		actualizarBotonesVista();
	}

	private void actualizarInventario() {
		new Grilla().mostrarGrilla(contenedorJuego, 560 ,1000, Color.RED, Color.ORANGE,80, 9,1, 0.5);
		Collection<Posicionable> inventario = juego.getJugador().obtenerTodosLosElementos();
		for( Posicionable posicionable : inventario) new PosicionableVista(contenedorJuego, posicionable).mostrarPosicionable(560,1000, 80, posicionable.getPosicion());
	}

	private void actualizarMapaVista(){
		elegirImagenDeFondo("media/images/gamebackground.jpg/", contenedorJuego);
		new Grilla().mostrarGrilla(contenedorJuego, 0 ,0, Color.GREEN, Color.VIOLET, 80, 20,11, 0.5);
		Collection<Posicionable> tablero = juego.obtenerTodosLosElementos();
		for( Posicionable posicionable : tablero) new PosicionableVista(contenedorJuego, posicionable).mostrarPosicionable(0,0, 80, posicionable.getPosicion());
	}

	private void actualizarBotonesVista() { botonera.actualizarBotones(this); }


}
