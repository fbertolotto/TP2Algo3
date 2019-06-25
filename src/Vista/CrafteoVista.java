package Vista;

import Controlador.BotonCrafteo;
import Controlador.ControladorCerrarCrafteo;
import Vista.InventarioVista.InventarioVista;
import Vista.MesaDeCrafteoVista.MesaDeCrafteoVista;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class CrafteoVista {

    private Comunicador comunicador = new Comunicador();
    private Pane contenedor;


    public CrafteoVista(JuegoVista juego) {
        this.contenedor = juego.getcontenedorJuego();
        this.mesaDeCrafteoVista = new MesaDeCrafteoVista( juego, comunicador,juego.getImagenes());
        this.inventarioVista = new InventarioVista(juego, comunicador, juego.getImagenes());
    }

    public void empezarCrafteo(JuegoVista juego) {
        Button Botoncrafteo = new BotonCrafteo();
        contenedor.getChildren().add(Botoncrafteo);
        ControladorCerrarCrafteo controladorCerrarrCrafteo = new ControladorCerrarCrafteo(juego);
        Botoncrafteo.setOnAction(controladorCerrarrCrafteo);
        actualizarCelda();
        actualizarTodo();
    }

    public  void actualizarTodo() {
        actualizarCelda();
        actualizarInventario();
        actualizarMesaDeCrafteo();
        mesaDeCrafteoVista.mostrarResultadoCrafteo();
    }

    public void actualizarInventario() {
        new Grilla(contenedor, 540 ,240 , Color.GRAY, Color.DARKGRAY, 80, 8,5, 1,1);
        inventarioVista.mostrarInventario();
    }

    public void actualizarMesaDeCrafteo() {
        new Grilla(contenedor, 1300, 240, Color.GRAY, Color.DARKGRAY, 100, 2, 2, 1,1);
        mesaDeCrafteoVista.mostrarMesadeCrafteo();
    }

    public  void actualizarCelda() {
        Rectangle celda = new Rectangle(1400, 560, 100, 100);
        celda.setFill(Color.DARKGRAY);
        celda.setStroke(Color.WHITE);
        contenedor.getChildren().add(celda);
    }

    protected MesaDeCrafteoVista mesaDeCrafteoVista;
    protected InventarioVista inventarioVista;

    public InventarioVista getInventarioVista() {
        return inventarioVista;
    }

}
