package Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import static Vista.Juego.empezarJuego;

public class ControladorCambiarAMenu implements EventHandler<ActionEvent> {

    private AudioClip music;
    private Stage stage;

    public ControladorCambiarAMenu(AudioClip musica, Stage stage){
        this.music = musica;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        System.out.println("Entrando al mundo...");
        music.stop();
        empezarJuego(stage);

    }
}
