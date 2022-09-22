/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author ROGA11
 */
public class Elementos extends JPanel {

    Color Snake = Color.BLACK;
    Color Food = Color.RED;

    int TamañoPanel;
    int Tamaño;
    int cuadros;
    int residuo;

    coordenadas serpiente[] = new coordenadas[10];
    coordenadas ultimo[];
    int comida[]= new int[2];
    String direccion = "right";

    public Elementos(int TamañoPanel, int cuadros) {
        this.TamañoPanel = TamañoPanel;
        this.cuadros = cuadros;
        this.Tamaño = TamañoPanel / cuadros;
        this.residuo = TamañoPanel % cuadros;
        int posicion[] = {cuadros / 2 - 1, cuadros / 2 - 1};
        serpiente[0] = new coordenadas(posicion[0], posicion[1]);
        comida();

    }

    public  int obtenerposicion() {
        int i;
        for (i = 0; i < serpiente.length; i++) {
            if (serpiente[i] == null) {
                break;
            }
        }
        return i;
    }

    @Override
    public void paint(Graphics g) {
        int i;
        super.paint(g);
        g.setColor(Snake);
        for (i = 0; i < serpiente.length; i++) {
            while (serpiente[i] != null) {
                g.fillRect(serpiente[i].getX() * Tamaño, serpiente[i].getY() * Tamaño, Tamaño - 1, Tamaño - 1);
                break;
            }
        }
        g.setColor(Food);
         g.fillRect(comida[0] * Tamaño, comida[1] * Tamaño, Tamaño - 1, Tamaño - 1);
    }

    public void mover() {
        if (serpiente[obtenerposicion()] == null && serpiente[obtenerposicion() - 1] != null) {
            ultimo[0] = serpiente[obtenerposicion() - 1];

            int agregarx = 0;
            int agregary = 0;

            switch (direccion) {
                case "right":
                    agregarx = 1;
                    break;
                case "left":
                    agregarx = -1;
                    break;
                case "up":
                    agregary = -1;
                    break;
                case "down":
                    agregary = 1;
                    break;
            }
            int nuevo[] = {ultimo[0].getX() + agregarx, ultimo[0].getY() + agregary};
            
            serpiente[0]= new coordenadas(nuevo[0],nuevo[1]);
            eliminar(0);
        }
    }
    public void eliminar(int cabeza){
        for(int i=cabeza;i<serpiente.length;i++){
            serpiente[i]=serpiente[i+1];
        }
        
    }

    public void comida() {
        boolean ocupado = false;
        int x = (int) (Math.random() * cuadros);
        int y = (int) (Math.random() * cuadros);
        for (int i = 0; i < serpiente.length; i++) {
            while(serpiente[i]!=null){
            if (serpiente[i].getX() == x && serpiente[i].getY() == y) {
                ocupado = true;
                comida();
               
            }
             break;
            }
            if (!ocupado) {
                this.comida[0] = x;
                this.comida[1] = y;
            }
        }
    }
}
