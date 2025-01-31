import java.util.concurrent.Semaphore;

public class Pac implements Runnable {
	private int posx;
	private int posy;
	private char dir; // indica la direccion en la que se va a mover
	private Tablero tab;
	private Semaphore semaforo;
	
	public Pac(int posx, int posy, char dir, Tablero tab) {
		this.posx = posx;
		this.posy = posy;
		this.dir = dir;
		this.tab=tab;
		this.semaforo=tab.getSemaforo();
		tab.actualizarPosicion(posx, posy, " P ");
	}
	
	
	public void mover() {
		
		int nuevax=posx;
		int nuevay=posy;
		
		
		switch(dir) {
		case 'U': 
			if(posx>1) {
				nuevax--;
			}
			break;
		case 'D':
			if(posx<Tablero.getFilas()-2) {
				nuevax++;
			}
			break;
		case 'L':
			if(posy>1) {
				nuevay--;
			}
			break;
		case 'R':
			if(posy<Tablero.getColumnas()-2) {
				nuevay++;
			}
			break;
		
		}
		String posSiguiente = tab.getMatrTab()[nuevax][nuevay];
		if(posSiguiente.equals(" | ") || posSiguiente.equals("───")) {
			return;
		}
		
		tab.cogerPuntos(posx, posy);
		posx=nuevax;
		posy=nuevay;
		
		tab.actualizarPosicion(posx, posy, " P ");
		
		
		
	}
	
	public void cambiarDireccion(char nuevadire) {
		if(nuevadire =='U' || nuevadire =='D' || nuevadire=='L' || nuevadire=='R' ) {
			this.setDir(nuevadire);
		} else {
			System.out.println("Direccion invalida");
		}
	}
	
	
	
	
	public int getPosx() {
		return posx;
	}
	public void setPosx(int posx) {
		this.posx = posx;
	}
	public int getPosy() {
		return posy;
	}
	public void setPosy(int posy) {
		this.posy = posy;
	}


	public char getDir() {
		return dir;
	}


	public void setDir(char dir) {
		this.dir = dir;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				tab.borrarMapa();
				semaforo.acquire();
				mover();
				tab.mostrarLaberinto();
				semaforo.release();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
}
