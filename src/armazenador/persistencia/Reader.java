package armazenador.persistencia;

import armazenador.Armazenador;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONException;
import tipoPrimitivo.TipoPrimitivo;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Leitura do arquivo(Json) desejado pelo usuario.
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20231031
 */
public class Reader {
    public void lerJson(int largura, int altura, String nomeArquivo, ArrayList<Object> array) {
        try {
            // Ler o arquivo JSON
            FileReader reader = new FileReader(nomeArquivo + ".json");

            // Criar um objeto JSON a partir do arquivo
            JSONObject jsonObject = new JSONObject(new JSONTokener(reader));

            // Acessar a chave "desenho"
            JSONObject desenho = jsonObject.getJSONObject("desenho");

            // Acessar as chaves dentro de "desenho"
            if(!desenho.isNull("ponto")){
                JSONArray pontoArray = desenho.getJSONArray("ponto");
                // Processar os PONTOS
                for (int i = 0; i < pontoArray.length(); i++) {
                    JSONObject ponto = pontoArray.getJSONObject(i);
                    double esp = ponto.getDouble("esp");
                    double x = ponto.getDouble("x");
                    x *= largura;
                    double y = ponto.getDouble("y");
                    y *= altura;
                    // Acessar a chave "cor" para obter os valores de R, G e B
                    JSONObject cor = ponto.getJSONObject("cor");
                    int r = cor.getInt("r");
                    int g = cor.getInt("g");
                    int b = cor.getInt("b");
                    Color aux = new Color(r,g,b);

                    Armazenador temp = new Armazenador((int) x,(int) y,TipoPrimitivo.PONTO,(int) esp, aux);
                    array.add(temp);

                    //debug abaixo, caso necessário
                    /*
                    String id = ponto.getString("id");
                    double esp = ponto.getDouble("esp");
                    double x = ponto.getDouble("x");
                    double y = ponto.getDouble("y");
                    // Mostrar os valores lidos
                    System.out.println("Ponto " + id + ": Espessura=" + esp + ", X=" + x + ", Y=" + y + ", Cor (R, G, B)=" + r + ", " + g + ", " + b);
                     */
                }
            }
            // Processar as RETAS
            if(!desenho.isNull("reta")){
                JSONArray retaArray = desenho.getJSONArray("reta");
                for (int i = 0; i < retaArray.length(); i++) {
                    JSONObject reta = retaArray.getJSONObject(i);
                    String id = reta.getString("id");


                    // Acessar os pontos p1 e p2
                    JSONObject p1 = reta.getJSONObject("p1");
                    JSONObject p2 = reta.getJSONObject("p2");
                    //JSONObject espessura = reta.getJSONObject("esp");

                    double esp = reta.getDouble("esp");
                    double p1x = p1.getDouble("x");
                    double p1y = p1.getDouble("y");
                    double p2x = p2.getDouble("x");
                    double p2y = p2.getDouble("y");
                    p1x *= largura;
                    p1y *= altura;
                    p2x *= largura;
                    p2y *= altura;

                    // Acessar a chave "cor" para obter os valores de R, G e B
                    JSONObject cor = reta.getJSONObject("cor");
                    int r = cor.getInt("r");
                    int g = cor.getInt("g");
                    int b = cor.getInt("b");
                    Color aux = new Color(r,g,b);


                    Armazenador temp = new Armazenador((int) p1x,(int) p1y, (int) p2x,(int) p2y, TipoPrimitivo.RETA,(int) esp, aux, null);
                    array.add(temp);

                    /*
                    // Mostrar os valores lidos
                    System.out.println("Reta " + id + ": Espessura=" + esp);
                    System.out.println("Ponto 1 (X, Y): " + p1x + ", " + p1y);
                    System.out.println("Ponto 2 (X, Y): " + p2x + ", " + p2y);
                    System.out.println("Cor (R, G, B): " + r + ", " + g + ", " + b);
                     */
                }
            }
            // Processar os CIRCULOS
            if(!desenho.isNull("circulo")){
                JSONArray circuloArray = desenho.getJSONArray("circulo");
                for (int i = 0; i < circuloArray.length(); i++) {
                    JSONObject circulo = circuloArray.getJSONObject(i);
                    String id = circulo.getString("id");

                    // Acessar informacoes do circulo
                    JSONObject centro = circulo.getJSONObject("centro");
                    double esp = circulo.getDouble("esp");
                    double centroX = centro.getDouble("x");
                    double centroY = centro.getDouble("y");
                    double auxRaio = circulo.getDouble("raio");
                    centroX *= largura;
                    centroY *= altura;
                    auxRaio *= largura;

                    // Acessar a chave "cor" para obter os valores de R, G e B
                    JSONObject cor = circulo.getJSONObject("cor");
                    int r = cor.getInt("r");
                    int g = cor.getInt("g");
                    int b = cor.getInt("b");

                    Color aux = new Color(r,g,b);


                    Armazenador temp = new Armazenador((int) centroX,(int) centroY, (int) (centroX + auxRaio),(int) centroY, TipoPrimitivo.CIRCULO,(int) esp, aux, null);
                    array.add(temp);

                    //debugging
                    /*
                    // Mostrar os valores lidos
                    System.out.println("Circulo " + id + ": Espessura=" + esp);
                    System.out.println("Centro (X, Y): " + centroX + ", " + centroY);
                    System.out.println("Raio: " + raio);
                    System.out.println("Cor (R, G, B): " + r + ", " + g + ", " + b);
                     */
                }
            }
            // Processar os TRIANGULOS
            if(!desenho.isNull("triangulo")){
                JSONArray trianguloArray = desenho.getJSONArray("triangulo");
                for (int i = 0; i < trianguloArray.length(); i++) {
                    JSONObject triangulo = trianguloArray.getJSONObject(i);
                    String id = triangulo.getString("id");

                    // Acessar informacoes dos tres pontos do triangulo
                    JSONObject p1 = triangulo.getJSONObject("p1");
                    JSONObject p2 = triangulo.getJSONObject("p2");
                    JSONObject p3 = triangulo.getJSONObject("p3");

                    double esp = triangulo.getDouble("esp");
                    double p1x = p1.getDouble("x");
                    double p1y = p1.getDouble("y");
                    double p2x = p2.getDouble("x");
                    double p2y = p2.getDouble("y");
                    double p3x = p3.getDouble("x");
                    double p3y = p3.getDouble("y");
                    p1x *= largura;
                    p1y *= altura;
                    p2x *= largura;
                    p2y *= altura;
                    p3x *= largura;
                    p3y *= altura;

                    // Acessar a chave "cor" para obter os valores de R, G e B
                    JSONObject cor = triangulo.getJSONObject("cor");
                    int r = cor.getInt("r");
                    int g = cor.getInt("g");
                    int b = cor.getInt("b");
                    Color aux = new Color(r,g,b);


                    Armazenador temp = new Armazenador((int) p1x,(int) p1y, (int) p2x,(int) p2y,(int) p3x,(int) p3y, TipoPrimitivo.TRIANGULO,(int) esp, aux);
                    array.add(temp);
                    //debugging
                    /*
                    // Mostrar os valores lidos
                    System.out.println("Triangulo " + id + ": Espessura=" + esp);
                    System.out.println("Ponto 1 (X, Y): " + p1x + ", " + p1y);
                    System.out.println("Ponto 2 (X, Y): " + p2x + ", " + p2y);
                    System.out.println("Ponto 3 (X, Y): " + p3x + ", " + p3y);
                    System.out.println("Cor (R, G, B): " + r + ", " + g + ", " + b);
                     */
                }
            }
            // Processar RETANGULOS
            if(!desenho.isNull("retangulo")){
                JSONArray retanguloArray = desenho.getJSONArray("retangulo");
                for (int i = 0; i < retanguloArray.length(); i++) {
                    JSONObject retangulo = retanguloArray.getJSONObject(i);
                    String id = retangulo.getString("id");

                    // Acessar informacoes dos dois pontos do retangulo
                    JSONObject p1 = retangulo.getJSONObject("p1");
                    JSONObject p2 = retangulo.getJSONObject("p2");

                    double esp = retangulo.getDouble("esp");
                    double p1x = p1.getDouble("x");
                    double p1y = p1.getDouble("y");
                    double p2x = p2.getDouble("x");
                    double p2y = p2.getDouble("y");
                    p1x *= largura;
                    p1y *= altura;
                    p2x *= largura;
                    p2y *= altura;

                    // Acessar a chave "cor" para obter os valores de R, G e B
                    JSONObject cor = retangulo.getJSONObject("cor");
                    int r = cor.getInt("r");
                    int g = cor.getInt("g");
                    int b = cor.getInt("b");
                    Color aux = new Color(r,g,b);

                    Armazenador temp = new Armazenador((int) p1x,(int) p1y, (int) p2x,(int) p2y, TipoPrimitivo.RETANGULO,(int) esp, aux, null);
                    array.add(temp);

                    //debugging
                    /*
                    // Mostrar os valores lidos
                    System.out.println("Retangulo " + id + ": Espessura=" + esp);
                    System.out.println("Ponto 1 (X, Y): " + p1x + ", " + p1y);
                    System.out.println("Ponto 2 (X, Y): " + p2x + ", " + p2y);
                    System.out.println("Cor (R, G, B): " + r + ", " + g + ", " + b);
                     */
                }
            }
            // Processar MANDALAS
            if(!desenho.isNull("mandala")){
                JSONArray mandalaArray = desenho.getJSONArray("mandala");
                for (int i = 0; i < mandalaArray.length(); i++) {
                    JSONObject mandala = mandalaArray.getJSONObject(i);
                    String id = mandala.getString("id");

                    // Acessar informacoes dos pontos da mandala
                    JSONObject p1 = mandala.getJSONObject("p1");
                    JSONObject p2 = mandala.getJSONObject("p2");

                    double esp = mandala.getDouble("esp");
                    double p1x = p1.getDouble("x");
                    double p1y = p1.getDouble("y");
                    double p2x = p2.getDouble("x");
                    double p2y = p2.getDouble("y");
                    p1x *= largura;
                    p1y *= altura;
                    p2x *= largura;
                    p2y *= altura;

                    // Acessar informacoes das cores da mandala
                    JSONObject cor1 = mandala.getJSONObject("cor1");
                    JSONObject cor2 = mandala.getJSONObject("cor2");

                    int r1 = cor1.getInt("r");
                    int g1 = cor1.getInt("g");
                    int b1 = cor1.getInt("b");
                    Color caux1 = new Color(r1,g1,b1);

                    int r2 = cor2.getInt("r");
                    int g2 = cor2.getInt("g");
                    int b2 = cor2.getInt("b");
                    Color caux2 = new Color(r2,g2,b2);

                    Armazenador temp = new Armazenador((int) p1x,(int) p1y, (int) p2x,(int) p2y, TipoPrimitivo.MANDALA,(int) esp, caux1, caux2);
                    array.add(temp);
                    //debugging

                    // Mostrar os valores lidos
                    System.out.println("Mandala " + id + ": Espessura=" + esp);
                    System.out.println("Ponto 1 (X, Y): " + p1x + ", " + p1y);
                    System.out.println("Ponto 2 (X, Y): " + p2x + ", " + p2y);
                    System.out.println("Cor 1 (R, G, B): " + r1 + ", " + g1 + ", " + b1);
                    System.out.println("Cor 2 (R, G, B): " + r2 + ", " + g2 + ", " + b2);

                }
            }
            // Feche o leitor
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
