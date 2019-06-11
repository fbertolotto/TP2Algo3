package Vista;

import Controlador.ControladorAbrirCrafteo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

public class Crafteo {

    public static void empezarCrafteo(Pane contenedor, Button BotonCerrar){
        File file = new File("media/images/inventario.png/");
        Image bgImage = new Image(file.toURI().toString());
        ImageView imageView = new ImageView();
        imageView.setImage(bgImage);
        imageView.setLayoutX(600);
        imageView.setLayoutY(200);
        contenedor.getChildren().add(imageView);

        BotonCerrar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("Cerrar mesa de crafteo.");
                imageView.setImage(null);
                ControladorAbrirCrafteo controladorAbrirCrafteo = new ControladorAbrirCrafteo(BotonCerrar, contenedor);
                BotonCerrar.setOnAction(controladorAbrirCrafteo);
            }
        });

    }
}
