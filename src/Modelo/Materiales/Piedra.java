package Modelo.Materiales;

import Modelo.Herramientas.*;

public class Piedra extends Material {

    public Piedra() {
        this.durabilidad = 30;
    }

    public void desgastar(Herramienta herramienta) {
        if (Piedra.class.isAssignableFrom(herramienta.getClass())) {
            this.durabilidad -= herramienta.getFuerza();
        }
    }
}
