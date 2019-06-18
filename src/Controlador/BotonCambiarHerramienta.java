package Controlador;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class BotonCambiarHerramienta extends Button {

	public BotonCambiarHerramienta() {
		File file = new File("media/images/cambiarHerramienta.png/");
		Image image = new Image(file.toURI().toString());
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(60);
		imageView.setFitWidth(60);
		this.setGraphic(imageView);
		this.setLayoutX(1825);
		this.setLayoutY(150);
	}
}
