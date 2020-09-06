
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


public class iop {
    Replacing ganti = new Replacing();
    Cleansing Removal = new Cleansing();
    Stemming Stem = new Stemming();
    Stemming2 Stem2 = new Stemming2();
    
    ArrayList<String> isiFile;
    File file[];
    int JumlahDok;    
    public void readFile(File txt) throws IOException{        
        file        = txt.listFiles();
        JumlahDok   = file.length;
        isiFile     = new ArrayList<>();
        for(int i=0; i<file.length; i++){
            BufferedReader br = new BufferedReader(new FileReader(file[i]));
            System.out.println(file[i].getAbsolutePath());
            Scanner baca    = new Scanner(br);
            String temp=""; String temp2=""; String isi = "";
            Stem.InsertKamus();
            Stem2.InsertKamus2();
            
            while(baca.hasNextLine()){
                isi = isi + baca.nextLine().toLowerCase().replaceAll("^\"|\"$", "");//.replaceAll("[^A-Za-z0-9\']", " ").trim();
            }
            System.out.println(isi);
            
            String[] kata = isi.split(" ");
            for (String loop:kata) {
                loop = Removal.cleanse(loop);
                temp = temp + loop + " ";
            }
            
            temp = temp.replaceAll("[^A-Za-z\']", " ").trim();
            temp = temp.replaceAll("\'", "").trim();
            System.out.println(temp);
            
            String[] kata2 = temp.split(" ");
            for (String loop2:kata2) {
                loop2 = ganti.ReplaceDPGaul(loop2);
                //loop2 = ganti.ReplaceDPGaul2(loop2);
                loop2 = ganti.gantiKataGaul(loop2);
                
                Stem.Cegah_Perulangan_Rule();
                loop2 = Stem.CS_Stemmer(loop2);
                Stem.Cegah_Perulangan_Rule();
                loop2 = Stem.CS_Stemmer2(loop2);
                
                Stem2.Cegah_Perulangan_Rule2();
                loop2 = Stem2.CS_Stemmer12(loop2);
                Stem.Cegah_Perulangan_Rule();
                loop2 = Stem2.CS_Stemmer22(loop2);
                
                loop2 = Stem2.Tidak2(loop2);
                
                temp2 = temp2 + loop2 + " ";
                temp2 = ganti.featureSpace(temp2);
            }
            
            //temp2 = ganti.featureSpace(temp2);
            System.out.println(temp2+"\n");
            isiFile.add(temp2);
            baca.close();
        }
    }
    
    
    ArrayList<String> stoplist;
    public boolean stopwordRemoval(String word){
        stoplist = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("stopwordlist.txt"));
            Scanner baca    = new Scanner(br);
            String kata     = "";
            while (baca.hasNext()) {                
                kata = baca.next().toLowerCase();
                stoplist.add(kata);
            }
            baca.close();
        } catch (Exception e) {
            System.out.println("Kamus Stopword Tidak Ditemukan!");
        }
        return(stoplist.contains(word));
    }
    
    
    HashMap<String, postingList> daftarTerm = new HashMap<String, postingList>();
    postingList postList;
    
    public void invertedIndex(String term, String namaDok, int posisi, int indexDok){
        if (daftarTerm.containsKey(term)) {
            postList = daftarTerm.get(term);
            if (postList.namaDok.indexOf(namaDok)<0) {
                postList.namaDok.add(namaDok);
                postList.frekuensiTermDiDok.add(new ArrayList<>());
                postList.indexDok.add(indexDok);
            }
            postList.frekuensiTermDiDok.get(postList.namaDok.indexOf(namaDok)).add(posisi);
            daftarTerm.put(term, postList);
        } else {
            daftarTerm.put(term, new postingList(namaDok, posisi, indexDok));
        }
    }
    
    
    //int sumKata[];//
    String beforeStemming;
    public void termIndexing(){
        //sumKata     = new int[isiFile.size()];//
        String isiDok, token;
        StringTokenizer st;
        for (int i = 0; i < isiFile.size(); i++) {
            System.out.println("\n=============Load Tweet " + (i+1) + "=============");
            isiDok      = isiFile.get(i);
            st          = new StringTokenizer(isiDok);    
            int posisi = 1 ;//, kata = 1;//
            while (st.hasMoreTokens()) {
                token = st.nextToken();
                //token = Removal.hapusURL(token);
                //token = Removal.hapusTanya(token);
                //token = ganti.gantiKataGaul(token);
                //System.out.println(token);------------------------------------cetak 
                
                if (token.length()>3 && !stopwordRemoval(token)) {             // tambah stopword
//                    Stem.InsertKamus();
//                    Stem.Cegah_Perulangan_Rule();
//                    token = Stem.CS_Stemmer(token);
//                    Stem.Cegah_Perulangan_Rule();
//                    token = Stem.CS_Stemmer2(token);
                    System.out.println(token);
                    invertedIndex(token, "Tweet-"+(i+1), posisi, i);
                    posisi++;
                    //kata++;//
                }
            }
            //System.out.println(" Dokumen " + (i+1) + " = " + kata + " kata");//
            //sumKata[i] = kata;//
            System.out.println("=============Tweet " +(i+1) + " Loaded=============");
        }
    }
    
    
    public void IDF(){
        double temp_y, temp_z;
        //double temp_x = 5;        
        for (Map.Entry<String, postingList> entry: daftarTerm.entrySet()) {
            postList = daftarTerm.get(entry.getKey());
            temp_y = JumlahDok;
            temp_z = entry.getValue().namaDok.size();
            //temp_x = temp_y/temp_z;
            postList.idf = Math.log10(temp_y/temp_z);
            //System.out.println("\n postList.idf = " + postList.idf);
            daftarTerm.put(entry.getKey(), postList);
        }
    }
    
    
//    double bobotDok[][];
//    public void bobotDokumen(){
//        bobotDok = new double[daftarTerm.size()][JumlahDok];
//        int a = 0;
//        for (Map.Entry<String, postingList> entry: daftarTerm.entrySet()) {
//            for (int i=0; i<entry.getValue().namaDok.size(); i++) {
//                bobotDok[a][entry.getValue().indexDok.get(i)] =
//                        entry.getValue().frekuensiTermDiDok.get(i).size() * entry.getValue().idf;
//            }
//            a++;
//        }
//    }
    
    public void cobaCetak() {
        System.out.println();
	for(Map.Entry<String, postingList> entry : daftarTerm.entrySet()) {
		System.out.print(entry.getKey()+" : "); //Term
		for(int i=0; i<entry.getValue().namaDok.size(); i++) {
			System.out.print(entry.getValue().namaDok.get(i)+"");
			System.out.print("(TF="+entry.getValue().frekuensiTermDiDok.get(i).size() +/*" : "
					+entry.getValue().frekuensiTermDiDok.get(i)+ */" |IDF: " + entry.getValue().idf +")");
                        //Term : Nama dokumen (Frekuensi=x : [p,o,s,i,s,i])
			System.out.print(",");
		}
		System.out.println();
	}
    }
    
    public void Cetak(){
        System.out.println();
        DecimalFormat koma = new DecimalFormat("###.####");
        double tf;
        double idf;
        for (Map.Entry<String, postingList> entry: daftarTerm.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (int i=0; i<entry.getValue().namaDok.size(); i++) {
                tf  = entry.getValue().frekuensiTermDiDok.get(i).size();
                idf = entry.getValue().idf;
                System.out.print(entry.getValue().namaDok.get(i));
                System.out.print("(TF=" + tf + ":" + entry.getValue().frekuensiTermDiDok.get(i)+")");//+ " | IDF=" + koma.format(idf) + " | TF-IDF=" + koma.format(tf*idf) + ")");
                //System.out.print("(TF-IDF=" + koma.format(tf*idf) + ")");
                //tf  = tf/sumKata[i];//
                
                System.out.print("(IDF=" + koma.format(idf));//
                System.out.print("; ");
            }
            System.out.println();
        }
    }
    
    public void Cetak2(){
        System.out.println();
        DecimalFormat koma = new DecimalFormat("###.####");
        double tf;
        double idf;
        for (Map.Entry<String, postingList> entry: daftarTerm.entrySet()) {
            for (int i=0; i<entry.getValue().namaDok.size(); i++) {
                tf  = entry.getValue().frekuensiTermDiDok.get(i).size();
                //tf  = Math.log(tf)+1;                                       // log(1+tf)
                idf = entry.getValue().idf;
                System.out.print(entry.getKey() + " : ");
                System.out.print(entry.getValue().namaDok.get(i));
                System.out.print("(TF-IDF=" + koma.format(tf*idf) + ")");
                System.out.print(";\n");
            }
            System.out.println();
        }
    }
    
    public void Cetak3(){
        System.out.println();
        DecimalFormat koma = new DecimalFormat("###.####");
        double tf;
        double idf;
        for (Map.Entry<String, postingList> entry: daftarTerm.entrySet()) {
            if ("nofast".equals(entry.getKey())) {
                for (int i=0; i<entry.getValue().namaDok.size(); i++) {
                    tf  = entry.getValue().frekuensiTermDiDok.get(i).size();
                    idf = entry.getValue().idf;
                    System.out.print(entry.getKey() + " : ");
                    System.out.print(entry.getValue().namaDok.get(i));
                    System.out.print("(TF-IDF=" + koma.format(tf*idf) + ")");
                    System.out.print(";\n");
                }
            }
            System.out.println();
            if ("nosent".equals(entry.getKey())) {
                for (int i=0; i<entry.getValue().namaDok.size(); i++) {
                    tf  = entry.getValue().frekuensiTermDiDok.get(i).size();
                    idf = entry.getValue().idf;
                    System.out.print(entry.getKey() + " : ");
                    System.out.print(entry.getValue().namaDok.get(i));
                    System.out.print("(TF-IDF=" + koma.format(tf*idf) + ")");
                    System.out.print(";\n");
                }
            }
            System.out.println();
            if ("nohappy".equals(entry.getKey())) {
                for (int i=0; i<entry.getValue().namaDok.size(); i++) {
                    tf  = entry.getValue().frekuensiTermDiDok.get(i).size();
                    idf = entry.getValue().idf;
                    System.out.print(entry.getKey() + " : ");
                    System.out.print(entry.getValue().namaDok.get(i));
                    System.out.print("(TF-IDF=" + koma.format(tf*idf) + ")");
                    System.out.print(";\n");
                }
            }
            if ("yessent".equals(entry.getKey())) {
                for (int i=0; i<entry.getValue().namaDok.size(); i++) {
                    tf  = entry.getValue().frekuensiTermDiDok.get(i).size();
                    idf = entry.getValue().idf;
                    System.out.print(entry.getKey() + " : ");
                    System.out.print(entry.getValue().namaDok.get(i));
                    System.out.print("(TF-IDF=" + koma.format(tf*idf) + ")");
                    System.out.print(";\n");
                }
            }
            if ("yesfast".equals(entry.getKey())) {
                for (int i=0; i<entry.getValue().namaDok.size(); i++) {
                    tf  = entry.getValue().frekuensiTermDiDok.get(i).size();
                    idf = entry.getValue().idf;
                    System.out.print(entry.getKey() + " : ");
                    System.out.print(entry.getValue().namaDok.get(i));
                    System.out.print("(TF-IDF=" + koma.format(tf*idf) + ")");
                    System.out.print(";\n");
                }
            }
            if ("yeshappy".equals(entry.getKey())) {
                for (int i=0; i<entry.getValue().namaDok.size(); i++) {
                    tf  = entry.getValue().frekuensiTermDiDok.get(i).size();
                    idf = entry.getValue().idf;
                    System.out.print(entry.getKey() + " : ");
                    System.out.print(entry.getValue().namaDok.get(i));
                    System.out.print("(TF-IDF=" + koma.format(tf*idf) + ")");
                    System.out.print(";\n");
                }
            }
//            for (int i=0; i<entry.getValue().namaDok.size(); i++) {
//                tf  = entry.getValue().frekuensiTermDiDok.get(i).size();
//                idf = entry.getValue().idf;
//                System.out.print(entry.getKey() + " : ");
//                System.out.print(entry.getValue().namaDok.get(i));
//                System.out.print("(TF-IDF=" + koma.format(tf*idf) + ")");
//                System.out.print(";\n");
//            }
            
        }
    }
    
}