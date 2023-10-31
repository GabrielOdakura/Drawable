package userInterface;
import armazenador.Armazenador;
import ponto.FiguraPontos;
import reta.triangulo.TransfTriangulo;
import tipoPrimitivo.TipoPrimitivo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SelecionarTrianguloRot {

   private PainelDesenho areaDesenho;
   private JFrame telaRotacionar = new JFrame("Rotacionar Triangulo");
   private JPanel caixa3 = new JPanel();
   private JPanel caixa4 = new JPanel();
   private JLabel nomeTriangulo = new JLabel();
   private JTextArea textoPonto = new JTextArea();
   private JButton jbVoltar = new JButton("◀");
   private JButton jbVai = new JButton("▶");
   private JButton jbRotacao = new JButton("Rotacionar o Triangulo");
   private static final Color corDeFundo = new Color(238,238,238);

    private Color corRoxo = new Color(174,55,255);
    private Armazenador atual;
    private boolean visible = false;
    private boolean pintarSaida = true;
    private int indiceAtual = 0;

   public SelecionarTrianguloRot(PainelDesenho me){
       this.areaDesenho = me;
       construirTela2();
   }
   private void construirTela2(){

       Dimension dim = new Dimension(400,230);
       telaRotacionar.setMinimumSize(dim);
       telaRotacionar.setLocation((dim.width / 2) - (100 / 2), (dim.height / 2) + (500 / 2));
       telaRotacionar.setSize(dim);
       telaRotacionar.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               if(pintarSaida) pintarPontosPadraoTri();
               super.windowClosing(e);
           }
       });

       telaRotacionar.setResizable(false);

       configurarElemento();

       String entradaUser;

       entradaUser = JOptionPane.showInputDialog("Angulo de Rotação: ");

       double i = Float.parseFloat(entradaUser);

       //adicionar elementos no painel (caixa3)
       caixa3.add(nomeTriangulo, BorderLayout.WEST);
       caixa3.add(textoPonto, BorderLayout.CENTER);
       caixa3.add(jbRotacao, BorderLayout.EAST);

       //adicionar botoes ao painel 2 (caixa2)
       caixa4.add(jbVoltar, BorderLayout.WEST);
       caixa4.add(jbVai, BorderLayout.EAST);

       telaRotacionar.add(caixa3, BorderLayout.NORTH);
       telaRotacionar.add(caixa4, BorderLayout.SOUTH);

       //config Area de Texto
       textoPonto.setBackground(corDeFundo);
       textoPonto.setLineWrap(true);
       textoPonto.setEditable(false);

       jbVoltar.setEnabled(false);
       if (areaDesenho.getTamanhoED()<=1) jbVai.setEnabled(false);
       else  jbVai.setEnabled(true);

       jbVai.addActionListener(e ->{
           if(!(areaDesenho.getTamanhoED() == indiceAtual)){
               pintarPontosPadraoTri();
               indiceAtual++;
               configurarElemento();
               pintarPontosTri();
               jbVoltar.setEnabled(true);
           }
           if(areaDesenho.getTamanhoED() - 1 == indiceAtual){
               jbVai.setEnabled(false);
           }
       });

       jbVoltar.addActionListener(e ->{
           pintarPontosPadraoTri();
           indiceAtual--;
           configurarElemento();
           pintarPontosTri();
           jbVai.setEnabled(true);
           if (indiceAtual == 0){
               jbVoltar.setEnabled(false);
           }
       });

       jbRotacao.addActionListener(e ->{
           if(areaDesenho.retrocederVazia()){
               nomeTriangulo.setText("Sem Elementos Restantes");
               textoPonto.setVisible(false);
               pintarSaida = false;
               jbRotacao.setEnabled(false);
               jbRotacao.setVisible(false);
               jbVai.setEnabled(false);
               jbVoltar.setEnabled(false);
           }else {
               if (indiceAtual != 0) {
                   indiceAtual--;
                   if(indiceAtual == 0) {
                       jbVoltar.setEnabled(false);
                       jbVai.setEnabled(false);
                       if(areaDesenho.getTamanhoED() > 1) {
                           jbVai.setEnabled(true);
                       }

                   }
               }
               configurarElemento();
               pintarPontosTri();
               Armazenador temp = areaDesenho.buscarED(indiceAtual);
               TransfTriangulo rotacionar = new TransfTriangulo(areaDesenho.getX1(), areaDesenho.getY1());
               double tetha = Double.parseDouble(entradaUser);
               Armazenador transformado = rotacionar.rotacionarTriangulo(tetha, temp);
               areaDesenho.deletarEspecifico(indiceAtual);
               areaDesenho.inserirED(transformado);
               areaDesenho.redesenharTrianguloTransf(transformado);
           }
       });

       pintarPontosTri();
       telaRotacionar.setVisible(true);
   }

    private void configurarElemento() {
        atual = areaDesenho.buscarED(indiceAtual);
        String caixaDeTexto;
        if(atual.getTipo() == TipoPrimitivo.TRIANGULO){
            nomeTriangulo.setText("Triangulo");
            caixaDeTexto = "Ponto 1 X: " + atual.getPonto1().getX() + "\n" +  "Ponto 1 Y: " + + atual.getPonto1().getY() + "\n"
                    + "Ponto 2 X: " + atual.getPonto2().getX() + "\n" +  "Ponto 2 Y: " + + atual.getPonto2().getY() + "\n"
                    + "Ponto 3 X: " + atual.getPonto3().getX() + "\n" +  "Ponto 3 Y: " + + atual.getPonto3().getY() + "\n";
            textoPonto.setText(caixaDeTexto);
        }
    }

   public void toggleVisible2(){
       telaRotacionar.setVisible(false);
   }

    public void pintarPontosTri(){
        Graphics g = areaDesenho.getGraphics();
        if(atual.getTipo() == TipoPrimitivo.TRIANGULO){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), corRoxo);
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), corRoxo);
            FiguraPontos.desenharPonto(g,(int) atual.getPonto3().getX(),(int) atual.getPonto3().getY(),
                    "", atual.getEspessura(), corRoxo);
        }
    }

    public void pintarPontosPadraoTri(){
        Graphics g = areaDesenho.getGraphics();
        if(atual.getTipo() == TipoPrimitivo.TRIANGULO){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
            FiguraPontos.desenharPonto(g,(int) atual.getPonto3().getX(),(int) atual.getPonto3().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
        }
    }
}
