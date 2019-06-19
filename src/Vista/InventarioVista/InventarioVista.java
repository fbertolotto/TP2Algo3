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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Collection;


public class InventarioVista {

	private JuegoVista juegoVista;
	private int TAM_CELDA = 80;;
	private int corrimientoX = 540;
	private int corrimientoY = 240;
	private Comunicador comunicador;
	private Grilla grillaInventario;
	private Pane contenedor;


	public InventarioVista(JuegoVista juegoVista) {
		this.contenedor = juegoVista.getcontenedorJuego();
		this.grillaInventario = new Grilla(juegoVista.getcontenedorJuego(), 540 ,240 , Color.GRAY, Color.DARKGRAY, 80, 8,5, 1,1);
	}

	public void mostrarInventarioCambiar(JuegoVista juegoVista){

		Rectangle fondo = new Rectangle(1920, 1080);
		fondo.setFill(Color.rgb(0, 0, 0, 0.9));
		juegoVista.getcontenedorJuego().getChildren().add(fondo);
		grillaInventario.actualizar();
		Collection<Posicionable> inventario = juegoVista.getJuego().getJugador().getInventario().obtenerTodosLosElementos();
		for( Posicionable posicionable : inventario) new PosicionableVista(juegoVista.getcontenedorJuego(), posicionable).mostrarPosicionable(corrimientoX ,corrimientoY, TAM_CELDA, posicionable.getPosicion(),"inventario", true);

	}


	public void mostrarInventario(JuegoVista juegoVista, Comunicador comunicador){
		this.comunicador = comunicador;
		this.juegoVista = juegoVista;
		Juego juego = juegoVista.getJuego();
		Inventario inventario  = juego.getJugador().getInventario();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 6; j++) {
				Posicion posicionaux = new Posicion(i, j);
				Posicionable posicionable = inventario.obtenerElementoEnPosicion(posicionaux);
				if (posicionable == null) {
					ReceptoraInventarioVista imagenReceptora = new ReceptoraInventarioVista(posicionaux, TAM_CELDA, corrimientoX, corrimientoY, juego, juegoVista, this.comunicador);
					juegoVista.getcontenedorJuego().getChildren().add(imagenReceptora.getImagen());
					imagenReceptora.setearOnDragOver();
					imagenReceptora.setearOnDragDropped();
					continue;
				}

				ImageView imagenMostradora = new PosicionableVista(juegoVista.getcontenedorJuego(), posicionable).mostrarPosicionable(corrimientoX, corrimientoY, TAM_CELDA, posicionaux,"inventario", true);
				MostradoraInventarioVista imagen = new MostradoraInventarioVista(imagenMostradora, posicionable, corrimientoY, corrimientoX, this.comunicador, juegoVista);

				imagen.setearOnDragDetected();
				imagen.setearOnDragDone();

			}
		}
	}

}