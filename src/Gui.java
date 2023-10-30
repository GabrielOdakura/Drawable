import ponto.FiguraPontos;
import tipoPrimitivo.TipoPrimitivo;

import java.awt.*;


import javax.swing.*;
//import javax.swing.JPopupMenu;

@SuppressWarnings("serial")
/**
 * Cria a interface com o usuario (GUI)
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura, Julio Arakaki
 * @version 20230905
 */
class Gui extends JFrame {
    // Tipo Atual de primitivo
    private TipoPrimitivo tipoAtual = TipoPrimitivo.PONTO;

    // Cor atual
    private Color corAtual = Color.BLACK;

    // Espessura atual do primitivo
    private int espAtual = 3;

    // Componentes de GUI
    // barra de menu (inserir componente)
    private JToolBar barraComandos = new JToolBar();

    // Mensagens
    private JLabel msg = new JLabel("Msg: ");

    // Painel de desenho
    private PainelDesenho areaDesenho = new PainelDesenho(msg, tipoAtual, corAtual, 10);

    // Painel de Deletar
    private SelecionarFiguraDel deletar;

    //Painel de Rotação
    private SelecionarTrianguloRot rotacao;

    private SelecionarEscala escala;

    // Botoes
    private JButton jbDesfazer = new JButton("↩");
    private JButton jbRefazer = new JButton("↪");
    private JButton jbRedesenhar = new JButton("↻");
    private JButton jbPonto = new JButton("°");
    private JButton jbReta = new JButton("——");
    private JButton jbRetangulo = new JButton("□");
    private JButton jbTriangulo = new JButton("△");
    private JButton jbCirculo = new JButton("◯");
    private JButton jbMandala = new JButton("Mandala");  
    private JButton jbLimpar = new JButton("Limpar");
    private JButton jbOpcoes = new JButton("Opções");
    private JButton jbCor = new JButton("Cor");
    private JButton jbSair = new JButton("Sair");

    // Entrada (slider) para definir espessura dos primitivos
    private JLabel jlEsp = new JLabel("   Espessura: " + String.format("%-5s", 3));
    private JSlider jsEsp = new JSlider(3, 50, 3);
    
    // Itens relacionados ao menuPopup
    private JMenuItem limpezaTotal = new JMenuItem("Limpar Tudo");
    private JMenuItem limparTela = new JMenuItem("Limpar Tela");
    private JMenuItem limparED = new JMenuItem("Limpar Estrutura de Dados");
    private JMenuItem fecharLimpar = new JMenuItem("Cancelar");
    private JPopupMenu popupMenu = new JPopupMenu();
    
    // Itens Relacionados ao OpçõesPopUp
    private JMenuItem salvarDesenho = new JMenuItem("Salvar Desenho");
    private JMenuItem carregarDesenho = new JMenuItem("Carregar Desenho");
    private JMenuItem deletarDesenho = new JMenuItem("Deletar do Desenho");
    private JMenuItem rotacionarTriangulo = new JMenuItem("Rotacionar Triangulo");
    private JMenuItem escalaDesenho = new JMenuItem("Escalonamento do Desenho");
    private JMenuItem fecharPopUp = new JMenuItem("Cancelar");
    private JPopupMenu popupOpcoes = new JPopupMenu();

    /**
     * Constroi a GUI
     *
     * @param larg largura da janela
     * @param alt altura da janela
     */
    public Gui(int larg, int alt) {
        /**
         * Definicoes de janela
         */
        super("Testa Primitivos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(larg, alt);
        setVisible(true);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width / 2) - (larg / 2), (dim.height / 2) - (alt / 2));
        
        // PopUp de Confirmação
        popupMenu.setVisible(false);
        popupMenu.setEnabled(false);
        popupMenu.setLocation((dim.width / 2) - (100 / 2), (dim.height / 2) - (50 / 2));
        popupMenu.setBorder(BorderFactory.createLineBorder(Color.black));
        
        // PopUp de Opções
        popupOpcoes.setVisible(false);
        popupOpcoes.setEnabled(false);
        popupOpcoes.setLocation((dim.width / 2) - (50 / 2), (dim.height / 2) - (25 / 2));
        popupOpcoes.setBorder(BorderFactory.createLineBorder(Color.black));

        // Adicionando os componentes
        barraComandos.add(jbDesfazer);
        barraComandos.add(jbRefazer);
        barraComandos.add(jbRedesenhar);
        barraComandos.add(jbPonto);
        barraComandos.add(jbReta);
        barraComandos.add(jbRetangulo);
        barraComandos.add(jbTriangulo);
        barraComandos.add(jbCirculo);
        barraComandos.add(jbMandala);        
        barraComandos.add(jbCor); 		// Botao de Cores
        barraComandos.add(jbLimpar); 	// Botao de Limpar
        barraComandos.add(jbOpcoes); 	// Botao com Opcoes do Programa
        barraComandos.add(jlEsp); 		// Label para espessura
        barraComandos.add(jsEsp);    	// Slider para espacamento
        areaDesenho.setEsp(espAtual);	// Define a espessura inicial
        barraComandos.add(jbSair); 		// Botao de Cores

        barraComandos.setFloatable(false);//faz a barra nao poder ser mais arrastada

        // Área do PopUp
        popupMenu.add(limpezaTotal);
        popupMenu.add(limparTela);
        popupMenu.add(limparED);
        popupMenu.add(fecharLimpar);
        this.add(popupMenu);
        
        // Área do PopUpOpçoes
        popupOpcoes.add(salvarDesenho);
        popupOpcoes.add(carregarDesenho);
        popupOpcoes.add(deletarDesenho);
        popupOpcoes.add(rotacionarTriangulo);
        popupOpcoes.add(escalaDesenho);
        popupOpcoes.add(fecharPopUp);
        this.add(popupOpcoes);

        // adiciona os componentes com os respectivos layouts
        add(barraComandos, BorderLayout.NORTH);                
        add(areaDesenho, BorderLayout.CENTER);                
        add(msg, BorderLayout.SOUTH);
        
        // Adiciona "tratador" ("ouvidor") de eventos para 
        // cada componente
        jbPonto.addActionListener(e -> {
        	
        	//Texto (Hover)
        	jbPonto.setToolTipText("Ponto");
        	
        	popupMenu.setVisible(false);
            popupOpcoes.setVisible(false);
            tipoAtual = TipoPrimitivo.PONTO;
            areaDesenho.setTipo(tipoAtual);
            if(deletar != null) {
            	deletar.toggleVisible();
            }
            if(rotacao != null) {
                rotacao.toggleVisible2();
            }
            if(escala != null) {
                escala.toggleVisible3();
            }
        });                             
        jbReta.addActionListener(e -> {
        	
        	//Texto (Hover)
        	jbReta.setToolTipText("Reta");
        	
        	popupMenu.setVisible(false);
            popupOpcoes.setVisible(false);
            tipoAtual = TipoPrimitivo.RETA;
            areaDesenho.setTipo(tipoAtual);
            if(deletar != null) {
            	deletar.toggleVisible();
            }
            if(rotacao != null) {
                rotacao.toggleVisible2();
            }
            if(escala != null) {
                escala.toggleVisible3();
            }
        });
        jbRetangulo.addActionListener(e -> {
        	
        	//Texto (Hover)
        	jbRetangulo.setToolTipText("Retangulo");
        	
        	popupMenu.setVisible(false);
            popupOpcoes.setVisible(false);
            tipoAtual = TipoPrimitivo.RETANGULO;
            areaDesenho.setTipo(tipoAtual);
            if(deletar != null) {
            	deletar.toggleVisible();
            }
            if(rotacao != null) {
                rotacao.toggleVisible2();
            }
            if(escala != null) {
                escala.toggleVisible3();
            }
        });
        jbTriangulo.addActionListener(e -> {
        	
        	//Texto (Hover)
        	jbTriangulo.setToolTipText("Triangulo");
        	
        	popupMenu.setVisible(false);
            popupOpcoes.setVisible(false);
            tipoAtual = TipoPrimitivo.TRIANGULO;
            areaDesenho.setTipo(tipoAtual);
            if(deletar != null) {
            	deletar.toggleVisible();
            }
            if(rotacao != null) {
                rotacao.toggleVisible2();
            }
            if(escala != null) {
                escala.toggleVisible3();
            }
        });
        jbCirculo.addActionListener(e -> {
        	
        	//Texto (Hover)
        	jbCirculo.setToolTipText("Circulo");
        	
        	popupMenu.setVisible(false);
            popupOpcoes.setVisible(false);
            tipoAtual = TipoPrimitivo.CIRCULO;
            areaDesenho.setTipo(tipoAtual);
            if(deletar != null) {
            	deletar.toggleVisible();
            }
            if(rotacao != null) {
                rotacao.toggleVisible2();
            }
            if(escala != null) {
                escala.toggleVisible3();
            }
        });
        jbMandala.addActionListener(e ->{
        	
        	//Texto (Hover)
        	jbMandala.setToolTipText("Desenhar Mandala");
        	
        	popupMenu.setVisible(false);
        	popupOpcoes.setVisible(false);
            tipoAtual = TipoPrimitivo.MANDALA;
            areaDesenho.setPrimeiraCorMandala(JColorChooser.showDialog(null, "Escolha a cor das retas", msg.getForeground()));
            areaDesenho.setSegundaCorMandala(JColorChooser.showDialog(null, "Escolha a cor dos circulos", msg.getForeground()));
            areaDesenho.setTipo(tipoAtual);
            if(deletar != null) {
            	deletar.toggleVisible();
            }
            if(rotacao != null) {
                rotacao.toggleVisible2();
            }
            if(escala != null) {
                escala.toggleVisible3();
            }
        });
        jbRedesenhar.addActionListener(e ->{
        	
        	//Texto (Hover)
        	jbRedesenhar.setToolTipText("Redesenhar o Desenho");
        	
        	popupMenu.setVisible(false);
        	popupOpcoes.setVisible(false);
            areaDesenho.redesenharED();
            if(deletar != null) {
            	deletar.toggleVisible();
            }
            if(escala != null) {
                escala.toggleVisible3();
            }
        });
        jbLimpar.addActionListener(e -> {
            popupMenu.setVisible(true);
            popupMenu.setEnabled(true);
            popupOpcoes.setVisible(false);
            
            //Texto (Hover)
            limpezaTotal.setToolTipText("Limpar a Tela e Armazenador de Figuras");
            limparTela.setToolTipText("Limpar apenas a Tela");
            limparED.setToolTipText("Limpar Armazenador de Figuras");
            fecharLimpar.setToolTipText("Fechar o Popup");
            
            limpezaTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            	public void mouseEntered(java.awt.event.MouseEvent evt) {
            		limpezaTotal.setBackground(Color.lightGray);
            	}
            	
            	public void mouseExited(java.awt.event.MouseEvent evt) {
            		limpezaTotal.setBackground(UIManager.getColor(new Color(238,238,238)));
                }
            });
            
            limparTela.addMouseListener(new java.awt.event.MouseAdapter() {
            	public void mouseEntered(java.awt.event.MouseEvent evt) {
            		limparTela.setBackground(Color.lightGray);
            	}
            	
            	public void mouseExited(java.awt.event.MouseEvent evt) {
            		limparTela.setBackground(UIManager.getColor(new Color(238,238,238)));
                }
            });
            
            limparED.addMouseListener(new java.awt.event.MouseAdapter() {
            	public void mouseEntered(java.awt.event.MouseEvent evt) {
            		limparED.setBackground(Color.lightGray);
            	}
            	
            	public void mouseExited(java.awt.event.MouseEvent evt) {
            		limparED.setBackground(UIManager.getColor(new Color(238,238,238)));
                }
            });
            
            fecharLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            	
            	public void mouseEntered(java.awt.event.MouseEvent evt) {
            		fecharLimpar.setBackground(Color.lightGray);
            	}
            	
            	public void mouseExited(java.awt.event.MouseEvent evt) {
            		fecharLimpar.setBackground(UIManager.getColor(new Color(238,238,238)));
                }
            	            	
            });
            
            limpezaTotal.addActionListener(i -> {
            	areaDesenho.removeAll();
                jsEsp.setValue(1); // inicia slider (necessario para limpar ultimo primitivo da tela)
                //repaint();
                jsEsp.setValue(3);
                areaDesenho.limparTela();
            	areaDesenho.limparED();
                popupMenu.setVisible(false);
                popupOpcoes.setVisible(false);
            });
            limparTela.addActionListener(i -> {
                areaDesenho.removeAll();
                jsEsp.setValue(1); // inicia slider (necessario para limpar ultimo primitivo da tela)
                //repaint();
                jsEsp.setValue(3);
                areaDesenho.limparTela();
                popupMenu.setVisible(false);
            });
            limparED.addActionListener(i ->{
                areaDesenho.limparED();
                popupMenu.setVisible(false);
            });
            fecharLimpar.setBackground(UIManager.getColor(new Color(238,238,238)));
            fecharLimpar.addActionListener(i ->{
                popupMenu.setVisible(false);
            });
            if(deletar != null) {
            	deletar.toggleVisible();
            }
            if(rotacao != null) {
                rotacao.toggleVisible2();
            }
            if(escala != null) {
                escala.toggleVisible3();
            }
        });   
        
        jbOpcoes.addActionListener(e -> {
        	popupOpcoes.setVisible(true);
            popupOpcoes.setEnabled(true);
            popupMenu.setVisible(false);
            
            //Texto (Hover)
            salvarDesenho.setToolTipText("Salvar Desenho em um Arquivo");
            carregarDesenho.setToolTipText("Ler o Desenho de um Arquivo");
            deletarDesenho.setToolTipText("Deletar Elemento do Desenho");
            escalaDesenho.setToolTipText("Escalonar do Desenho");
            fecharPopUp.setToolTipText("Fechar o Popup");
            
            salvarDesenho.addMouseListener(new java.awt.event.MouseAdapter() {
            	public void mouseEntered(java.awt.event.MouseEvent evt) {
            		salvarDesenho.setBackground(Color.lightGray);
            	}
            	
            	public void mouseExited(java.awt.event.MouseEvent evt) {
            		salvarDesenho.setBackground(UIManager.getColor(new Color(238,238,238)));
                }
            });

            carregarDesenho.addMouseListener(new java.awt.event.MouseAdapter() {
            	public void mouseEntered(java.awt.event.MouseEvent evt) {
            		carregarDesenho.setBackground(Color.lightGray);
            	}
            	
            	public void mouseExited(java.awt.event.MouseEvent evt) {
            		carregarDesenho.setBackground(UIManager.getColor(new Color(238,238,238)));
                }
            });
            
            deletarDesenho.addMouseListener(new java.awt.event.MouseAdapter() {
            	public void mouseEntered(java.awt.event.MouseEvent evt) {
            		deletarDesenho.setBackground(Color.lightGray);
            	}
            	
            	public void mouseExited(java.awt.event.MouseEvent evt) {
            		deletarDesenho.setBackground(UIManager.getColor(new Color(238,238,238)));
                }
            });

            rotacionarTriangulo.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    rotacionarTriangulo.setBackground(Color.lightGray);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    rotacionarTriangulo.setBackground(UIManager.getColor(new Color(238,238,238)));
                }
            });
            escalaDesenho.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    escalaDesenho.setBackground(Color.lightGray);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    escalaDesenho.setBackground(UIManager.getColor(new Color(238,238,238)));
                }
            });
            fecharPopUp.addMouseListener(new java.awt.event.MouseAdapter() {
            	public void mouseEntered(java.awt.event.MouseEvent evt) {
            		fecharPopUp.setBackground(Color.lightGray);
            	}
            	
            	public void mouseExited(java.awt.event.MouseEvent evt) {
            		fecharPopUp.setBackground(UIManager.getColor(new Color(238,238,238)));
                }
            });

            salvarDesenho.addActionListener(b ->{
                popupOpcoes.setVisible(false);
                areaDesenho.writeJSON();
            });

            carregarDesenho.addActionListener(c ->{
                popupOpcoes.setVisible(false);
                areaDesenho.readJSON();
            });
                                  
            deletarDesenho.addActionListener(j -> {
            	if(!areaDesenho.retrocederVazia())
            		deletar = new SelecionarFiguraDel(areaDesenho);
            	popupOpcoes.setVisible(false);
            });

            rotacionarTriangulo.addActionListener(j -> {
                popupOpcoes.setVisible(false);
                if(!areaDesenho.retrocederVazia())
                    rotacao = new SelecionarTrianguloRot(areaDesenho);
            });

            escalaDesenho.addActionListener(j -> {
                popupOpcoes.setVisible(false);
                if(!areaDesenho.retrocederVazia())
                    escala = new SelecionarEscala(areaDesenho);
            });
            
            fecharPopUp.setBackground(UIManager.getColor(new Color(238,238,238)));
            fecharPopUp.addActionListener(j ->{
                popupOpcoes.setVisible(false);
            });

            if(deletar != null) {
                deletar.toggleVisible();
            }
            if(rotacao != null) {
                rotacao.toggleVisible2();
            }
            if(escala != null) {
                escala.toggleVisible3();
            }
            
        });
                        
        jbDesfazer.addActionListener(i -> {
        	
        	//Texto (Hover)
        	jbDesfazer.setToolTipText("Desfazer");
        	
        	popupMenu.setVisible(false);
        	popupOpcoes.setVisible(false);
        	if(!areaDesenho.retrocederVazia())
        	areaDesenho.retroceder();
        	if(deletar != null) {
            	deletar.toggleVisible();
            }
            if(rotacao != null) {
                rotacao.toggleVisible2();
            }
            if(escala != null) {
                escala.toggleVisible3();
            }
        });
        jbRefazer.addActionListener(i -> {
        	
        	//Texto (Hover)
        	jbRefazer.setToolTipText("Refazer");
        	
        	popupMenu.setVisible(false);
        	popupOpcoes.setVisible(false);
        	if(!areaDesenho.recuperarVazia())
        	areaDesenho.recuperar();
        	if(deletar != null) {
            	deletar.toggleVisible();
            }
            if(rotacao != null) {
                rotacao.toggleVisible2();
            }
            if(escala != null) {
                escala.toggleVisible3();
            }
        });
        jbCor.addActionListener(e -> {
        	
        	//Texto (Hover)
        	jbCor.setToolTipText("Escolha de Cor");
        	
        	popupMenu.setVisible(false);
            popupOpcoes.setVisible(false);
            Color c = JColorChooser.showDialog(null, "Escolha uma cor", msg.getForeground()); 
            if (c != null){ 
                corAtual = c; // pega do chooserColor 
            }
            areaDesenho.setCorAtual(corAtual); // cor atual           
        });  
        jsEsp.addChangeListener(e -> {
            espAtual = jsEsp.getValue();
            jlEsp.setText("   Espessura: " + String.format("%-5s", espAtual));
            areaDesenho.setEsp(espAtual);        
        });        

        jbSair.addActionListener(e -> {
            System.exit(0);
        });
    }
}
