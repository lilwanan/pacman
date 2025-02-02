import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Tablero {
	
	private static final int filas = 15;
	private static final int columnas = 19;
	private static String [][] matrTab;
	private Semaphore semaforo;
	private static boolean salir;
	private static int dificultad;
	
	public Tablero(int dificultad) {
		this.dificultad=dificultad;
		matrTab = new String [filas][columnas];
		semaforo = new Semaphore(1);
		generarLaberinto();
		generarLimites();
		generarLimitesDentro();
		generarPacman(); 
		generarFantasma();
		mostrarLaberinto();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce dificultad 1.FACIL 2.NORMAL 3.DIFICIL");
		dificultad=sc.nextInt();
		if(dificultad==1) {
			Tablero tab = new Tablero(1);
			Pac pac = new Pac(9,9,'R',tab);
			Fantasma f1 = new Fantasma(7,9,tab);
			Fantasma f2 = new Fantasma(7,10,tab);
			Fantasma f3 = new Fantasma(7,8,tab);
			Fantasma f4 = new Fantasma(6,9,tab);
			Thread hiloPac = new Thread(pac);
			Thread hiloF4 = new Thread(f4);
			Thread hiloF1 = new Thread(f1);
			Thread hiloF2 = new Thread(f2);
			Thread hiloF3 = new Thread(f3);
			
			hiloPac.start();
			hiloF4.start();
			hiloF1.start();
			hiloF2.start();
			hiloF3.start();
			while(true) {
				
				char nuevaDir = sc.next().toUpperCase().charAt(0);
				pac.cambiarDireccion(nuevaDir);
				borrarMapa1();
				mostrarLaberinto();
				
				
				
			}
		}
		else if(dificultad==2) {
			Tablero tab = new Tablero(2);
			Pac pac = new Pac(9,9,'R',tab);
			Fantasma f1 = new Fantasma(7,9,tab);
			Fantasma f2 = new Fantasma(7,10,tab);
			Fantasma f3 = new Fantasma(7,8,tab);
			Fantasma f4 = new Fantasma(6,9,tab);
			Thread hiloPac = new Thread(pac);
			Thread hiloF4 = new Thread(f4);
			Thread hiloF1 = new Thread(f1);
			Thread hiloF2 = new Thread(f2);
			Thread hiloF3 = new Thread(f3);
			
			hiloPac.start();
			hiloF4.start();
			hiloF1.start();
			hiloF2.start();
			hiloF3.start();
			while(true) {
				
				char nuevaDir = sc.next().toUpperCase().charAt(0);
				pac.cambiarDireccion(nuevaDir);
				borrarMapa1();
				mostrarLaberinto();
				
				
			}
		} else if(dificultad==3) {
			Tablero tab = new Tablero(3);
			Pac pac = new Pac(9,9,'R',tab);
			Fantasma f1 = new Fantasma(7,9,tab);
			Fantasma f2 = new Fantasma(7,10,tab);
			Fantasma f3 = new Fantasma(7,8,tab);
			Fantasma f4 = new Fantasma(6,9,tab);
			Thread hiloPac = new Thread(pac);
			Thread hiloF4 = new Thread(f4);
			Thread hiloF1 = new Thread(f1);
			Thread hiloF2 = new Thread(f2);
			Thread hiloF3 = new Thread(f3);
			
			hiloPac.start();
			hiloF4.start();
			hiloF1.start();
			hiloF2.start();
			hiloF3.start();
			while(true) {
				
				char nuevaDir = sc.next().toUpperCase().charAt(0);
				pac.cambiarDireccion(nuevaDir);
				borrarMapa1();
				mostrarLaberinto();
				
				
			}
		}
		
		
		
		
		
	}
	
	
	public static void generarLaberinto() {
		for(int i = 1; i<filas;i++) {
			for (int j = 1; j<columnas;j++) {
				matrTab[i][j] = " *"
						+ " ";
				
				
				
			}
			
		}
		
	}
	
	public static void mostrarLaberinto() {
		for(int i =0;i<filas;i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.print(matrTab[i][j]);
			}
			System.out.println();
			
		}
	}
	
	public static void generarLimites() {
		for(int i = 0; i<filas;i++) {
			for (int j = 0; j<columnas;j++) {
				matrTab[0][j] = "___";
				matrTab[i][0] = " | ";
				matrTab[14][j]="───";
				matrTab[i][18] = " | ";
				
			}
			
		}
	}
	
	public static void generarLimitesDentro() {
		for(int i = 0; i<filas;i++) {
			for (int j = 0; j<columnas;j++) {
				matrTab[2][3] = "───";
				matrTab[2][2] = "───";
				matrTab[4][2] = "───";
				matrTab[4][3] = "───";
				matrTab[6][3] = "───";
				matrTab[6][2] = "───";
				matrTab[6][1] = "───";
				matrTab[6][0] = "───";
				
				matrTab[8][3] = "───";
				matrTab[8][2] = "───";
				matrTab[8][1] = "───";
				matrTab[8][0] = "───";
				matrTab[10][2] = "───";
				matrTab[10][3] = "───";
				matrTab[12][2] = "───";
				matrTab[12][3] = "───";
				matrTab[12][4] = "───";
				matrTab[12][6] = "───";
				matrTab[12][7] = "───";
				matrTab[12][3] = "───";
				matrTab[12][9] = " | ";
				matrTab[13][9] = " | ";
				matrTab[12][11] = "───";
				matrTab[12][12] = "───";
				matrTab[12][14] = "───";
				matrTab[12][15] = "───";
				matrTab[12][16] = "───";
				matrTab[10][15] = "───";
				matrTab[10][16] = "───";
				matrTab[8][15] = "───";
				matrTab[8][16] = "───";
				matrTab[8][17] = "───";
				matrTab[6][15] = "───";
				matrTab[6][16] = "───";
				matrTab[6][17] = "───";
				matrTab[4][15] = "───";
				matrTab[4][16] = "───";
				matrTab[2][15] = "───";
				matrTab[2][16] = "───";
				matrTab[3][13] = " | ";
				matrTab[2][13] = " | ";
				matrTab[4][13] = " | ";
				matrTab[5][13] = " | ";
				matrTab[2][12] = "───";
				matrTab[2][11] = "───";
				matrTab[2][9] = " | ";
				matrTab[1][9] = " | ";
				matrTab[2][7] = "───";
				matrTab[2][6] = "───";
				matrTab[2][5] = " | ";
				matrTab[3][5] = " | ";
				matrTab[4][5] = " | ";
				matrTab[5][5] = " | ";
				matrTab[7][5] = " | ";
				matrTab[8][5] = " | ";
				matrTab[9][5] = " | ";
				matrTab[10][5] = " | ";
				matrTab[7][13] = " | ";
				matrTab[8][13] = " | ";
				matrTab[9][13] = " | ";
				matrTab[10][13] = " | ";
				matrTab[10][11] = "───";
				matrTab[10][9] = "───";
				matrTab[10][10] = "───";
				matrTab[10][8] = "───";
				matrTab[10][7] = "───";
				matrTab[8][11] = "───";
				matrTab[8][9] = "───";
				matrTab[8][10] = "───";
				matrTab[8][8] = "───";
				matrTab[8][7] = "───";
				matrTab[7][7] = " | ";
				matrTab[6][7] = "───";
				matrTab[7][11] = " | ";
				matrTab[6][8] = "───";
				matrTab[6][11] = "───";
				matrTab[6][10] = "───";
				matrTab[4][11] = "───";
				matrTab[4][9] = "───";
				matrTab[4][10] = "───";
				matrTab[4][8] = "───";
				matrTab[4][7] = "───";
				matrTab[7][0] = "   ";
				matrTab[7][18] = "   ";
				matrTab[6][18] = "───";
				matrTab[8][18] = "───";
				System.out.println(matrTab[i][j]);
				
			}
			
		}
	}
	
	public static void generarPacman() {
		for(int i = 0; i<filas;i++) {
			for (int j = 0; j<columnas;j++) {
				
				matrTab[9][9] = " P ";
				
				
			}
			
		}
	}



	public static void generarFantasma() {
		
				matrTab[7][9] = " F ";
				matrTab[7][10] = " F ";
				matrTab[7][8] = " F ";
				matrTab[6][9] = " F ";
				
				
				
			
			
		
	}
	
	public static void borrarMapa() {
		
	       
	        for (int i = 0; i < 50; i++) {
	            System.out.println();
	        }
	    
	}
	
	public void actualizarPosicion(int posx , int posy, String valor) {
		matrTab[posx][posy]= valor;
	}
	
	public void cogerPuntos (int posx, int posy) {
		if(!matrTab[posx][posy].equals(" | ") && !matrTab[posx][posy].equals("───"))
			matrTab[posx][posy]="   ";
	}
	
	public void moverFantasma(int posx, int posy) {
		if(!matrTab[posx][posy].equals(" | ") && !matrTab[posx][posy].equals("───"))
			matrTab[posx][posy]=" * ";
	}


	public Semaphore getSemaforo() {
		return semaforo;
	}


	public void setSemaforo(Semaphore semaforo) {
		this.semaforo = semaforo;
	}


	public static int getFilas() {
		return filas;
	}


	public static int getColumnas() {
		return columnas;
	}


	public static String[][] getMatrTab() {
		return matrTab;
	}


	public static void setMatrTab(String[][] matrTab) {
		Tablero.matrTab = matrTab;
	}


	public boolean isSalir() {
		return salir;
	}


	public void setSalir(boolean salir) {
		this.salir = salir;
	}


	public static int getDificultad() {
		return dificultad;
	}


	public static void setDificultad(int dificultad) {
		Tablero.dificultad = dificultad;
	}
	
	public static void borrarMapa1() {
	    try {
	        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public boolean comprobarColision(int x, int y) {
	    return matrTab[x][y].equals(" F "); // Si la posición tiene un fantasma, devuelve true
	}
	
	public boolean comprobarEstrellas() {
		for(int i = 0 ; i<filas;i++) {
			for(int j =0 ; j< columnas; j++) {
				if(matrTab[i][j].equals(" * ")) {
					return true;
				}
			}
		}
		return false;
	}


	
	
	
	
	
	

}
