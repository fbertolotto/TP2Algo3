package Vista;

import Controlador.*;
import Modelo.Juego.Juego;
import Modelo.Posicionable.Posicionable;
import Vista.PosicionablesVista.PosicionableVista;
import Vista.PosicionablesVista.PosicionableVista.*;
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

	private Button crearBoton(int x,int y,String icon,int scale,int corrimientoX,int corrmientoY,Pane contenedorJuego) {
		Button boton = new Button(icon);
		boton.setScaleX(scale);
		boton.setLayoutX(x + corrimientoX);
		boton.setLayoutY(y + corrmientoY);
		contenedorJuego.getChildren().add(boton);
		return boton;
	}

	public void empezarJuego(Stage stage){

    Pane contenedorJuego = new Pane();
    Scene escenaJuego = new Scene(contenedorJuego, 1920, 1080);
    MediaPlayer musicadeljuego = reproducirCancion("media/audio/minecraft.mp3/", 1.0);


    Juego juego = new Juego(11,20);
    actualizarTodo(contenedorJuego, juego, musicadeljuego);


    escenaJuego.setOnKeyPressed(e -> {
        if (e.getCode() == KeyCode.ESCAPE) {
            System.out.println("Cerrando App");
            stage.close();
        }
    });

    escenaJuego.setOnMouseClicked(event -> {
		actualizarTodo(contenedorJuego, juego, musicadeljuego);
	});

    stage.setScene(escenaJuego);
    stage.setFullScreen(true);
    stage.show();
    }

	public void actualizarMapaVista(Pane contenedor, Juego juego){
		new Grilla().mostrarGrilla(contenedor, 0 ,0, Color.GREEN, Color.VIOLET, 80, 20,11);
		Collection<Posicionable> coleccion = juego.obtenerTodosLosElementos();
		for( Posicionable posicionable : coleccion) new PosicionableVista(contenedor, posicionable).mostrarPosicionable();
	}


	public void actualizarBotonesVista(Pane contenedor, MediaPlayer musicadeljuego, Juego juego){


		Button botonArriba = crearBoton(1760,480,"↑",2,30,0,contenedor);
		ControladorMoverJugadorArriba controlador = new ControladorMoverJugadorArriba(juego, contenedor);
		botonArriba.setOnAction(controlador);

		Button botonDerecha = crearBoton(1760,480,"→",2,60,25,contenedor);
		Button botonAbajo = crearBoton(1760,480,"↓",2,30,50,contenedor);
		Button botonIzquierda = crearBoton(1760,480,"←",2,0,25,contenedor);

		Button Botoncrafteo = new BotonCrafteo();
		contenedor.getChildren().add(Botoncrafteo);
		ControladorAbrirCrafteo controladorAbrirCrafteo = new ControladorAbrirCrafteo(Botoncrafteo, contenedor);
		Botoncrafteo.setOnAction(controladorAbrirCrafteo);

		Button BotondelVolumen = new BotonVolumen();
		contenedor.getChildren().add(BotondelVolumen);
		ControladorVolumen controladorVolumen = new ControladorVolumen(BotondelVolumen, contenedor, musicadeljuego);
		BotondelVolumen.setOnAction(controladorVolumen);
	}

	public void  actualizarTodo(Pane contenedorJuego, Juego juego, MediaPlayer musicadeljuego){
		elegirImagenDeFondo("media/images/gamebackground.jpg/", contenedorJuego);
		actualizarMapaVista( contenedorJuego,juego);
		new Grilla().mostrarGrilla(contenedorJuego, 560 ,1000, Color.RED, Color.ORANGE,80, 9,1);
		actualizarBotonesVista(contenedorJuego, musicadeljuego, juego);

	}
}
