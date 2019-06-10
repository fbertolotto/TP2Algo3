package Vista;

import Controlador.BotonVolumen;
import Controlador.ControladorAbrirCrafteo;
import Controlador.BotonCrafteo;
import Controlador.ControladorVolumen;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static Vista.Cancion.reproducirCancion;
import static Vista.Imagen.elegirImagenDeFondo;

public class JuegoVista {

    public static void empezarJuego(Stage stage){

    Pane ContenedorJuego = new Pane();
    Scene escenaJuego = new Scene(ContenedorJuego, 1920, 1080);

    elegirImagenDeFondo("images/gamebackground.jpg/", ContenedorJuego);
    MediaPlayer musicadeljuego = reproducirCancion("audio/minecraft.mp3/", 1.0);


    new Grilla().mostrarGrilla(ContenedorJuego, 0 ,0, Color.GREEN, Color.VIOLET, 40, 47,24);
    new Grilla().mostrarGrilla(ContenedorJuego, 560 ,1000, Color.RED, Color.ORANGE,80, 9,1);

    Button Botoncrafteo = new BotonCrafteo();
    ContenedorJuego.getChildren().add(Botoncrafteo);
    ControladorAbrirCrafteo controladorAbrirCrafteo = new ControladorAbrirCrafteo(Botoncrafteo, ContenedorJuego);
    Botoncrafteo.setOnAction(controladorAbrirCrafteo);

    Button BotondelVolumen = new BotonVolumen();
    ContenedorJuego.getChildren().add(BotondelVolumen);
    ControladorVolumen controladorVolumen = new ControladorVolumen(BotondelVolumen, ContenedorJuego, musicadeljuego);
    BotondelVolumen.setOnAction(controladorVolumen);

    escenaJuego.setOnKeyPressed(e -> {
        if (e.getCode() == KeyCode.ESCAPE) {
            System.out.println("Cerrando App");
            stage.close();
        }
    });

    stage.setScene(escenaJuego);
    stage.setFullScreen(true);
    stage.show();
    }

}
