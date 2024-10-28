package reta.triangulo;

import java.awt.*;

import userInterface.*;
import armazenador.Armazenador;
import reta.RetaGr;
import tipoPrimitivo.TipoPrimitivo;

/**
 * Contem metodos para a modificação de tringulos.
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20231031
 */
public class TransfTriangulo {

    private Armazenador atual;

    //Ponto selecionado pelo Usuário para rotação
    int xT;
    int yT;
    public TransfTriangulo(int xT, int yT) {
    	this.xT = xT;
    	this.yT = yT;
    }

    public Armazenador escalaTriangulo(Armazenador arm, double Sx, double Sy) {

        double x1 = arm.getPonto1().getX();
        double x2 = arm.getPonto2().getX();
        double x3 = arm.getPonto3().getX();
        double y1 = arm.getPonto1().getY();
        double y2 = arm.getPonto2().getY();
        double y3 = arm.getPonto3().getY();

        //Novos pontos após o escalonamento
        int x1T = (int) (Sx * x1 + (1 - Sx) * xT);
        int y1T = (int) (Sy * y1 + (1 - Sy) * yT);
        
        int x2T = (int) (Sx * x2 + (1 - Sx) * xT);
        int y2T = (int) (Sy * y2 + (1 - Sy) * yT);
        
        int x3T = (int) (Sx * x3 + (1 - Sx) * xT);
        int y3T = (int) (Sy * y3 + (1 - Sy) * yT);

        return new Armazenador(x1T,y1T,x2T,y2T,x3T,y3T,TipoPrimitivo.TRIANGULO,arm.getEspessura(),arm.getCorFigura());
    }
    public Armazenador rotacionarTriangulo(double theta, Armazenador arm){
    
    	double x1 = arm.getPonto1().getX();
    	double x2 = arm.getPonto2().getX();
    	double x3 = arm.getPonto3().getX();
    	double y1 = arm.getPonto1().getY();
    	double y2 = arm.getPonto2().getY();
    	double y3 = arm.getPonto3().getY();
    	
        theta = Math.toRadians(theta);

        int x1T = (int) (xT + (x1 - xT) * Math.cos(theta) - (y1-yT)* Math.sin(theta));
        int y1T = (int) (yT + (x1 - xT) * Math.sin(theta) + (y1-yT)* Math.cos(theta));

        int x2T = (int) (xT + (x2 - xT) * Math.cos(theta) - (y2-yT)* Math.sin(theta));
        int y2T = (int) (yT + (x2 - xT) * Math.sin(theta) + (y2-yT)* Math.cos(theta));

        int x3T = (int) (xT + (x3 - xT) * Math.cos(theta) - (y3-yT)* Math.sin(theta));
        int y3T = (int) (yT + (x3 - xT) * Math.sin(theta) + (y3-yT)* Math.cos(theta));

        return new Armazenador(x1T,y1T,x2T,y2T,x3T,y3T,TipoPrimitivo.TRIANGULO,arm.getEspessura(),arm.getCorFigura());
        
    }
}
