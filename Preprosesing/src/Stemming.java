import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stemming {
//    Replacing ganti = new Replacing();
    ArrayList<String> kata_dasar;
    
    public void InsertKamus() {
        kata_dasar   = new ArrayList<>();
        try{
            BufferedReader br   = new BufferedReader(new FileReader("rootwords.txt"));
            try (Scanner read = new Scanner(br)) {
                String rootwords    = " ";
                while(read.hasNextLine()){
                    rootwords       = read.next().toLowerCase().replaceAll("[^A-Za-z0-9/']", "").trim();
                    kata_dasar.add(rootwords);
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Kamus Kata Dasar Tidak Ada!");
        }
    }
//______________________________________________________________________________
    public boolean CheckKamus(String kata) {
        if(kata_dasar.contains(kata)) {
            return true;
        }
        return false;
    }
//______________________________________________________________________________
    public boolean TigaHuruf(String kata) {   
        return kata.length()<=3;
    }
//______________________________________________________________________________
    public boolean RulePrecedence(String kata){
        if(kata.startsWith("be") && kata.endsWith("lah"))
            return true;
        else if(kata.startsWith("be") && kata.endsWith("an"))
            return true;
        else if(kata.startsWith("me") && kata.endsWith("i"))
            return true;
        else if(kata.startsWith("di") && kata.endsWith("i"))
            return true;
        else if(kata.startsWith("pe") && kata.endsWith("i"))
            return true;
        else if(kata.startsWith("ter") && kata.endsWith("i"))
            return true;
        return false;
    }
//______________________________________________________________________________
    public boolean WrongCombination(String token) {
        if(token.startsWith("ber")&& token.endsWith("i"))
            return true;
        else if(token.startsWith("di")&& token.endsWith("an"))
            return true;
        else if(token.startsWith("ke")&& token.endsWith("i"))
            return true;
        else if(token.startsWith("ke")&& token.endsWith("kan"))
            return true;
        else if(token.startsWith("me")&& token.endsWith("an"))
            return true;
        else if(token.startsWith("ter")&& token.endsWith("an"))
            return true;
        else if(token.startsWith("per")&& token.endsWith("an"))
            return true;
        return false;
    }
//______________________________________________________________________________
    public static boolean CheckWord(String pattern, String token){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(token);
        return m.find();
    }

    String register, register2;
    ArrayList<String> hasil_stem = new ArrayList<>();
//______________________________________________________________________________
    public String HapusP(String kata){
        if(kata_dasar.contains(kata)){
            return kata;
        }
        if(CheckWord("([kl]ah|pun)$",kata)){
            register = kata.substring(0, kata.length()-3);
            return register;
        }
        return kata;
    }
//______________________________________________________________________________
    public String HapusPP(String kata){
        if(kata_dasar.contains(kata)){
            return kata;
        }
        if(CheckWord("(q)$", kata)){
            register = kata.substring(0, kata.length()-1);
            return register;
        }
        if(CheckWord("(ku|mu|qu)$", kata)){
            register = kata.substring(0, kata.length()-2);
            return register;
        }
        if(CheckWord("(nya)$", kata)){
            register = kata.substring(0, kata.length()-3);
            return register;
        }
        if(CheckWord("(ny)$", kata)){///////////////////////////////////////////
            register = kata.substring(0, kata.length()-2);
            return register;
        }
        return kata;
    }
//______________________________________________________________________________
    public String HapusDS(String kata){
        if(kata_dasar.contains(kata)){
            return kata;
        }
        if(WrongCombination(kata)){
            return kata;
        }
        if(CheckWord("(i)$", kata)){
            register = kata.substring(0, kata.length()-1);
            return register;
        }
        if(CheckWord("(in)$", kata)){
            register = kata.substring(0, kata.length()-2);
            return register;
        }
        if(CheckWord("(kan)$", kata)){
            register = kata.substring(0, kata.length()-3);
            return register;
        }
        if(CheckWord("(an)$", kata)){
            register = kata.substring(0, kata.length()-2);
            return register;
        }
        return kata;
    }
//______________________________________________________________________________
    int rule1, rule2, rule3, rule4, rule5, rule6, rule7, rule8, rule9, rule10;
    int rule11, rule12, rule13, rule14, rule15, rule16, rule17, rule18, rule19, rule20;
    int rule21, rule23, rule24, rule25, rule26, rule27, rule28, rule29, rule30;
    int rule31, rule32, rule33, rule34, rule35, rule36, ruledikese, ruled, ruleny;
    
    public void Cegah_Perulangan_Rule(){
        rule1=1; rule2=1; rule3=1; rule4=1; rule5=1; rule6=1; rule7=1; rule8=1; rule9=1; rule10=1;
        rule11=1; rule12=1; rule13=1; rule14=1; rule15=1; rule16=1; rule17=1; rule18=1; rule19=1; rule20=1;
        rule21=1; rule23=1; rule24=1; rule25=1; rule26=1; rule27=1; rule28=1; rule29=1; rule30=1;
        rule31=1; rule32=1; rule33=1; rule34=1; rule35=1; rule36=1; ruledikese=1; ruled=1; ruleny=1;
    }
//______________________________________________________________________________
    public String HapusDP(String kata){
        //Check Kamus
        if(kata_dasar.contains(kata)){
            return kata;
        }
        
        //RULE 1
        if(CheckWord("^(ber)[aiueo]", kata)){
            if(rule1<2){
                register = kata.substring(3, kata.length());
                if(kata_dasar.contains(register)){
                    rule1++;
                    return register;
                }
                register = kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    rule1++;
                    return register;
                }
                rule1++;
                return register;
                }
        }
        
        //RULE 2
        if(CheckWord("^(ber)[^aiueor][a-z](?!er)", kata)){
            if(rule2<2){
                register = kata.substring(3, kata.length());
                rule2++;
                return register;
            }
        }
        
        //RULE 3
        if(CheckWord("^(ber)[^aiueor][a-z](er)[aiueo]", kata)){
            if(rule3<2){
                register = kata.substring(3, kata.length());
                rule3++;
                return register;
            }
        }
        
        //RULE 4
        if(CheckWord("(belajar|belunjur)", kata)){
            if(rule4<2){
                register = kata.substring(3, kata.length());
                rule4++;
                return register;
            }
        }
                
        //RULE 5
        if(CheckWord("^(be)[^aiueolr](er)[^aiueo]", kata)){
            if(rule5<2){
                register = kata.substring(2, kata.length());
                rule5++;
                return register;
            }
        }
        
        ////////////////////////////////////////////////////////////////////////
        //RULE 6
        if(CheckWord("^(ter)[aiueo]", kata)){
            if(rule6<2){
                register = kata.substring(3, kata.length());
                if(kata_dasar.contains(register)){
                    rule6++;
                    return register;
                }
                register = kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    rule6++;
                    return register;
                }
                rule6++;
                return register;
            }
        }
        
        //RULE 7
        if(CheckWord("^(ter)[^aiueor](er)[aiueo]", kata)){
            if(rule7<2){
                register = kata.substring(3, kata.length());
                rule7++;
                return register;
            }
        }
        
        //RULE 8
        if(CheckWord("^(ter)[^aiueor](?!er)", kata)){
            if(rule8<2){
                register = kata.substring(3, kata.length());
                rule8++;
                return register;
            }
        }
        
        //RULE 9
        if(CheckWord("^(te)[^aiueor](er)[^aiueo]", kata)){
            if(rule9<2){
                register = kata.substring(2, kata.length());
                rule9++;
                return register;
            }
        }
        
        //RULE 10
        if(CheckWord("^(me)[lrwy][aiueo]", kata)){
            if(rule10<2){
                register = kata.substring(2, kata.length());
                rule10++;
                return register;
            }
        }
        
        //RULE 11
        if(CheckWord("^(mem)[bfv]", kata)){
            if(rule11<2){
                register = kata.substring(3, kata.length());
                rule11++;
                return register;
            }
        }
        
        //RULE 12
        if(CheckWord("^(mempe)", kata)){
            if(rule12<2){
                register = kata.substring(3, kata.length());
                rule12++;
                return register;
            }
        }
        
        //RULE 13
        if(CheckWord("^(mem)((r[aiueo])|[aiueo])", kata)){
            if(rule13<2){
                register = kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    rule13++;
                    return register;
                }
                register = "p" + kata.substring(3, kata.length());
                if(kata_dasar.contains(register)){
                    rule13++;
                    return register;
                }
                rule13++;
                return register;
            }
        }
        
        //RULE 14
        if(CheckWord("^(men)[cdjz]", kata)){
            if(rule14<2){
                register = kata.substring(3, kata.length());
                rule14++;
                return register;
            }
        }
        
        //RULE 15
        if(CheckWord("^(men)[aiueo]", kata)){
            if(rule15<2){
                register = kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    rule15++;
                    return register;
                }
                register = "t" + kata.substring(3, kata.length());
                if(kata_dasar.contains(register)){
                    rule15++;
                    return register;
                }
                rule15++;
                return register;
            }
        }
        
        //RULE 16
        if(CheckWord("^(meng)[ghkq]", kata)){
            if(rule16<2){
                register = kata.substring(4, kata.length());
                rule16++;
                return register;
            }
        }
        
        //RULE 17
        if(CheckWord("^(meng)[aiueo]", kata)){
            if(rule17<2){
                register = kata.substring(4, kata.length());
                if(kata_dasar.contains(register)){
                    rule17++;
                    return register;
                }
                register = "k" + kata.substring(4, kata.length());
                if(kata_dasar.contains(register)){
                    rule17++;
                    return register;
                }
                rule17++;
                return register;
            }
        }
        
        //RULE 18
        if(CheckWord("^(meny)[aiueo]", kata)){
            if(rule18<2){
                register = "s" + kata.substring(4, kata.length());
                rule18++;
                return register;
            }
        }
        
        //RULE 19
        if(CheckWord("^(memp)[aiuo]", kata)){
            if(rule19<2){
                register = kata.substring(3, kata.length());
                rule19++;
                return register;
            }
        }
        
        //RULE 20
        if(CheckWord("^(pe)[wy][aiueo]", kata)){
            if(rule20<2){
                register = kata.substring(2, kata.length());
                rule20++;
                return register;
            }
        }
        
        //RULE 21
        if(CheckWord("^(per)[aiueo]", kata)){
            if(rule21<2){
                register = kata.substring(3, kata.length());
                if(kata_dasar.contains(register)){
                    rule21++;
                    return register;
                }
                register = kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    rule21++;
                    return register;
                }
                rule21++;
                return register;
            }
        }
        
        //RULE 23
        if(CheckWord("^(per)[^aiueor][a-z](?!er)", kata)){
            if(rule23<2){
                register = kata.substring(3, kata.length());
                rule23++;
                return register;
            }
        }
        
        //RULE 24
        if(CheckWord("^(per)[^aiueor][a-z](er)[aiueo]", kata)){
            if(rule24<2){
                register = kata.substring(3, kata.length());
                rule24++;
                return register;
            }
        }
        
        //RULE 25
        if(CheckWord("^(pem)[bfv]", kata)){
            if(rule25<2){
                register = kata.substring(3, kata.length());
                rule25++;
                return register;
            }
        }
        
        //RULE 26
        if(CheckWord("^(pem)[[r[aiueo]]|[aiueo]]", kata)){
            if(rule26<2){
                register = kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    rule26++;
                    return register;
                }
                register = "p" + kata.substring(3, kata.length());
                if(kata_dasar.contains(register)){
                    rule26++;
                    return register;
                }
                rule26++;
                return register;
            }
        }
        
        //RULE 27
        if(CheckWord("^(pen)[cdjz]", kata)){
            if(rule27<2){
                register = kata.substring(3, kata.length());
                rule27++;
                return register;
            }
        }
        
        //RULE 28
        if(CheckWord("^(pen)[aiueo]", kata)){
            if(rule28<2){
                register = kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    rule28++;
                    return register;
                }
                register = "t" + kata.substring(3, kata.length());
                if(kata_dasar.contains(register)){
                    rule28++;
                    return register;
                }
                rule28++;
                return register;
            }
        }
        
        //RULE 29
        if(CheckWord("^(peng)[ghq]", kata)){
            if(rule29<2){
                register = kata.substring(4, kata.length());
                rule29++;
                return register;
            }
        }
        
        //RULE 30
        if(CheckWord("^(peng)[aiueo]", kata)){
            if(rule30<2){
                register = kata.substring(4, kata.length());
                if(kata_dasar.contains(register)){
                    rule30++;
                    return register;
                }
                register = "k" + kata.substring(4, kata.length());
                if(kata_dasar.contains(register)){
                    rule30++;
                    return register;
                }
                rule30++;
                return register;
            }
        }
        
        //RULE 31
        if(CheckWord("^(peny)[aiueo]", kata)){
            if(rule31<2){
                register = "s" + kata.substring(4, kata.length());
                rule31++;
                return register;
            }
        }
        
        //RULE 32
        if(CheckWord("^(pel)[aiueo]", kata)){
            if(rule32<2){
                register = kata.substring(2, kata.length());
                rule32++;
                return register;
            }
        }
        
        //RULE 33
        if(CheckWord("^(pe)[^aiueorwylmn](er)[aiueo]", kata)){
            if(rule33<2){
                register = kata.substring(2, kata.length());
                rule33++;
                return register;
            }
        }
        
        //RULE 34
        if(CheckWord("^(pe)[^aiueorwylmn](?!er)", kata)){
            if(rule34<2){
                register = kata.substring(2, kata.length());
                rule34++;
                return register;
            }
        }
        
        //RULE 35
        if(CheckWord("^(ter)[^aiueor](er)[^aiueo]", kata)){
            if(rule35<2){
                register = kata.substring(3, kata.length());
                rule35++;
                return register;
            }
        }
        
        //RULE 36
        if(CheckWord("^(pe)[^aiueorwylmn](er)[^aiueo]", kata)){
            if(rule36<2){
                register = kata.substring(2, kata.length());
                rule36++;
                return register;
            }
        }
        
        //RULE di,ke,se
        if(CheckWord("^(di)|(ke)|(se)", kata)){
            if(ruledikese<2){
                register = kata.substring(2, kata.length());
                ruledikese++;
                return register;
            }
        }
        
        //RULE d
        if(CheckWord("^(d)", kata)){
            if(ruled<2){
                register = kata.substring(1, kata.length());
                ruled++;
                return register;
            }
        }
        
        //RULE ny
        if(CheckWord("^(ny)", kata)){
            if(ruleny<2){
                register = "c" + kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    ruleny++;
                    return register;
                }
                register = "s" + kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    ruleny++;
                    return register;
                }
                ruleny++;
                return kata;
            }
        }
        
        return kata;
    }
//______________________________________________________________________________
    public String HapusDP2(String kata){
        //Check Kamus
        if(kata_dasar.contains(kata)){
            return kata;
        }
        
        //RULE 1
        if(CheckWord("^(ber)[aiueo]", kata)){
            if(rule1<2){
                register = kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    rule1++;
                    return register;
                }
                register = kata.substring(3, kata.length());
                if(kata_dasar.contains(register)){
                    rule1++;
                    return register;
                }
                rule1++;
                return register;
                }
        }
        
        //RULE 2
        if(CheckWord("^(ber)[^aiueor][a-z](?!er)", kata)){
            if(rule2<2){
                register = kata.substring(3, kata.length());
                rule2++;
                return register;
            }
        }
        
        //RULE 3
        if(CheckWord("^(ber)[^aiueor][a-z](er)[aiueo]", kata)){
            if(rule3<2){
                register = kata.substring(3, kata.length());
                rule3++;
                return register;
            }
        }
        
        //RULE 4
        if(CheckWord("(belajar|belunjur)", kata)){
            if(rule4<2){
                register = kata.substring(3, kata.length());
                rule4++;
                return register;
            }
        }
                
        //RULE 5
        if(CheckWord("^(be)[^aiueolr](er)[^aiueo]", kata)){
            if(rule5<2){
                register = kata.substring(2, kata.length());
                rule5++;
                return register;
            }
        }
        
        //RULE 6
        if(CheckWord("^(ter)[aiueo]", kata)){
            if(rule6<2){
                register = kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    rule6++;
                    return register;
                }
                register = kata.substring(3, kata.length());
                if(kata_dasar.contains(register)){
                    rule6++;
                    return register;
                }
                rule6++;
                return register;
            }
        }
        
        //RULE 7
        if(CheckWord("^(ter)[^aiueor](er)[aiueo]", kata)){
            if(rule7<2){
                register = kata.substring(3, kata.length());
                rule7++;
                return register;
            }
        }
        
        //RULE 8
        if(CheckWord("^(ter)[^aiueor](?!er)", kata)){
            if(rule8<2){
                register = kata.substring(3, kata.length());
                rule8++;
                return register;
            }
        }
        
        //RULE 9
        if(CheckWord("^(te)[^aiueor](er)[^aiueo]", kata)){
            if(rule9<2){
                register = kata.substring(2, kata.length());
                rule9++;
                return register;
            }
        }
        
        ////////////////////////////////////////////////////////////////////////
        //RULE 10
        if(CheckWord("^(me)[lrwy][aiueo]", kata)){
            if(rule10<2){
                register = kata.substring(2, kata.length());
                rule10++;
                return register;
            }
        }
        
        //RULE 11
        if(CheckWord("^(mem)[bfv]", kata)){
            if(rule11<2){
                register = kata.substring(3, kata.length());
                rule11++;
                return register;
            }
        }
        
        //RULE 12
        if(CheckWord("^(mempe)", kata)){
            if(rule12<2){
                register = kata.substring(3, kata.length());
                rule12++;
                return register;
            }
        }
        
        //RULE 13
        if(CheckWord("^(mem)((r[aiueo])|[aiueo])", kata)){
            if(rule13<2){
                register = "p" + kata.substring(3, kata.length());
                if(kata_dasar.contains(register)){
                    rule13++;
                    return register;
                }
                register = kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    rule13++;
                    return register;
                }
                rule13++;
                return register;
            }
        }
        
        //RULE 14
        if(CheckWord("^(men)[cdjz]", kata)){
            if(rule14<2){
                register = kata.substring(3, kata.length());
                rule14++;
                return register;
            }
        }
        
        //RULE 15
        if(CheckWord("^(men)[aiueo]", kata)){
            if(rule15<2){
                register = "t" + kata.substring(3, kata.length());
                if(kata_dasar.contains(register)){
                    rule15++;
                    return register;
                }
                register = kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    rule15++;
                    return register;
                }
                rule15++;
                return register;
            }
        }
        
        //RULE 16
        if(CheckWord("^(meng)[ghkq]", kata)){
            if(rule16<2){
                register = kata.substring(4, kata.length());
                rule16++;
                return register;
            }
        }
        
        //RULE 17
        if(CheckWord("^(meng)[aiueo]", kata)){
            if(rule17<2){
                register = "k" + kata.substring(4, kata.length());
                if(kata_dasar.contains(register)){
                    rule17++;
                    return register;
                }
                register = kata.substring(4, kata.length());
                if(kata_dasar.contains(register)){
                    rule17++;
                    return register;
                }
                rule17++;
                return register;
            }
        }
        
        //RULE 18
        if(CheckWord("^(meny)[aiueo]", kata)){
            if(rule18<2){
                register = "s" + kata.substring(4, kata.length());
                rule18++;
                return register;
            }
        }
        
        //RULE 19
        if(CheckWord("^(memp)[aiuo]", kata)){
            if(rule19<2){
                register = kata.substring(3, kata.length());
                rule19++;
                return register;
            }
        }
        
        //RULE 20
        if(CheckWord("^(pe)[wy][aiueo]", kata)){
            if(rule20<2){
                register = kata.substring(2, kata.length());
                rule20++;
                return register;
            }
        }
        
        //RULE 21
        if(CheckWord("^(per)[aiueo]", kata)){
            if(rule21<2){
                register = kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    rule21++;
                    return register;
                }
                register = kata.substring(3, kata.length());
                if(kata_dasar.contains(register)){
                    rule21++;
                    return register;
                }
                rule21++;
                return register;
            }
        }
        
        //RULE 23
        if(CheckWord("^(per)[^aiueor][a-z](?!er)", kata)){
            if(rule23<2){
                register = kata.substring(3, kata.length());
                rule23++;
                return register;
            }
        }
        
        //RULE 24
        if(CheckWord("^(per)[^aiueor][a-z](er)[aiueo]", kata)){
            if(rule24<2){
                register = kata.substring(3, kata.length());
                rule24++;
                return register;
            }
        }
        
        //RULE 25
        if(CheckWord("^(pem)[bfv]", kata)){
            if(rule25<2){
                register = kata.substring(3, kata.length());
                rule25++;
                return register;
            }
        }
        
        //RULE 26
        if(CheckWord("^(pem)[[r[aiueo]]|[aiueo]]", kata)){
            if(rule26<2){
                register = "p" + kata.substring(3, kata.length());
                if(kata_dasar.contains(register)){
                    rule26++;
                    return register;
                }
                register = kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    rule26++;
                    return register;
                }
                rule26++;
                return register;
            }
        }
        
        //RULE 27
        if(CheckWord("^(pen)[cdjz]", kata)){
            if(rule27<2){
                register = kata.substring(3, kata.length());
                rule27++;
                return register;
            }
        }
        
        //RULE 28
        if(CheckWord("^(pen)[aiueo]", kata)){
            if(rule28<2){
                register = "t" + kata.substring(3, kata.length());
                if(kata_dasar.contains(register)){
                    rule28++;
                    return register;
                }
                register = kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    rule28++;
                    return register;
                }
                rule28++;
                return register;
            }
        }
        
        //RULE 29
        if(CheckWord("^(peng)[ghq]", kata)){
            if(rule29<2){
                register = kata.substring(4, kata.length());
                rule29++;
                return register;
            }
        }
        
        //RULE 30
        if(CheckWord("^(peng)[aiueo]", kata)){
            if(rule30<2){
                register = "k" + kata.substring(4, kata.length());
                if(kata_dasar.contains(register)){
                    rule30++;
                    return register;
                }
                register = kata.substring(4, kata.length());
                if(kata_dasar.contains(register)){
                    rule30++;
                    return register;
                }
                rule30++;
                return register;
            }
        }
        
        //RULE 31
        if(CheckWord("^(peny)[aiueo]", kata)){
            if(rule31<2){
                register = "s" + kata.substring(4, kata.length());
                rule31++;
                return register;
            }
        }
        
        //RULE 32
        if(CheckWord("^(pel)[aiueo]", kata)){
            if(rule32<2){
                register = kata.substring(2, kata.length());
                rule32++;
                return register;
            }
        }
        
        //RULE 33
        if(CheckWord("^(pe)[^aiueorwylmn](er)[aiueo]", kata)){
            if(rule33<2){
                register = kata.substring(2, kata.length());
                rule33++;
                return register;
            }
        }
        
        //RULE 34
        if(CheckWord("^(pe)[^aiueorwylmn](?!er)", kata)){
            if(rule34<2){
                register = kata.substring(2, kata.length());
                rule34++;
                return register;
            }
        }

        //RULE 35
        if(CheckWord("^(ter)[^aiueor](er)[^aiueo]", kata)){
            if(rule35<2){
                register = kata.substring(3, kata.length());
                rule35++;
                return register;
            }
        }
        
        //RULE 36
        if(CheckWord("^(pe)[^aiueorwylmn](er)[^aiueo]", kata)){
            if(rule36<2){
                register = kata.substring(2, kata.length());
                rule36++;
                return register;
            }
        }
        
        //RULE di,ke,se
        if(CheckWord("^(di)|(ke)|(se)", kata)){
            if(ruledikese<2){
                register = kata.substring(2, kata.length());
                ruledikese++;
                return register;
            }
        }
        
        //RULE d
        if(CheckWord("^(d)", kata)){
            if(ruled<2){
                register = kata.substring(1, kata.length());
                ruled++;
                return register;
            }
        }
        
        //RULE ny
        if(CheckWord("^(ny)", kata)){
            if(ruleny<2){
                register = "c" + kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    ruleny++;
                    return register;
                }
                register = "s" + kata.substring(2, kata.length());
                if(kata_dasar.contains(register)){
                    ruleny++;
                    return register;
                }
                ruleny++;
                return kata;
            }
        }
        
        return kata;
    }
//______________________________________________________________________________
    String temporary;
    
    public String Stemmer_NA(String kata){
        if(TigaHuruf(kata)){
            return  kata;
        }
        
        if(CheckKamus(kata)){
            return kata;
        }
        
        temporary = HapusP(kata);//--------------------------------------------- Hapus Partikel
        if(CheckKamus(temporary)){
            return temporary;
        }
        
        temporary = HapusPP(temporary);//--------------------------------------- Hapus Posessive Partikel
        if(CheckKamus(temporary)){
            return temporary;
        }
        
        temporary = HapusDS(temporary);//--------------------------------------- Hapus akhiran/suffix
        if(CheckKamus(temporary)){
            return temporary;
        }
        
        temporary = HapusDP(temporary);//--------------------------------------- Hapus awalan/prefix
        if(CheckKamus(temporary)){
            return temporary;
        }
        
        temporary = HapusDP(temporary);//--------------------------------------- Hapus awalan/prefix
        if(CheckKamus(temporary)){
            return temporary;
        }
        
        temporary = HapusDP(temporary);//--------------------------------------- Hapus awalan/prefix
        if(CheckKamus(temporary)){
            return temporary;
        }
        return kata;
    }
//______________________________________________________________________________
    public String Stemmer_NA2(String kata){
        if(TigaHuruf(kata)){
            return  kata;
        }
        
        if(CheckKamus(kata)){
            return kata;
        }
        
        temporary = HapusP(kata);//--------------------------------------------- Hapus Partikel
        if(CheckKamus(temporary)){
            return temporary;
        }
        
        temporary = HapusPP(temporary);//--------------------------------------- Hapus Posessive Partikel
        if(CheckKamus(temporary)){
            return temporary;
        }
        
        temporary = HapusDS(temporary);//--------------------------------------- Hapus akhiran/suffix
        if(CheckKamus(temporary)){
            return temporary;
        }
        
        temporary = HapusDP2(temporary);//--------------------------------------- Hapus awalan/prefix
        if(CheckKamus(temporary)){
            return temporary;
        }
        
        temporary = HapusDP2(temporary);//--------------------------------------- Hapus awalan/prefix
        if(CheckKamus(temporary)){
            return temporary;
        }
        
        temporary = HapusDP2(temporary);//--------------------------------------- Hapus awalan/prefix
        if(CheckKamus(temporary)){
            return temporary;
        }
        return kata;
    }
//______________________________________________________________________________
    public String CS_Stemmer(String kata){
        if(TigaHuruf(kata)){
            return  kata;
        }
        
        if(CheckKamus(kata)){
            return kata;
        }
        
        temporary = HapusP(kata);//--------------------------------------------- Hapus Partikel
        if(CheckKamus(temporary)){
            return temporary;
        }

        temporary = HapusPP(temporary);//--------------------------------------- Hapus Posessive Partikel
        if(CheckKamus(temporary)){
            return temporary;
        }

        int iterasi = 1;
        while(!RulePrecedence(temporary) && iterasi<=2){//---------------------- Check apakah Rule Precedence?
            temporary = HapusDP(temporary);
            if(CheckKamus(temporary)){
                return temporary;
            }
            iterasi++;//-------------------------------------------------------- Jika tidak, maka hapus awalan 2 kali // Jika ya, langsung keluar loop
        }
        
        if(RulePrecedence(temporary)){//---------------------------------------- Jika Rule Precedence, hapus awalan kemudian hapus akhiran
            temporary = HapusDP(temporary);
            if(CheckKamus(temporary)){
                return temporary;
            }
            
            temporary = HapusDS(temporary);
            if(CheckKamus(temporary)){
                return temporary;
            }
        }
        else{
            temporary = HapusDS(temporary);//----------------------------------- Jika bukan Rule Precedence, hapus akhiran kemudian hapus awalan
            if(CheckKamus(temporary)){
                return temporary;
            }
            
            temporary = HapusDP(temporary);
            if(CheckKamus(temporary)){
                return temporary;
            }
        }
        
        return kata;
    }
//______________________________________________________________________________
    public String CS_Stemmer2(String kata){
        if(TigaHuruf(kata)){
            return  kata;
        }
        
        if(CheckKamus(kata)){
            return kata;
        }
        
        temporary = HapusP(kata);//--------------------------------------------- Hapus Partikel
        if(CheckKamus(temporary)){
            return temporary;
        }

        temporary = HapusPP(temporary);//--------------------------------------- Hapus Posessive Partikel
        if(CheckKamus(temporary)){
            return temporary;
        }

        int iterasi = 1;
        while(!RulePrecedence(temporary) && iterasi<=2){//---------------------- Check apakah Rule Precedence?
            temporary = HapusDP2(temporary);
            if(CheckKamus(temporary)){
                return temporary;
            }
            iterasi++;//-------------------------------------------------------- Jika tidak, hapus awalan 2 kali // Jika ya, langsung keluar loop
        }
        
        if(RulePrecedence(temporary)){//---------------------------------------- Jika Rule Precedence, hapus awalan kemudian hapus akhiran
            temporary = HapusDP2(temporary);
            if(CheckKamus(temporary)){
                return temporary;
            }
            
            temporary = HapusDS(temporary);
            if(CheckKamus(temporary)){
                return temporary;
            }
        }
        else{
            temporary = HapusDS(temporary);//----------------------------------- Jika bukan Rule Precedence, hapus akhiran kemudian hapus awalan
            if(CheckKamus(temporary)){
                return temporary;
            }
            
            temporary = HapusDP2(temporary);
            if(CheckKamus(temporary)){
                return temporary;
            }
        }
        return kata;
    }
    
    
    //--------------------------------------------------------------------------
    
    
    public String BrTr(String kata){
        InsertKamus();
        if(CheckWord("^(br)", kata)){
//            register = kata.substring(2, kata.length());
//            register2 = ganti.gantiKataGaul(register);
//            if(kata_dasar.contains(register2)){
//                return register2;
//            }
            register = "ber" + kata.substring(2, kata.length());
            if(kata_dasar.contains(CS_Stemmer(register)) || kata_dasar.contains(CS_Stemmer2(register))){
                return register;
            }    
        }
        if(CheckWord("^(tr)", kata)){
            register = "ter" + kata.substring(2, kata.length());
            if(kata_dasar.contains(CS_Stemmer(register)) || kata_dasar.contains(CS_Stemmer2(register))){
                return register;
            }    
        }
        return kata;
    }
    
    
    //--------------------------------------------------------------------------
    
    
    public String Ng(String kata){
        InsertKamus();
        if (CheckWord("^(ngga|nggak|nga)$", kata)){
            return "tidak";
        }
        if (CheckWord("^(ng)", kata)) {
            register = "meng" + kata.substring(2, kata.length());
            if(kata_dasar.contains(CS_Stemmer(register)) || kata_dasar.contains(CS_Stemmer2(register))){
                return register;
            }
        }
        if (CheckWord("^(ng)", kata)) {
            register = "h" + kata.substring(2, kata.length());
            if(kata_dasar.contains(CS_Stemmer(register)) || kata_dasar.contains(CS_Stemmer2(register))){
                return register;
            }
        }
        return kata;
    }
    
    
    //--------------------------------------------------------------------------
    
    
    public String Tidak(String kata){
        InsertKamus();
        if (CheckWord("^(gada)$", kata)) {
            return "tidak ada";
        }
        if(CheckKamus(kata)){
            return kata;
        }
        if (CheckWord("^(g|ga|gk|gx|gak|gax)$", kata)) {
            return "tidak";
        }
        if (CheckWord("^(ga)", kata)) {
            register = kata.substring(2, kata.length());
            if (kata_dasar.contains(register)) {
                return ("tidak " + register);
            }
        }
        
        return kata;
    }
        
}
