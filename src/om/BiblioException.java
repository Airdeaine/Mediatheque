package om;

class BiblioException extends Exception {
    protected Bibliotheque bibliotheque;

    // Constructeur
    public BiblioException(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }
}
