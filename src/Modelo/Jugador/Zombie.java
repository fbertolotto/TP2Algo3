package Modelo.Jugador;

import Modelo.Posicionable.Posicionable;
import java.util.concurrent.ThreadLocalRandom;

public class Zombie extends Posicionable {

    public Zombie() {nombre = "Zombie";}

    public int moverRandom() {
        int random = ThreadLocalRandom.current().nextInt(-1, 2);
        return random;
    }
}
