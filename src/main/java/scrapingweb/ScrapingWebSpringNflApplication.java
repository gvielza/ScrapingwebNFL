package scrapingweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import scrapingweb.entity.Player;

@SpringBootApplication
public class ScrapingWebSpringNflApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ScrapingWebSpringNflApplication.class, args);
		String url = "https://www.nfl.com/stats/player-stats/category/passing/2021/reg/all/passingyards/desc";
		// conectando a la url
		Document doc = Jsoup.connect(url).get();
		System.out.println(doc.title());
		// puede ser tambien first en vez del indice
		Element titulo = doc.getElementsByClass("d3-o-tabs__list-item d3-is-active").get(0);
		System.out.println(titulo.text());
		Element tbody = doc.getElementsByTag("tbody").first();
		// lista de elementos
		List<Element> players = tbody.getElementsByTag("tr");
		// Lista de jugadores
		List<Player> objplayers = new ArrayList<>();

		for (Element p : players) {
			List<Element> atributos = p.getElementsByTag("td");
			Player player = new Player(atributos.get(0).text(), atributos.get(1).text(), atributos.get(2).text(),
					atributos.get(3).text());
			objplayers.add(player);
		}
		for (Player a : objplayers) {
			converterToJson(a);
		}
	}
	
	//metodo que me convierte las entidades string a json
public static void converterToJson(Player py) {
	ObjectMapper mapper=new ObjectMapper();
	 try {
		String json=mapper.writeValueAsString(py);
		System.out.println(json);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}




}
