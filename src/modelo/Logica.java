package modelo;

import java.util.LinkedList;

import processing.core.PApplet;

public class Logica {
	
	PApplet app;
	LinkedList <Personaje> homeros;
	public Logica(PApplet app) {
		this.app=app;
		
		homeros=new LinkedList<Personaje>();
	}
	
	public void crearBoton() {
		app.rect(500,550,100,30);
		app.fill(0);
		app.text("crear",550,570);
		app.fill(255,255,0);
	}
	
	public void crearPersonaje() {
		if(app.mouseX>=500 &&app.mouseX<=600&&app.mouseY>=550&&app.mouseY<=580) {
			homeros.add(new Personaje((int)app.random(0,100),(int)app.random(0,100),
					app,(int)app.random(250,750),(int)app.random(0,500),"homero_simpson.png"));
		}
		
	}
	
	public void pintarPersonajes() {
		for (int i = 0; i < homeros.size(); i++) {
			homeros.get(i).pintar();
		}
	}
	
	public void moverPersonaje() {
		for (int i = 0; i < homeros.size(); i++) {
			new Thread(homeros.get(i)).start();
		}
	}
}
