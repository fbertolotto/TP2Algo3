package Modelo.Herramientas.Desgaste;

public class DesgasteLineal extends Desgaste{

    private float divisor = 1;

    public DesgasteLineal(float unDivisor) {
        divisor = unDivisor;
    }

    @Override
    public float desgastar(float valor) {
        return valor/this.divisor;
    }

}
