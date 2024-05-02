package om;

import om.Document;

public class Livre extends Document {

    private String auteur;
    private String editeur;
    private int page;

    public Livre(String titre,int page,String auteur,String editeur){
        super(titre);
        this.page = page;
        this.auteur = auteur;
        this.editeur = editeur;
    }

    @Override
    public String toString() {
        return super.toString()+"\nPage : "+this.page+"\nAuteur : "+this.auteur+"\nEditeur : "+this.editeur;
    }
}
