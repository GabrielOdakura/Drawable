/**
 * Desenha uma mandala na tela
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20230810
 */
package Mandala;


import java.awt.*;

public class FiguraMandalas {

    /**
     * Desenha uma mandala de acordo com os pontos p1 e p2
     *
     * @param g biblioteca para desenhar o primitivo grafico
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     * @param nome nome da reta
     * @param espessura espessura da reta
     * @param corAtual cor da reta
     */

    public static void desenharMandala(Graphics g, int x1, int y1, int x2, int y2, String nome, int espessura, Color corAtual){
        MandalaGr mandala = new MandalaGr(x1, y1, x2, y2, nome, espessura, corAtual);
        mandala.desenharMandala(g);
    }
}
