package Vista;
import Controlador.BotonCrafteo;
import Controlador.ControladorCerrarCrafteo;
import Vista.InventarioVista.InventarioVista;
import Vista.MesaDeCrafteoVista.MesaDeCrafteoVista;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class CrafteoVista {
    private JuegoVista juego;
    public Comunicador comunicador = new Comunicador();

    public void empezarCrafteo(JuegoVista juego) {
        this.juego = juego;
        Button Botoncrafteo = new BotonCrafteo();
        juego.getcontenedorJuego().getChildren().add(Botoncrafteo);
        ControladorCerrarCrafteo controladorCerrarrCrafteo = new ControladorCerrarCrafteo(juego);
        Botoncrafteo.setOnAction(controladorCerrarrCrafteo);
        actualizarCelda(juego);
        actualizarTodo(juego,comunicador);
    }

    public  void actualizarTodo(JuegoVista juego, Comunicador comunicador) {
        actualizarInventario(juego,comunicador);
        actualizarMesaDeCrafteo(juego,comunicador);
    }
    public void actualizarInventario(JuegoVista juego, Comunicador comunicador) {
        new Grilla().mostrarGrilla(juego.getcontenedorJuego(), 540 ,240 , Color.GRAY, Color.DARKGRAY, 80, 8,5, 1);
        new InventarioVista().mostrarInventario(juego, comunicador);
    }
    public void actualizarMesaDeCrafteo(JuegoVista juego, Comunicador comunicador){
        new Grilla().mostrarGrilla(juego.getcontenedorJuego(), 1300, 240, Color.GRAY, Color.DARKGRAY, 100, 2, 2, 1);
        new MesaDeCrafteoVista().mostrarMesadeCrafteo(juego,comunicador);

    }
    public  void actualizarCelda(JuegoVista juego) {
        Rectangle celda = new Rectangle(1400, 560, 100, 100);
        celda.setFill(Color.DARKGRAY);
        celda.setStroke(Color.WHITE);
        juego.getcontenedorJuego().getChildren().add(celda);
    }

}
