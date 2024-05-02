package om;

public class DocumentPasTrouve extends BiblioException {
    private String index;

    // Constructeur
    public DocumentPasTrouve(Bibliotheque bibliotheque, String index) {
        super(bibliotheque);
        this.index = index;
    }

    // Méthode toString pour afficher l'exception
    public String toString() {
        return "Document introuvable dans la bibliothèque '" + bibliotheque.getNom() + "' pour l'index '" + index + "'";
    }
}
