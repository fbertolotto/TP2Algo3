package Modelo.Herramientas.Desgaste;

public class DesgasteLineal extends Desgaste{

    protected float divisor = 1;

    @Override
    public float desgastar(float valor) {
        return valor/this.divisor;
    }

    public DesgasteLineal(float unDivisor) {
        divisor = unDivisor;
    }

}
