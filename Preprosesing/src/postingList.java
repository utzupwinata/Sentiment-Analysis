
import java.util.ArrayList;


public class postingList {
    double idf;
    ArrayList<Integer> indexDok;
    ArrayList<Integer> frekuensiKueri;
    ArrayList<String> namaDok;
    ArrayList<ArrayList<Integer>> frekuensiTermDiDok;
    
    
    public postingList(String nameDoc, int posisiTerm, int ind){
        indexDok = new ArrayList<>();
        frekuensiKueri = new ArrayList<>();
        namaDok = new ArrayList<>();
        frekuensiTermDiDok = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> posisi = new ArrayList<>();    
        namaDok.add(nameDoc);
        posisi.add(posisiTerm);
        frekuensiTermDiDok.add(posisi);
        indexDok.add(ind);
    }
}
