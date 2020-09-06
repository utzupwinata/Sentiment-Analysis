import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replacing {
    Stemming Stem = new Stemming();
    
    public static boolean cekKata(String pola, String kata){
        Pattern p = Pattern.compile(pola);
        Matcher m = p.matcher(kata);
        return m.find();
    }
    
    public String ReplaceDPGaul(String kata){
        if (cekKata("^(br|tr)", kata)) {
            kata = Stem.BrTr(kata);
        }
        if (cekKata("^(ng)", kata)) {
            kata = Stem.Ng(kata);
        }
        if (cekKata("^(ga)", kata)) {
            kata = Stem.Tidak(kata);
        }
        return kata;
    }
       
    public String gantiKataGaul(String kata){
        if (cekKata("^(dear)$", kata)) {
            kata = "kepada";
        }
        else if (cekKata("^(alhamdulilah|alhamdulillah|hamdalah|hamdallah|alhmdulillah|alhmdulilah)$", kata)) {
            kata = "yeshappy";
        }
        else if (cekKata("^(seneng|puas|hepi|hapy|happi|happy|bahagia|love|luv)$", kata)) {
            kata = "yeshappy";
        }
        else if (cekKata("^(milih)$", kata)) {
            kata = "pilih";
        }
        else if (cekKata("^(numpuk)$", kata)) {
            kata = "tumpuk";
        }
        else if (cekKata("^(nawar)$", kata)) {
            kata = "tawar";
        }
        else if (cekKata("^(promo)$", kata)) {
            kata = "promosi";
        }
        else if (cekKata("^(pas)$", kata)) {
            kata = "saat";
        }
        else if (cekKata("^(untk|utk)$", kata)) {////////////////////////////
            kata = "untuk";
        }
        else if (cekKata("^(tlg|tlong|tolng|help)$", kata)) {
            kata = "tolong";
        }
        else if (cekKata("^(mhn|mhon)$", kata)) {
            kata = "mohon";
        }
        else if (cekKata("^(respon|rspn|rspon|respn)$", kata)) {
            kata = "respons";
        }
        else if (cekKata("^(antri)$", kata)) {
            kata = "antre";
        }
        else if (cekKata("^(jwb|jwab)$", kata)) {
            kata = "jawab";
        }
        else if (cekKata("^(sry|sory|sorry|maap|map)$", kata)) {
            kata = "maaf";
        }
        else if (cekKata("^(mksd|maksd|mksud)$", kata)) {
            kata = "maksud";
        }
        else if (cekKata("^(bls|blas|bles|bales)$", kata)) {////////////////////////////
            kata = "balas";
        }
        else if (cekKata("^(hub|hbngi|hubngi|ngehubungi)$", kata)) {
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
        else if (cekKata("^(recived|recieved)$", kata)) {
            kata = "received";
        }
        else if (cekKata("^(conf|konf|confirm|konfirm)$", kata)) {
            kata = "konfirmasi";
        }
        else if (cekKata("^(note)$", kata)) {
            kata = "catat";
        }
        else if (cekKata("^(pls|plz|plis|pleas|please)$", kata)) {
            kata = "mohon";
        }
        else if (cekKata("^(cs)$", kata)) {
            kata = "customer service";
        }
        else if (cekKata("^(cust)$", kata)) {
            kata = "customer";
        }
        else if (cekKata("^(center)$", kata)) {
            kata = "pusat";
        }
        else if (cekKata("^(claim)$", kata)) {
            kata = "klain";
        }
        else if (cekKata("(track|tracking|tracker|tracing|trace|tracer)", kata)) {//////
            kata = "trek";
        }
        else if (cekKata("(route|routing)", kata)) {////////////////////////////
            kata = "rute";
        }
        else if (cekKata("(check|checking|checker|cek)", kata)) {///////////////////
            kata = "dicek";
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
        else if (cekKata("^(progres|progress|proggres|proggress|progrs|proggrs|progrss|prgres|prggres|prgress|prgrs|prggrs|prgrss|prggrss)$", kata)) {
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
        else if (cekKata("^(code)$", kata)) {
            kata = "kode";
        }
        else if (cekKata("^(useless)$", kata)) {
            kata = "tidak guna";
        }
        else if (cekKata("^(cot|bcot|bcod|bacot|bacod)$", kata)) {
            kata = "berisik";
        }
        else if (cekKata("^(g|ga|gk|gx|gak|gax|engg|ngga|nggak|enggax|enggak|tdk|tdak|tak|tk|kurang|krang|krng|nga|nda|ndak)$", kata)) {
            kata = "tidak";
        }
        else if (cekKata("^(prnh|perna|prna|prnah)$", kata)) {
            kata = "pernah";
        }
        else if (cekKata("^(gosah)$", kata)) {
            kata = "tidak usah";
        }
//        else if (cekKata("^(ganyampe|gasampe)$", kata)) {
//            kata = "tidak sampai";
//        }
        else if (cekKata("^(rmh|rmah|rumh)$", kata)) {
            kata = "rumah";
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
        else if (cekKata("^(stlh|stlah|stelah)$", kata)) {
            kata = "telah";
        }
        else if (cekKata("^(nyasar|nysar|nyasr|nysr|kesasar)$", kata)) {
            kata = "nosent";
        }
        else if (cekKata("^(muter)$", kata)) {
            kata = "putar";
        }
        else if (cekKata("^(nyangkut|nyangkt|nyngkut|nyngkt|sangkut)$", kata)) {
            kata = "nofast";
        }
        else if (cekKata("^(stuck|stuk|stak|ngestuck|ngestuk|ngestak|ngstuck|ngstak|ngstuk)$", kata)) {
            kata = "nofast";//macet atau terjebak
        }
        else if (cekKata("^(mandek|sendat|tunda|tahan|ketahan|ketunda|ditunda|tertunda|tertahan|tersendat)$", kata)) {
            kata = "nofast";
        }
        else if (cekKata("^(tertukar)$", kata)) {
            kata = "nohappy";
        }
        else if (cekKata("^(ampe|sampe|smpe|samp|nyampe|nympe)", kata)) {
            kata = "sampai";
        }
        else if (cekKata("^(smp|smpai)$", kata)) {
            kata = "sampai";
        }
        else if (cekKata("^(sgt|sangt|sngat|sngt)$", kata)) {
            kata = "sangat";
        }
        else if (cekKata("^(skli|skl|sklian)$", kata)) {
            kata = "sekali";
        }
        else if (cekKata("^(lmbt|lmbat|lambt)$", kata)) {
            kata = "lambat";
        }
        else if (cekKata("^(lemot|lmot|lelet|llet|siput|keong|kiong)$", kata)) {
            kata = "nofast";
        }
        else if (cekKata("^(terlambat|telat|tlat|dlay|delay)$", kata)) {
            kata = "nofast";
        }
        else if (cekKata("^(lma)$", kata)) {//---------------------------------------
            kata = "lama";
        }
        else if (cekKata("^(grak|gerakan|pergerakan)$", kata)) {
            kata = "gerak";
        }
        else if (cekKata("^(br|bru)$", kata)) {
            kata = "baru";
        }
        else if (cekKata("^(bda)$", kata)) {
            kata = "beda";
        }
        else if (cekKata("^(brubah|ubh)$", kata)) {
            kata = "ubah";
        }
        else if (cekKata("^(bat|bet|bgt|bngt|bnget|bangt|bingit|bngit)$", kata)) {
            kata = "banget";
        }
        else if (cekKata("^(ngeselin|kcewa|kcwa|kesel|kesal|ksl|kesl|ksel|kzl|bete|nyesel|nysel|parah|prah|pasrah|psrah|ngecewain|ngcewain|mengecewakan|menyesal|sebel|sbel|sbl|ngasal|ngsal|kpok|kapok|hopeless)$", kata)) {           
            kata = "nohappy";//kecewa
        }
        else if (cekKata("^(ngaco|kacau|kacaw|kaco)$", kata)) {
            kata = "nohappy";
        }
        else if (cekKata("^(payah|ceroboh|rugi|merugikan|dirugikan)$", kata)) {
            kata = "nohappy";//kecewa
        }
        else if (cekKata("^(gedek|gedeg)$", kata)) {
            kata = "nohappy";
        }
        else if (cekKata("^(magabut)$", kata)) {
            kata = "nohappy";
        }
        else if (cekKata("^(gji|gajih)$", kata)) {
            kata = "gaji";
        }
        else if (cekKata("^(bosen|bosennya)$", kata)) {
            kata = "bosan";
        }
        else if (cekKata("^(nyerah|nyerh|nyrah|nyrh)$", kata)) {
            kata = "serah";
        }
        else if (cekKata("^(rsak|pecah|pcah|patah|ptah|hancur|ancur|ancr|penyok|sobek|robek|lecek)$", kata)) {
            kata = "rusak";
        }
        else if (cekKata("^(disobek|dirobek)$", kata)) {
            kata = "rusak";
        }
        else if (cekKata("^(ilang|hlang|hilng|hlng|diilangin)$", kata)) {
            kata = "hilang";
        }
        else if (cekKata("^(cepet|cpt|cpet|cept|gercep|grcep|gercp|grcp|scptnya)$", kata)) {////////////////////////////
            kata = "cepat";
        }
        else if (cekKata("^(hrs|hrus)$", kata)) {
            kata = "harus";
        }
        else if (cekKata("^(must|msti|musti)$", kata)) {
            kata = "mesti";
        }
        else if (cekKata("^(dgn|dng|dngan)$", kata)) {
            kata = "dengan";
        }
        else if (cekKata("^(msh|msi|msih)$", kata)) {
            kata = "masih";
        }
        else if (cekKata("^(dateng|datengin|dteng|dtengin|dtang|dtangin|dtng|dtngin|dtg)$", kata)) {
            kata = "datang";
        }
        else if (cekKata("^(i|q|ak|aq|ku|aqu|w|gw|gwe|gue|gua|gwa|sy|sya|aku|acu|me|i'm|im)$", kata)) {///////////////////
            kata = "saya";
        }
        else if (cekKata("^(u|l|lo|lu|elo|elu|you)$", kata)) {
            kata = "kamu";
        }
        else if (cekKata("^(dia|die|doi|dya|dy)$", kata)) {
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
        else if (cekKata("^(ndiri|sndri|sndiri)$", kata)) {
            kata = "sendiri";
        }
        else if (cekKata("^(ky|kyk|kyak|kek|kaya|sprti|sprt|kayak)$", kata)) {//kaya------------------
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
        else if (cekKata("^(reg|regis|regist)$", kata)) {
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
        else if (cekKata("^(skr|skrg|skrng|skrang|skarang)$", kata)) {
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
        else if (cekKata("^(smw|smua)$", kata)) {
            kata = "semua";
        }
        else if (cekKata("^(sdkt|sikit|sdikit|dikit|dkit)$", kata)) {
            kata = "sedikit";
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
        else if (cekKata("^(antr|anter|anterin|nganter)$", kata)) {/////////////////////////////
            kata = "antar";
        }
        else if (cekKata("^(tlp|telp|tlpn|tlpon|telpon|telfon|nelp|nelpon|nelpn|nlpn|nelfon|telefon|ditelp|ditlp)$", kata)) {
            kata = "telepon";
        }
        else if (cekKata("^(kntk|kntak|kontk)$", kata)) {
            kata = "kontak";
        }
        else if (cekKata("^(jls|jlas)$", kata)) {
            kata = "jelas";
        }
        else if (cekKata("^(mw|mo|mao)$", kata)) {
            kata = "mau";
        }
        else if (cekKata("^(krn|krna|karna)$", kata)) {
            kata = "karena";
        }
        else if (cekKata("^(tb|tba)$", kata)) {
            kata = "tiba";
        }
        else if (cekKata("^(tbtb)$", kata)) {
            kata = "tiba tiba";
        }
        else if (cekKata("^(soale)$", kata)) {
            kata = "soal";
        }
        else if (cekKata("^(naro|naroh|naruh|taro|taroh|dtaro|dtaroh|ditaro|ditaroh)$", kata)) {
            kata = "taruh";
        }
        else if (cekKata("^(jrk|jrak)$", kata)) {
            kata = "jarak";
        }
        else if (cekKata("^(krm|krim|dikrm|dkrim|dikirim|dkrm|krmn|krman|krimn|kriman|kiriman)$", kata)) {
            kata = "kirim";
        }
        else if (cekKata("^(trma|trima|dtrma|dtrima|nerima|nrima|nrma)$", kata)) {
            kata = "terima";
        }
        else if (cekKata("^(penerima|pnerima|pnrima|pnrma|nerima|nrima|nrma)$", kata)) {
            kata = "terima";
        }
        else if (cekKata("^(center)$", kata)) {
            kata = "pusat";
        }
        else if (cekKata("^(liat|lhat)$", kata)) {
            kata = "lihat";
        }
        else if (cekKata("^(denger|dnger|dngar|dengr)$", kata)) {
            kata = "dengar";
        }
        else if (cekKata("^(blg|blng|blang)$", kata)) {
            kata = "bilang";
        }
        else if (cekKata("^(kmpl|kmpul|kumpl)$", kata)) {
            kata = "kumpul";
        }
        else if (cekKata("^(kli)$", kata)) {
            kata = "kalih";
        }
        else if (cekKata("^(bermasalah)$", kata)) {
            kata = "masalah";
        }
        else if (cekKata("^(pkt|pket|pket|paketan|package)$", kata)) {
            kata = "paket";
        }
        else if (cekKata("^(pack|packing|packingan)$", kata)) {
            kata = "bungkus";
        }
        else if (cekKata("^(tumpukan)$", kata)) {
            kata = "tumpuk";
        }
        else if (cekKata("^(dibalikan|kebalikannya)$", kata)) {
            kata = "balik";
        }
        else if (cekKata("^(pengalaman)$", kata)) {
            kata = "alam";
        }
        else if (cekKata("^(pengantaran)$", kata)) {
            kata = "antar";
        }
        else if (cekKata("^(ditindaklanjuti)$", kata)) {
            kata = "tindak lanjut";
        }
        else if (cekKata("^(dikembalikan)$", kata)) {
            kata = "kembali";
        }
        else if (cekKata("^(keterangan|keterangannya)$", kata)) {
            kata = "terang";
        }
        else if (cekKata("^(ksh|ksi|kasi|ksih|ngsi|ngsh|ngsih|ngasi|ngasih|dikasih|dikasihin|diksh|dikshin)$", kata)) {
            kata = "kasih";
        }
        else if (cekKata("^(memberikan|mmberikan|mmbrikan|membrikan|membrkn|mmbrkn|dbrikan|dberikan|diberikan)$", kata)) {//////////////////////////
            kata = "beri";
        }
        else if (cekKata("^(lsg|lgs|lngsung|langsng|lngsng)$", kata)) {
            kata = "langsung";
        }
        else if (cekKata("^(thanks|thank|thanx|thnx|thnks|thks|thx|tks|tx|makasih|makash|mkasih|mkash|mksih|mksh|mksi|trims)$", kata)) {
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
        else if (cekKata("^(j|z|ae|aj|az|azz|ajj|aja|aza|ajja|azza|ajh|azh|ajah|azah|ajjah|ajjh)$", kata)) {
            kata = "saja";
        }
        else if (cekKata("^(slama|slamany|slma|slmany)", kata)) {//////////////////////////////
            kata = "selama";
        }
        else if (cekKata("^(min|admn|admin|mimin)$", kata)) {
            kata = "administrator";
        }
        else if (cekKata("^(kryawan|kryawn|krywan|krywn)$", kata)) {
            kata = "karyawan";
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
        else if (cekKata("^(via|lwt|lwat|liwat)$", kata)) {
            kata = "lewat";
        }
        else if (cekKata("^(pcs|pack|bngks|bks|bh)$", kata)) {
            kata = "buah";
        }
        else if (cekKata("^(wrap|warp|wrp|packaging)$", kata)) {
            kata = "bungkus";
        }
        else if (cekKata("^(rpi|rpih|rapih|rapi)$", kata)) {
            kata = "yeshappy";
        }
        else if (cekKata("^(seal|sealed)$", kata)) {
            kata = "segel";
        }
        else if (cekKata("^(keep|simpen|simpn|smpan|smpen|smpn|dsimpan|disimpan)$", kata)) {
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
        else if (cekKata("^(kk|ka|kaa|kak|kka|kaka)$", kata)) {
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
        else if (cekKata("^(bsok)$", kata)) {
            kata = "besok";
        }
        else if (cekKata("^(pas)$", kata)) {
            kata = "saat";
        }
        else if (cekKata("^(mngkin|mngkn|maybe)$", kata)) {
            kata = "mungkin";
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
            kata = "yeshappy";
        }
        else if (cekKata("^(bagus|bgus|bgs)$", kata)) {
            kata = "yeshappy";
        }
        else if (cekKata("^(salut)$", kata)) {
            kata = "yeshappy";
        }
        else if (cekKata("^(ok|oc|oce)$", kata)) {
            kata = "oke";
        }
        else if (cekKata("^(slmt|slmat|slamat|slamet|selamet)$", kata)) {
            kata = "selamat";
        }
        else if (cekKata("^(ps|pas)$", kata)) {
            kata = "kepada";
        }
        else if (cekKata("^(pg|pgi)$", kata)) {
            kata = "pagi";
        }
        else if (cekKata("^(sre)$", kata)) {
            kata = "sore";
        }
        else if (cekKata("^(mlm|mlam|malem|semalem)$", kata)) {
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
        else if (cekKata("^(dlm|dlam)$", kata)) {
            kata = "dalam";
        }
        else if (cekKata("^(dkt|dket|deket)$", kata)) {
            kata = "dekat";
        }
        else if (cekKata("^(kt)$", kata)) {
            kata = "kota";
        }
        else if (cekKata("^(kab)$", kata)) {
            kata = "kabupaten";
        }
        else if (cekKata("^(kel)$", kata)) {
            kata = "kelurahan";
        }
        else if (cekKata("^(kec)$", kata)) {
            kata = "kecamatan";
        }
        else if (cekKata("^(prov)$", kata)) {
            kata = "provinsi";
        }
        else if (cekKata("^(jkt|jkarta)$", kata)) {
            kata = "jakarta";
        }
        else if (cekKata("^(sby|sub)$", kata)) {
            kata = "surabaya";
        }
        else if (cekKata("^(bdg)$", kata)) {
            kata = "bandung";
        }
        else if (cekKata("^(bpn)$", kata)) {
            kata = "balikpapan";
        }
        else if (cekKata("^(tgr)$", kata)) {
            kata = "tangerang";
        }
        else if (cekKata("^(tkg)$", kata)) {
            kata = "bandar lampung";
        }
        else if (cekKata("^(jakbar)$", kata)) {
            kata = "jakarta barat";
        }
        else if (cekKata("^(jaktim)$", kata)) {
            kata = "jakarta timur";
        }
        else if (cekKata("^(jatim)$", kata)) {
            kata = "jawa timur";
        }
        else if (cekKata("^(kalbar)$", kata)) {
            kata = "kalimantan barat";
        }
        else if (cekKata("^(smrg|smrng|smrang|smarng|smarang)$", kata)) {
            kata = "semarang";
        }
        else if (cekKata("^(diy|yogya|jogja)$", kata)) {
            kata = "yogyakarta";
        }
        else if (cekKata("^(tanggungjawab|bertanggungjawab|mempertanggungjawabkan|tnggngjwb)$", kata)) {
            kata = "tanggung jawab";
        }
        else if (cekKata("^(pengirimannya|pengirimanny|pengrimnnya|pengrimanny|pengrimnny)", kata)) {
            kata = "pengiriman";
        }
        else if (cekKata("^(kelanjutanny)", kata)) {
            kata = "lanjut";
        }
        else if (cekKata("^(keberadaanny)", kata)) {
            kata = "ada";
        }
        else if (cekKata("^(penyelesaianny)", kata)) {
            kata = "selesai";
        }
        else if (cekKata("^(keteranganny)", kata)) {
            kata = "terang";
        }
        else if (cekKata("^(pemesanan)$", kata)) {
            kata = "pesan";
        }
        else if (cekKata("^(sekalipun)$", kata)) {
            kata = "sekali";
        }
        else if (cekKata("^(ngerti)$", kata)) {
            kata = "paham";
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
        else if (cekKata("^(bgm|gmn|gmna|gmne|gmana|gmane|gimna|gmne|gimana|gimane|bgmn|bgmna|bgmana|begimana)$", kata)) {
            kata = "bagaimana";
        }
        else if (cekKata("^(mn|mna)$", kata)) {
            kata = "mana";
        }
        else if (cekKata("^(nanya|nnya|tnya|ditnykan)$", kata)) {
            kata = "tanya";
        }
        else if (cekKata("^(trs|trz|trus|teros|tros)$", kata)) {
            kata = "terus";
        }
        else if (cekKata("^(mulu)$", kata)) {
            kata = "melulu";
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
        else if (cekKata("^(ywd|yauda|yaudah)$", kata)) {
            kata = "sudah";
        }
        else if (cekKata("^(drpd|dripd|drpda|dripda|dripada)$", kata)) {
            kata = "daripada";
        }
        else if (cekKata("^(lol|kocak|ngelawak|ngakak)$", kata)) {
            kata = "lucu";
        }
        else if (cekKata("^(gokil|gilak)$", kata)) {
            kata = "gila";
        }
        else if (cekKata("^(btw)$", kata)) {
            kata = "omong omong";
        }
        else if (cekKata("^(php)$", kata)) {
            kata = "beri harap palsu";
        }
        else if (cekKata("^(oot)$", kata)) {
            kata = "luar topik";
        }
        else if (cekKata("^(omg)$", kata)) {
            kata = "astaga";
        }
        else if (cekKata("^(samsek)$", kata)) {
            kata = "sama sekali";
        }
        else if (cekKata("^(warbiasa|warbyasa|warbyasah)$", kata)) {
            kata = "luar biasa";
        }
        else if (cekKata("^(gj|gje|gaje|geje)$", kata)) {
            kata = "tidak jelas";
        }
        else if (cekKata("^(ongkir)$", kata)) {
            kata = "ongkos kirim";
        }
        else if (cekKata("^(ybs)$", kata)) {
            kata = "yang sangkut";
        }
        else if (cekKata("^(aer)$", kata)) {
            kata = "air";
        }
        return kata;
    }
    
    
    public String featureSpace(String kata){
//        if (cekKata("^(kecewa)$", kata)) {
//            kata = "xpuas";
//            return kata;
//        }
//        if (cekKata("^(lama banget|lambat banget|lama sekali|lambat sekali)$", kata)) {
//            kata = "xcepat";
//        }
//        if (cekKata("^(belum sampai|belum |tidak sampai|tidak datang)$", kata)) {
//            kata = "xsampai";
//            return kata;
//        }
//        return kata;
        
        kata = kata.replace("bad service", "nohappy");
        kata = kata.replace("belum ada kabar", "nohappy");
        kata = kata.replace("bikin emosi", "nohappy");
        kata = kata.replace("bikin masalah", "nohappy");
        kata = kata.replace("buat masalah", "nohappy");
        kata = kata.replace("buruk", "nohappy");
        kata = kata.replace("hilang", "nohappy");
        kata = kata.replace("jelek", "nohappy");
        kata = kata.replace("kecewa", "nohappy");
        kata = kata.replace("komplain", "nohappy");
        kata = kata.replace("rusak", "nohappy");
        kata = kata.replace("tidak becus", "nohappy");
        kata = kata.replace("tidak tanggung jawab", "nohappy");
        kata = kata.replace("tidak jelas", "nohappy");
        kata = kata.replace("tidak ada jelas", "nohappy");
        kata = kata.replace("tidak ada kabar", "nohappy");
        kata = kata.replace("tidak ada tanggung jawab", "nohappy");
        kata = kata.replace("tidak puas", "nohappy");
        kata = kata.replace("salah beri", "nohappy");
        
        kata = kata.replace("belum antar", "nofast");
        kata = kata.replace("belum di antar", "nofast");
        kata = kata.replace("belum di kirim", "nofast");
        kata = kata.replace("belum dia antar", "nofast");
        kata = kata.replace("belum dia kirim", "nofast");
        kata = kata.replace("belum gerak", "nofast");
        kata = kata.replace("belum jalan", "nofast");
        kata = kata.replace("belum kirim", "nofast");
        kata = kata.replace("belum juga antar", "nofast");
        kata = kata.replace("belum juga di antar", "nofast");
        kata = kata.replace("belum juga di kirim", "nofast");
        kata = kata.replace("belum juga dia antar", "nofast");
        kata = kata.replace("belum juga dia kirim", "nofast");
        kata = kata.replace("belum juga kirim", "nofast");
        kata = kata.replace("belum juga gerak", "nofast");
        kata = kata.replace("belum juga ubah", "nofast");
        kata = kata.replace("belum juga rubah", "nofast");
        kata = kata.replace("jadi lama", "nofast");
        kata = kata.replace("jadi lambat", "nofast");
        kata = kata.replace("lama amat", "nofast");
        kata = kata.replace("lama banget", "nofast");
        kata = kata.replace("lama benar", "nofast");
        kata = kata.replace("lama kali", "nofast");
        kata = kata.replace("lama sampai", "nofast");
        kata = kata.replace("lambat amat", "nofast");
        kata = kata.replace("lambat banget", "nofast");
        kata = kata.replace("lambat benar", "nofast");
        kata = kata.replace("lambat kali", "nofast");
        kata = kata.replace("makin lama", "nofast");
        kata = kata.replace("makin lambat", "nofast");
        kata = kata.replace("tidak ada gerak", "nofast");
        kata = kata.replace("tidak ada kabar", "nofast");
        kata = kata.replace("tidak ada maju", "nofast");//tidak ada kemajuan
        kata = kata.replace("tidak ada ubah", "nofast");//tidak ada perubahan
        kata = kata.replace("tidak ada rubah", "nofast");
        kata = kata.replace("tidak antar", "nofast");
        kata = kata.replace("tidak di antar", "nofast");
        kata = kata.replace("tidak di kirim", "nofast");
        kata = kata.replace("tidak dia antar", "nofast");
        kata = kata.replace("tidak dia kirim", "nofast");
        kata = kata.replace("tidak gerak", "nofast");
        kata = kata.replace("tidak jalan", "nofast");
        kata = kata.replace("tidak juga antar", "nofast");
        kata = kata.replace("tidak juga di antar", "nofast");
        kata = kata.replace("tidak juga dia antar", "nofast");
        kata = kata.replace("tidak juga di kirim", "nofast");
        kata = kata.replace("tidak juga dia kirim", "nofast");
        kata = kata.replace("tidak juga kirim", "nofast");
        kata = kata.replace("tidak juga gerak", "nofast");
        kata = kata.replace("tidak juga ubah", "nofast");
        kata = kata.replace("tidak juga rubah", "nofast");
        kata = kata.replace("tidak kirim", "nofast");
        kata = kata.replace("tidak ubah", "nofast");
        kata = kata.replace("tidak rubah", "nofast");
        
        kata = kata.replace("belum datang", "nosent");
        kata = kata.replace("belum di terima", "nosent");
        kata = kata.replace("belum sampai", "nosent");
        kata = kata.replace("belum terima", "nosent");
        kata = kata.replace("belum saya terima", "nosent");
        kata = kata.replace("belum juga datang", "nosent");
        kata = kata.replace("belum juga sampai", "nosent");
        kata = kata.replace("belum juga tiba", "nosent");
        kata = kata.replace("belum juga terima", "nosent");
        kata = kata.replace("belum juga di terima", "nosent");
        kata = kata.replace("tidak ada yang datang", "nosent");
        kata = kata.replace("tidak ada yang sampai", "nosent");
        kata = kata.replace("tidak ada yang tiba", "nosent");
        kata = kata.replace("tidak datang", "nosent");
        kata = kata.replace("tidak juga datang", "nosent");
        kata = kata.replace("tidak juga sampai", "nosent");
        kata = kata.replace("tidak juga tiba", "nosent");
        kata = kata.replace("tidak kunjung datang", "nosent");
        kata = kata.replace("tidak kunjung sampai", "nosent");
        kata = kata.replace("tidak kunjung tiba", "nosent");
        kata = kata.replace("tidak sampai", "nosent");
        kata = kata.replace("tidak tiba", "nosent");
        kata = kata.replace("tidak terima", "nosent");
        kata = kata.replace("tidak di terima", "nosent");
        kata = kata.replace("salah alamat", "nosent");
        kata = kata.replace("salah kirim", "nosent");
        kata = kata.replace("salah kota", "nosent");
        kata = kata.replace("salah scan", "nosent");
        kata = kata.replace("salah sortir", "nosent");
        
        ////////////////////////////////////////////////////////////////////////
        
        kata = kata.replace("belum ada kendala", "yeshappy");
        kata = kata.replace("belum ada masalah", "yeshappy");
        kata = kata.replace("belum ada sama kali masalah", "yeshappy");
        kata = kata.replace("belum ada sama kali kendala", "yeshappy");
        kata = kata.replace("selalu aman", "yeshappy");
        kata = kata.replace("tidak ada masalah", "yeshappy");
        kata = kata.replace("tidak ada kendala", "yeshappy");
        kata = kata.replace("tidak pernah ada masalah", "yeshappy");
        kata = kata.replace("tidak pernah ada kendala", "yeshappy");
        kata = kata.replace("tidak pernah masalah", "yeshappy");
        kata = kata.replace("tidak pernah kendala", "yeshappy");
        kata = kata.replace("tidak pernah nohappy", "yeshappy");
        kata = kata.replace("untung ada jntexpress", "yeshappy");
        kata = kata.replace("prefer pakai jntexpress", "yeshappy");
        kata = kata.replace("prefer jntexpress", "yeshappy");
        
        kata = kata.replace("cepat sampai", "yesfast");
        kata = kata.replace("cepat banget", "yesfast");
        kata = kata.replace("lebih cepat", "yesfast");
        kata = kata.replace("suka cepat", "yesfast");
        kata = kata.replace("sudah cepat", "yesfast");
        kata = kata.replace("tidak pernah nofast", "yesfast");
        
        kata = kata.replace("dengan selamat", "yessent");
        kata = kata.replace("selalu sampai", "yessent");
        kata = kata.replace("sudah sampai", "yessent");
        kata = kata.replace("tidak pernah nosent", "yessent");
        
        
        //untung
        
        return kata;
    }
    
    
//    public String testFS(String kata){        
////        if (cekKata("belum sampai", kata)) {
////            kata = kata.replace("belum sampai", "xsampai");
////        }
//
//        kata = kata.replaceAll("(blm|blman|blum|bluman|blom|bloman|blon|blonan|bloman|belon|belonan|belom|beloman)", "belum");
//        kata = kata.replaceAll("(sampai|ampe|sampe|smpe|smp|samp|nyampe|nympe)", "sampai");
//        kata = kata.replace("belum sampai", "xsampai");
////        kata = kata.replace("blm", "belum");
////        kata = kata.replace("blum", "belum");
////        kata = kata.replace("blom", "belum");
////        kata = kata.replace("belom", "belum");
//        
////        kata = kata.replace("smpe", "sampai");
////        kata = kata.replace("smp", "sampai");
////        kata = kata.replace("sampe", "sampai");
//        
//        return kata;
//    }
    
}


//        else if (cekKata("()", kata)) {
//            kata = "";
//        }
//        else if (cekKata("^()$", kata)) {
//            kata = "";
//        }