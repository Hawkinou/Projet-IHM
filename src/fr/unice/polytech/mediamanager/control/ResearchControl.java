package fr.unice.polytech.mediamanager.control;

import java.util.ArrayList;

import fr.unice.polytech.mediamanager.model.Film;
import fr.unice.polytech.mediamanager.model.Genre;
import fr.unice.polytech.mediamanager.model.Manager;
import fr.unice.polytech.mediamanager.model.Nationality;

/**
 * 
 * @author Cl�ment AUDRY
 *
 */
public class ResearchControl {
	private ResearchControl()
	{
		
	}
 
	/** Instance unique pr�-initialis�e */
	private static ResearchControl INSTANCE = new ResearchControl();
 
	/** Point d'acc�s pour l'instance unique du singleton */
	public static ResearchControl getInstance()
	{	return INSTANCE;
	}
	public ArrayList<Film> getFilm(){
		return Manager.getInstance().getAllFilms();
	}
	public ArrayList<Nationality>  getNationality() {
		return Manager.getInstance().getAllNationalities();
		
	}
	public ArrayList<Genre> getGenre() {
		return Manager.getInstance().getAllGenres();
	}
	
}
