package Vista;


import Modelo.Juego.Juego;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.PosicionablesVista.ImagenesVista;
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
	private Stage stage;
	private Juego juego;
	private MediaPlayer musica;
	private Botonera botonera;
	private Consola consola;
	private Grilla grillaInventario;
	private Grilla grillaMapa;
	private CrafteoVista crafteoVista;
	private ImagenesVista imagenesVista;

	public ImagenesVista getImagenes() { return imagenesVista;}
	public Juego getJuego() { return juego;}
	public MediaPlayer getMusica() { return musica;}
	public Pane getcontenedorJuego() { return contenedorJuego;}
	public CrafteoVista getCrafteoVista() { return crafteoVista; }

	public void empezarJuego(Stage stage, Pane controlador){

		//Inicializadores
	    this.contenedorJuego = controlador;
	    this.stage = stage;
		this.juego = new Juego(100,100);
		this.musica = reproducirCancion("media/audio/minecraft.mp3/", 1.0);
		this.botonera = new Botonera(this);
		this.consola = new Consola(contenedorJuego);
		this.grillaInventario = new Grilla(contenedorJuego, 560 ,996, Color.rgb(0, 0, 0, 0.5), Color.GRAY,80, 8,1, 1,10);
		this.grillaMapa = new Grilla(contenedorJuego, 0 ,0, Color.DARKGREEN, Color.BLACK, 80, 23,14, 0.8,0.5);
		this.imagenesVista = new ImagenesVista(contenedorJuego);
		this.crafteoVista = new CrafteoVista(this);
	    actualizarTodo();

	    actualizarTeclas();
    }

	public void actualizarTodo(){
		contenedorJuego.getChildren().clear();
		System.gc();
		actualizarZombie();
		actualizarMapaVista();
		actualizarInventario();
		actualizarHerramientaEquipada();
		actualizarBotonesVista();
		actualizarConsola();
		actualizarTeclas();
	}

	private void actualizarZombie() { juego.moverZombie(); }

	private void actualizarConsola() { consola.actualizarConsola(); }

	private void actualizarInventario() {
		grillaInventario.actualizar();
		Collection<Posicionable> inventario = juego.getJugador().obtenerTodosLosElementos();
		for( Posicionable posicionable : inventario) {
			imagenesVista.agregarView(posicionable, "inventario", posicionable.getPosicion(), 560, 996,80,false);
		}
	}

	private void actualizarMapaVista(){
		elegirImagenDeFondo("media/images/gamebackground.jpg/", contenedorJuego);
		grillaMapa.actualizar();
		Collection<Posicionable> tablero = juego.obtenerTodosLosElementos();
		for( Posicionable posicionable : tablero) {
			if(posicionable.getPosicion().estaenRango(juego.getJugador().getPosicion(),12,7)) {
				Posicion posicionrelativa = new Posicion(posicionable.getPosicion().getColumna()-juego.getJugador().getPosicion().getColumna(), posicionable.getPosicion().getFila()-juego.getJugador().getPosicion().getFila());
				imagenesVista.agregarView(posicionable, "", posicionrelativa, 960, 560,80,true);
			}
		}
	}

	public void escribirEnConsola(String mensaje) { consola.escribir(mensaje);}

	private void actualizarBotonesVista() { botonera.actualizarBotones(this); }

	private void actualizarHerramientaEquipada() {
		Rectangle Celda = new Rectangle(1720, 945, 125, 125);
		Celda.setStroke(Color.GRAY);
		Celda.setOpacity(1);
		Celda.setStrokeWidth(10);
		Celda.setFill(Color.rgb(0, 0, 0, 0.5));
		contenedorJuego.getChildren().add(Celda);
		if (juego.getJugador().obtenerHerramientaEquipada() == null) { return; }
		imagenesVista.agregarView(juego.getJugador().obtenerHerramientaEquipada(), "inventario", new Posicion(0, 0), 1743, 962, 80,true);
	}


	public void actualizarTeclas(){
		stage.getScene().setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ESCAPE) { stage.close();}
			if (e.getCode() == KeyCode.W) { botonera.moverArriba();}
			if (e.getCode() == KeyCode.S) { botonera.moverAbajo();}
			if (e.getCode() == KeyCode.A) { botonera.moverIzquierda();}
			if (e.getCode() == KeyCode.D) { botonera.moverDerecha();}
			if (e.getCode() == KeyCode.E) { botonera.usar();}
			if (e.getCode() == KeyCode.Q) { botonera.cambiarHerramienta(); }
			if (e.getCode() == KeyCode.R) { botonera.abrirCrafteo();}
		});
	}


}
