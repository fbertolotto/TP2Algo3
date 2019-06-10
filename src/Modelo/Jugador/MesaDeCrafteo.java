package Modelo.Jugador;

import Modelo.Herramientas.*;
import Modelo.Juego.Crafteo;

import java.util.*;


public class MesaDeCrafteo {

	private HashMap<Crafteo, Herramienta> crafteos;

	public MesaDeCrafteo() {

		crafteos = new HashMap();

		List hachademadera = Arrays.asList("Madera", "Madera", "", "Madera", "Madera", "", "", "Madera", "");
		Crafteo HachaDeMadera = new Crafteo(hachademadera);
		crafteos.put(HachaDeMadera, new HachaDeMadera());


		Crafteo HachaDePiedra = new Crafteo(new ArrayList<>(Arrays.asList("Piedra", "Piedra", "", "Piedra", "Piedra", "", "", "Piedra", "")));
		crafteos.put(HachaDePiedra, new HachaDePiedra());


		Crafteo HachaDeMetal = new Crafteo(new ArrayList<>(Arrays.asList("Metal", "Metal", "", "Metal", "Madera", "", "", "Madera", "")));
		crafteos.put(HachaDeMetal, new HachaDeMetal());


		Crafteo PicoDeMadera = new Crafteo(new ArrayList<>(Arrays.asList("Madera", "Madera", "Madera", "", "Madera", "", "", "Madera", "")));
		crafteos.put(PicoDeMadera, new PicoDeMadera());


		Crafteo PicoDePiedra = new Crafteo(new ArrayList<>(Arrays.asList("Piedra", "Piedra", "Piedra", "", "Madera", "", "", "Madera", "")));
		crafteos.put(PicoDePiedra, new PicoDePiedra());


		Crafteo PicoDeMetal = new Crafteo(new ArrayList<>(Arrays.asList("Metal", "Metal", "Metal", "", "Madera", "", "", "Madera", "")));
		crafteos.put(PicoDeMetal, new PicoDeMetal());


		Crafteo PicoFino = new Crafteo(new ArrayList<>(Arrays.asList("Metal", "Metal", "Metal", "Piedra", "Madera", "", "", "Madera", "")));
		crafteos.put(PicoFino, new PicoFino());
	}

	public Herramienta craftear(Crafteo crafteo) {
		return crafteos.get(crafteo);
	}
}


