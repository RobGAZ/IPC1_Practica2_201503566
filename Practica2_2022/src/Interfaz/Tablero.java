package Interfaz;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ROGA11
 */
public class Tablero extends JPanel {

    Color Backgroud = Color.green;

    int TamañoPanel;
    int Tamaño;
    int cuadros;
    

    public Tablero(int TamañoPanel, int cuadros) {
        this.TamañoPanel = TamañoPanel;
        this.cuadros = cuadros;
        this.Tamaño = TamañoPanel / cuadros;
      

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Backgroud);
        for (int i = 0; i < cuadros; i++) {
            for (int j = 0; j < cuadros; j++) {
                g.fillRect(i * Tamaño, j * Tamaño, Tamaño - 1, Tamaño - 1);
            }
        }

    }
}
