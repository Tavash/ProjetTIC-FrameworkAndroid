package fr.tic;

import org.jdom2.DataConversionException;

import configuratormangement.Configurator;
import configuratormangement.XmlCreator;
import plurals.Catalogue;
import plurals.ListeCategories;
import plurals.ListeClients;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//_____________________________
		//Jeux de test :
		//__________________________________________________________

		ListeCategories mesCategories = new ListeCategories();
		ListeClients mesClients = new ListeClients();
		Catalogue monCatalogue = new Catalogue();

		mesCategories.findCategories();
		mesClients.findClients();
		monCatalogue.findProduits();

		monCatalogue.ajoutObserver(mesClients);

		// Test Parser XML
		/*
		XmlCreator x = new XmlCreator();
		Configurator c = new Configurator();
		c.setShoppingCart(true);
		c.setCustomerNotice(true);
		c.setOrder(false);
		c.setWebsiteName("SiteDeLaMort");
		try {
			x.create(c);
			x.display();
			x.save("test.xml");
		} catch (DataConversionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 */

		// Test Cat�gorie et Produit

		/*Categorie C1 = new Categorie(0, "Salle de bain");
		Categorie C2 = new Categorie(0, "Salon");

		Produit P1 = new Produit(0, "Tapis", 38, "Tapis de salle de bain", "Michelin", 100);
		Produit P2 = new Produit(0, "Bureau", 67, "Bureau en ch�ne", "Lacoste", 3);
		Produit P3 = new Produit(0, "Douche", 400, "Douche italienne", "Nike", 12);

		P1.addObserver(mesClients);
		P2.addObserver(mesClients);
		P3.addObserver(mesClients);

		C1.ajouterProduitCategorie(P1);
		C2.ajouterProduitCategorie(P2);
		C1.ajouterProduitCategorie(P3);

		mesCategories.ajouterCategorie(C1);
		mesCategories.ajouterCategorie(C2);


		//Test Client et Panier

		Client CLT1 = new Client(0, "Slava", "Hubert", "36 rue des Lilas", true);
		Client CLT2 = new Client(0, "Dutilleux", "Sophie", "27 avenue des marchands", false);

		Panier PN1 = new Panier(0, false, "");
		Panier PN2 = new Panier(0, false, "");
		Panier PN3 = new Panier(0, false, "");
		Panier PN4 = new Panier(0, false, "");

		CLT1.ajouterPanierClient(PN1);
		CLT1.getMesPanier().get(0).commander("Carte");
		CLT1.ajouterPanierClient(PN2);

		CLT2.ajouterPanierClient(PN3);
		CLT2.ajouterPanierClient(PN4);
		CLT2.supprimerPanierClient(PN3);

		//Test Panier

		PN1.ajouterProduitPanier(P1, 25);
		PN2.ajouterProduitPanier(P2, 5);
		PN4.ajouterProduitPanier(P3, 3);
		PN1.supprimerProduitPanier(P1);
		PN1.ajouterProduitPanier(P3, 4);

		CLT1.supprimerPanierClient(PN1);



		//Test affichage
		for(Produit p : monCatalogue.getMesProduits()){
			System.out.println("Nom : " + p.getNomProduit() + " & " + " Prix : " + p.getStockProduit());

		}

		for(Client c : mesClients.getListeClients()){
			System.out.println("Nom : " + c.getNomClient() + " & " + " Taille panier : " + c.getMesPanier().size());
		}

		for(Categorie ca : mesCategories.getListeCategories()){
			System.out.println("Nom : " + ca.getNomCategorie() + " & " + " Nombre de produits : " + ca.getMesProduits().size());
		}*/

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}