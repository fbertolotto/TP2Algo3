package Vista;

import Controlador.ControladorAbrirCrafteo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Crafteo {

    public static void empezarCrafteo(Pane contenedor, Button BotonCerrar){
        Image bgImage = new Image(Main.class.getResource("images/inventario.png/").toExternalForm());
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
