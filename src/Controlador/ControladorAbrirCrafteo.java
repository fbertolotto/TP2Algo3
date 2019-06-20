package Controlador;

import Vista.JuegoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ControladorAbrirCrafteo implements EventHandler<ActionEvent> {
    private JuegoVista juego;

    public ControladorAbrirCrafteo(JuegoVista juego){ this.juego = juego; }

    @Override
    public void handle(ActionEvent event) {
        Rectangle fondo = new Rectangle(1920, 1080);
        fondo.setFill(Color.rgb(0, 0, 0, 0.9));
        juego.getcontenedorJuego().getChildren().add(fondo);
        juego.getCrafteoVista().empezarCrafteo(juego );
        Scene escena  = juego.getcontenedorJuego().getScene();
        escena.setOnKeyPressed(e -> {
           if(e.getCode()== KeyCode.R){
               juego.actualizarTodo();
               event.consume();
           }
        });

    }
}
