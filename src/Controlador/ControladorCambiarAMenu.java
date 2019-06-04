package Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import static Vista.Cancion.ReproducirCancion;
import static Vista.Imagen.ElegirImagenDeFondo;

public class ControladorCambiarAMenu implements EventHandler<ActionEvent> {

    private Button Boton;
    private AudioClip music;
    private Stage stage;

    public ControladorCambiarAMenu(Button miBoton, AudioClip musica, Stage stage){
        this.Boton = miBoton;
        this.music = musica;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        System.out.println("Entrando al mundo...");
        Pane ContenedorJuego = new Pane();
        Scene escenaJuego = new Scene(ContenedorJuego, 1920, 1080);

        ElegirImagenDeFondo("images/gamebackground.jpg/", ContenedorJuego);


        music.stop();
        AudioClip musicadeljuego = ReproducirCancion("audio/minecraft.mp3/", 1.0);

        stage.setScene(escenaJuego);
        stage.setFullScreen(true);

        BotonGenerico botonexit = new BotonExit();
        ContenedorJuego.getChildren().add(botonexit);

       stage.show();

        ControladorCerrarApp miBotonEventHandler = new ControladorCerrarApp(botonexit, musicadeljuego,stage);

        botonexit.setOnAction(miBotonEventHandler );
    }
}
