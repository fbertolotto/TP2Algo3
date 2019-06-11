package Controlador;

import Modelo.Juego.Juego;
import Modelo.Posicionable.Posicionable;
import Vista.Grilla;
import Vista.PosicionablesVista.PosicionableVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Collection;

import static Vista.Imagen.elegirImagenDeFondo;

public class ControladorMoverJugadorArriba implements EventHandler<ActionEvent> {

		private Juego juego;
		private Pane contenedor;

		public ControladorMoverJugadorArriba(Juego juego, Pane contenedor){
			this.juego = juego;
			this.contenedor = contenedor;
		}

		@Override
		public void handle(ActionEvent actionEvent) {
			elegirImagenDeFondo("images/gamebackground.jpg/", contenedor);
			new Grilla().mostrarGrilla(contenedor, 0 ,0, Color.GREEN, Color.VIOLET, 80, 20,11);
			new Grilla().mostrarGrilla(contenedor, 560 ,1000, Color.RED, Color.ORANGE,80, 9,1);
			juego.moverJugadorEnVertical(-1);
			Collection<Posicionable> coleccion = juego.obtenerTodosLosElementos();
			for( Posicionable posicionable : coleccion) {
				new PosicionableVista(contenedor, posicionable).mostrarPosicionable();
			}
			int layoutX = 1760;
			int layoutY = 480;
			Button botonArriba = new Button("↑");
			botonArriba.setScaleX(2);
			botonArriba.setLayoutX(layoutX + 30);
			botonArriba.setLayoutY(layoutY);
			contenedor.getChildren().add(botonArriba);
			ControladorMoverJugadorArriba controlador = new ControladorMoverJugadorArriba(juego, contenedor);
			botonArriba.setOnAction(controlador);
		}
	}
