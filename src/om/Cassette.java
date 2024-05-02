package om;

import java.util.Date;

public class Cassette extends Document {

    private String auteur;
    private int duree;

    public Cassette(String titre,int duree,String auteur){
        super(titre);
        this.duree = duree;
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return super.toString()+"\nDuree : "+this.duree+"\nAuteur : "+this.auteur;
    }
}