package Modelo.Herramientas.Desgaste;

public class DesgasteLineal extends Desgaste{

    @Override
    public float desgastar(float valor) {
        return valor/this.divisor;
    }

}
