package ponto.Circulo;

import ponto.Ponto;
import ponto.PontoGr;

import java.awt.*;

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
        double xBorda = (int) getPonto2().getX();
        double yBorda = (int) getPonto2().getY();
        double raio = getRaio();
        int theta;

        for(theta = 0; theta <= 360; theta++) {
            double radiano = Math.toRadians(theta);
            double seno = Math.sin(radiano);
            double cosseno = Math.cos(radiano);
            xBorda = xCentral + cosseno * raio;
            yBorda = yCentral + seno * raio;
            PontoGr circulo = new PontoGr((int) xBorda,(int) yBorda, corAtual, espessura);
            circulo.desenharPonto(g);
        }
    }
}
