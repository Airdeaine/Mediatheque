package om;

import java.util.Enumeration;

public class DocEnum implements Enumeration {
    private int position;
    private Document[] docs;

    public DocEnum(Document[] docs){
        this.docs = docs;
        this.position = 0;
    }


    @Override
    public boolean hasMoreElements() {
        return position < docs.length;
    }

    @Override
    public Object nextElement() {
        if (hasMoreElements()) {
            Document nextDoc = docs[position];
            position++;
            return nextDoc;
        }
        return null;
    }
}
