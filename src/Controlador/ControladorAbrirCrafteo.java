package Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import static Vista.Crafteo.empezarCrafteo;

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
        empezarCrafteo(contenedor, BotonCerrar);
    }
}
