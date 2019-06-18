package Vista.InventarioVista;

import Modelo.Juego.Juego;
import Modelo.Jugador.Inventario;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.Comunicador;
import Vista.Grilla;
import Vista.JuegoVista;
import Vista.PosicionablesVista.PosicionableVista;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Collection;


public class InventarioVista {
	public JuegoVista juegoVista;
	public int TAM_CELDA = 80;;
	public int corrimientoX = 540;
	public int corrimientoY = 240;
	public Comunicador comunicador;

	public void mostrarInventarioCambiar(JuegoVista juegoVista){
		Rectangle fondo = new Rectangle(1920, 1080);
		fondo.setFill(Color.rgb(0, 0, 0, 0.9));
		juegoVista.getcontenedorJuego().getChildren().add(fondo);
		new Grilla().mostrarGrilla(juegoVista.getcontenedorJuego(), 540 ,240 , Color.GRAY, Color.DARKGRAY, 80, 8,5, 1,1);
		Collection<Posicionable> inventario = juegoVista.getJuego().getJugador().getInventario().obtenerTodosLosElementos();
		for( Posicionable posicionable : inventario) new PosicionableVista(juegoVista.getcontenedorJuego(), posicionable).mostrarPosicionable(corrimientoX ,corrimientoY, TAM_CELDA, posicionable.getPosicion(),"inventario");
	}


	public void mostrarInventario(JuegoVista juegoVista, Comunicador comuicador){
		this.comunicador = comuicador;
		this.juegoVista = juegoVista;
		Juego juego = juegoVista.getJuego();
		Inventario inventario  = juego.getJugador().getInventario();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 6; j++) {
				Posicion posicionaux = new Posicion(i, j);
				Posicionable posicionable = inventario.obtenerElementoEnPosicion(posicionaux);
				if (posicionable == null) {
					ReceptoraInventarioVista imagenReceptora = new ReceptoraInventarioVista(posicionaux, TAM_CELDA, corrimientoX, corrimientoY, juego, juegoVista, comunicador);
					juegoVista.getcontenedorJuego().getChildren().add(imagenReceptora.getImagen());
					imagenReceptora.setearOnDragOver();
					imagenReceptora.setearOnDragDropped();
					continue;
				}

				ImageView imagenMostradora = new PosicionableVista(juegoVista.getcontenedorJuego(), posicionable).mostrarPosicionable(corrimientoX, corrimientoY, TAM_CELDA, posicionaux,"inventario");
				MostradoraInventarioVista imagen = new MostradoraInventarioVista(imagenMostradora, posicionable, corrimientoY, corrimientoX, comunicador, juegoVista);

				imagen.setearOnDragDetected();
				imagen.setearOnDragDone();

			}
		}
	}

}