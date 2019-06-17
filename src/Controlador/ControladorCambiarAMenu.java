package Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import Vista.JuegoVista;

public class ControladorCambiarAMenu implements EventHandler<ActionEvent> {

    private Pane controlador;
    private MediaPlayer music;
    private Stage stage;

    public ControladorCambiarAMenu(MediaPlayer musica, Pane controlador, Stage stage){
        this.music = musica;
        this.stage = stage;
        this.controlador = controlador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        music.stop();
        new JuegoVista().empezarJuego(stage, controlador);

    }
}
