package com.ecommerce.wines;

import com.ecommerce.wines.models.Category;
import com.ecommerce.wines.models.Client;
import com.ecommerce.wines.models.Moment;
import com.ecommerce.wines.models.Product;
import com.ecommerce.wines.repositories.ClientRepository;
import com.ecommerce.wines.repositories.MomentRepository;
import com.ecommerce.wines.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WinesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WinesApplication.class, args);
		System.out.println(" 123");
	}

	@Bean
	public CommandLineRunner initData(ProductRepository productRepository, ClientRepository clientRepository, MomentRepository momentRepository){
		return args ->{



			//PRODUCTOS


			Product product1 = new Product(Category.white, "Goda", "Albariño grapes, following a rigorous and careful process to guarantee its " +
					"varietal purity. The vineyards are cultivated on land loamy-sandy, granitic and slightly acidic. pneumatic pressing with separation " +
					"of musts.", 10, 13.3, 1.0, "https://i.ibb.co/T4zrWf6/goda.png",
					"100% Albariño", "Clean and bright. Greenish yellow. Clean and bright mature nose. Greenish yellow. Ripe nose with notes " +
					"of white flowers, pear, apricot, elderberry and a light smoky note. On the palate it is very good length and freshness.", "10-12 °C");
			Product product2 = new Product(Category.white, "Gaudila", "Strict control in our own vineyards with manual harvest in 15kg boxes. " +
					"Immediate transport to the winery where the grapes are subjected to temperature control. Table selection bunch by bunch. Fermentation at " +
					"controlled temperature.", 10, 10.63, 1.0, "https://i.ibb.co/X4XrbQS/gaudila-2017.png", "100% Albariño ",
					"Straw yellow color, clean and very bright. Elegance and character, shows aromas of fresh fruit, Citrus, intensely floral with " +
					"good complexity, mineral, herbal notes.", "10-12 °C");
			Product product3 = new Product(Category.red, "Gaudila sobre lías", "The grapes are destemmed upon entering the winery and macerated " +
					"cold pre-fermentation of the must with the skins at a temperature 6ºC for 6 hours for greater extraction of aromatic precursors and " +
					"fermentation at a low temperature of 13ºC.", 10, 12.4, 1.0, "https://i.ibb.co/MMVr5rx/gaudila-2013.png", "100% Albariño",
					"Intense straw yellow, high aromatic intensity, with notes of very ripe fruit pear, peach, memory of aging on very clean lees. " +
					"wide entry into mouth and enveloping, fatty and with volume, with an excellent mid palate, long and fruity aftertaste.", "10-12 °C");
			Product product4 = new Product(Category.white, "Pájaro loco Godello", "The mixture of grapes is macerated at cold temperatures before " +
					"being gently pressed by the method of bleeding. Then its must is taken to tanks stainless steel, where it is fermented for 2 weeks at cold " +
					"temperatures, with the use of natural yeasts.", 10, 13.7, 1.0, "https://i.ibb.co/M9t9XRs/pajaro-blanco.png",
					"Godello", "Straw yellow color with greenish notes, medium-high intensity, notes herbaceous and white-fleshed fruit like apples. Very enveloping " +
					"taste phase and fresh with a long aftertaste and citric aftertaste.", "10-12 °C");
			Product product5 = new Product(Category.red, "Pájaro loco Mencía", "The mixture of grapes is macerated at cold temperatures before " +
					"being gently pressed by the method of bleeding. Then its must is taken to tanks of stainless steel, where it is fermented for 2 weeks at cold " +
					"temperatures, with the use of natural yeasts.", 10, 16.2, 1.0, "https://i.ibb.co/DrVTmRf/pajaro-tinto.png",
					"Mencía", "Garnet red color and purple rim, with good tears and forceful layer. complex nose, very intense, red fruits such " +
					"as strawberry, blackberry or raspberry, vegetal and spaced notes of coffee, cocoa and chocolate Enveloping.", "16-18 °C");
			Product product6 = new Product(Category.white, "Nervo", "Extensive control in the vineyard with manual harvest in 15kg boxes. Immediate " +
					"transport to the warehouse where the grape is subjected to temperature control. Selection on vibrating table cluster by cluster.", 10, 13.98, 1.0, "https://i.ibb.co/CsLv6kn/nervo.png", "Treixadura, Albariño y " +
					"Godello", "Clean, bright, greenish-yellow. Ripe nose with notes to white flowers, pear, apricot, elderberry, and a slight note of " +
					"smoke. On the palate it is fatty, sweet, unctuous, but with a very good length and freshness.", "10-12 °C");
			Product product7 = new Product(Category.red, "El Maquinista", "Traditional, 100% destemmed. Aging for 14 months in barrels French and American oak Bordeaux.", 10,
					15.6, 1.0, "https://i.ibb.co/Px3KX4g/maquinista.png", "100% Tempranillo", "Ruby-red color with a cherry red " +
					"rim. Aroma of good intensity with notes of fruit reds and berries, mineral and spicy. Good notes of wood, reminding vanilla, chocolate and " +
					"roasted.", "16-18 °C");
			Product product8 = new Product(Category.white, "Fiano", "Chestnut honey, hazelnuts, caramelized sugar, peanut butter, broom flowers: juice and salt compete for " +
					"the palate in an energetic battle", 10, 14.0, 1.0, "https://i.ibb.co/cv7RjC6/fiano.webp", "100% Fiano", " A summery, toasted and roasted nose, ignited " +
					"by a deep salty core and a pungent aromatic herb like oregano.", "10-12 °C ");
			Product product9 = new Product(Category.rose, "Negroamaro Rosato", "A velvet glove opens up a thick, fresh texture, a harbinger of smooth juiciness and spicy-sweet " +
					"spiciness.", 10, 14.0, 1.0, "https://i.ibb.co/0XzLWS8/negroamaro.webp", "100% Negroamaro", " A scent of sweet, dark berries, blackberries and mulberries, " +
					"with hints of cola, lavender and a dark, chinotto-like citrus fruit.", "10-12 °C");
			Product product10 = new Product(Category.red, "Primitivo Bio", "The palate is ignited by a juicy spiciness, innervated by a serious, citrusy, soaring acidity that " +
					"animates its haughty bearing, even in its breadth.", 10, 16.23, 1.0, "https://i.ibb.co/vQtkymh/primitivobio.webp", "100% Primitivo", "Pulsing haematic " +
					"fleshyness, imbued with red spices and cloves, blossoming into the floral notes of lilium.", "16-18 °C");
			Product product11 = new Product(Category.rose, "Vuciata Rosso", "The latticed pulp of a large, dark cherry, throbs in the glass along with balsamic flecks of rhubarb, chocolate " +
					"and pomegranate kernels.", 10, 21.52, 1.0, "https://i.ibb.co/Hry22GG/vuciatarosso.webp", "100% Vuciata", "Impressive on the palate, it unleashes earthy moods and " +
					"a sharp, precise touch that resonates with cherry juice and black pepper powder.", "10-12 °C");
			Product product12 = new Product(Category.rose, "Vuciata Rosato", "Consistent and spicy, the voluminous and soft sip is innervated by the salty thrill of an ascending spine: vertical and " +
					"punctilious.", 10, 18.0, 1.0, "https://i.ibb.co/vkxBCwC/Rosato-ancestrale.webp","100% Vuciata", " Fleshy on the nose, it exudes haematic and spicy notes in equal measure, grafting the flowers and fruits of a late spring: " +
					"lime, cut grass, unripe cherry.", "16-18 °C");
			Product product13 = new Product(Category.rose, "Rosato Ancestrale", "An initial puff of lychee, pomegranate kernels and watermelon soon transfigures into notes, spicy on the nose, of chilli " +
					"jam.", 10, 18.23, 1.0, "https://i.ibb.co/vkxBCwC/Rosato-ancestrale.webp", "Nero di Troia", "Whether you drink it with or without a base, the palate has the spiciness of tobacco, " +
					"creamy texture and lingering colour. The softness comes through, the wine is chewy, and immediately enjoyable.", "8-10 °C");
			Product product14 = new Product(Category.white, "Solnato Bianco", "A delicate peach, permeated with fresh puffs of mint and rock salt, inhabits the pale white chalice.", 10, 12.31, 1.0,
					"https://i.ibb.co/QJZXQbj/solnatobianco.webp", "100% Malvasia del Lazio ", " On the taste, a salty, straight, mineral structure rounds off an already terse sip, which revives " +
					"the aftertaste with notes of white peach", "8-10 °C");
			Product product15 = new Product(Category.rose, "Solnato Rosso", "From a vermilion, violet and impenetrable juice, rise notes of black olive, sour cherry and chocolate.", 10, 15.0, 1.0,
					"https://i.ibb.co/fpgnf5h/solnatorosso.webp", "70% Montepulciano, 25% Cesanese, 5% Merlot", "The nose is broad, with notes of ripe red fruit that blend well with hints of " +
					"liquorice and spices. The taste is robust and dense thanks to the presence of tannins that blend well with the structure of the product.", "18-20 °C");
			Product product16 = new Product(Category.white, "Vuciata Bianco", "Extensive aromas of hay and smoke, puffs of scorched earth, medicinal herbs and star anise animate a deep " +
					"and expansive, dynamic and vital nose.", 10, 19.23, 1.0, "https://i.ibb.co/bKx7Kmh/vuciatabianco.webp", "100% Vuciata", "The sip is a penetrating punch of salt, dry, juicy, " +
					"salacious, full and pulpy; it has texture and structure, levity and ease.", "10-12 °C");
			Product product17 = new Product(Category.red, "Conti Ducco Caramel", "The Franciacorta that you don't expect: soft, pleasant, that adapts to all palates. A masterful companion to appetizers, " +
					"it also perfectly accompanies the most delicate desserts.", 10, 28.2, 1.0, "https://i.ibb.co/S7VJLLb/Conti-Ducco-Caramel.png", "100% Chardonnay",
					"Of a yellow color with golden reflections. Fine, delicate and persistent wine. An aroma of toasted nuts, and an intense flavor, with a good acid structure, fine and persistent.",
					"6-8 °C");
			Product product18 = new Product(Category.red, "Terri di Conti Ducco", "Winner of the Viniplus 2018 Quattro Rose Camune award, the true essence of Franciacorta is revealed without secrets with " +
					"the slightest addition of expedition liqueur.", 10, 18.25, 1.0, "https://i.ibb.co/89vh1vv/Terrediconti-Ducco.png", "100% Chardonnay", "Of a yellow color with greenish reflections. " +
					"Fine and persistent wine. An aroma of bread crust and dried fruit, and a fresh, savory taste.", "6-8 °C");
			Product product19 = new Product(Category.red, "Conti Ducco Saten", "Franciacorta's flagship product, which everyone envy us, is tinged with a new complexity: its soft and silky foam...simply irresistible.",
					10, 31.23, 1.0, "https://i.ibb.co/tsMXJZj/Conti-Ducco-Saten.png", "100% Chardonnay", "Of a yellow color with greenish reflections. Fine, delicate and persistent wine. An aroma of white-fleshed fruit and floral notes, and an intense flavor, " +
					"with good acidity and persistent structure.", "6-8 °C");
			Product product20 = new Product(Category.white, "Conti Ducco Blanc de Blancs", "The complexity of the French oak, the long refinements with selected yeasts, the purity of the Chardonnay... create a perfect " +
					"blend: the 2015 that is stripped bare, with a very elegant new shape.", 10, 25.84, 1.0, "https://i.ibb.co/GnxjrTK/Conti-Ducco-Blanc.png", "100% Chardonnay",
					"Of a bright yellow color. Fine and persistent wine. An aroma of candied citrus, light hints of yeast given by the long refining, and a flavor in the mouth, the white-fleshed " +
					"fruit joins the toasted and vanilla notes of the part in the barrel.", "6-8 °C");
			Product product21 = new Product(Category.rose, "Conti Ducco Rosé", "It is the perfect fusion between femininity and structure, delicacy and complexity, elegance and persistence that best expresses all " +
					"the poetry of Pinot Noir, now Millesimato.", 10, 32.25, 1.0, "https://i.ibb.co/1r17wTg/Conti-Ducco-Rose.png", "100% Pinot Nero", "An antique rose quartz color. Fine, abundant and persistent wine. " +
					"A complex, very intense, fruity aroma and a fine, elegant and persistent taste.", "6-8 °C");
			Product product22 = new Product(Category.red, "Conti Ducco Pas Dosé", "The union between the purity and elegance of the best grapes, without any addition of expedition liqueur. " +
					"The very high selection makes this Franciacorta, in numbered and limited bottles, the true 'Vintage Sauvage'.", 10, 39.0, 1.0, "https://i.ibb.co/TY0TzpR/contiduco-Pasdose.png",
					"100% Pinot Noirs", "Of an intense yellow color with greenish reflections. Fine and persistent wine. A mineral aroma accompanied by notes of white gold, and a " +
					"flavor of acid complexity combined with a harmonious structure.", "8-10 °C");
			Product product23 = new Product(Category.white, "Conti Ducco Brut", "Produced in limited quantities, the high-quality wine project comes from a single vineyard of approximately" +
					" 1.5 hectares, with yields per hectare of 50 quintals and a total production of 4,000 bottles.", 10, 31.23, 1.0, "https://i.ibb.co/tztsVkM/ducco-brut.png", "100% Chardonnay",
					"Of a bright straw yellow color. Fine and persistent wine. The fresh and floral aroma of Chardonnay joins the " +
					" notes given by the light touch of madora, the taste with a good acid structure favors a structured and elegant body.", "10-12 °C");

			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product3);
			productRepository.save(product4);
			productRepository.save(product5);
			productRepository.save(product6);
			productRepository.save(product7);
			productRepository.save(product8);
			productRepository.save(product9);
			productRepository.save(product10);
			productRepository.save(product11);
			productRepository.save(product12);
			productRepository.save(product13);
			productRepository.save(product14);
			productRepository.save(product15);
			productRepository.save(product16);
			productRepository.save(product17);
			productRepository.save(product18);
			productRepository.save(product19);
			productRepository.save(product20);
			productRepository.save(product21);
			productRepository.save(product22);
			productRepository.save(product23);






		};
	}

}
