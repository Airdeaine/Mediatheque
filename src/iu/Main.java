package iu;

import java.util.Enumeration;
import java.util.Scanner;

import om.*;

public class Main {
    public static void main(String[] args) throws DocumentPasTrouve {
        Document doc = new Document();
        Document doc1 = new Document("caca");
        Cassette cass = new Cassette("aladin", 60, "baba");
        Periodique perio = new Periodique("judo", 40, "157");
        Livre livre = new Livre("prpp", 452, "robert", "livrpoche");

        Bibliotheque bibli = new Bibliotheque("docs");

        bibli.ajouterDocument(doc,new String[]{"1", "2"});
        bibli.ajouterDocument(doc1,new String[]{"2", "3"});
        bibli.ajouterDocument(cass, new String[]{"1"});
        bibli.ajouterDocument(perio, new String[]{"3"});
        bibli.ajouterDocument(livre, new String[]{"2"});

        // Liste de tous les index
        /*
        Enumeration<String> indexes = bibli.indexes();
        System.out.println("Liste de tous les index:");
        while (indexes.hasMoreElements()) {
            System.out.println(indexes.nextElement());
        }*/



        Scanner scanner = new Scanner(System.in);

        boolean quitter = false;

        while (!quitter) {
            System.out.println("Menu principal :");
            System.out.println("1) Créer un document");
            System.out.println("2) Lister les documents");
            System.out.println("3) Rechercher les documents par critère");
            System.out.println("4) Quitter l'application");
            System.out.print("Votre choix : ");

            int choixPrincipal = scanner.nextInt();
            scanner.nextLine();

            switch (choixPrincipal) {
                case 1:
                    creerDocumentMenu(scanner, bibli);
                    break;
                case 2:


                    Enumeration<Document> documents = bibli.documents();
                    System.out.println("Liste de tous les documents:");
                    while (documents.hasMoreElements()) {
                        System.out.println(documents.nextElement());}
                    break;
                case 3:

                    Enumeration<String> indexes = bibli.indexes();
                    System.out.println("Liste de tous les index:");
                    while (indexes.hasMoreElements()) {
                        System.out.println(indexes.nextElement());
                    }

                    System.out.print("Index ? ");
                    String indexe = scanner.nextLine();
                    Enumeration<Document> docsPourIndex2 = bibli.afficherDocumentsIndex(indexe);
                    /*Enumeration<String> indexPourCassette1 = bibli.afficherIndexDocument(perio);*/
                    break;
                case 4:
                    quitter = true;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }

        scanner.close();
    }

    public static void creerDocumentMenu(Scanner scanner, Bibliotheque bibliotheque) {
        boolean retourMenuPrincipal = false;

        while (!retourMenuPrincipal) {
            System.out.println("Menu de création de document :");
            System.out.println("1) Créer une cassette");
            System.out.println("2) Créer un livre");
            System.out.println("3) Créer un périodique");
            System.out.println("4) Retour au menu principal");
            System.out.print("Votre choix : ");

            int choixCreation = scanner.nextInt();
            scanner.nextLine();

            switch (choixCreation) {
                case 1:
                    creerCassette(scanner, bibliotheque);
                    retourMenuPrincipal = true;
                    break;
                case 2:
                    creerLivre(scanner,bibliotheque);
                    retourMenuPrincipal = true;
                    break;
                case 3:
                    creerPeriodique(scanner,bibliotheque);
                    retourMenuPrincipal = true;
                    break;
                case 4:
                    retourMenuPrincipal = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }
    }

    public static void creerCassette(Scanner scanner, Bibliotheque bibliotheque) {
        System.out.print("Titre de la cassette : ");
        String titre = scanner.nextLine();

        System.out.print("Auteur de la cassette : ");
        String auteur = scanner.nextLine();

        System.out.print("Durée de la cassette : ");
        int duree = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Critères de la cassette (séparés par des virgules) : ");
        String[] criteres = scanner.nextLine().split(",");

        Cassette ca = new Cassette(titre, duree, auteur);
        bibliotheque.ajouterDocument(ca,criteres);
        System.out.println("Cassette créée avec succès !");
    }

    public static void creerPeriodique(Scanner scanner, Bibliotheque bibliotheque) {
        System.out.print("Titre du Periodique : ");
        String titre = scanner.nextLine();

        System.out.print("Frequence du Periodique : ");
        String frequ = scanner.nextLine();

        System.out.print("Nombre de page du Periodique : ");
        int page = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Critères du Periodique (séparés par des virgules) : ");
        String[] criteres = scanner.nextLine().split(",");

        Periodique pe = new Periodique(titre, page, frequ);
        bibliotheque.ajouterDocument(pe,criteres);
        System.out.println("Periodique créée avec succès !");
    }

    public static void creerLivre(Scanner scanner, Bibliotheque bibliotheque) {
        System.out.print("Titre du Livre : ");
        String titre = scanner.nextLine();

        System.out.print("Auteur du Livre : ");
        String auteur = scanner.nextLine();

        System.out.print("Editeur du Livre : ");
        String edit = scanner.nextLine();

        System.out.print("Nombre de page du Livre : ");
        int page = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Critères du Periodique (séparés par des virgules) : ");
        String[] criteres = scanner.nextLine().split(",");

        Livre li = new Livre(titre, page, auteur, edit);
        bibliotheque.ajouterDocument(li,criteres);
        System.out.println("Periodique créée avec succès !");
    }

}
