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
	
	public void addFilm(String id, String title, String director,String actors, String genres, String runtime, String poster, String synopsis){

	}	

	public void addFilm(String id, String title, Director director, ArrayList<Actor> actors, ArrayList<Genre> genres, int runtime, String poster, String synopsis){
		Film film = new Film(id,title,director,actors,genres,runtime,poster,synopsis);
		Manager.getInstance().addFilm(film);

	}
}
