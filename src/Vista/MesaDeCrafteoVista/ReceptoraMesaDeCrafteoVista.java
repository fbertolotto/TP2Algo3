package Vista.MesaDeCrafteoVista;

import Modelo.Excepciones.PosicionFueraDeRangoException;
import Modelo.Excepciones.PosicionOcupadaException;
import Modelo.Juego.Juego;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.Comunicador;
import Vista.CrafteoVista;
import Vista.JuegoVista;
import Vista.PosicionablesVista.PosicionableVista;
import javafx.event.EventHandler;
import javafx.scene.Node;

import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class ReceptoraMesaDeCrafteoVista {

	public int TAM_CELDA;
	public int corrimientoX;
	public int corrimientoY;
	public ImageView imagenreceptora;
	public Comunicador comunicador;
	public JuegoVista juegoVista;
	public Juego juego;


	public ReceptoraMesaDeCrafteoVista(int tam_celda, int corrimientoX, int corrimientoY, Juego juego, JuegoVista juegoVista, Comunicador comunicador, Posicion posicionaux) {
		this.TAM_CELDA = tam_celda;
		this.corrimientoX = corrimientoX;
		this.corrimientoY = corrimientoY;
		this.comunicador = comunicador;
		this.juegoVista = juegoVista;
		this.juego = juego;
		this.imagenreceptora = new ImageView();
		imagenreceptora.setImage(null);
		imagenreceptora.setPickOnBounds(true);
		imagenreceptora.setFitHeight(TAM_CELDA);
		imagenreceptora.setFitWidth(TAM_CELDA);
		imagenreceptora.setLayoutX(posicionaux.getColumna() * TAM_CELDA + corrimientoX);
		imagenreceptora.setLayoutY(posicionaux.getFila()* TAM_CELDA + corrimientoY);
	}

	public Node getImagen() {
		return imagenreceptora;
	}

	public void setearOnDragOver() {
		imagenreceptora.setOnDragOver(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				Dragboard dragboard = event.getDragboard();

				if (dragboard.hasImage()) {
					event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				}
				event.consume();
			}
		});
	}

	public void setearOnDragDroppped(Posicionable posicionable) {
		imagenreceptora.setOnDragDropped(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				System.out.println("Event on Target: drag dropped");
				Dragboard dragboard = event.getDragboard();

				if (dragboard.hasImage()) {
					imagenreceptora.setImage(dragboard.getImage());
					try {
						Posicionable posicionabletrasladado = comunicador.consultarPosicionable();
						int nuevaFila = (int)(imagenreceptora.getLayoutY() - corrimientoY)/TAM_CELDA   ;
						System.out.println("Fila "+ (nuevaFila+1));
						int nuevaColumna = (int)(imagenreceptora.getLayoutX()- corrimientoX)/TAM_CELDA   ;
						System.out.println("Columna "+ (nuevaColumna+1));
						double LayoutY =imagenreceptora.getLayoutY();
						System.out.println("LayoutY: "+ LayoutY);
						double LayoutX=imagenreceptora.getLayoutX();
						System.out.println("LayoutX: "+ LayoutX);
						System.out.println("posicionable recibido: " + posicionabletrasladado);
						double MouseX = comunicador.consultarPosicionMouseX();
						double MouseY = comunicador.consultarPosicionMouseY();
						System.out.println("MOUSE X: "+MouseX+"MOUSE Y:"+MouseY);
						if((MouseX<1500)&&(MouseX>1300)&&(MouseY<540)&&(MouseY>240)){
							juego.getMesaDeCrafteo().removerElemento(posicionabletrasladado);
						}else {
							juego.getJugador().removerEnInventario(posicionabletrasladado);
						}

						juego.getMesaDeCrafteo().colocarElementoEnPosicion(posicionabletrasladado, new Posicion(nuevaColumna,nuevaFila));
						new CrafteoVista().actualizarTodo(juegoVista,comunicador);
						Posicionable posicionablecrafteado= juego.getMesaDeCrafteo().craftear();
						System.out.println("poscicionable crafteado"+posicionablecrafteado);


						ImageView imagencrafteada =new PosicionableVista(juegoVista.getcontenedorJuego(), posicionablecrafteado).mostrarPosicionable(1400, 560, 100, new Posicion(0,0));
						CrafteadoraMesaDeCrafteoVista imagenCrafteada = new CrafteadoraMesaDeCrafteoVista(imagencrafteada, TAM_CELDA, corrimientoX, corrimientoY, juego, juegoVista, comunicador);
						imagenCrafteada.setearOnDragDetected(posicionable,posicionablecrafteado);
						imagenCrafteada.setearOnDragDone();

					} catch (PosicionOcupadaException | PosicionFueraDeRangoException e) { System.out.println("Algo rompe");}

					// Data transfer is successful
					event.setDropCompleted(true);
				} else {
					// Data transfer is not successful
					event.setDropCompleted(false);
				}
				event.consume();
			}
		});
	}
}
