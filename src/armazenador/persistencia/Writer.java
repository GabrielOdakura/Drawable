package armazenador.persistencia;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.*;

import armazenador.Armazenador;
import tipoPrimitivo.TipoPrimitivo;


public class Writer {
	public void escreverJSON(int largura, int altura, String nomeArquivo, ArrayList<Object> lista) {
		Armazenador temp;

		JSONObject desenho = new JSONObject();
        JSONObject root = new JSONObject();
        JSONArray pontoArray = new JSONArray();
        JSONArray retaArray = new JSONArray();
        JSONArray trianguloArray = new JSONArray();
        JSONArray retanguloArray = new JSONArray();
        JSONArray circuloArray = new JSONArray();
        JSONArray mandalaArray = new JSONArray();
        
        
        int indicePonto = 1, indiceCirculo = 1, indiceRetangulo = 1, indiceTriangulo = 1, indiceReta = 1, indiceMandala = 1;
        
        for (int i = 0; i < lista.size(); i++) {
        	temp = (Armazenador) lista.get(i);
        	if(temp.getTipo() == TipoPrimitivo.PONTO) {
        		
        		//coordenadas ponto
        		JSONObject ponto = new JSONObject();
        		ponto.put("id", "ponto_" + indicePonto);
        		ponto.put("esp", temp.getEspessura());
        		ponto.put("x", temp.getPonto1().getX() / largura);
        		ponto.put("y", temp.getPonto1().getY() / altura);
        		
        		//cor ponto
        		JSONObject cor = pegarCor(temp);
        		
        		ponto.put("cor", cor);
        		pontoArray.put(ponto);
        		indicePonto++;
        	}else if(temp.getTipo() == TipoPrimitivo.CIRCULO) {
				JSONObject circulo = new JSONObject();
				circulo.put("id", "circulo_" + indiceCirculo);
				
				//coordenadas
				JSONObject centro = pegarPonto1(temp, largura, altura);
				JSONObject raio = calcularRaio(temp, largura);
				
				
        		//cor ponto
        		JSONObject cor = pegarCor(temp);
        		
        		circulo.put("raio", raio);
        		circulo.put("centro", centro);
        		circulo.put("cor", cor);
        		circuloArray.put(circulo);
        		indiceCirculo++;
			}else if(temp.getTipo() == TipoPrimitivo.RETANGULO) {
				JSONObject retangulo = new JSONObject();
				retangulo.put("id", "retangulo_" + indiceRetangulo);
				
				//coordenadas
				JSONObject ponto1 = pegarPonto1(temp, largura, altura);
				JSONObject raio = pegarPonto2(temp, largura, altura);
				
				//cor ponto
				JSONObject cor = pegarCor(temp);
        		
				retangulo.put("p1", ponto1);
				retangulo.put("p2", raio);
				retangulo.put("cor", cor);
				retanguloArray.put(retangulo);
				indiceRetangulo++;
			}else if(temp.getTipo() == TipoPrimitivo.TRIANGULO) {
				JSONObject triangulo = new JSONObject();
				triangulo.put("id", "triangulo_" + indiceTriangulo);
				
				//coordenadas
				JSONObject ponto1 = pegarPonto1(temp, largura, altura);
				JSONObject ponto2 = pegarPonto2(temp, largura, altura);
				JSONObject ponto3 = pegarPonto3(temp, largura, altura);
				
				//cor ponto
				JSONObject cor = pegarCor(temp);
        		
				triangulo.put("p1", ponto1);
				triangulo.put("p2", ponto2);
				triangulo.put("p3", ponto3);
				triangulo.put("cor", cor);
				trianguloArray.put(triangulo);
				indiceTriangulo++;
			}else if(temp.getTipo() == TipoPrimitivo.RETA) {
				JSONObject reta = new JSONObject();
				reta.put("id", "reta_" + indiceReta);
				
				//coordenadas
				JSONObject ponto1 = pegarPonto1(temp, largura, altura);
				JSONObject ponto2 = pegarPonto2(temp, largura, altura);
				
				//cor ponto
				JSONObject cor = pegarCor(temp);
        		
				reta.put("p1", ponto1);
				reta.put("p2", ponto2);
				reta.put("cor", cor);
				retaArray.put(reta);
				indiceReta++;
			}else if(temp.getTipo() == TipoPrimitivo.MANDALA) {
				JSONObject mandala = new JSONObject();
				mandala.put("id", "mandala_" + indiceMandala);
				
				//coordenadas
				JSONObject ponto1 = pegarPonto1(temp, largura, altura);
				JSONObject ponto2 = pegarPonto2(temp, largura, altura);
				
				//cor ponto
        		JSONObject cor1 = pegarCor(temp);
				JSONObject cor2 = pegarCor2(temp);
        		
        		mandala.put("p1", ponto1);
        		mandala.put("p2", ponto2);
        		mandala.put("cor1", cor1);
				mandala.put("cor2", cor2);
        		mandalaArray.put(mandala);
        		indiceMandala++;
			}
		}
        
        desenho.put("ponto", pontoArray);
        desenho.put("reta", retaArray);
        desenho.put("triangulo", trianguloArray);
        desenho.put("retangulo", retanguloArray);
        desenho.put("circulo", circuloArray);
        desenho.put("mandala", mandalaArray);
        
        root.put("desenho", desenho);
		
		try (FileWriter writer = new FileWriter(nomeArquivo + ".json")) {
            writer.write(root.toString(4)); // O argumento 4 indica a quantidade de espaços de recuo para a formatação
            System.out.println("Arquivo JSON criado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	private JSONObject pegarCor(Armazenador aux) {
		JSONObject cor = new JSONObject();
		cor.put("r", aux.getCorFigura().getRed());
		cor.put("g", aux.getCorFigura().getGreen());
		cor.put("b", aux.getCorFigura().getBlue());
		return cor;
	}

	private JSONObject pegarCor2(Armazenador aux) {
		JSONObject cor = new JSONObject();
		cor.put("r", aux.getSegundaCorMandala().getRed());
		cor.put("g", aux.getSegundaCorMandala().getGreen());
		cor.put("b", aux.getSegundaCorMandala().getBlue());
		return cor;
	}
	
	private JSONObject pegarPonto1(Armazenador aux, int largura, int altura) {
		JSONObject ponto = new JSONObject();
		ponto.put("esp", aux.getEspessura());
		ponto.put("x", aux.getPonto1().getX() / largura);
		ponto.put("y", aux.getPonto1().getY() / altura);
		return ponto;
	}
	
	private JSONObject pegarPonto2(Armazenador aux, int largura, int altura) {
		JSONObject ponto = new JSONObject();
		ponto.put("esp", aux.getEspessura());
		ponto.put("x", aux.getPonto2().getX() / largura);
		ponto.put("y", aux.getPonto2().getY() / altura);
		return ponto;
	}
	
	private JSONObject pegarPonto3(Armazenador aux, int largura, int altura) {
		JSONObject ponto = new JSONObject();
		ponto.put("esp", aux.getEspessura());
		ponto.put("x", aux.getPonto3().getX() / largura);
		ponto.put("y", aux.getPonto3().getY() / altura);
		return ponto;
	}
	
	private JSONObject calcularRaio(Armazenador aux, int largura) {
		double x1 = aux.getPonto1().getX();
		double x2 = aux.getPonto2().getX();
		double y1 = aux.getPonto1().getY();
		double y2 = aux.getPonto2().getY();
		double calcRaio = Math.sqrt(Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2));
		calcRaio /= largura;
		JSONObject raio = new JSONObject();
		raio.put("raio", calcRaio);
		return raio;
	}
}
