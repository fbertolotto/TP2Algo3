package Vista;

import Modelo.Juego.Juego;
import Modelo.Jugador.Inventario;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.PosicionablesVista.PosicionableVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.Color;


public class InventarioVista {
	private JuegoVista juegoVista;
	public int TAM_CELDA = 80;;
	public int corrimientoX = 540;
	public int corrimientoY = 240;
	public Comunicador comunicador;

	public void mostrarInventario(JuegoVista juegoVista, Comunicador comuicador){
		this.comunicador = comuicador;
		this.juegoVista = juegoVista;
		Juego juego = juegoVista.getJuego();
		Inventario inventario  = juego.getJugador().getInventario();
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 6; j++) {
				Posicion posicionaux = new Posicion(i,j);
				Posicionable posicionable = inventario.obtenerElementoEnPosicion(posicionaux);
				if(posicionable == null) {
					ImageView imagenreceptora = new ImageView();
					imagenreceptora.setImage(null);
					imagenreceptora.setPickOnBounds(true);
					imagenreceptora.setFitHeight(TAM_CELDA);
					imagenreceptora.setFitWidth(TAM_CELDA);
					imagenreceptora.setLayoutX(posicionaux.getColumna() * TAM_CELDA + corrimientoX);
					imagenreceptora.setLayoutY(posicionaux.getFila() * TAM_CELDA + corrimientoY);

					juegoVista.getcontenedorJuego().getChildren().add(imagenreceptora);
					imagenreceptora.setOnDragOver(new EventHandler<DragEvent>() {
						public void handle(DragEvent event) {
							Dragboard dragboard = event.getDragboard();

							if (dragboard.hasImage()) {
								event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
							}

							event.consume();
						}
					});
					imagenreceptora.setOnDragDropped(new EventHandler<DragEvent>() {
						public void handle(DragEvent event) {
							System.out.println("Event on Target: drag dropped");
							Dragboard dragboard = event.getDragboard();
							if (dragboard.hasImage()) {
								imagenreceptora.setImage(dragboard.getImage());
								Posicionable posicionabletrasladado = comuicador.consultarPosicionable();
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
								if((MouseX<1300)&&(MouseX>540)&&(MouseY<720)&&(MouseY>240)){
									juego.getJugador().removerEnInventario(posicionabletrasladado);
								}else if((MouseY>560)&&(MouseY<660)&&(MouseX>1400)&&(MouseX<1500)) {
									new CrafteoVista().actualizarCelda(juegoVista);
								}else{
									juego.getMesaDeCrafteo().removerElemento(posicionabletrasladado);
								}
								juego.getJugador().agregarEnInventarioEnPosicion(posicionabletrasladado, new Posicion(nuevaColumna,nuevaFila));
								new CrafteoVista().actualizarTodo(juegoVista,comunicador);

								// Data transfer is successful
								event.setDropCompleted(true);
							} else {
								// Data transfer is not successful
								event.setDropCompleted(false);
							}
							event.consume();
						}
					});


					continue;
				}
			ImageView imagen = new PosicionableVista(juegoVista.getcontenedorJuego(), posicionable).mostrarPosicionable(corrimientoX, corrimientoY,TAM_CELDA, posicionaux);

			imagen.setOnDragDetected(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					System.out.println("Event on Source: drag detected");
					Image imagenaextraer = imagen.getImage();
					System.out.println("posicionable enviado: " + posicionable);

					if (imagenaextraer == null) {
						event.consume();
						return;
					}

					// Initiate a drag-and-drop gesture
					Dragboard dragboard = imagen.startDragAndDrop(TransferMode.MOVE);

					// Add the source text to the Dragboard
					ClipboardContent content = new ClipboardContent();
					content.putImage(imagenaextraer);
					dragboard.setContent(content);
					comunicador.asignarPosicionable(posicionable);
					comunicador.asignarPosicionMouse(event.getX()+corrimientoX, event.getY()+corrimientoY);
					event.consume();
				}
			});

			imagen.setOnDragDone(new EventHandler<DragEvent>() {
				public void handle(DragEvent event) {
					System.out.println("Event on Source: drag done");
					TransferMode modeUsed = event.getTransferMode();

					if (modeUsed == TransferMode.MOVE) {
						imagen.setImage(null);
					}
					new CrafteoVista().actualizarTodo(juegoVista,comunicador);
					event.consume();
				}
			});
		}
	}

}