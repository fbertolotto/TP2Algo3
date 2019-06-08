package Modelo.Materiales;

import Modelo.Herramientas.*;

public class Madera extends Material {

    public Madera() {
        this.durabilidad = 10;
    }

    public void desgastar(Hacha hacha) { this.durabilidad -= hacha.getFuerza(); }

}


