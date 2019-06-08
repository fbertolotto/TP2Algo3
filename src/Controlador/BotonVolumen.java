package Controlador;

import Vista.Main;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonVolumen extends Button {

    public BotonVolumen(){
        Image image = new Image(Main.class.getResource("images/volume.png/").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        this.setGraphic(imageView);
        this.setLayoutX(520);
        this.setLayoutY(1000);

    }
}
