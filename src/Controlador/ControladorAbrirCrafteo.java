package Controlador;

import Vista.JuegoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Vista.CrafteoVista;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ControladorAbrirCrafteo implements EventHandler<ActionEvent> {
    private JuegoVista juego;

    public ControladorAbrirCrafteo(JuegoVista juego){
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Abrir Mesa de Crafteo.");
        Rectangle fondo = new Rectangle(1920, 1080);
        fondo.setFill(Color.rgb(0, 0, 0, 0.9));
        juego.getcontenedorJuego().getChildren().add(fondo);
        new CrafteoVista().empezarCrafteo(juego );
    }
}
