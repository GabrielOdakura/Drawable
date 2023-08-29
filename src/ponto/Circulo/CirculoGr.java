package ponto.Circulo;

import ponto.Ponto;
import ponto.PontoGr;

import java.awt.*;

public class CirculoGr extends Circulo{

    private String nome;
    private int espessura;
    private Color corAtual = Color.BLUE;

    public CirculoGr(Ponto p, int diametro) {
        super(p, diametro);
    }

    public CirculoGr(int x1, int y1, int x2, int y2, String nome, int espessura, Color corAtual){
        super(x1,y1,x2,y2);
        this.nome = nome;
        this.espessura = espessura;
//        this.corAtual = corAtual;
    }

    public CirculoGr(double x1, double y1, double x2, double y2, String nome, int espessura, Color corAtual){
        super(x1,y1,x2,y2);
        this.nome = nome;
        this.espessura = espessura;
//        this.corAtual = corAtual;
    }

    public void desenharCirculo(Graphics g){
        int xCentral = (int) getPonto1().getX();
        int yCentral = (int) getPonto1().getY();
        double x = (int) getPonto2().getX();
        double y = (int) getPonto2().getY();
        double raio = getRaio();
        int theta;

        for(theta = 0; theta <= 360; theta++) {
            double radiano = Math.toRadians(theta);
            double seno = Math.sin(radiano);
            double cosseno = Math.cos(radiano);
            x = xCentral + cosseno * raio;
            y = yCentral + seno * raio;
            PontoGr circulo = new PontoGr((int) x,(int) y,Color.black, espessura);
            circulo.desenharPonto(g);
        }

/*        PontoGr p1 = new PontoGr((x + xCentral), (y + yCentral), Color.black, espessura);
        p1.desenharPonto(g);
        PontoGr p2 = new PontoGr((x + xCentral), ((-1 * y) + yCentral), Color.black, espessura);
        p2.desenharPonto(g);
        PontoGr p3 = new PontoGr((y + xCentral), (x + yCentral), Color.black, espessura);
        p3.desenharPonto(g);
        PontoGr p4 = new PontoGr(((-1 * y) + xCentral), (x + yCentral), Color.black, espessura);
        p4.desenharPonto(g);

        while(x > y){
            y++;
            if(p <= 0){
                p = p + (2 * y) + 1;
            }else{
                x--;
                p = p + (2 * y) - (2 * x) + 1;
            }

            if(x < y){
                break;
            }

            PontoGr p5 = new PontoGr((x + xCentral), (y + yCentral), corAtual, espessura);
            p5.desenharPonto(g);
            PontoGr p6 = new PontoGr(( (-1 * x) + xCentral), (y + yCentral), corAtual, espessura);
            p6.desenharPonto(g);
            PontoGr p7 = new PontoGr((x + xCentral), ((-1 * y) + yCentral), corAtual, espessura);
            p7.desenharPonto(g);
            PontoGr p8 = new PontoGr(((-1 * x) + xCentral), ((-1 * y) + yCentral), corAtual, espessura);
            p8.desenharPonto(g);

            if( x != y){
                PontoGr p9 = new PontoGr((y + xCentral), (x + yCentral), corAtual, espessura);
                p9.desenharPonto(g);
                PontoGr p10 = new PontoGr(( (-1 * y) + xCentral), (x + yCentral), corAtual, espessura);
                p10.desenharPonto(g);
                PontoGr p11 = new PontoGr((y + xCentral), ((-1 * x) + yCentral), corAtual, espessura);
                p11.desenharPonto(g);
                PontoGr p12 = new PontoGr(((-1 * y) + xCentral), ((-1 * x) + yCentral), corAtual, espessura);
                p12.desenharPonto(g);
            }
        }
    */
    }
}
