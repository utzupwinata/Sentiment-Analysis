import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stemming2 {
    Replacing kamus_gaul = new Replacing();
    String temp2 = "";
    
    ArrayList<String> kata_dasar;
    public void InsertKamus2() {
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
    ////////////////////////////////////////////////////////////////////////////
    
    public boolean CheckKamus2(String kata) {
        if(kata_dasar.contains(kata)) {
            return true;
        }
        return false;
    }
    ////////////////////////////////////////////////////////////////////////////
    
    public boolean RulePrecedence2(String kata){
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
    ////////////////////////////////////////////////////////////////////////////
    
    public boolean WrongCombination2(String token) {
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
    ////////////////////////////////////////////////////////////////////////////
    
    public static boolean CheckWord2(String pattern, String token){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(token);
        return m.find();
    }
    ////////////////////////////////////////////////////////////////////////////
    
    String register, register2;
    public String HapusP2(String kata){
        if(kata_dasar.contains(kata)){
            return kata;
        }
        if(CheckWord2("([kl]ah|pun)$",kata)){
            register = kata.substring(0, kata.length()-3);
            temp2 = kamus_gaul.gantiKataGaul(register);
            if(kata_dasar.contains(temp2)){
                return temp2;
            }
            return register;
        }
        return kata;
    }
    ////////////////////////////////////////////////////////////////////////////
    
    public String HapusPP2(String kata){
        if(kata_dasar.contains(kata)){
            return kata;
        }
        if(CheckWord2("(q)$", kata)){
            register = kata.substring(0, kata.length()-1);
            temp2 = kamus_gaul.gantiKataGaul(register);
            if(kata_dasar.contains(temp2)){
                return temp2;
            }
            return register;
        }
        if(CheckWord2("(ku|mu|qu)$", kata)){
            register = kata.substring(0, kata.length()-2);
            temp2 = kamus_gaul.gantiKataGaul(register);
            if(kata_dasar.contains(temp2)){
                return temp2;
            }
            return register;
        }
        if(CheckWord2("(nya)$", kata)){
            register = kata.substring(0, kata.length()-3);
            temp2 = kamus_gaul.gantiKataGaul(register);
            if(kata_dasar.contains(temp2)){
                return temp2;
            }
            return register;
        }
        if(CheckWord2("(ny)$", kata)){//////////////////////////////////////////
            register = kata.substring(0, kata.length()-2);
            temp2 = kamus_gaul.gantiKataGaul(register);
            if(kata_dasar.contains(temp2)){
                return temp2;
            }
            return register;
        }
        
        return kata;
    }
    ////////////////////////////////////////////////////////////////////////////
    
    public String HapusDS2(String kata){
        if(kata_dasar.contains(kata)){
            return kata;
        }
        if(WrongCombination2(kata)){
            return kata;
        }
        if(CheckWord2("(i)$", kata)){
            register = kata.substring(0, kata.length()-1);
            temp2 = kamus_gaul.gantiKataGaul(register);
            if(kata_dasar.contains(temp2)){
                return temp2;
            }
            return register;
        }
        if(CheckWord2("(in)$", kata)){//////////////////////////////////////////
            register = kata.substring(0, kata.length()-2);
            temp2 = kamus_gaul.gantiKataGaul(register);
            if(kata_dasar.contains(temp2)){
                return temp2;
            }
            return register;
        }
        if(CheckWord2("(kan)$", kata)){
            register = kata.substring(0, kata.length()-3);
            temp2 = kamus_gaul.gantiKataGaul(register);
            if(kata_dasar.contains(temp2)){
                return temp2;
            }
            return register;
        }
        if(CheckWord2("(an)$", kata)){
            register = kata.substring(0, kata.length()-2);
            temp2 = kamus_gaul.gantiKataGaul(register);
            if(kata_dasar.contains(temp2)){
                return temp2;
            }
            return register;
        }
        return kata;
    }
    ////////////////////////////////////////////////////////////////////////////
    
    int rule1, rule2, rule3, rule4, rule5, rule6, rule7, rule8, rule9, rule10;
    int rule11, rule12, rule13, rule14, rule15, rule16, rule17, rule18, rule19, rule20;
    int rule21, rule23, rule24, rule25, rule26, rule27, rule28, rule29, rule30;
    int rule31, rule32, rule33, rule34, rule35, rule36, ruledikese, ruled, ruleny;
    
    public void Cegah_Perulangan_Rule2(){
        rule1=1; rule2=1; rule3=1; rule4=1; rule5=1; rule6=1; rule7=1; rule8=1; rule9=1; rule10=1;
        rule11=1; rule12=1; rule13=1; rule14=1; rule15=1; rule16=1; rule17=1; rule18=1; rule19=1; rule20=1;
        rule21=1; rule23=1; rule24=1; rule25=1; rule26=1; rule27=1; rule28=1; rule29=1; rule30=1;
        rule31=1; rule32=1; rule33=1; rule34=1; rule35=1; rule36=1; ruledikese=1; ruled=1; ruleny=1;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
     public String HapusDP12(String kata){
        //Check Kamus
        if(kata_dasar.contains(kata)){
            return kata;
        }
        
        //RULE 1
        if(CheckWord2("^(ber)[aiueo]", kata)){
            if(rule1<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule1++;
                    return register;
                }
                
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule1++;
                    return register;
                }
                
                rule1++;
                return kata;
            }
        }
        
        //RULE 2
        if(CheckWord2("^(ber)[^aiueor][a-z](?!er)", kata)){
            if(rule2<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule2++;
                    return register;
                }
            }
        }
        
        //RULE 3
        if(CheckWord2("^(ber)[^aiueor][a-z](er)[aiueo]", kata)){
            if(rule3<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule3++;
                    return register;
                }
            }
        }
        
        //RULE 4
        if(CheckWord2("(belajar|belunjur)", kata)){
            if(rule4<2){
                register = kata.substring(3, kata.length());
                rule4++;
                return register;
            }
        }
                
        //RULE 5
        if(CheckWord2("^(be)[^aiueolr](er)[^aiueo]", kata)){
            if(rule5<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule5++;
                    return register;
                }
            }
        }
        
        ////////////////////////////////////////////////////////////////////////
        //RULE 6
        if(CheckWord2("^(ter)[aiueo]", kata)){
            if(rule6<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule6++;
                    return register;
                }
                
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule6++;
                    return register;
                }
                
                rule6++;
                return kata;
            }
        }
        
        //RULE 7
        if(CheckWord2("^(ter)[^aiueor](er)[aiueo]", kata)){
            if(rule7<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule7++;
                    return register;
                }
            }
        }
        
        //RULE 8
        if(CheckWord2("^(ter)[^aiueor](?!er)", kata)){
            if(rule8<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule8++;
                    return register;
                }
            }
        }
        
        //RULE 9
        if(CheckWord2("^(te)[^aiueor](er)[^aiueo]", kata)){
            if(rule9<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule9++;
                    return register;
                }
            }
        }
        
        //RULE 10
        if(CheckWord2("^(me)[lrwy][aiueo]", kata)){
            if(rule10<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule10++;
                    return register;
                }
            }
        }
        
        //RULE 11
        if(CheckWord2("^(mem)[bfv]", kata)){
            if(rule11<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule11++;
                    return register;
                }
            }
        }
        
        //RULE 12
        if(CheckWord2("^(mempe)", kata)){
            if(rule12<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule12++;
                    return register;
                }
            }
        }
        
        //RULE 13
        if(CheckWord2("^(mem)((r[aiueo])|[aiueo])", kata)){
            if(rule13<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule13++;
                    return register;
                }
                
                register = "p" + kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule13++;
                    return register;
                }
                
                rule13++;
                return kata;
            }
        }
        
        //RULE 14
        if(CheckWord2("^(men)[cdjz]", kata)){
            if(rule14<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule14++;
                    return register;
                }
            }
        }
        
        //RULE 15
        if(CheckWord2("^(men)[aiueo]", kata)){
            if(rule15<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule15++;
                    return register;
                }
                
                register = "t" + kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule15++;
                    return register;
                }
                
                rule15++;
                return kata;
            }
        }
        
        //RULE 16
        if(CheckWord2("^(meng)[ghkq]", kata)){
            if(rule16<2){
                register = kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule16++;
                    return register;
                }
            }
        }
        
        //RULE 17
        if(CheckWord2("^(meng)[aiueo]", kata)){
            if(rule17<2){
                register = kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule17++;
                    return register;
                }
                
                register = "k" + kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule17++;
                    return register;
                }
                
                rule17++;
                return kata;
            }
        }
        
        //RULE 18
        if(CheckWord2("^(meny)[aiueo]", kata)){
            if(rule18<2){
                register = "s" + kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule18++;
                    return register;
                }
            }
        }
        
        //RULE 19
        if(CheckWord2("^(memp)[aiuo]", kata)){
            if(rule19<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule19++;
                    return register;
                }
            }
        }
        
        //RULE 20
        if(CheckWord2("^(pe)[wy][aiueo]", kata)){
            if(rule20<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule20++;
                    return register;
                }
            }
        }
        
        //RULE 21
        if(CheckWord2("^(per)[aiueo]", kata)){
            if(rule21<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule21++;
                    return register;
                }
                
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule21++;
                    return register;
                }
                
                rule21++;
                return kata;
            }
        }
        
        //RULE 23
        if(CheckWord2("^(per)[^aiueor][a-z](?!er)", kata)){
            if(rule23<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule23++;
                    return register;
                }
            }
        }
        
        //RULE 24
        if(CheckWord2("^(per)[^aiueor][a-z](er)[aiueo]", kata)){
            if(rule24<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule24++;
                    return register;
                }
            }
        }
        
        //RULE 25
        if(CheckWord2("^(pem)[bfv]", kata)){
            if(rule25<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule25++;
                    return register;
                }
            }
        }
        
        //RULE 26
        if(CheckWord2("^(pem)[[r[aiueo]]|[aiueo]]", kata)){
            if(rule26<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule26++;
                    return register;
                }
                
                register = "p" + kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule26++;
                    return register;
                }
                
                rule26++;
                return kata;
            }
        }
        
        //RULE 27
        if(CheckWord2("^(pen)[cdjz]", kata)){
            if(rule27<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule27++;
                    return register;
                }
            }
        }
        
        //RULE 28
        if(CheckWord2("^(pen)[aiueo]", kata)){
            if(rule28<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule28++;
                    return register;
                }
                
                register = "t" + kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule28++;
                    return register;
                }
                
                rule28++;
                return kata;
            }
        }
        
        //RULE 29
        if(CheckWord2("^(peng)[ghq]", kata)){
            if(rule29<2){
                register = kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule29++;
                    return register;
                }
            }
        }
        
        //RULE 30
        if(CheckWord2("^(peng)[aiueo]", kata)){
            if(rule30<2){
                register = kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule30++;
                    return register;
                }
                
                register = "k" + kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule30++;
                    return register;
                }
                
                rule30++;
                return kata;
            }
        }
        
        //RULE 31
        if(CheckWord2("^(peny)[aiueo]", kata)){
            if(rule31<2){
                register = "s" + kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule31++;
                    return register;
                }
            }
        }
        
        //RULE 32
        if(CheckWord2("^(pel)[aiueo]", kata)){
            if(rule32<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule32++;
                    return register;
                }
            }
        }
        
        //RULE 33
        if(CheckWord2("^(pe)[^aiueorwylmn](er)[aiueo]", kata)){
            if(rule33<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule33++;
                    return register;
                }
            }
        }
        
        //RULE 34
        if(CheckWord2("^(pe)[^aiueorwylmn](?!er)", kata)){
            if(rule34<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule34++;
                    return register;
                }
            }
        }
        
        //RULE 35
        if(CheckWord2("^(ter)[^aiueor](er)[^aiueo]", kata)){
            if(rule35<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule35++;
                    return register;
                }
            }
        }
        
        //RULE 36
        if(CheckWord2("^(pe)[^aiueorwylmn](er)[^aiueo]", kata)){
            if(rule36<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule36++;
                    return register;
                }
            }
        }
        
        //RULE di,ke,se
        if(CheckWord2("^(di)|(ke)|(se)", kata)){
            if(ruledikese<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    ruledikese++;
                    return register;
                }
            }
        }
        
        //RULE d
        if(CheckWord2("^(d)", kata)){
            if(ruled<2){
                register = kata.substring(1, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    ruled++;
                    return register;
                }
            }
        }
        
        //RULE ny
        if(CheckWord2("^(ny)", kata)){
            if(ruleny<2){
                register = "c" + kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    ruleny++;
                    return register;
                }
                
                register = "s" + kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
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
     
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
     
     public String HapusDP22(String kata){
        //Check Kamus
        if(kata_dasar.contains(kata)){
            return kata;
        }
        
        //RULE 1
        if(CheckWord2("^(ber)[aiueo]", kata)){
            if(rule1<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule1++;
                    return register;
                }
                
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule1++;
                    return register;
                }
                
                rule1++;
                return kata;
                }
        }
        
        //RULE 2
        if(CheckWord2("^(ber)[^aiueor][a-z](?!er)", kata)){
            if(rule2<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule2++;
                    return register;
                }
            }
        }
        
        //RULE 3
        if(CheckWord2("^(ber)[^aiueor][a-z](er)[aiueo]", kata)){
            if(rule3<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule3++;
                    return register;
                }
            }
        }
        
        //RULE 4
        if(CheckWord2("(belajar|belunjur)", kata)){
            if(rule4<2){
                register = kata.substring(3, kata.length());
                rule4++;
                return register;
            }
        }
                
        //RULE 5
        if(CheckWord2("^(be)[^aiueolr](er)[^aiueo]", kata)){
            if(rule5<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule5++;
                    return register;
                }
            }
        }
        
        //RULE 6
        if(CheckWord2("^(ter)[aiueo]", kata)){
            if(rule6<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule6++;
                    return register;
                }
                
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule6++;
                    return register;
                }
                
                rule6++;
                return kata;
            }
        }
        
        //RULE 7
        if(CheckWord2("^(ter)[^aiueor](er)[aiueo]", kata)){
            if(rule7<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule7++;
                    return register;
                }
            }
        }
        
        //RULE 8
        if(CheckWord2("^(ter)[^aiueor](?!er)", kata)){
            if(rule8<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule8++;
                    return register;
                }
            }
        }
        
        //RULE 9
        if(CheckWord2("^(te)[^aiueor](er)[^aiueo]", kata)){
            if(rule9<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule9++;
                    return register;
                }
            }
        }
        
        ////////////////////////////////////////////////////////////////////////
        //RULE 10
        if(CheckWord2("^(me)[lrwy][aiueo]", kata)){
            if(rule10<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule10++;
                    return register;
                }
            }
        }
        
        //RULE 11
        if(CheckWord2("^(mem)[bfv]", kata)){
            if(rule11<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule11++;
                    return register;
                }
            }
        }
        
        //RULE 12
        if(CheckWord2("^(mempe)", kata)){
            if(rule12<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule12++;
                    return register;
                }
            }
        }
        
        //RULE 13
        if(CheckWord2("^(mem)((r[aiueo])|[aiueo])", kata)){
            if(rule13<2){
                register = "p" + kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule13++;
                    return register;
                }
                
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule13++;
                    return register;
                }
                
                rule13++;
                return kata;
            }
        }
        
        //RULE 14
        if(CheckWord2("^(men)[cdjz]", kata)){
            if(rule14<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule14++;
                    return register;
                }
            }
        }
        
        //RULE 15
        if(CheckWord2("^(men)[aiueo]", kata)){
            if(rule15<2){
                register = "t" + kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule15++;
                    return register;
                }
                
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule15++;
                    return register;
                }
                
                rule15++;
                return kata;
            }
        }
        
        //RULE 16
        if(CheckWord2("^(meng)[ghkq]", kata)){
            if(rule16<2){
                register = kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule16++;
                    return register;
                }
            }
        }
        
        //RULE 17
        if(CheckWord2("^(meng)[aiueo]", kata)){
            if(rule17<2){
                register = "k" + kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule17++;
                    return register;
                }
                
                register = kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule17++;
                    return register;
                }
                
                rule17++;
                return kata;
            }
        }
        
        //RULE 18
        if(CheckWord2("^(meny)[aiueo]", kata)){
            if(rule18<2){
                register = "s" + kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule18++;
                    return register;
                }
            }
        }
        
        //RULE 19
        if(CheckWord2("^(memp)[aiuo]", kata)){
            if(rule19<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule19++;
                    return register;
                }
            }
        }
        
        //RULE 20
        if(CheckWord2("^(pe)[wy][aiueo]", kata)){
            if(rule20<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule20++;
                    return register;
                }
            }
        }
        
        //RULE 21
        if(CheckWord2("^(per)[aiueo]", kata)){
            if(rule21<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule21++;
                    return register;
                }
                
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule21++;
                    return register;
                }
                
                rule21++;
                return kata;
            }
        }
        
        //RULE 23
        if(CheckWord2("^(per)[^aiueor][a-z](?!er)", kata)){
            if(rule23<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule23++;
                    return register;
                }
            }
        }
        
        //RULE 24
        if(CheckWord2("^(per)[^aiueor][a-z](er)[aiueo]", kata)){
            if(rule24<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule24++;
                    return register;
                }
            }
        }
        
        //RULE 25
        if(CheckWord2("^(pem)[bfv]", kata)){
            if(rule25<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule25++;
                    return register;
                }
            }
        }
        
        //RULE 26
        if(CheckWord2("^(pem)[[r[aiueo]]|[aiueo]]", kata)){
            if(rule26<2){
                register = "p" + kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule26++;
                    return register;
                }
                
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule26++;
                    return register;
                }
                
                rule26++;
                return kata;
            }
        }
        
        //RULE 27
        if(CheckWord2("^(pen)[cdjz]", kata)){
            if(rule27<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule27++;
                    return register;
                }
            }
        }
        
        //RULE 28
        if(CheckWord2("^(pen)[aiueo]", kata)){
            if(rule28<2){
                register = "t" + kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule28++;
                    return register;
                }
                
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule28++;
                    return register;
                }
                
                rule28++;
                return kata;
            }
        }
        
        //RULE 29
        if(CheckWord2("^(peng)[ghq]", kata)){
            if(rule29<2){
                register = kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule29++;
                    return register;
                }
            }
        }
        
        //RULE 30
        if(CheckWord2("^(peng)[aiueo]", kata)){
            if(rule30<2){
                register = "k" + kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule30++;
                    return register;
                }
                
                register = kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule30++;
                    return register;
                }
                
                rule30++;
                return kata;
            }
        }
        
        //RULE 31
        if(CheckWord2("^(peny)[aiueo]", kata)){
            if(rule31<2){
                register = "s" + kata.substring(4, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule31++;
                    return register;
                }
            }
        }
        
        //RULE 32
        if(CheckWord2("^(pel)[aiueo]", kata)){
            if(rule32<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule32++;
                    return register;
                }
            }
        }
        
        //RULE 33
        if(CheckWord2("^(pe)[^aiueorwylmn](er)[aiueo]", kata)){
            if(rule33<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule33++;
                    return register;
                }
            }
        }
        
        //RULE 34
        if(CheckWord2("^(pe)[^aiueorwylmn](?!er)", kata)){
            if(rule34<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule34++;
                    return register;
                }
            }
        }

        //RULE 35
        if(CheckWord2("^(ter)[^aiueor](er)[^aiueo]", kata)){
            if(rule35<2){
                register = kata.substring(3, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule35++;
                    return register;
                }
            }
        }
        
        //RULE 36
        if(CheckWord2("^(pe)[^aiueorwylmn](er)[^aiueo]", kata)){
            if(rule36<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    rule36++;
                    return register;
                }
            }
        }
        
        //RULE di,ke,se
        if(CheckWord2("^(di)|(ke)|(se)", kata)){
            if(ruledikese<2){
                register = kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    ruledikese++;
                    return register;
                }
            }
        }
        
        //RULE d
        if(CheckWord2("^(d)", kata)){
            if(ruled<2){
                register = kata.substring(1, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    ruled++;
                    return register;
                }
            }
        }
        
        //RULE ny
        if(CheckWord2("^(ny)", kata)){
            if(ruleny<2){
                register = "c" + kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
                if(kata_dasar.contains(register)){
                    ruleny++;
                    return register;
                }
                
                register = "s" + kata.substring(2, kata.length());
                register = kamus_gaul.gantiKataGaul(register);
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
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
     
    String temporary;
     
    public String CS_Stemmer12(String kata){
        if(CheckKamus2(kata)){
            return kata;
        }
        
        
        temporary = ReplaceDPGaul2(kata);//-------------------------------------- Replace Imbuhan yang Disingkat
        if(CheckKamus2(temporary)){
            return temporary;
        }
        
        temporary = HapusP2(temporary);//---------------------------------------- Hapus Partikel
        if(CheckKamus2(temporary)){
            return temporary;
        }

        temporary = HapusPP2(temporary);//--------------------------------------- Hapus Posessive Partikel
        if(CheckKamus2(temporary)){
            return temporary;
        }

        int iterasi = 1;
        while(!RulePrecedence2(temporary) && iterasi<=2){//---------------------- Check apakah Rule Precedence?
            temporary = HapusDP12(temporary);
            if(CheckKamus2(temporary)){
                return temporary;
            }
            iterasi++;//-------------------------------------------------------- Jika tidak, maka hapus awalan 2 kali // Jika ya, langsung keluar loop
        }
        
        if(RulePrecedence2(temporary)){//---------------------------------------- Jika Rule Precedence, hapus awalan kemudian hapus akhiran
            temporary = HapusDP12(temporary);
            if(CheckKamus2(temporary)){
                return temporary;
            }
            
            temporary = HapusDS2(temporary);
            if(CheckKamus2(temporary)){
                return temporary;
            }
        }
        else{
            temporary = HapusDS2(temporary);//----------------------------------- Jika bukan Rule Precedence, hapus akhiran kemudian hapus awalan
            if(CheckKamus2(temporary)){
                return temporary;
            }
            
            temporary = HapusDP12(temporary);
            if(CheckKamus2(temporary)){
                return temporary;
            }
        }
        
        return kata;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    public String CS_Stemmer22(String kata){
        if(CheckKamus2(kata)){
            return kata;
        }
        
        temporary = ReplaceDPGaul2(kata);//-------------------------------------- Replace Imbuhan yang Disingkat
        if(CheckKamus2(temporary)){
            return temporary;
        }
        
        temporary = HapusP2(temporary);//---------------------------------------- Hapus Partikel
        if(CheckKamus2(temporary)){
            return temporary;
        }

        temporary = HapusPP2(temporary);//--------------------------------------- Hapus Posessive Partikel
        if(CheckKamus2(temporary)){
            return temporary;
        }

        int iterasi = 1;
        while(!RulePrecedence2(temporary) && iterasi<=2){//---------------------- Check apakah Rule Precedence?
            temporary = HapusDP22(temporary);
            if(CheckKamus2(temporary)){
                return temporary;
            }
            iterasi++;//-------------------------------------------------------- Jika tidak, hapus awalan 2 kali // Jika ya, langsung keluar loop
        }
        
        if(RulePrecedence2(temporary)){//---------------------------------------- Jika Rule Precedence, hapus awalan kemudian hapus akhiran
            temporary = HapusDP22(temporary);
            if(CheckKamus2(temporary)){
                return temporary;
            }
            
            temporary = HapusDS2(temporary);
            if(CheckKamus2(temporary)){
                return temporary;
            }
        }
        else{
            temporary = HapusDS2(temporary);//----------------------------------- Jika bukan Rule Precedence, hapus akhiran kemudian hapus awalan
            if(CheckKamus2(temporary)){
                return temporary;
            }
            
            temporary = HapusDP22(temporary);
            if(CheckKamus2(temporary)){
                return temporary;
            }
        }
        return kata;
    }
    ////////////////////////////////////////////////////////////////////////////
    
    public String BrTr2(String kata){
        //InsertKamus2();
        if(CheckWord2("^(br)", kata)){
            register = "ber" + kata.substring(2, kata.length());
            register = kamus_gaul.gantiKataGaul(register);
            if(kata_dasar.contains(CS_Stemmer12(register)) || kata_dasar.contains(CS_Stemmer22(register))){
                return register;
            }    
        }
        
        if(CheckWord2("^(tr)", kata)){
            register = "ter" + kata.substring(2, kata.length());
            register = kamus_gaul.gantiKataGaul(register);
            if(kata_dasar.contains(CS_Stemmer12(register)) || kata_dasar.contains(CS_Stemmer22(register))){
                return register;
            }    
        }
        
        return kata;
    }
    ////////////////////////////////////////////////////////////////////////////
    
    public String Ng2(String kata){
        //InsertKamus2();
        if (CheckWord2("^(ngga|nggak|nga)$", kata)){
            return "tidak";
        }
        
        if (CheckWord2("^(ngeselin)$", kata)){
            return "kecewa";
        }
        
        if (CheckWord2("^(ng)", kata)) {
            register = "meng" + kata.substring(2, kata.length());
            register = kamus_gaul.gantiKataGaul(register);
            if(kata_dasar.contains(CS_Stemmer12(register)) || kata_dasar.contains(CS_Stemmer22(register))){
                return register;
            }
        }
        
        if (CheckWord2("^(ng)", kata)) {
            register = "h" + kata.substring(2, kata.length());
            register = kamus_gaul.gantiKataGaul(register);
            if(kata_dasar.contains(CS_Stemmer12(register)) || kata_dasar.contains(CS_Stemmer22(register))){
                return register;
            }
        }
        
        if (CheckWord2("^(ng)", kata)) {
            register = "k" + kata.substring(2, kata.length());
            register = kamus_gaul.gantiKataGaul(register);
            if(kata_dasar.contains(CS_Stemmer12(register)) || kata_dasar.contains(CS_Stemmer22(register))){
                return register;
            }
        }
        
        return kata;
    }
    ////////////////////////////////////////////////////////////////////////////
    
    public String Tidak2(String kata){
        //InsertKamus2();
        if (CheckWord2("^(gada)$", kata)) {
            return "tidak ada";
        }
        if(CheckKamus2(kata)){
            return kata;
        }
        if (CheckWord2("^(g|ga|gk|gx|gak|gax)$", kata)) {
            return "tidak";
        }
        if (CheckWord2("^(ga)", kata)) {
            register = kata.substring(2, kata.length());
            register = kamus_gaul.gantiKataGaul(register);
            if (kata_dasar.contains(register)) {
                return ("tidak " + register);
            }
        }
        
        return kata;
    }
    
    public String ReplaceDPGaul2(String kata){
        if (CheckWord2("^(br|tr)", kata)) {
            kata = BrTr2(kata);
        }
        if (CheckWord2("^(ng)", kata)) {
            kata = Ng2(kata);
        }
        //if (CheckWord2("^(ga)", kata)) {
        //    kata = Tidak2(kata);
        //}
        return kata;
    }
}
