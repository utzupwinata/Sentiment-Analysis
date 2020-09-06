import java.io.*;

public class SVM {
    public static void main(String[] args) throws IOException {

        //Cleansing r = new Cleansing();
        //r.testRegex();
        
//        Replacing rep = new Replacing();
//        String token = rep.testFS("payah blm smpe nih min :(, kecewa aku karna blum smp dateng, barang belom sampai! maaf sebelomnya");
//        System.out.println(token);

        ////////////////////////////////////////////////////////////////////////

        iop proyek     = new iop();
        proyek.readFile(new File("Testing"));
        proyek.termIndexing();
        proyek.IDF();
        proyek.cobaCetak();
        proyek.Cetak2();
        
        ////////////////////////////////////////////////////////////////////////
//        Replacing Rep = new Replacing();
//        Stemming2 Stem = new Stemming2();
//        Stem.InsertKamus2();
//        String kata = "gada";
        
//        kata = Stem.CS_Stemmer22(kata);
//        System.out.println(kata);
        
//        kata = Stem.Tidak2(kata);
//        System.out.println(kata);
        
//        kata = Rep.gantiKataGaul(kata);
//        System.out.println(kata);
        
//        kata = Stem.ReplaceDPGaul2(kata);
//        System.out.println(kata);
//        
//        kata = Stem.HapusP2(kata);
//        System.out.println(kata);
//        
//        kata = Stem.HapusPP2(kata);
//        System.out.println(kata);
//        
//        kata = Stem.HapusDS2(kata);
//        System.out.println(kata);
//        
//        kata = Stem.HapusDP22(kata);
//        System.out.println(kata);
    }
    
}