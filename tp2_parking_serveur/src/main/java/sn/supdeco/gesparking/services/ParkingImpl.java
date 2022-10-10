package sn.supdeco.gesparking.services;

import sn.supdeco.gesparking.models.Storage;
import sn.supdeco.gesparking.models.Utilisateur;
import sn.supdeco.gesparking.models.Voiture;

import java.rmi.RemoteException;
import java.util.Random;
import java.util.Scanner;

public class ParkingImpl implements IParking {
    private static final Random RANDOM = new Random();
    Scanner scanner = new Scanner(System.in);

    @Override
    public String creerUtilisateur(Utilisateur utilisateur) throws RemoteException {

        Storage.addUtilisateur(utilisateur);
        return "Utilisateur enregistré avec succès !";

    }

    @Override
    public String creerVoiture(Voiture voiture, Utilisateur utilisateur) throws RemoteException {
        System.out.println(Storage.geVoitures().size());
        if (Storage.geVoitures().size() > 5) {
            return "Nous n'avons plus de place pour vous stationner ! ";
        }

        voiture.setCodeParking("PRK" + RANDOM.nextInt());
        Storage.addVoiture(voiture);
        //Database.addUtilisateur(utilisateur);
        return "Merci de garder le code de stationnement " + voiture.getCodeParking();

    }

    @Override
    public String recupererVoiture(String codeParking) throws RemoteException {
        Storage.geUtilisateurs();
        for (int i = 0; i < Storage.geVoitures().size(); i++) {
            if (Storage.geVoitures().get(i).getCodeParking().equalsIgnoreCase(codeParking)) {

                Storage.geVoitures().remove(i);
                return "Merci de nous avoir fait confiance";
            }
        }

        return null;
    }
}
