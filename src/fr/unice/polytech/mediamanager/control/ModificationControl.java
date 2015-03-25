package fr.unice.polytech.mediamanager.control;
import java.util.ArrayList;

import fr.unice.polytech.mediamanager.model.Actor;
import fr.unice.polytech.mediamanager.model.Director;
import fr.unice.polytech.mediamanager.model.Film;
import fr.unice.polytech.mediamanager.model.Genre;
import fr.unice.polytech.mediamanager.model.Manager;

/**
 * 
 * @author Audry Clement
 *
 */
public class ModificationControl {
	private ModificationControl(){
	}
	/** Instance unique pré-initialisée */
	private static ModificationControl INSTANCE = new ModificationControl();
 
	/** Point d'accès pour l'instance unique du singleton */
	public static ModificationControl getInstance()
	{	return INSTANCE;
	}
	
	public String addFilm(String title, String director,String actors, String genres, String runtime, String poster, String synopsis){
		 if (title.equals("")||director.equals("")||actors.equals("")||genres.equals("")||runtime.equals("")||
				 poster.equals("")||synopsis.equals(""))
			 return "Ajout refusé: \n Il y a des champs non remplis!";
		 else if(testDirector(director)){
			 return "Ajout refusé: \n Problème au niveau du directeur";
		 }
		 else if(testDirector(actors)) 
			return "Ajout refusé: \n Problème au niveau des acteurs";
		else if(testGenre(genres))
			return "Ajout refusé: \n Problème au niveau des genres";
		else if (testRuntime(runtime))
			return "Ajout refusé: \n Problème au niveau de la duree";
		else if (testPoster(poster))
			return "Ajout refusé: \n Problème au niveau de l'affiche";
	 
		return "";
	}	

	private boolean testPoster(String poster) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean testRuntime(String runtime) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean testGenre(String genres) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean testDirector(String director) {

		return false;
	}

	public void addFilm(String id, String title, Director director, ArrayList<Actor> actors, ArrayList<Genre> genres, int runtime, String poster, String synopsis){
		Film film = new Film(id,title,director,actors,genres,runtime,poster,synopsis);
		Manager.getInstance().addFilm(film);

	}
}
