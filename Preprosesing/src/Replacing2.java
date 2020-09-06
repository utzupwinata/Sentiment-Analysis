import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replacing2 {
    
    public static boolean cekKata(String pola, String kata){
        Pattern p = Pattern.compile(pola);
        Matcher m = p.matcher(kata);
        return m.find();
    }
    
    public String gantiKataGaul(String kata){
        if (cekKata("^(dear)$", kata)) {
            kata = "kepada";
        }
        else if (cekKata("^(u/)$", kata)) {////////////////////////////
            kata = "untuk";
        }
        if (cekKata("^(tlong|tolng|help)$", kata)) {
            kata = "tolong";
        }
        if (cekKata("^(mhn|mhon)$", kata)) {
            kata = "mohon";
        }
        if (cekKata("^(respon|rspn|rspon|respn)$", kata)) {
            kata = "respons";
        }
        if (cekKata("^(jwb|jwab)$", kata)) {
            kata = "jawab";
        }
        if (cekKata("^(sry|sory|sorry|maap|map)$", kata)) {
            kata = "maaf";
        }
        if (cekKata("^(mksd|maksd|mksud)$", kata)) {
            kata = "maksud";
        }
        else if (cekKata("^(bls|blas|bles|bales)$", kata)) {////////////////////////////
            kata = "balas";
        }
        else if (cekKata("^(hub|hbngi|hubngi)$", kata)) {
            kata = "hubungi";
        }
        else if (cekKata("^(pm|dm|sms)$", kata)) {
            kata = "kirim pesan";
        }
        if (cekKata("^(wa)$", kata)) {
            kata = "whatsapp";
        }
        if (cekKata("^(ig)$", kata)) {
            kata = "instagram";
        }
        else if (cekKata("^(smoga|smga)$", kata)) {
            kata = "semoga";
        }
        else if (cekKata("^(brp|brpa|brapa)$", kata)) {
            kata = "berapa";
        }
        else if (cekKata("^(rb|rbu)$", kata)) {
            kata = "ribu";
        }
        else if (cekKata("(warehouse)", kata)) {////////////////////////////////
            kata = "gudang";
        }
        if (cekKata("^(recived|recieved)$", kata)) {
            kata = "received";
        }
        else if (cekKata("^(cs)$", kata)) {
            kata = "customer service";
        }
        if (cekKata("^(center)$", kata)) {
            kata = "pusat";
        }
        else if (cekKata("(track|tracking|tracker|trace|tracer)", kata)) {//////
            kata = "trek";
        }
        else if (cekKata("(route|routing)", kata)) {////////////////////////////
            kata = "rute";
        }
        else if (cekKata("(check|checking|checker)", kata)) {///////////////////
            kata = "cek";
        }
        else if (cekKata("(double|doble|doubel)", kata)) {//////////////////////
            kata = "dobel";
        }
        else if (cekKata("^(complain|complen|compln|komplen|kmplain|kompln|kmplen)$", kata)) {
            kata = "komplain";
        }
        else if (cekKata("(web|website|webset|websit)", kata)) {////////////////
            kata = "situs";
        }
        if (cekKata("^(progres|proggress|progrs|proggrs|progrss|prgres|prggres|prgress|prgrs|prggrs|prgrss|prggrss)$", kata)) {
            kata = "kemajuan";
        }
        else if (cekKata("^(tau|tw|notif|notip|notify|notification)$", kata)) {
            kata = "tahu";
        }
        else if (cekKata("^(may)$", kata)) {
            kata = "mei";
        }
        else if (cekKata("^(thread|trit)$", kata)) {
            kata = "artikel";
        }
        else if (cekKata("^(fragile|frgile|frgle)$", kata)) {
            kata = "rapuh";
        }
        else if (cekKata("^(seller|sellr|sller|sell)$", kata)) {
            kata = "jual";
        }
        else if (cekKata("^(buyyer|buyer|buy)$", kata)) {
            kata = "beli";
        }
        else if (cekKata("^(rekber|rkber|rkbr)$", kata)) {
            kata = "rekening bersama";
        }
        else if (cekKata("^(cod|ceode|codan|cotan|ceodean)$", kata)) {
            kata = "temu";
        }
        if (cekKata("^(code)$", kata)) {
            kata = "kode";
        }
        if (cekKata("^(useless)$", kata)) {
            kata = "tidak guna";
        }
        else if (cekKata("^(cot|bcot|bcod|bacot|bacod)$", kata)) {
            kata = "berisik";
        }
        else if (cekKata("^(cek)$", kata)) {
            kata = "dicek";
        }
        else if (cekKata("^(g|ga|gk|gx|gak|gax|engg|ngga|nggak|enggax|enggak|tdk|tdak|tak|tk|kurang|krang|krng)$", kata)) {
            kata = "tidak";
        }
        else if (cekKata("^(lbh|lbih)$", kata)) {
            kata = "lebih";
        }
        else if (cekKata("^(y|ya)$", kata)) {
            kata = "iya";
        }
        else if (cekKata("^(blm|blman|blum|bluman|blom|bloman|blon|blonan|bloman|belon|belonan|belom|beloman)$", kata)) {
            kata = "belum";
        }
        else if (cekKata("^(nyasar|nysar|nyasr|nysr)$", kata)) {
            kata = "xsampai";
        }
        else if (cekKata("^(nyangkut|nyangkt|nyngkut|nyngkt)$", kata)) {
            kata = "xsampai";
        }
        else if (cekKata("^(stuck|stuk|stak|ngestuck|ngestuk|ngestak|ngstuck|ngstak|ngstuk)$", kata)) {
            kata = "xsampai";//macet atau terjebak
        }
        else if (cekKata("^(ampe|sampe|smpe|samp|nyampe|nympe)", kata)) {
            kata = "sampai";
        }
        else if (cekKata("^(smp)$", kata)) {
            kata = "sampai";
        }
        else if (cekKata("^(sgt|sangt|sngat|sngt)$", kata)) {
            kata = "sangat";
        }
        else if (cekKata("^(skli|skl|sklian)$", kata)) {
            kata = "sekali";
        }
        else if (cekKata("^(lmbt|lmbat|lambt|lemot|lmot|lelet|llet|siput|keong|kiong)$", kata)) {
            kata = "lambat";
        }
        if (cekKata("^(lma)$", kata)) {//---------------------------------------
            kata = "lama";
        }
        if (cekKata("^(br|bru)$", kata)) {
            kata = "baru";
        }
        else if (cekKata("^(bat|bet|bgt|bngt|bnget|bangt|bingit|bngit)$", kata)) {
            kata = "banget";
        }
        else if (cekKata("^(kcewa|kcwa|kesel|ksl|kesl|ksel|kzl|bete|nyesel|nysel|parah|prah|pasrah|psrah|ngecewain|ngcewain|mengecewakan|menyesal|sebel|sbel|sbl|ngasal|ngsal|kpok|kapok|hopeless)$", kata)) {           
            kata = "kecewa";
        }
        else if (cekKata("^(nyerah|nyerh|nyrah|nyrh)$", kata)) {
            kata = "serah";
        }
        else if (cekKata("^(rsak|pecah|pcah|patah|ptah|hancur|ancur|ancr|penyok|sobek|robek)$", kata)) {
            kata = "rusak";
        }
        if (cekKata("^(ilang|hlang|hilng|hlng)$", kata)) {
            kata = "hilang";
        }
        else if (cekKata("^(cepet|cpt|cpet|cept|gercep|grcep|gercp|grcp)", kata)) {////////////////////////////
            kata = "cepat";
        }
        if (cekKata("^(hrs|hrus)$", kata)) {
            kata = "harus";
        }
        else if (cekKata("^(dgn|dngan)$", kata)) {
            kata = "dengan";
        }
        if (cekKata("^(msh|msi|msih)$", kata)) {
            kata = "masih";
        }
        else if (cekKata("^(dateng|datengin|dteng|dtengin|dtang|dtangin|dtng|dtngin|dtg)$", kata)) {
            kata = "datang";
        }
        else if (cekKata("^(i|q|aq|aqu|w|gw|gwe|gue|gua|gwa|sy|sya|aku|acu|me|i'm|im)$", kata)) {///////////////////
            kata = "saya";
        }
        else if (cekKata("^(u|l|lo|lu|elo|elu|you)$", kata)) {
            kata = "kamu";
        }
        if (cekKata("^(dia|die|doi|dya|dy)$", kata)) {
            kata = "dia";
        }
        else if (cekKata("^(klen|klean|klian|kalean|gaes|guys|guy)$", kata)) {
            kata = "kalian";
        }
        else if (cekKata("^(mrk|mrka|mreka|they)$", kata)) {
            kata = "mereka";
        }
        else if (cekKata("^(qt|qta|we)$", kata)) {
            kata = "kita";
        }
        else if (cekKata("^(ky|kyk|kyak|kek|kaya)$", kata)) {//kaya------------------
            kata = "seperti";
        }
        else if (cekKata("^(kyny|kykny|kyakny|kekny)", kata)) {/////////////////
            kata = "seperti";
        }
        else if (cekKata("^(gn|gni|gini|bgn|bgni|bgini|begindang|bgindang)$", kata)) {
            kata = "begini";
        }
        else if (cekKata("^(gt|gtu|gitu|bgtu|bgitu)$", kata)) {
            kata = "begitu";
        }
        else if (cekKata("^(no|nmr|nmor|nomr|nomer)$", kata)) {
            kata = "nomor";
        }
        else if (cekKata("^(reg|regis)$", kata)) {
            kata = "registrasi";
        }
        else if (cekKata("^(tp|tpi|ttpi)$", kata)) {
            kata = "tapi";
        }
        else if (cekKata("^(ttp|ttep|tetep)$", kata)) {
            kata = "tetap";
        }
        else if (cekKata("^(yg|yng)$", kata)) {
            kata = "yang";
        }
        else if (cekKata("^(hr|hri)$", kata)) {
            kata = "hari";
        }
        else if (cekKata("^(brg|brng|brang)$", kata)) {
            kata = "barang";
        }
        else if (cekKata("^(skrng|skarang|skrang|skrg)$", kata)) {
            kata = "sekarang";
        }
        else if (cekKata("^(dg|dgn|dngan)$", kata)) {
            kata = "dengan";
        }
        else if (cekKata("^(slh|slah)$", kata)) {
            kata = "salah";
        }
        else if (cekKata("^(td|tdi)$", kata)) {
            kata = "tadi";
        }
        else if (cekKata("^(kalo|klo|klu|kl)$", kata)) {
            kata = "kalau";
        }
        else if (cekKata("^(kli)$", kata)) {
            kata = "kalih";
        }
        else if (cekKata("^(lg|lgi)$", kata)) {
            kata = "lagi";
        }
        else if (cekKata("^(dpt|dpat|dpet|dapet)$", kata)) {
            kata = "dapat";
        }
        else if (cekKata("^(nunggu)$", kata)) {
            kata = "tunggu";
        }
        else if (cekKata("^(sempet|sempt|smpet)$", kata)) {///////////////////// =/=sempet
            kata = "sempat";
        }
        else if (cekKata("^(skl|skli)$", kata)) {
            kata = "sekali";
        }
        else if (cekKata("^(mhal)$", kata)) {
            kata = "mahal";
        }
        else if (cekKata("^(sm|sma)$", kata)) {
            kata = "sama";
        }
        else if (cekKata("^(jg|jga)$", kata)) {
            kata = "juga";
        }
        else if (cekKata("^(psn|psen|psan|pesen)$", kata)) {////////////////////
            kata = "pesan";
        }
        else if (cekKata("^(antr|anter)$", kata)) {/////////////////////////////
            kata = "antar";
        }
        else if (cekKata("^(tlp|telp|tlpn|tlpon|telpon|nelp|nelpon|nlpn)$", kata)) {
            kata = "telepon";
        }
        else if (cekKata("^(kntk|kntak|kontk)$", kata)) {
            kata = "kontak";
        }
        else if (cekKata("^(jls|jlas)$", kata)) {
            kata = "jelas";
        }
        else if (cekKata("^(mw|mo)$", kata)) {
            kata = "mau";
        }
        else if (cekKata("^(krn|krna|karna)$", kata)) {
            kata = "karena";
        }
        else if (cekKata("^(tb|tba)$", kata)) {
            kata = "tiba";
        }
        else if (cekKata("^(krm|krim|dikrm|dkrim|dkrm|krmn|krman|krimn|kriman|kiriman)$", kata)) {
            kata = "kirim";
        }
        else if (cekKata("^(trma|trima|dtrma|dtrima|nerima|nrima|nrma)$", kata)) {
            kata = "terima";
        }
        else if (cekKata("^(penerima|pnerima|pnrima|pnrma|nerima|nrima|nrma)$", kata)) {
            kata = "terima";
        }
        else if (cekKata("^(liat|lhat)$", kata)) {
            kata = "lihat";
        }
        else if (cekKata("^(denger|dnger|dngar|dengr)$", kata)) {
            kata = "dengar";
        }
        if (cekKata("^(blg|blng|blang)$", kata)) {
            kata = "bilang";
        }
        if (cekKata("^(kmpl|kmpul|kumpl)$", kata)) {
            kata = "kumpul";
        }
        else if (cekKata("^(kli)$", kata)) {
            kata = "kalih";
        }
        else if (cekKata("^(bermasalah)$", kata)) {
            kata = "masalah";
        }
        else if (cekKata("^(pket|pket|paketan|package)$", kata)) {
            kata = "paket";
        }
        else if (cekKata("^(tumpukan)$", kata)) {
            kata = "tumpuk";
        }
        else if (cekKata("^(ksh|ksi|kasi|ksih|ngsi|ngsh|ngsih|ngasi|ngasih)$", kata)) {
            kata = "kasih";
        }
        else if (cekKata("^(memberikan|mmberikan|mmbrikan|membrikan|membrkn|mmbrkn)$", kata)) {//////////////////////////
            kata = "beri";
        }
        else if (cekKata("^(lsg|lgs|lngsung|langsng|lngsng)$", kata)) {
            kata = "langsung";
        }
        else if (cekKata("^(thanks|thank|thanx|thnx|thnks|thks|thx|tks|tx|makasih|makash|mkasih|mkash|mksih|mksh|mksi)$", kata)) {
            kata = "terimakasih";
        }
        else if (cekKata("^(ska|sk)$", kata)) {
            kata = "suka";
        }
        else if (cekKata("^(kbr|kbar)$", kata)) {
            kata = "kabar";
        }
        else if (cekKata("^(dh|dah|ud|udh|ude|uda|sdh|udah|udeh|sdah)$", kata)) {
            kata = "sudah";
        }
        else if (cekKata("^(j|z|aj|az|azz|ajj|aja|aza|ajja|azza|ajh|azh|ajah|azah|ajjah|ajjh)$", kata)) {
            kata = "saja";
        }
        else if (cekKata("^(slama|slamany|slma|slmany)", kata)) {//////////////////////////////
            kata = "selama";
        }
        else if (cekKata("^(min|admn|admin|mimin)$", kata)) {
            kata = "administrator";
        }
        else if (cekKata("^(org|orng|wong|rang|horang|people)$", kata)) {
            kata = "orang";
        }
        else if (cekKata("^(emg|emng|emang)$", kata)) {
            kata = "memang";
        }
        else if (cekKata("^(tgl)$", kata)) {
            kata = "tanggal";
        }
        else if (cekKata("^(pk|pke|pake|pakek|pkek|pkai)$", kata)) {
            kata = "pakai";
        }
        else if (cekKata("^(pcs|pack|bngks|bks|bh)$", kata)) {
            kata = "buah";
        }
        else if (cekKata("^(wrap|warp|wrp|packaging)$", kata)) {
            kata = "bungkus";
        }
        else if (cekKata("^(keep|simpen|simpn|smpan|smpen|smpn)$", kata)) {
            kata = "simpan";
        }
        else if (cekKata("^(ad|da)$", kata)) {
            kata = "ada";
        }
        else if (cekKata("^(zonk|zong|ksong)$", kata)) {
            kata = "kosong";
        }
        else if (cekKata("^(pd|pda)$", kata)) {
            kata = "pada";
        }
        else if (cekKata("^(pdhl|pdhlkn|pdhal|pdhalkn|pdahal|pdahalkn|padahl|padahlkn)$", kata)) {
            kata = "padahal";
        }
        else if (cekKata("^(msa|masa)$", kata)) {
            kata = "serius";
        }
        else if (cekKata("^(cm|cma|cuma|cuman|cmn|cumn|doang)$", kata)) {
            kata = "hanya";
        }
        else if (cekKata("^(kk|kak|kka)$", kata)) {
            kata = "kakak";
        }
        else if (cekKata("^(dek|deq|ddk|dd|dde|ddek)$", kata)) {
            kata = "adik";
        }
        else if (cekKata("^(bu|buk)$", kata)) {
            kata = "ibu";
        }
        else if (cekKata("^(mas|cowok|cowo|cwo|masmas)$", kata)) {
            kata = "pria";
        }
        else if (cekKata("^(mba|mbak|cewek|cwek|cwk|mbamba|mbakmbak)$", kata)) {
            kata = "wanita";
        }
        else if (cekKata("^(dr|dri)$", kata)) {
            kata = "dari";
        }
        else if (cekKata("^(kmrn|kmren|kmrin|kemaren)$", kata)) {
            kata = "kemarin";
        }
        else if (cekKata("^(bsk|bsok)$", kata)) {
            kata = "besok";
        }
        else if (cekKata("^(pas)$", kata)) {
            kata = "saat";
        }
        else if (cekKata("^(bs|bsa)$", kata)) {
            kata = "bisa";
        }
        else if (cekKata("(bnr|sbnr|bner|sbner|bnar|sbnar|bener|sbener)", kata)) {////////////////////////////////
            kata = "benar";
        }
        else if (cekKata("^(btul|tul)$", kata)) {
            kata = "betul";
        }
        else if (cekKata("^(mantul|mntul|mantep|mntep|mantp|mntp|mntap|tap|taps|ntap|ntaps)$", kata)) {
            kata = "mantap";
        }
        else if (cekKata("^(ok|oc|oce)$", kata)) {
            kata = "oke";
        }
        else if (cekKata("^(slmt|slmat|slamat)$", kata)) {
            kata = "selamat";
        }
        if (cekKata("^(ps|pas)$", kata)) {
            kata = "kepada";
        }
        else if (cekKata("^(pg|pgi)$", kata)) {
            kata = "pagi";
        }
        else if (cekKata("^(sre)$", kata)) {
            kata = "sore";
        }
        else if (cekKata("^(mlm|mlam|malem)$", kata)) {
            kata = "malam";
        }
        else if (cekKata("^(d)$", kata)) {
            kata = "di";
        }
        else if (cekKata("^(dsni|dsini)$", kata)) {
            kata = "disini";
        }
        else if (cekKata("^(dsna|dsana)$", kata)) {
            kata = "disana";
        }
        else if (cekKata("^(dmri|dmari)$", kata)) {
            kata = "dimari";
        }
        else if (cekKata("^(dstu|dsitu)$", kata)) {
            kata = "disitu";
        }
        else if (cekKata("^(ksni|ksini)$", kata)) {
            kata = "kesini";
        }
        else if (cekKata("^(ksna|ksana)$", kata)) {
            kata = "kesana";
        }
        else if (cekKata("^(kmri|kmari)$", kata)) {
            kata = "kemari";
        }
        else if (cekKata("^(ksitu|kstu)$", kata)) {
            kata = "kesitu";
        }
        else if (cekKata("^(dkt|dket|deket)$", kata)) {
            kata = "dekat";
        }
        else if (cekKata("^(tanggungjawab|bertanggungjawab|mempertanggungjawabkan|tnggngjwb)$", kata)) {
            kata = "tanggung jawab";
        }
        else if (cekKata("^(pengirimannya|pengirimanny|pengrimnnya|pengrimanny|pengrimnny)", kata)) {
            kata = "pengiriman";
        }
        else if (cekKata("^(keteranganny)", kata)) {
            kata = "terang";
        }
        else if (cekKata("^(sekalipun)", kata)) {
            kata = "sekali";
        }
        else if (cekKata("^(tnggng|tnggung)$", kata)) {
            kata = "tanggung";
        }
        else if (cekKata("^(p|pa|ap)$", kata)) {
            kata = "apa";
        }
        else if (cekKata("^(syp|sypa|sapa)$", kata)) {
            kata = "siapa";
        }
        else if (cekKata("^(kpn|kpan)$", kata)) {
            kata = "kapan";
        }
        else if (cekKata("^(np|npa|napa|knp|knpa|knapa)$", kata)) {
            kata = "kenapa";
        }
        else if (cekKata("^(ngapa|ngpa)", kata)) {//////////////////////////////
            kata = "kenapa";
        }
        else if (cekKata("^(dmn|dmna|dmana|dimans|dmans|dmns)", kata)) {
            kata = "dimana";
        }
        else if (cekKata("^(kmna|kmana|kmn)$", kata)) {
            kata = "kemana";
        }
        else if (cekKata("^(gmn|gmna|gmana|gimana|bgmn|bgmna|bgmana|begimana)$", kata)) {
            kata = "bagaimana";
        }
        else if (cekKata("^(mn|mna)$", kata)) {
            kata = "mana";
        }
        else if (cekKata("^(nanya|nnya|tnya)$", kata)) {
            kata = "tanya";
        }
        else if (cekKata("^(bli)$", kata)) {
            kata = "beli";
        }
        else if (cekKata("^(slalu|sllu|sll)$", kata)) {
            kata = "selalu";
        }
        else if (cekKata("^(n)$", kata)) {
            kata = "dan";
        }
        else if (cekKata("^(ni|nih)$", kata)) {
            kata = "ini";
        }
        else if (cekKata("^(tu|tuh)$", kata)) {
            kata = "itu";
        }
        else if (cekKata("^(ket|ktrngn|ktrangan|ktrngan|ktrngn|ktrangan|ktrangn|ketrangan|ketrngn|ketrngan)$", kata)) {
            kata = "terang";
        }
        else if (cekKata("^(dll|etc)$", kata)) {
            kata = "dan lain";
        }
        else if (cekKata("^(tsb)$", kata)) {
            kata = "tersebut";
        }
        else if (cekKata("^(egp)$", kata)) {
            kata = "memang saya pikirkan";
        }
        else if (cekKata("^(otw|otewe|otwe|on the way)$", kata)) {
            kata = "jalan";
        }
        else if (cekKata("^(gpp|rapopo|rpopo)$", kata)) {
            kata = "tidak apa";
        }        
        else if (cekKata("^(boam|bodo|bdo)$", kata)) {
            kata = "masa bodoh";
        }
        else if (cekKata("^(donk|dong)$", kata)) {
            kata = "dnk";
        }
        else if (cekKata("^(dkk)$", kata)) {
            kata = "dan kawan";
        }
        if (cekKata("^(ywd)$", kata)) {
            kata = "sudah";
        }
        if (cekKata("^(drpd)$", kata)) {
            kata = "daripada";
        }
        return kata;
    }
    
}
