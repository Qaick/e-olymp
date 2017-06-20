package my.eolymp;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class CryptographyChallenge {
    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        cryptographyChallenge101();
    }

    static void testThings(int n){
        System.out.println("before");
        assert(false);
//        System.err.println("error");
        System.out.println("Pumpurum");
    }

    static void testLambdas(){
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
        //java8
        //слева параметры выражения, справа тело
        numbers.forEach(integer -> System.out.print(integer+" "));//лямбда, хз пока что это такое
        numbers.forEach(System.out::print);//получение ссыки на метод
        System.out.println(sumAll(numbers, n -> true));
        System.out.println(sumAll(numbers, n -> n % 2 == 0));
        System.out.println(sumAll(numbers, n -> n > 3));
    }

    public static int sumAll(List<Integer> numbers, Predicate<Integer> p) {
        int total = 0;
        for (int number : numbers) {
            if (p.test(number)) {
                total += number;
            }
        }
        return total;
    }

    //https://www.khanacademy.org/computing/computer-science/cryptography/cryptochallenge/a/cryptochallenge-introduction
    static void cryptographyChallenge101() {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
        String s11 = "gl uhtl ishjr vba dvyyplk aoha\nvby jpwoly pz avv dlhr vu ulea\ntlzzhnl zdpajo av cpnlulyl\n" +
                "jpwoly rlfdvyk pz aol opkklu\nzftivs vm klhao pu tf mhcvypal ovsilpu luk\n",
                s12 = "vwduw l judeehg hyhubwklqj\nl frxog ilqg sohdvh uhwxuq\ndqb eoxh sulqwv iru ydxow dqg\n" +
                        "dodup ghvljq edvhg rq\nzklfk edqn brx ghflgh rq l dp\nvhwwlqj xs vdih krxvh fr\n",
                s2 = "Klkbn qlcytfy s ryuco cphgbd iz zfc mjwku ch zy esw fogm metww ossdchr zy ldsbw nyde dnzwnefyd t htdd bojice\n" +
                        "mluc dygicczh oadr zcylw adsx pil piecs komoltej t kmqqyme hp mmjx yol wpeewjc kznpc cpsvsxa uyo dhalmr ioc\n" +
                        "wpelwbc ni yfxmwjc emcyr azdqlsom dbfljw nbij xpddsyo ehxpc esw toxwb le ecsax cnuetzy wfn\n",
                s3 = "44541134541123335344541242434244325141\n" +
                        "2123113113531554425442444243443251415343543242\n" +
                        "34411125513553341342432253431144543453\n" +
                        "43225134314214325134125334121554153451\n" +
                        "3351444411225144425442444415345123551543\n" +
                        "21345111131121235142543153332142435144531534\n" +
                        "143451254253154433515432534144\n" +
                        "43513544";
        caesarCipherDec(s11, 19);//done
        caesarCipherDec(s12, 23);//done
        vigenereCipherDec(s2, "sskkuullll");//done
        polybiusSquareDec(s3);//done
        lastOne();//done
    }

    static void lastOne() {
        /*Star code:
        star have 8 vertices(lines): vershini
        2(1)      0(0)-up
        3(0)left  3(1)-up-right
        1(1)      1(0)-right
        2(0)down  0(1)-down-right
        0,1 is for number position is like 2(0) vertex on figure mean the first digit is 2,
        second vertex will be like *(1) what mean second digit. System of numeration is with base 4
        what mean 03->3-0011, 10->5-0100, 32->14-1110

        start cibc bank see schematics for alarm and vault hit tomorrow at 10am after alarm test vault code is
5567leetat black out end
    ******
         */
        int[] mas = {8, 15, 10, 9, 0, 15, 12, 1,//0
                2, 8, 10, 2, 14, 8, 5,
                15, 3, 12, 3, 14, 3, 0, 10,//2
                1, 15, 11, 11, 4, 3, 10,
                7, 7, 8, 1, 5, 3, 10, 8,//4
                8, 8, 10, 15, 8, 7, 11,
                7, 15, 10, 12, 15, 1, 8, 9,//6
                4, 6, 5, 0, 14, 11, 7,
                10, 2, 0, 4, 13, 2, 15, 8,//8
                13, 3, 6, 1, 5, 15, 14,
                11, 2, 1, 0, 14, 4, 4, 12,//10
                1, 4, 11, 13, 4, 2, 0,
                12, 11, 13, 4, 3, 3, 1, 2,//12
                15, 2, 11, 9, 12, 6, 3,
                6, 10, 0, 3, 7, 13, 0, 4, //14
                5, 9, 3, 11, 2, 8, 7,
                2, 14, 12, 13, 11, 15, 8, 2, //16
                6, 15, 12, 0, 10, 6, 12,
                7, 3, 1, 3, 3, 11, 10, 2,//18
                12, 8, 3, 10, 11, 14, 11,//all good from this into binMas
                2, 2, 13, 8, 11, 7, 12, 2};//20 P.S. didn't count last 2(0010)
        String newspaper = "Thewholegraingoodnessofbluechi" +
                "pdividendstockshasitslimitsuti" +
                "litystocksconsumerstaplespipel" +
                "inestelecomsandrealestateinves" +
                "tmenttrustshavealllostgroundov" +
                "erthepastmonthevenwhilethebroa" +//5
                "dermarkethasbeenflatwiththebon" +//6
                "dmarketsignallinganexpectation" +//7
                "ofrisinginterestratesthefiveye" +//8
                "arrallyforsteadybluechipdivide" +//9
                "ndpayershasstalledShouldyoubes" +//10
                "caredifyouownalotofthesestocks" +
                "eitherdirectlyorthroughmutualf" +//12good
                "undsorexchangetradedfundsDavid" +
                "BaskinpresidentofBaskinFinanci" +
                "alServiceshasatwoprongedanswer" +//15
                "Keepyourtopqualitydividendstoc" +
                "ksbutbepreparedtofollowhisfirm" +
                "sexampleintrimmingholdingsinst" +
                "ockssuchasTransCanadaCorpKeyer" +
                "aCorpandPembinaPipelineCorpLetsh";//20
        newspaper = newspaper.toLowerCase();

        String vowels="aeiouy";//glasnyi zvuk, krome 'y'
        int size = 21;//prob need to be counted from mas
        int[] binNP=new int[size];
//        System.out.println("Binary from newspaper:");
        for (int i = 0; i < binNP.length; i++) {
            for (int j = 0; j < 30; j++) {
                if(vowels.indexOf(newspaper.charAt(30*i+j)) < 0) binNP[i]<<=1;
                else binNP[i]=(binNP[i]<<1)+1;
            }
//            System.out.println(new StringBuilder(String.format("%2d:%30s",i, Integer.toBinaryString(binNP[i])).replace(' ', '0')).insert(7," ").insert(12,' ').insert(17,' ').insert(22,' ').insert(27,' ').insert(32,' ').insert(37,' '));
        }
        System.out.println("\nneed to xor "+mas.length*4+" or "+binNP.length*30);

        System.out.println("Binary from arrows code:");
        int[] binMas=new int[size];
        int lastExist=0,lastValue=0;
        int id=0;
        for (int i = 0; i < binMas.length; i++) {
            for (int j = 0; j < 8; j++) {
                if(j==0&&lastExist==1){
                    binMas[i]<<=2;
                    binMas[i]+=lastValue;
                }
                if(j==7){
                    if(lastExist==1){
                        lastExist=0;
                    }
                    else{
                        try {
                            binMas[i] <<= 2;
                            binMas[i] += (mas[id] & 12) >> 2;//was mistake
                            lastExist = 1;
                            lastValue = mas[id++] & 3;
                        }catch(Exception e){}
                    }
                }
                else{
                    binMas[i]<<=4;
                    try {
                        binMas[i] += mas[id++];
                    }catch(Exception e){}
                }
            }
            if(i%2==1) System.out.println(new StringBuilder(String.format("%2d:%30s",i, Integer.toBinaryString(binMas[i])).replace(' ', '0')).insert(5," ").insert(10,' ').insert(15,' ').insert(20,' ').insert(25,' ').insert(30,' ').insert(35,' '));
            else System.out.println(new StringBuilder(String.format("%2d:%30s",i, Integer.toBinaryString(binMas[i])).replace(' ', '0')).insert(7," ").insert(12,' ').insert(17,' ').insert(22,' ').insert(27,' ').insert(32,' ').insert(37,' '));
        }
        System.out.println("didn't count "+(mas.length-id));
        System.out.println("Binary after XOR:");
        int[] sp={6,10,14,18,22,26,30,34,38};
        for (int i = 0; i < binMas.length; i++) {
            binMas[i]=binMas[i]^binNP[i];
            System.out.println(new StringBuilder(String.format("%2d:%30s",i, Integer.toBinaryString(binMas[i])).replace(' ', '0')).insert(sp[0]," ").insert(sp[1],' ').insert(sp[2],' ').insert(sp[3],' ').insert(sp[4],' ').insert(sp[5],' ').insert(sp[6],' ').insert(sp[7],' ').insert(sp[8],' '));
        }
        //convert into values for polybius
        System.out.println("conv "+size+" ints into values: "+size*30/3);
        int[] polMas = new int[230];
        int idx=0;
        int pat=7;//pattern 0111
        for (int i = 0; i < binMas.length; i++) {
            System.out.print(i+": ");
            for (int j = 1; j <= 10; j++) {
                polMas[idx++]=(binMas[i]>>(30-j*3))&pat;
                System.out.print(polMas[idx-1]);
            }
            System.out.println();
        }
        //fill polybiusSquare
        String sequence = "abcdefghijklmnopqrstuvwxyz0123456789";
        int n=6,number=0;
        char[][] arr=new char[n][n];
        for (int j = 0; j < (n + 1) / 2; j++)
        {
            for (int i = n - j - 1; i > j; i--) {
                arr[i][j] = sequence.charAt(number++);
            }
            for (int i = j; i < n - j; i++) {
                arr[j][i] = sequence.charAt(number++);
            }
            for (int i = j + 1; i < n - j; i++) {
                arr[i][n - j - 1] = sequence.charAt(number++);
            }
            for (int i = n - j - 2; i > j; i--) {
                arr[n - j - 1][i] = sequence.charAt(number++);
            }
        }
        //print Polybius
        System.out.println("Polybius square:");
        System.out.println("  0 1 2 3 4 5");
        for (int i = 0; i < n; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        //can i read this?
        for (int i=0;i<polMas.length;i=i+2) {
            System.out.print(arr[polMas[i]][polMas[i+1]]);
        }
    }

    static void polybiusSquareDec(String s) {
        ArrayList<Integer> al = new ArrayList<>();
        String mes = new String();
        int tmp, ni = 0;
        int[] n = new int[8];
        //you can make char array and do all in one cycle
        for (char c : s.toCharArray()) {
            if (c != '\n') al.add(Integer.parseInt(c + ""));
            else n[ni++] = al.size();
        }
        n[ni] = 1;
        ni = 0;
        for (int i = 0; i < al.size(); i++) {
            if (n[ni] == i) {
                mes += '\n';
                ni++;
            }
            tmp = (al.get(i + 1) - 1) * 5 + al.get(i) - 1;
//            if(tmp>8) tmp++;//for i==j in square
            mes += (char) ('a' + tmp);
            i++;
        }
        System.out.println(mes);
    }

    //Сдпнпзю - ьсн йнвгя бре зжбдрсмн, мн мзцдвн мд пяансядс. Опяйсзйя - ьсн йнвгя бре пяансядс з мзйсн мд жмядс онцдлт. Лъ зф наыдгзмюдл, сднпзэ з опяйсзйт: мзцдвн мд пяансядс з мзйсн мд жмядс онцдлт. Опяйсзйтисдры, внронгя йпзоснямяпфзрсъ з чзупноямйз.
    //Caesar cipher decryption
    static void caesarCipherDec(String s, int shift) {
        for (char c : s.toCharArray()) {
            if (c != ' ' && c != '\n') System.out.print((char) ((c + shift - 'a') % 26 + 'a'));
            else System.out.print(c);
        }
        System.out.println();
    }

    //Ырыуэнжятм дксцрзсофь сьнющсюи рфжкфпьвюу. иу нмзуео мьввно нирфэ ды тхнуптр о яюы, май яоыоаюь ешгт, ддшочуръвмвк мосьроф нр пыу аклт ыи вонъма быжрсыоаю, кьощф бююпцнцк, дл и яюых уёт нш ъоп схыв. умнарьэе ф удшбжсы
    //Vigenere cipher encryption + something
    static void crypto2() {//1040-1072-1103 А-а-я
        String key = "ЛамповаяНаука";

        Scanner in = new Scanner(System.in);
        char c1 = 'А', letCase, k;
        for (int i = 0; i < 32; i++) {
            System.out.print((int) c1 + "=" + c1++ + " ");
        }
        System.out.println();
        String s = in.nextLine();
        int iKey = 0, l = 1;

        for (char c : s.toCharArray()) {
            if ('А' <= c && c <= 'я') {
                k = key.charAt(iKey);
                if (c > 'Я') letCase = 'а';
                else letCase = 'А';
                c = (char) (c - k + letCase - l);
                l = (l == 1) ? 0 : 1;
//                if(c<'А')c=(char)(c-letCase+'я');
                iKey = (iKey < key.length() - 1) ? iKey + 1 : 0;
                System.out.print(c/*+" "+(int)c*/);
            } else System.out.print(c);
        }
    }

    //Vigenere cipher decryption, for enc make (c - charCase + k)
    static void vigenereCipherDec(String message, String key) {
        char k, lc = 'a', hc = 'A', charCase;//lowCase highCase
        key=key.toLowerCase();
        int iKey = 0;
        for (char c : message.toCharArray()) {
            if (c != ' ' && c != ',' && c != '.' && c != '\n') {
                k = (char) (key.charAt(iKey) - lc);
                if (c >= lc) charCase = lc;
                else charCase = hc;
                c = (char) ((c - charCase - k + 26) % 26 + charCase);
                iKey = (iKey < key.length() - 1) ? iKey + 1 : 0;
            }
            System.out.print(c);
        }
        System.out.println();
    }
}