package Vista;

import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import static Vista.Cancion.reproducirCancion;


public class Consola {

	private Pane contenedor;
	private TextArea consola;

	public Consola(Pane contenedor) {
		this.contenedor = contenedor;
		consola = new TextArea();
		consola.setLayoutX(1560);
		consola.setLayoutY(760);
		consola.setMaxSize(350,175);
		consola.setEditable(false);
		consola.setOpacity(0.6);
		consola.setStyle("-fx-text-fill: red; -fx-font-size: 14px;");
		this.actualizarConsola();
	}

	public void actualizarConsola() {
		contenedor.getChildren().add(consola);
	}
	public void escribir(String mensaje) {
		reproducirCancion("media/audio/broken.mp3", 0.5,1);
		consola.appendText("• " + mensaje + "\n"); }
}
