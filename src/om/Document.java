package om;

import java.util.Date;

public class Document {
    private String titre;
    private Date creationDate;

    public Document(){
        this.titre = null;
        this.creationDate = new Date();
    }
    public Document(String titre){
        this.titre = titre;
        this.creationDate = new Date();
    }

    @Override
    public String toString() {
        return "Titre : "+this.titre+"\nDate de création : "+this.creationDate;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
