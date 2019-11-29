package modelo;

import java.util.LinkedList;

import processing.core.PApplet;

public class Logica {
	
	PApplet app;
	LinkedList <Personaje> homeros;
	LinkedList<Personaje> izquierda;
	boolean error1=false;
	public Logica(PApplet app) {
		this.app=app;
		
		homeros=new LinkedList<Personaje>();
		izquierda=new LinkedList<Personaje>();
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
					app,(int)app.random(250,699),(int)app.random(0,570),"simpson/homero_simpson.png"));
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
	
	public void pintarIzquierda() {
		for (int i = 0; i < izquierda.size(); i++) {
			if(error1==false) {
				izquierda.get(i).setPosX(50);
				izquierda.get(i).setPosY(20+i*100);
				izquierda.get(i).setLink("simpson/lisa_simpson.png");
				izquierda.get(i).pintar();
			}
	
		}
	}
	
	public void aLaIzquierda() {
			for (int j = 0; j < homeros.size(); j++) {
				if(error1==false) {
					if(app.dist(homeros.get(j).getPosX(), homeros.get(j).getPosY(), app.mouseX, app.mouseY)<=70) {
						izquierda.add(homeros.get(j));
						System.out.println(izquierda.size());
					}
				}
				
			}
	}
	
	
	public void demasiadosElementos() throws NoMasPersonajes{
		if(izquierda.size()>=5) {
			throw new NoMasPersonajes("No se pueden crear más de 4 personajes");
		}
	}
	
	public void noAgregarMas() {
		try {
			demasiadosElementos();
		}catch(NoMasPersonajes e) {
			error1=true;
			System.out.println(e.getMessage());
		}
	}
}
