package Controlador;

import Vista.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ControladorAbrirCrafteo implements EventHandler<ActionEvent> {
    private Pane contenedor;
    private Button BotonCerrar;

    public ControladorAbrirCrafteo(Button boton, Pane contenedor){
        this.contenedor = contenedor;
        this.BotonCerrar = boton;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Abrir Mesa de Crafteo.");
        Image bgImage = new Image(Main.class.getResource("images/crafteo.png/").toExternalForm());
        ImageView imageView = new ImageView();
        imageView.setImage(bgImage);
        imageView.setFitHeight(500);
        imageView.setFitWidth(500);
        imageView.setLayoutX(1380);
        imageView.setLayoutY(940);
        this.contenedor.getChildren().add(imageView);

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
