package Modelo.Mapa;

import java.util.HashMap;
import Modelo.Posicionable.Posicionable;

public class Mapa {
    private HashMap<Posicion, Posicionable> grilla;

    private Mapa() {
        this.grilla = new HashMap<>();
    }


}
