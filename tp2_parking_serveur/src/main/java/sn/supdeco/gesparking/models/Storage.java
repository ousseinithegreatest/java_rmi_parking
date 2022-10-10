package sn.supdeco.gesparking.models;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final List<Utilisateur> utilisateurs = new ArrayList<>();
    private static final List<Voiture> voitures = new ArrayList<>();
    private Storage(){};

    public static void addVoiture(Voiture voiture){
        voitures.add(voiture);
    }

    public static List<Voiture> geVoitures(){
        return voitures;
    }

    public static void addUtilisateur(Utilisateur utilisateur){
        utilisateurs.add(utilisateur);
    }

    public static List<Utilisateur> geUtilisateurs(){
        return utilisateurs;
    }
}
