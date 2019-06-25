package Vista.MesaDeCrafteoVista;

import Modelo.Juego.*;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.Comunicador;
import Vista.JuegoVista;
import Vista.PosicionablesVista.ImagenesCrafteoVista;
import Vista.PosicionablesVista.ImagenesVista;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class MesaDeCrafteoVista {

	public int TAM_CELDA = 100;
	public int corrimientoX = 1300;
	public int corrimientoY = 240;
	public Comunicador comunicador;
	public JuegoVista juegoVista;
	public Pane contenedor;
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
					ReceptoraMesaDeCrafteoVista imagenReceptora = new ReceptoraMesaDeCrafteoVista(TAM_CELDA, corrimientoX, corrimientoY, juego, juegoVista, comunicador, posicionaux);
					contenedor.getChildren().add(imagenReceptora.getImagen());
					imagenReceptora.setearOnDragOver();
					imagenReceptora.setearOnDragDroppped();
					continue;
				}

				//ImageView imagenMostradora = new ImagenesCrafteoVista(contenedor, posicionable).mostrarPosicionable(corrimientoX, corrimientoY, TAM_CELDA, posicionaux,"inventario", true);
				ImageView imagenMostradora = imagenesVista.agregarView(posicionable,"inventario",posicionaux,corrimientoX,corrimientoY,20,20,true);
				MostradoraMesaDeCrafteoVista imagen = new MostradoraMesaDeCrafteoVista(imagenMostradora, TAM_CELDA, corrimientoX, corrimientoY, juego, juegoVista, comunicador);

				imagen.setearOnDragDetected(posicionable);
				imagen.setearOnDragDone();
			}
		}
	}

	public void mostrarResultadoCrafteo(){
		juegoVista.getCrafteoVista().actualizarCelda();
		Posicionable posicionablecrafteado= juegoVista.getJuego().getMesaDeCrafteo().craftear();

		if(posicionablecrafteado != null) {
			//ImageView imagencrafteada = new ImagenesCrafteoVista(contenedor, posicionablecrafteado).mostrarPosicionable(1400, 560, 100, new Posicion(0,0),"", true);
			ImageView imagencrafteada = imagenesVista.agregarView(posicionablecrafteado,"",new Posicion(0,0),1400,560,20,20,true);
			CrafteadoraMesaDeCrafteoVista imagenCrafteada = new CrafteadoraMesaDeCrafteoVista(imagencrafteada, 100, 1400, 560, juegoVista, comunicador);
			imagenCrafteada.setearOnDragDetected(posicionablecrafteado);
			imagenCrafteada.setearOnDragDone();
		}
	}
}
