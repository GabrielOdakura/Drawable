package reta.triangulo;

import java.awt.*;

import reta.RetaGr;

public class TransfTriangulo extends Triangulo{

    int x1 = (int) getPonto1().getX();
    int x2 = (int) getPonto2().getX();
    int x3 = (int) getPonto3().getX();
    int y1 = (int) getPonto1().getY();
    int y2 = (int) getPonto2().getY();
    int y3 = (int) getPonto3().getY();

    //Ponto selecionado pelo Usuário para rotação
    int xT = (int) getPontoT().getX();
    int yT = (int) getPontoT().getY();
    public TransfTriangulo(int x1, int y1, int x2, int y2, int x3, int y3) {
        super(x1, y1, x2, y2, x3, y3);
    }

    public void escalaTriangulo(int x1, int y1, int x2, int y2, int x3, int y3, int Sx, int Sy, Graphics g, String nome, int espessura, Color corAtual) {

        //Ponto selecionado pelo Usuário para escala
        int xT = (int) getPontoT().getX();
        int yT = (int) getPontoT().getY();

        //Novos pontos após o escalonamento
        int x1T = Sx* x1 + (1-Sx)*xT;
        int y1T = Sy* y1 *(1-Sy)*yT;
        
        int x2T = Sx* x2 + (1-Sx)*xT;
        int y2T = Sy* y2 *(1-Sy)*yT;
        
        int x3T = Sx* x3 + (1-Sx)*xT;
        int y3T = Sy* y3 *(1-Sy)*yT;

        TrianguloGr triangulo = new TrianguloGr(x1T,y1T,x2T,y2T,x3T,y3T,nome,espessura,corAtual);
        triangulo.desenharTriangulo(g);
    }
    public void RotacionarTriangulo(int x1, int y1, int x2, int y2, int x3, int y3, double theta, Graphics g, String nome, int espessura, Color corAtual){

        // double theta = valor fornecido pelo usuário
        theta = Math.toRadians(theta);

        int x1T = (int) (xT + (x1 - xT)* Math.cos(theta) - (y1-yT)* Math.sin(theta));
        int y1T = (int) (yT + (x1 - xT)* Math.sin(theta) + (y1-yT)* Math.cos(theta));

        int x2T = (int) (xT + (x2 - xT)* Math.cos(theta) - (y2-yT)* Math.sin(theta));
        int y2T = (int) (yT + (x2 - xT)* Math.sin(theta) + (y2-yT)* Math.cos(theta));

        int x3T = (int) (xT + (x3 - xT)* Math.cos(theta) - (y3-yT)* Math.sin(theta));
        int y3T = (int) (yT + (x3 - xT)* Math.sin(theta) + (y3-yT)* Math.cos(theta));

        TrianguloGr triangulo = new TrianguloGr(x1T,y1T,x2T,y2T,x3T,y3T,nome,espessura,corAtual);
        triangulo.desenharTriangulo(g);
    }
}
