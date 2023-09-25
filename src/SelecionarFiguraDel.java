import armazenador.Armazenador;
import ponto.FiguraPontos;
import tipoPrimitivo.TipoPrimitivo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SelecionarFiguraDel {

    private PainelDesenho areaDesenho;

    private JFrame telaDeletar = new JFrame("Deletar Primitivo");
    private JPanel caixa = new JPanel();// serve como um armazenado para outros elementos
    private JPanel caixa2 = new JPanel();// serve como um armazenado para outros elementos
    private JLabel nomeElemento = new JLabel();
    private JTextArea textoPontos = new JTextArea();
    private JButton jbRetroceder = new JButton("<--");
    private JButton jbAvancar = new JButton("-->");
    private JButton jbDeletar = new JButton("Deletar Elemento");


    private Color corRoxo = new Color(174,55,255);
    private Armazenador atual;
    private boolean visible = false;
    private boolean pintarSaida = true;
    private int indiceAtual = 0;

    public SelecionarFiguraDel(PainelDesenho em){
        this.areaDesenho = em;
        construirTela();
    }

    private void construirTela(){
        Dimension dim = new Dimension(400,400);
        telaDeletar.setSize(dim);
        telaDeletar.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(pintarSaida) pintarPontosPadrao();
                super.windowClosing(e);
            }
        });

        configurarElemento();

        //adicionar elementos no painel (caixa)
        caixa.add(nomeElemento, BorderLayout.WEST);
        caixa.add(textoPontos, BorderLayout.CENTER);
        caixa.add(jbDeletar, BorderLayout.EAST);

        //adicionar botoes ao painel 2 (caixa2)
        caixa2.add(jbRetroceder, BorderLayout.WEST);
        caixa2.add(jbAvancar,BorderLayout.EAST);


        telaDeletar.add(caixa, BorderLayout.NORTH);
        telaDeletar.add(caixa2, BorderLayout.SOUTH);

        //config Area de Texto
        textoPontos.setLineWrap(true);
        textoPontos.setEditable(false);

        //config Botões
        jbRetroceder.setEnabled(false);
        System.out.println(areaDesenho.getTamanhoED());
        if(areaDesenho.getTamanhoED() <= 1) jbAvancar.setEnabled(false);
        else jbAvancar.setEnabled(true);

        jbAvancar.addActionListener(e ->{
            if(!(areaDesenho.getTamanhoED() == indiceAtual)){
                pintarPontosPadrao();
                indiceAtual++;
                configurarElemento();
                pintarPontos();
                jbRetroceder.setEnabled(true);
            }
            if(areaDesenho.getTamanhoED() - 1 == indiceAtual){
                jbAvancar.setEnabled(false);
            }
        });

        jbRetroceder.addActionListener(e ->{
            pintarPontosPadrao();
            indiceAtual--;
            configurarElemento();
            pintarPontos();
            jbAvancar.setEnabled(true);
            if (indiceAtual == 0){
                jbRetroceder.setEnabled(false);
            }
        });

        jbDeletar.addActionListener(e ->{
            areaDesenho.deletarEspecifico(indiceAtual);
            if(areaDesenho.retrocederVazia()){
                nomeElemento.setText("Sem Elementos Restantes");
                textoPontos.setText("Sem Elementos Restantes");
                pintarSaida = false;
                jbDeletar.setEnabled(false);
                jbAvancar.setEnabled(false);
                jbRetroceder.setEnabled(false);
            }else {
                if (indiceAtual != 0) {
                    indiceAtual--;
                    if(indiceAtual == 0) jbAvancar.setEnabled(false);
                }
                configurarElemento();
                pintarPontos();
            }
        });

        pintarPontos();
        telaDeletar.setVisible(true);
    }

    /** configurarElemento - Configura os elementos graficos para o novo elemento da ED
     *
     */
    private void configurarElemento() {
        atual = areaDesenho.buscarED(indiceAtual);
        String caixaDeTexto;
        if(atual.getTipo() == TipoPrimitivo.PONTO){
            nomeElemento.setText("Ponto");
            caixaDeTexto = "Ponto X: " + atual.getPonto1().getX() + "Ponto Y: " + + atual.getPonto1().getY();
            textoPontos.setText(caixaDeTexto);
        }else if(atual.getTipo() == TipoPrimitivo.RETA){
            nomeElemento.setText("Reta");
            caixaDeTexto = "Ponto 1 X: " + atual.getPonto1().getX() + " Ponto 1 Y: " + + atual.getPonto1().getY() + "\n"
                    + "Ponto 2 X: " + atual.getPonto2().getX() + " Ponto 2 Y: " + + atual.getPonto2().getY();
            textoPontos.setText(caixaDeTexto);
        }else if(atual.getTipo() == TipoPrimitivo.RETANGULO){
            nomeElemento.setText("Retangulo");
            caixaDeTexto = "Ponto 1 X: " + atual.getPonto1().getX() + " Ponto 1 Y: " + + atual.getPonto1().getY() + "\n"
                    + "Ponto 2 X: " + atual.getPonto2().getX() + " Ponto 2 Y: " + + atual.getPonto2().getY() + "\n"
                    + "Ponto 3 X: " + atual.getPonto1().getX() + " Ponto 3 Y: " + + atual.getPonto2().getY() + "\n"
                    + "Ponto 4 X: " + atual.getPonto2().getX() + " Ponto 4 Y: " + + atual.getPonto1().getY() + "\n";
            textoPontos.setText(caixaDeTexto);
        }else if(atual.getTipo() == TipoPrimitivo.TRIANGULO){
            nomeElemento.setText("Triangulo");
            caixaDeTexto = "Ponto 1 X: " + atual.getPonto1().getX() + " Ponto 1 Y: " + + atual.getPonto1().getY() + "\n"
                    + "Ponto 2 X: " + atual.getPonto2().getX() + " Ponto 2 Y: " + + atual.getPonto2().getY() + "\n"
                    + "Ponto 3 X: " + atual.getPonto3().getX() + " Ponto 3 Y: " + + atual.getPonto3().getY() + "\n";
            textoPontos.setText(caixaDeTexto);
        }else if(atual.getTipo() == TipoPrimitivo.CIRCULO){
            nomeElemento.setText("Circulo");
            caixaDeTexto = "Ponto 1 X: " + atual.getPonto1().getX() + " Ponto 1 Y: " + + atual.getPonto1().getY() + "\n"
                    + "Ponto 2 X: " + atual.getPonto2().getX() + " Ponto 2 Y: " + + atual.getPonto2().getY();
            textoPontos.setText(caixaDeTexto);
        }else if(atual.getTipo() == TipoPrimitivo.MANDALA){
            nomeElemento.setText("Mandala");
            caixaDeTexto = "Ponto 1 X: " + atual.getPonto1().getX() + " Ponto 1 Y: " + + atual.getPonto1().getY() + "\n"
                    + "Ponto 2 X: " + atual.getPonto2().getX() + " Ponto 2 Y: " + + atual.getPonto2().getY();
            textoPontos.setText(caixaDeTexto);
        }
    }

    public void toggleVisible(){
        if(visible) visible = false;
        else visible = true;
        telaDeletar.setVisible(visible);
    }

    public void pintarPontos(){
        Graphics g = areaDesenho.getGraphics();
        if(atual.getTipo() == TipoPrimitivo.PONTO){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), corRoxo);
        }else if(atual.getTipo() == TipoPrimitivo.RETA){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), corRoxo);
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), corRoxo);
        }else if(atual.getTipo() == TipoPrimitivo.RETANGULO){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), corRoxo);
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), corRoxo);
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), corRoxo);
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), corRoxo);
        }else if(atual.getTipo() == TipoPrimitivo.TRIANGULO){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), corRoxo);
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), corRoxo);
            FiguraPontos.desenharPonto(g,(int) atual.getPonto3().getX(),(int) atual.getPonto3().getY(),
                    "", atual.getEspessura(), corRoxo);
        }else if(atual.getTipo() == TipoPrimitivo.CIRCULO){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), corRoxo);
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), corRoxo);
        }else if(atual.getTipo() == TipoPrimitivo.MANDALA){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), corRoxo);
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), corRoxo);
        }
    }

    public void pintarPontosPadrao(){
        Graphics g = areaDesenho.getGraphics();
        if(atual.getTipo() == TipoPrimitivo.PONTO){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
        }else if(atual.getTipo() == TipoPrimitivo.RETA){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
        }else if(atual.getTipo() == TipoPrimitivo.RETANGULO){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
        }else if(atual.getTipo() == TipoPrimitivo.TRIANGULO){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
            FiguraPontos.desenharPonto(g,(int) atual.getPonto3().getX(),(int) atual.getPonto3().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
        }else if(atual.getTipo() == TipoPrimitivo.CIRCULO){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
        }else if(atual.getTipo() == TipoPrimitivo.MANDALA){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
        }
    }

    public void fecharJanela(){

    }


}
