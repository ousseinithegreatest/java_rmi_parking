package sn.supdeco.gesparking.services;

import sn.supdeco.gesparking.models.Utilisateur;
import sn.supdeco.gesparking.models.Voiture;

import java.rmi.RemoteException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void stationner(Utilisateur utilisateur, IParking parking) throws RemoteException {
        System.out.println("Infos client : \n");
        System.out.println("Saisir l'identifiant de l'utilisateur");
        String id = scanner.next();

        System.out.println("Saisir le nom de l'utilisateur");
        String nom = scanner.next();

        System.out.println("Saisir le prenom de l'utilisateur");
        String prenom = scanner.next();
        utilisateur = new Utilisateur(id, nom, prenom);

        String  message = parking.creerUtilisateur(utilisateur);
        System.out.println(message);

        System.out.println("Infos du véhicule : \n");
        System.out.println("Saisir le matricule de votre voiture");
        String matricule = scanner.next();
        System.out.println("Saisir le type de votre voiture");
        String typeVoiture = scanner.next();

        Voiture voiture = new Voiture(matricule,typeVoiture,utilisateur);
        message = parking.creerVoiture(voiture,utilisateur);
        System.out.println(message);
    }

    public void recuperer(IParking parking) throws RemoteException {
        System.out.println("Entrer votre code de parking avant de sortir");
        String code = scanner.next();
        String message = parking.recupererVoiture(code);
        System.out.println(message);
    }
}
