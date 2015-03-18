package fr.unice.polytech.mediamanager.control;

import fr.unice.polytech.mediamanager.model.*;
import java.util.ArrayList;
import java.util.Date;

public class TestManagerBase {

    public static void main(String[] args) {
        Manager manager = Manager.getInstance();
        ArrayList<Film> films = manager.getAllFilms();

        for(Film film: films) {
            System.out.println(film);
            System.out.println();
        }
    }
}