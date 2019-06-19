package Vista;

import Modelo.Juego.Juego;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.PosicionablesVista.PosicionableVista;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.Collection;

import static Vista.Cancion.reproducirCancion;
import static Vista.Imagen.elegirImagenDeFondo;

public class JuegoVista {

	private Pane contenedorJuego;
	private Juego juego;
	private MediaPlayer musica;
	private Botonera botonera;
	private Consola consola;

	public Juego getJuego() { return juego;};
	public MediaPlayer getMusica() { return musica;};
	public Pane getcontenedorJuego() { return contenedorJuego;};
	//public Botonera getBotonera() { return botonera; }

	public void empezarJuego(Stage stage, Pane controlador){

	    this.contenedorJuego = controlador;
		this.juego = new Juego(100,100);
		this.musica = reproducirCancion("media/audio/minecraft.mp3/", 1.0);
		this.botonera = new Botonera(this);
		this.consola = new Consola(contenedorJuego);

	    actualizarTodo();

	    stage.getScene().setOnKeyPressed(e -> {
	    	if (e.getCode() == KeyCode.ESCAPE) { stage.close();}
		    if (e.getCode() == KeyCode.W) { botonera.moverArriba();}
		    if (e.getCode() == KeyCode.S) { botonera.moverAbajo();}
			if (e.getCode() == KeyCode.A) { botonera.moverIzquierda();}
		    if (e.getCode() == KeyCode.D) { botonera.moverDerecha();}
		    if (e.getCode() == KeyCode.E) { botonera.usar();}
	    });
    }

	public void actualizarTodo(){
		contenedorJuego.getChildren().clear();
		juego.moverZombie();
		actualizarMapaVista();
		actualizarInventario();
		actualizarHerramientaEquipada();
		actualizarBotonesVista();
		consola.actualizarConsola();
	}

	private void actualizarInventario() {
		new Grilla().mostrarGrilla(contenedorJuego, 560 ,1000, Color.rgb(0, 0, 0, 0.5), Color.GRAY,80, 8,1, 1,10);
		Collection<Posicionable> inventario = juego.getJugador().obtenerTodosLosElementos();
		for( Posicionable posicionable : inventario) new PosicionableVista(contenedorJuego, posicionable).mostrarPosicionable(560,1000, 80, posicionable.getPosicion(),"inventario");
	}

	private void actualizarMapaVista(){
		elegirImagenDeFondo("media/images/gamebackground.jpg/", contenedorJuego);
		new Grilla().mostrarGrilla(contenedorJuego, 0 ,0, Color.DARKGREEN, Color.BLACK, 80, 23,14, 0.8,0.5);
		Collection<Posicionable> tablero = juego.obtenerTodosLosElementos();
		for( Posicionable posicionable : tablero) {
			if(posicionable.getPosicion().estaenRango(juego.getJugador().getPosicion(),12,7)) {
				Posicion posicionrelativa = new Posicion(posicionable.getPosicion().getColumna()-juego.getJugador().getPosicion().getColumna(), posicionable.getPosicion().getFila()-juego.getJugador().getPosicion().getFila());
				new PosicionableVista(contenedorJuego, posicionable).mostrarPosicionable(960, 560, 80, posicionrelativa,"");
			}
		}
	}

	public void escribirEnConsola(String mensaje) { consola.escribir(mensaje);}

	private void actualizarBotonesVista() { botonera.actualizarBotones(this); }

	private void actualizarHerramientaEquipada() {
		Rectangle Celda = new Rectangle(1720, 945, 125,125);
		Celda.setStroke(Color.GRAY);
		Celda.setOpacity(1);
		Celda.setStrokeWidth(10);
		Celda.setFill(Color.rgb(0, 0, 0, 0.5));
		contenedorJuego.getChildren().add(Celda);
		if (juego.getJugador().obtenerHerramientaEquipada() == null) {return;}
		new PosicionableVista(contenedorJuego, juego.getJugador().obtenerHerramientaEquipada()).mostrarPosicionable(1735, 955,100,new Posicion(0,0),"inventario");
	}
}
