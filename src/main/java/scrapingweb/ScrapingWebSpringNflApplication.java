package scrapingweb;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrapingWebSpringNflApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ScrapingWebSpringNflApplication.class, args);
		String url = "https://www.nfl.com/stats/player-stats/category/passing/2021/reg/all/passingyards/desc";
		// conectando a la url
		Document doc = Jsoup.connect(url).get();
		System.out.println(doc.title());
		//puede ser tambien first en vez del indice
		Element titulo=doc.getElementsByClass("d3-o-tabs__list-item d3-is-active").get(0);
		System.out.println(titulo.text());
		Element tbody=doc.getElementsByTag("tbody").first();
		List<Element> players=tbody.getElementsByTag("tr");
		
	for(Element p:players) {
		System.out.println(p.text());
	}
		
		
	}

}
