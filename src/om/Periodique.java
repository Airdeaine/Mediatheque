package om;

import om.Document;

public class Periodique extends Document {

    private String frequence;
    private int page;

    public Periodique(String titre,int page,String frequence){
        super(titre);
        this.page = page;
        this.frequence = frequence;
    }

    @Override
    public String toString() {
        return super.toString()+"\nPage : "+this.page+"\nFrequence : "+this.frequence;
    }
}
