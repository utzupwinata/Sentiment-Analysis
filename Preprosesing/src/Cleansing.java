import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cleansing {
    
    public static boolean cekKata(String pola, String kata){
        Pattern p = Pattern.compile(pola);
        Matcher m = p.matcher(kata);
        return m.find();
    }
    
    
    public String hapusURL(String kata) {
        if (cekKata("j&amp;t", kata)) {
            kata = "jntexpress";
        }
        if (cekKata("^(jnt)", kata)) {
            kata = "jntexpress";
        }
        if (cekKata("^@", kata)) {
            kata = "";
        }
        else if (cekKata("^#", kata)) {
            kata = "";
        }
        else if (cekKata("^http", kata)) {
            kata = "";
        }
        else if (cekKata("^<u+", kata)) {
            kata = "";
        }
        return kata;
    }
    
    
    public String hapusTanya(String kata){
        if (cekKata("askfm", kata)) {
            kata = "";
        }
        else if (cekKata("tanyarl", kata)) {
            kata = "";
        }
        return kata;
    }
    
    public String cleanse(String kata){
        kata = hapusURL(kata);
        kata = hapusTanya(kata);
        return kata;
    }
    
//    public void testRegex(){
//        String text = "http://jenkov.com", text2 = "<U+000012";
//        
//        Pattern p = Pattern.compile("<U+");
//        Matcher m = p.matcher(text2);
//        
//        System.out.println(text2);
//        while (m.find()) {
//            text = "x";
//            System.out.println(text);
//        }
//    }
    
}
