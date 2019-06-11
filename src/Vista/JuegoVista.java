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

    public void empezarJuego(Stage stage){

    Pane ContenedorJuego = new Pane();
    Scene escenaJuego = new Scene(ContenedorJuego, 1920, 1080);

    elegirImagenDeFondo("media/images/gamebackground.jpg/", ContenedorJuego);
    MediaPlayer musicadeljuego = reproducirCancion("media/audio/minecraft.mp3/", 1.0);


    new Grilla().mostrarGrilla(ContenedorJuego, 0 ,0, Color.GREEN, Color.VIOLET, 80, 20,11);
    new Grilla().mostrarGrilla(ContenedorJuego, 560 ,1000, Color.RED, Color.ORANGE,80, 9,1);

    Button Botoncrafteo = new BotonCrafteo();
    ContenedorJuego.getChildren().add(Botoncrafteo);
    ControladorAbrirCrafteo controladorAbrirCrafteo = new ControladorAbrirCrafteo(Botoncrafteo, ContenedorJuego);
    Botoncrafteo.setOnAction(controladorAbrirCrafteo);

    Button BotondelVolumen = new BotonVolumen();
    ContenedorJuego.getChildren().add(BotondelVolumen);
    ControladorVolumen controladorVolumen = new ControladorVolumen(BotondelVolumen, ContenedorJuego, musicadeljuego);
    BotondelVolumen.setOnAction(controladorVolumen);

    Juego juego = new Juego(11,20);
    int layoutX = 1760;
    int layoutY = 480;
    Button botonArriba = new Button("↑");
    botonArriba.setScaleX(2);
    botonArriba.setLayoutX(layoutX + 30);
    botonArriba.setLayoutY(layoutY);
    ContenedorJuego.getChildren().add(botonArriba);
    ControladorMoverJugadorArriba controlador = new ControladorMoverJugadorArriba(juego, ContenedorJuego);
    botonArriba.setOnAction(controlador);

    Button botonDerecha = new Button("→");
    botonDerecha.setScaleX(2);
    botonDerecha.setLayoutX(layoutX + 60);
    botonDerecha.setLayoutY(layoutY + 25);
    ContenedorJuego.getChildren().add(botonDerecha);

    Button botonAbajo = new Button("↓");
    botonAbajo.setScaleX(2);
    botonAbajo.setLayoutX(layoutX + 30);
    botonAbajo.setLayoutY(layoutY + 50);
    ContenedorJuego.getChildren().add(botonAbajo);

	Button botonIzquierda = new Button("←");
	botonIzquierda.setMaxSize(400, 400);
	botonIzquierda.setScaleX(2);
	botonIzquierda.setLayoutX(layoutX );
	botonIzquierda.setLayoutY(layoutY + 25);
	ContenedorJuego.getChildren().add(botonIzquierda);

	Collection<Posicionable> coleccion = juego.obtenerTodosLosElementos();
	for( Posicionable posicionable : coleccion) {
		System.out.println(posicionable.getNombre());
		System.out.println(posicionable.getPosicion().getPosX());
		System.out.println(posicionable.getPosicion().getPosY());
			new PosicionableVista(ContenedorJuego, posicionable).mostrarPosicionable();
		}
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
