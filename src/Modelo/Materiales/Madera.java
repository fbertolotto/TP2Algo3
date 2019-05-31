package Modelo.Materiales;

import Modelo.Herramientas.*;



public class Madera extends Material {

    public Madera() {
        this.durabilidad = 10;
    }

    public void desgastar(Herramienta herramienta) {
        if (Hacha.class.isAssignableFrom(herramienta.getClass())) {
            this.durabilidad -= herramienta.getFuerza();
        }
    }

}


