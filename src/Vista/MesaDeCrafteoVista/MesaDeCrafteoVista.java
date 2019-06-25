package Vista.MesaDeCrafteoVista;

import Modelo.Juego.*;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.Comunicador;
import Vista.JuegoVista;
import Vista.PosicionablesVista.ImagenesVista;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import static Vista.Cancion.reproducirSonido;


public class MesaDeCrafteoVista {

	private int tam = 100;
	private int corrimientoX = 1300;
	private int corrimientoY = 240;
	private Comunicador comunicador;
	private JuegoVista juegoVista;
	private Pane contenedor;
	private ImagenesVista imagenesVista;

	public MesaDeCrafteoVista(JuegoVista juegoVista, Comunicador comunicador, ImagenesVista imagenes) {

		this.imagenesVista = imagenes;
		this.comunicador = comunicador;
		this.juegoVista = juegoVista;
		this.contenedor = juegoVista.getcontenedorJuego();
	}

	public void mostrarMesadeCrafteo() {
		Juego juego = juegoVista.getJuego();
		MesaDeCrafteo mesadeCrafteo = juego.getMesaDeCrafteo();

		for (int columna = 0; columna < 3; columna++) {
			for (int fila = 0; fila < 3; fila++) {
				Posicion posicionaux = new Posicion(columna, fila);
				Posicionable posicionable = mesadeCrafteo.obtenerElementoEnPosicion(posicionaux);

				if (posicionable == null) {
					ReceptoraMesaDeCrafteoVista imagenReceptora = new ReceptoraMesaDeCrafteoVista(tam, corrimientoX, corrimientoY, juego, juegoVista, comunicador, posicionaux);
					contenedor.getChildren().add(imagenReceptora.getImagen());
					imagenReceptora.setearOnDragOver();
					imagenReceptora.setearOnDragDroppped();
					continue;
				}
				ImageView imagenMostradora = imagenesVista.agregarView(posicionable,"inventario",posicionaux,corrimientoX,corrimientoY,tam,false);
				MostradoraMesaDeCrafteoVista imagen = new MostradoraMesaDeCrafteoVista(imagenMostradora, tam, corrimientoX, corrimientoY, comunicador);

				imagen.setearOnDragDetected(posicionable);
				imagen.setearOnDragDone();
			}
		}
	}

	public void mostrarResultadoCrafteo(){

		juegoVista.getCrafteoVista().actualizarCelda();
		Posicionable posicionablecrafteado= juegoVista.getJuego().getMesaDeCrafteo().craftear();
		if(posicionablecrafteado != null) {
			ImageView imagencrafteada = imagenesVista.agregarView(posicionablecrafteado,"",new Posicion(0,0),1400,560,100,true);
			CrafteadoraMesaDeCrafteoVista imagenCrafteada = new CrafteadoraMesaDeCrafteoVista(imagencrafteada, 100, 1400, 560, juegoVista, comunicador);
			imagenCrafteada.setearOnDragDetected(posicionablecrafteado);
			reproducirSonido("media/audio/CrafteoExitoso.mp3", 1,1);
			imagenCrafteada.setearOnDragDone();
		}
	}

}
