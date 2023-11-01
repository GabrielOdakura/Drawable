/**
 * Implementação da classe Circulo Gráfico
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20230905
 */
package ponto.Circulo;

import ponto.Ponto;
import ponto.PontoGr;

import java.awt.*;

/**
 * Implementacao da classe Circulo grafico.
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20231031
 */
public class CirculoGr extends Circulo{

    private String nome;
    private int espessura;
    private Color corAtual;

    // Construtores
    /**
     * CirculoGr - Constroi uma circulo grafico
     *
     * @param p int. Coordenada ponto inicial
     * @param diametro int. Diametro da circunferencia
     */
    public CirculoGr(Ponto p, int diametro) {
        super(p, diametro);
    }

    /**
     * CirculoGr - Constroi um circulo grafico
     *
     * @param x1 int. Coordenada xCentral
     * @param y1 int. Coordenada yCentral
     * @param x2 int. Coordenada xBorda
     * @param y2 int. Coordenada yBorda
     * @param cor Color. Cor do circulo
     * @param nome String. Nome do circulo
     * @param esp int. Espessura do circulo
     */
    public CirculoGr(int x1, int y1, int x2, int y2, String nome, int espessura, Color corAtual){
        super(x1,y1,x2,y2);
        this.nome = nome;
        this.espessura = espessura;
        this.corAtual = corAtual;
    }

    /**
     * CirculoGr - Constroi um circulo grafico
     *
     * @param x1 int. Coordenada xCentral
     * @param y1 int. Coordenada yCentral
     * @param x2 int. Coordenada xBorda
     * @param y2 int. Coordenada yBorda
     * @param cor Color. Cor do circulo
     * @param nome String. Nome do circulo
     * @param esp int. Espessura do circulo
     */
    public CirculoGr(double x1, double y1, double x2, double y2, String nome, int espessura, Color corAtual){
        super(x1,y1,x2,y2);
        this.nome = nome;
        this.espessura = espessura;
        this.corAtual = corAtual;
    }

    /**
     * Desenha circulo grafico com base nas equaçoes
     * xBorda = xCentral + cosseno * raio
     * yBorda = yCentral + seno * raio
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    public void desenharCirculo(Graphics g){
        int xCentral = (int) getPonto1().getX();
        int yCentral = (int) getPonto1().getY();
        double x = getPonto2().getX();
        double y = getPonto2().getY();
        double raio = getRaio();

        x = raio;
        y = 0;

        // Raio = 0: Apenas um ponto é pintado.
        PontoGr p1 = new PontoGr((int) (x + xCentral), (int) (y + yCentral),corAtual, espessura);
        p1.desenharPonto(g);

        if (raio > 0) {
            PontoGr p2 = new PontoGr((int) (x + xCentral), (int) (-y + yCentral),corAtual, espessura);
            p2.desenharPonto(g);

            PontoGr p3 = new PontoGr((int) (y + xCentral), (int) (x + yCentral), corAtual, espessura);
            p3.desenharPonto(g);

            PontoGr p4 = new PontoGr((int) (-y + xCentral), (int) (x + yCentral),corAtual, espessura);
            p4.desenharPonto(g);

            int P = (int) (1 - raio);
            while (x > y) {

                y++;

                // Midpoint dentro ou no perímetro
                if (P <= 0)
                    P = (int) (P + 2 * y + 1);

                    // Mid-point fora do perímetro
                else {
                    x--;
                    P = (int) (P + 2 * y - 2 * x + 1);
                }

                // Pontos do perimetro definidos
                if (x < y)
                    break;

                PontoGr p5 = new PontoGr((int) (x + xCentral), (int) (y + yCentral), corAtual, espessura);
                p5.desenharPonto(g);

                PontoGr p6 = new PontoGr((int) (-x + xCentral), (int) (y + yCentral),corAtual, espessura);
                p6.desenharPonto(g);

                PontoGr p7 = new PontoGr((int) (x + xCentral), (int) (-y + yCentral),corAtual, espessura);
                p7.desenharPonto(g);

                PontoGr p8 = new PontoGr((int) (-x + xCentral), (int) (-y + yCentral),corAtual, espessura);
                p8.desenharPonto(g);

                if (x != y) {

                    PontoGr p9 = new PontoGr((int) (y + xCentral), (int) (x + yCentral),corAtual, espessura);
                    p9.desenharPonto(g);

                    PontoGr p10 = new PontoGr((int) (-y + xCentral), (int) (x + yCentral),corAtual, espessura);
                    p10.desenharPonto(g);

                    PontoGr p11 = new PontoGr((int) (y + xCentral), (int) (-x + yCentral),corAtual, espessura);
                    p11.desenharPonto(g);

                    PontoGr p12 = new PontoGr((int) (-y + xCentral), (int) (-x + yCentral),corAtual, espessura);
                    p12.desenharPonto(g);

                }
            }
        }
    }
}
