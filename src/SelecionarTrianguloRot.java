import javax.swing.*;
import java.awt.*;

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

   public SelecionarTrianguloRot(PainelDesenho me){
       this.areaDesenho = me;
       construirTela2();
   }
   private void construirTela2(){

       Dimension dim = new Dimension(400,230);
       telaRotacionar.setMinimumSize(dim);
       telaRotacionar.setLocation((dim.width / 2) - (100 / 2), (dim.height / 2) + (500 / 2));
       telaRotacionar.setSize(dim);

       telaRotacionar.setResizable(false);

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

       telaRotacionar.setVisible(true);
   }

   public void toggleVisible2(){
       telaRotacionar.setVisible(false);
   }
}
