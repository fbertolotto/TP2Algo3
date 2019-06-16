package Vista;

import Modelo.Excepciones.PosicionFueraDeRangoException;
import Modelo.Excepciones.PosicionOcupadaException;
import Modelo.Herramientas.PicoDeMadera;
import Modelo.Juego.Juego;
import Modelo.Juego.MesaDeCrafteo;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.PosicionablesVista.PosicionableVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class MesaDeCrafteoVista {
	private  JuegoVista juegoVista;
	public int TAM_CELDA = 100;;
	public int corrimientoX = 1300;
	public int corrimientoY = 240;
	public Comunicador comunicador;

	public void mostrarMesadeCrafteo(JuegoVista juegoVista, Comunicador comunicador) {
		this.juegoVista = juegoVista;
		this.comunicador = comunicador;
		Juego juego = juegoVista.getJuego();
		MesaDeCrafteo mesadeCrafteo = juego.getMesaDeCrafteo();
		for (int columna = 0; columna < 3; columna++)
			for (int fila = 0; fila < 3; fila++) {
				Posicion posicionaux = new Posicion(columna, fila);
				Posicionable posicionable = mesadeCrafteo.obtenerElementoEnPosicion(posicionaux);
				if(posicionable == null) {
					ImageView imagenreceptora = new ImageView();
					imagenreceptora.setImage(null);
					imagenreceptora.setPickOnBounds(true);
					imagenreceptora.setFitHeight(TAM_CELDA);
					imagenreceptora.setFitWidth(TAM_CELDA);
					imagenreceptora.setLayoutX(posicionaux.getColumna() * TAM_CELDA + corrimientoX);
					imagenreceptora.setLayoutY(posicionaux.getFila()* TAM_CELDA + corrimientoY);

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

									imagencrafteada.setOnDragDetected(new EventHandler<MouseEvent>() {
										public void handle(MouseEvent event) {
											System.out.println("Event on Source: drag detected");
											Image imagenaextraer = imagencrafteada.getImage();
											System.out.println("posicionable enviado: " + posicionable);

											if (imagenaextraer == null) {
												event.consume();
												return;
											}

											// Initiate a drag-and-drop gesture
											Dragboard dragboard = imagencrafteada.startDragAndDrop(TransferMode.COPY_OR_MOVE);

											// Add the source text to the Dragboard
											ClipboardContent content = new ClipboardContent();
											content.putImage(imagenaextraer);
											dragboard.setContent(content);
											comunicador.asignarPosicionable(posicionablecrafteado);
											comunicador.asignarPosicionMouse(event.getX()+corrimientoX, event.getY()+corrimientoY);
											event.consume();
										}
									});

									imagencrafteada.setOnDragDone(new EventHandler<DragEvent>() {
										public void handle(DragEvent event) {
											System.out.println("Event on Source: drag done");
											TransferMode modeUsed = event.getTransferMode();

											if (modeUsed == TransferMode.MOVE) {
												imagencrafteada.setImage(null);
											}
											new CrafteoVista().actualizarTodo(juegoVista,comunicador);
											event.consume();
										}
									});


									if(juego.getJugador().tieneUnaHerramienta(new PicoDeMadera())) System.out.println("Tenia la herramienta");
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

					continue;
				}
				ImageView imagen = new PosicionableVista(juegoVista.getcontenedorJuego(), posicionable).mostrarPosicionable(1300, 240, 100, posicionaux);
				imagen.setFitWidth(100);
				imagen.setFitHeight(100);
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
						Dragboard dragboard = imagen.startDragAndDrop(TransferMode.COPY_OR_MOVE);

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
