package om;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class Bibliotheque {
    private String nom;
    private Hashtable<Document, Vector<String>> documentToIndex;
    private Hashtable<String, Vector<Document>> indexToDocuments;
    private Vector<Document> allDocuments;

    // Constructeur
    public Bibliotheque(String nom) {
        this.nom = nom;
        documentToIndex = new Hashtable<>();
        indexToDocuments = new Hashtable<>();
        allDocuments = new Vector<>();
    }

    // Méthode pour ajouter un document avec ses index associés
    public void ajouterDocument(Document doc, String[] indexes) {
        // Ajouter le document à la liste de tous les documents
        allDocuments.addElement(doc);

        for (String index : indexes) {
            // Associer l'index au document
            if (indexToDocuments.containsKey(index)) {
                indexToDocuments.get(index).addElement(doc);
            } else {
                Vector<Document> documents = new Vector<>();
                documents.addElement(doc);
                indexToDocuments.put(index, documents);
            }

            // Associer le document à l'index
            if (documentToIndex.containsKey(doc)) {
                documentToIndex.get(doc).addElement(index);
            } else {
                Vector<String> indices = new Vector<>();
                indices.addElement(index);
                documentToIndex.put(doc, indices);
            }
        }
    }

    // Méthode pour obtenir le nom de la bibliothèque
    public String getNom() {
        return nom;
    }

    // Méthode toString pour afficher le nom de la bibliothèque
    public String toString() {
        return "Bibliothèque : " + nom;
    }

    // Méthode pour obtenir une énumération des documents pour un index donné
    public Enumeration<Document> trouverDocumentsIndex(String index) {
        if (indexToDocuments.containsKey(index)) {
            return indexToDocuments.get(index).elements();
        } else {
            return null;
        }
    }

    public Enumeration<Document> afficherDocumentsIndex(String index) throws DocumentPasTrouve {
        Enumeration<Document> enumeration = trouverDocumentsIndex(index);


            if (enumeration != null) {
                System.out.println("\nDocument associés à l'index :\n");
                while (enumeration.hasMoreElements()) {
                    Document document = enumeration.nextElement();
                    // Afficher les détails du document ou le traiter selon vos besoins
                    System.out.println(document); // Ou autre chose, selon la structure de Document
                }
            } else {
                throw  new DocumentPasTrouve(this, index);
            }
        return enumeration;
    }

    // Méthode pour obtenir une énumération des index pour un document donné
    public Enumeration<String> trouverIndexDocument(Document doc) {
        if (documentToIndex.containsKey(doc)) {
            return documentToIndex.get(doc).elements();
        } else {
            return null;
        }
    }

    public Enumeration<String> afficherIndexDocument(Document doc) {
        Enumeration<String> indexEnumeration = trouverIndexDocument(doc);

            if (indexEnumeration != null) {
                System.out.println("\nIndex associés au document :\n");
                while (indexEnumeration.hasMoreElements()) {
                    String index = indexEnumeration.nextElement();
                    System.out.println(index);
                }
            } else {
                System.out.println("Le document n'est associé à aucun index.");
            }
            return indexEnumeration;
    }


    // Méthode pour obtenir une énumération de tous les index
    public Enumeration<String> indexes() {
        return indexToDocuments.keys();
    }

    // Méthode pour obtenir une énumération de tous les documents
    public Enumeration<Document> documents() {
        return allDocuments.elements();
    }
}
