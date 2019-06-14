package Vista;
import Controlador.BotonCrafteo;
import Controlador.ControladorCerrarCrafteo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class CrafteoVista {
    private JuegoVista juego;

    public void empezarCrafteo(Button BotonCerrar, JuegoVista juego){
        this.juego = juego;
        javafx.scene.shape.Rectangle fondo = new Rectangle(1920, 1080);
        fondo.setFill(Color.rgb(0, 0, 0, 0.9));
        juego.getcontenedorJuego().getChildren().add(fondo);
        new Grilla().mostrarGrilla(juego.getcontenedorJuego(), 1300 ,240, Color.DARKGRAY, Color.DARKGRAY, 100, 2,2 ,0.9);
        javafx.scene.shape.Rectangle  celda = new Rectangle(1400,560,100,100);
        celda.setFill(Color.DARKGRAY);
        celda.setStroke (Color.WHITE);
        juego.getcontenedorJuego().getChildren().add(celda);
        Button Botoncrafteo = new BotonCrafteo();
        juego.getcontenedorJuego().getChildren().add(Botoncrafteo);
        ControladorCerrarCrafteo controladorAbrirCrafteo = new ControladorCerrarCrafteo(juego);
        Botoncrafteo.setOnAction(controladorAbrirCrafteo);
        new InventarioVista().mostrarInventario(juego);

        BotonCerrar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("Cerrar mesa de crafteo.");
                juego.actualizarTodo();
            }
        });

    }
}
