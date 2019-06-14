package Controlador;

import Vista.JuegoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import Vista.CrafteoVista;

public class ControladorAbrirCrafteo implements EventHandler<ActionEvent> {
    private JuegoVista juego;
    private Button BotonCerrar;

    public ControladorAbrirCrafteo(Button boton, JuegoVista juego){
        this.juego = juego;
        this.BotonCerrar = boton;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Abrir Mesa de Crafteo.");
        new CrafteoVista().empezarCrafteo(BotonCerrar, juego );
    }
}
