package Vista.MesaDeCrafteoVista;

import Modelo.Juego.*;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.Comunicador;
import Vista.JuegoVista;
import Vista.PosicionablesVista.PosicionableVista;
import javafx.scene.image.ImageView;


public class MesaDeCrafteoVista {
	public int TAM_CELDA = 100;;
	public int corrimientoX = 1300;
	public int corrimientoY = 240;
	public Comunicador comunicador;

	public void mostrarMesadeCrafteo(JuegoVista juegoVista, Comunicador comunicador) {
		this.comunicador = comunicador;
		Juego juego = juegoVista.getJuego();
		MesaDeCrafteo mesadeCrafteo = juego.getMesaDeCrafteo();
		for (int columna = 0; columna < 3; columna++) {
			for (int fila = 0; fila < 3; fila++) {
				Posicion posicionaux = new Posicion(columna, fila);
				Posicionable posicionable = mesadeCrafteo.obtenerElementoEnPosicion(posicionaux);

				if (posicionable == null) {
					ReceptoraMesaDeCrafteoVista imagenReceptora = new ReceptoraMesaDeCrafteoVista(TAM_CELDA, corrimientoX, corrimientoY, juego, juegoVista, comunicador, posicionaux);
					juegoVista.getcontenedorJuego().getChildren().add(imagenReceptora.getImagen());
					imagenReceptora.setearOnDragOver();
					imagenReceptora.setearOnDragDroppped(posicionable);
					continue;
				}

				ImageView imagenMostradora = new PosicionableVista(juegoVista.getcontenedorJuego(), posicionable).mostrarPosicionable(corrimientoX, corrimientoY, TAM_CELDA, posicionaux,"inventario");
				MostradoraMesaDeCrafteoVista imagen = new MostradoraMesaDeCrafteoVista(imagenMostradora, TAM_CELDA, corrimientoX, corrimientoY, juego, juegoVista, comunicador);

				imagen.setearOnDragDetected(posicionable);
				imagen.setearOnDragDone();
			}
		}
	}
}
