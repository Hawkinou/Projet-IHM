package fr.unice.polytech.mediamanager.control;

import java.util.ArrayList;

import fr.unice.polytech.mediamanager.model.Actor;
import fr.unice.polytech.mediamanager.model.Director;
import fr.unice.polytech.mediamanager.model.Film;
import fr.unice.polytech.mediamanager.model.Genre;
import fr.unice.polytech.mediamanager.model.Manager;
import fr.unice.polytech.mediamanager.model.Nationality;

/**
 * 
 * @author Clément AUDRY
 *
 */
public class ResearchControl {
	private ResearchControl()
	{
		
	}
 
	/** Instance unique pré-initialisée */
	private static ResearchControl INSTANCE = new ResearchControl();
 
	/** Point d'accès pour l'instance unique du singleton */
	public static ResearchControl getInstance()
	{	return INSTANCE;
	}
	public ArrayList<Film> getFilm(String researchBy, String entry){
		if (entry.equals("")){
			return Manager.getInstance().getAllFilms();
		}
		else if (researchBy.equals("Titre de film")){
			return Manager.getInstance().searchByTitle(entry);
		}
		else if (researchBy.equals("Genre")){
			for (Genre genre : Manager.getInstance().getAllGenres()){
				if (genre.getLabelFr().toLowerCase().equals(entry.toLowerCase())||genre.getLabelEn().toLowerCase().equals(entry.toLowerCase())){
					return Manager.getInstance().searchByGenre(genre);
				}
			}
			return new ArrayList<Film>();
		}
		else if (researchBy.equals("Actor")){
			for (Actor actor : Manager.getInstance().getAllActors()){
				if (actor.getFirstname().toLowerCase().equals(entry.toLowerCase())){ //Ne gère pas homonyme, faire une fonction de recherche plus poussé?
					return Manager.getInstance().searchByActor(actor);
				}
			}
			return Manager.getInstance().searchByActor(new Actor(entry, entry, entry, null, null, null, entry));
		}
		else{
			for (Director director : Manager.getInstance().getAllDirectors()){
				if (director.getFirstname().toLowerCase().equals(entry.toLowerCase())){
					return Manager.getInstance().searchByDirector(director);
				}
			}
			return Manager.getInstance().searchByDirector(new Director(entry, entry, entry, null, null, null, entry));	
		}
	}
	public ArrayList<Nationality>  getNationality() {
		return Manager.getInstance().getAllNationalities();
		
	}
	public ArrayList<Genre> getGenre() {
		return Manager.getInstance().getAllGenres();
	}
	public ArrayList<Director> getDirector() {
		return Manager.getInstance().getAllDirectors();
	}
	public ArrayList<Actor> getActor() {
		// TODO Auto-generated method stub
		return Manager.getInstance().getAllActors();	}
	
}
