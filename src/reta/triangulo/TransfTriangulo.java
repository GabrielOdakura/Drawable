package reta.triangulo;

import java.awt.Graphics;

import reta.RetaGr;

public class TransfTriangulo {
	
	
	/*public void escalaTriangulo(Graphics g) {
		// Cálculo do ponto central do triangulo
        int xCentral = (int) (getPonto1().getX() + getPonto2().getX() + getPonto3().getX())/3;
        int yCentral = (int) (getPonto1().getY() + getPonto2().getY() + getPonto3().getY())/3;
        int Sx , Sy;
        //Ponto selecionado pelo Usuário para escala
        int xT = getPontoT().getX();
        int yT = getPontoT().getY();
        
        if(xT>xCentral) {
        	Sx = xT/xCentral;
        } else {
        	Sx = xCentral/xT;
        }
        
        if(yT>yCentral) {
        	Sy = yT/yCentral;
        } else {
        	Sy = yCentral/yT;
        }
        //Novos pontos após o escalonamento
        int x1T = Sx* x1 + (1-Sx)*xCentral;
        int y1T = Sy* y1 *(1-Sy)*yCentral;
        
        int x2T = Sx* x2 + (1-Sx)*xCentral;
        int y2T = Sy* y2 *(1-Sy)*yCentral;
        
        int x3T = Sx* x3 + (1-Sx)*xCentral;
        int y3T = Sy* y3 *(1-Sy)*yCentral;
        
        RetaGr reta1 = new RetaGr(x1T, y1T, x2T, y2T, corAtual, nome, espessura);
        RetaGr reta2 = new RetaGr(x2T, y2T, x3T, y3T, corAtual, nome, espessura);
        RetaGr reta3 = new RetaGr(x1T, y1T, x3T, y3T, corAtual, nome, espessura);
        reta1.desenharReta(g);
        reta2.desenharReta(g);
        reta3.desenharReta(g);
    }*/
}
