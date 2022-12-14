package sn.supdeco.gesparking;

import sn.supdeco.gesparking.models.Utilisateur;
import sn.supdeco.gesparking.services.IParking;
import sn.supdeco.gesparking.services.Menu;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class GesParkingClient
{
    public static void main( String[] args ) throws RemoteException, NotBoundException, MalformedURLException
    {

        IParking parking = (IParking) Naming.lookup("rmi://localhost:2000/parking");
        Scanner scanner = new Scanner(System.in);
        Utilisateur utilisateur = null;
        String message ="";
        Menu menu= new Menu();


        int i = 1;
        while (i == 1) {
            System.out.println("Faites votre choix:");
            System.out.println("1. Stationner vehicule");
            System.out.println("2. Recuperer  vehicule");
            System.out.println("3. Quitter");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    menu.stationner(utilisateur, parking);
                    i=1;
                    break;
                case 2:
                    menu.recuperer(parking);
                    i=1;
                    break;
                case 3:
                    i=2;
                    break;

            }
        }
    }
}
