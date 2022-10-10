package sn.supdeco.gesparking.services;

import sn.supdeco.gesparking.models.Utilisateur;
import sn.supdeco.gesparking.models.Voiture;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IParking extends Remote {

    public String creerUtilisateur(Utilisateur utilisateur) throws RemoteException;
    public String creerVoiture(Voiture voiture, Utilisateur utilisateur) throws RemoteException;
    public String recupererVoiture(String codeParking) throws RemoteException;
}
