package Controlador;

import Vista.Main;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class BotonVolumen extends Button {

    public BotonVolumen(){
        File file = new File("media/images/volume.png/");
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        this.setGraphic(imageView);
        this.setLayoutX(520);
        this.setLayoutY(1000);

    }
}
