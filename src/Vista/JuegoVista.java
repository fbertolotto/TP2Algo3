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

    elegirImagenDeFondo("media/images/gamebackground.jpg/", contenedorJuego);
    MediaPlayer musicadeljuego = reproducirCancion("media/audio/minecraft.mp3/", 1.0);

    new Grilla().mostrarGrilla(contenedorJuego, 0 ,0, Color.GREEN, Color.VIOLET, 80, 20,11);
    new Grilla().mostrarGrilla(contenedorJuego, 560 ,1000, Color.RED, Color.ORANGE,80, 9,1);

    Button Botoncrafteo = new BotonCrafteo();
		contenedorJuego.getChildren().add(Botoncrafteo);
    ControladorAbrirCrafteo controladorAbrirCrafteo = new ControladorAbrirCrafteo(Botoncrafteo, contenedorJuego);
    Botoncrafteo.setOnAction(controladorAbrirCrafteo);

    Button BotondelVolumen = new BotonVolumen();
    ControladorVolumen controladorVolumen = new ControladorVolumen(BotondelVolumen, contenedorJuego, musicadeljuego);
    BotondelVolumen.setOnAction(controladorVolumen);

    Juego juego = new Juego(11,20);


    Button botonArriba = crearBoton(1760,480,"↑",2,30,0,contenedorJuego);
    ControladorMoverJugadorArriba controlador = new ControladorMoverJugadorArriba(juego, contenedorJuego);
    botonArriba.setOnAction(controlador);

    Button botonDerecha = crearBoton(1760,480,"→",2,60,25,contenedorJuego);
    Button botonAbajo = crearBoton(1760,480,"↓",2,30,50,contenedorJuego);
    Button botonIzquierda = crearBoton(1760,480,"←",2,0,25,contenedorJuego);
	//botonIzquierda.setMaxSize(400, 400);

	Collection<Posicionable> coleccion = juego.obtenerTodosLosElementos();


	//Print MAPA (?)
	for( Posicionable posicionable : coleccion) new PosicionableVista(contenedorJuego, posicionable).mostrarPosicionable();

    escenaJuego.setOnKeyPressed(e -> {
        if (e.getCode() == KeyCode.ESCAPE) {
            System.out.println("Cerrando App");
            stage.close();
        }
    });

    stage.setScene(escenaJuego);
    stage.setFullScreen(true);
    stage.show();
    }

}
