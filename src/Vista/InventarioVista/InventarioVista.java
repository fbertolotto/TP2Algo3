package Vista.InventarioVista;

import Modelo.Juego.Juego;
import Modelo.Jugador.Inventario;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.Comunicador;
import Vista.Grilla;
import Vista.JuegoVista;
import Vista.PosicionablesVista.ImagenesVista;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Collection;

public class InventarioVista {

	private JuegoVista juegoVista;
	private int tam = 80;
	private int corrimientoX = 540;
	private int corrimientoY = 240;
	private Comunicador comunicador;
	private Grilla grillaInventario;
	private Pane contenedor;
	private ImagenesVista imagenesVista;

	public InventarioVista(JuegoVista juegoVista, Comunicador comunicador, ImagenesVista imagenes){

		this.contenedor = juegoVista.getcontenedorJuego();
		this.juegoVista = juegoVista;
		this.comunicador = comunicador;
		this.grillaInventario = new Grilla(contenedor, 540 ,240 , Color.GRAY, Color.DARKGRAY, tam, 8,5, 1,1);
		this.imagenesVista = imagenes;
	}

	public void mostrarInventarioCambiar(){

		Rectangle fondo = new Rectangle(1920, 1080);
		fondo.setFill(Color.rgb(0, 0, 0, 0.9));
		juegoVista.getcontenedorJuego().getChildren().add(fondo);
		grillaInventario.actualizar();
		Collection<Posicionable> inventario = juegoVista.getJuego().getJugador().getInventario().obtenerTodosLosElementos();
		for( Posicionable posicionable : inventario) imagenesVista.agregarView(posicionable,"inventario",posicionable.getPosicion(),corrimientoX,corrimientoY,tam,false);
	}


	public void mostrarInventario(){
		Juego juego = juegoVista.getJuego();
		Inventario inventario  = juego.getJugador().getInventario();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 6; j++) {
				Posicion posicionaux = new Posicion(i, j);
				Posicionable posicionable = inventario.obtenerElementoEnPosicion(posicionaux);
				if (posicionable == null) {
					ReceptoraInventarioVista imagenReceptora = new ReceptoraInventarioVista(posicionaux, tam, corrimientoX, corrimientoY, juego, juegoVista, this.comunicador);
					contenedor.getChildren().add(imagenReceptora.getImagen());
					imagenReceptora.setearOnDragOver();
					imagenReceptora.setearOnDragDropped();
					continue;
				}
				ImageView imagenMostradora = imagenesVista.agregarView(posicionable,"inventario",posicionaux,corrimientoX,corrimientoY,80,false);
				MostradoraInventarioVista imagen = new MostradoraInventarioVista(imagenMostradora, posicionable, corrimientoY, corrimientoX, this.comunicador, tam);

				imagen.setearOnDragDetected();
				imagen.setearOnDragDone();

			}
		}
	}

}