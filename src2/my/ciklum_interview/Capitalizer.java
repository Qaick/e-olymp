package my.ciklum_interview;

import org.junit.Test;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class Capitalizer {
    public static void main(String[] args) {
        System.out.println("Hello 345".matches("^[a-zA-Z ]+$"));

        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        while (true) {
            Pattern pattern =
                    Pattern.compile(console.readLine("%nEnter your regex: "));
            Matcher matcher =
                    pattern.matcher(console.readLine("Enter input string to search: "));
            boolean found = false;
            while (matcher.find()) {
                console.format("I found the text" +
                                " \"%s\" starting at " +
                                "index %d and ending at index %d.%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }
            if (!found) {
                console.format("No match found.%n");
            }
        }
    }

    //Given a string, write a function to capitalize each word's seconder) letter.
    // "Hello World" should become "HEllo WOrld"
    public static String capitalize(String document) {
        char[] carr = document.toCharArray();
        int i = 0;
        if (!Character.isWhitespace(carr[0]) && carr.length > 1 && !Character.isWhitespace(carr[1])) {
            carr[1] = Character.toUpperCase(carr[1]);
            i = 2;
        }
        for (; i < carr.length - 2;) {
            if (Character.isWhitespace(carr[i])
                    && !Character.isWhitespace(carr[i + 1])
                    && !Character.isWhitespace(carr[i + 2])) {
                carr[i + 2] = Character.toUpperCase(carr[i + 2]);
                i += 3;
            } else i++;
        }
        return String.valueOf(carr);
    }

    public static String capitalize2(String doc) {
        StringBuilder sb = new StringBuilder();
        String[] arr = doc.split("\\s");
        char[] carr;
        for (String s : arr) {
            carr = s.toCharArray();
            if (carr.length > 1) carr[1] = Character.toUpperCase(carr[1]);
            sb.append(carr);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    static Pattern pattern = Pattern.compile("[ \n][a-zA-Z\"(]{2}");

    public static String capitalize3(String doc) {
        Matcher matcher = pattern.matcher(doc);
        char[] carr = doc.toCharArray();
        int tmp;
        if (!Character.isWhitespace(carr[0]) && carr.length > 1 && !Character.isWhitespace(carr[1]))
            carr[1] = Character.toUpperCase(carr[1]);
        while (matcher.find()) {
            tmp = matcher.start()+2;
            carr[tmp] = Character.toUpperCase(carr[tmp]);
        }
        return String.valueOf(carr);
    }

    String[] sa = {};

    @Test
    public void test() {
        long startTime = System.nanoTime();
        assertEquals(capitalize3("your \nstring"), "yOur \nsTring");
        assertEquals(capitalize3("Hello World"), "HEllo WOrld");
        assertEquals(capitalize3("    Hello     world"), "    HEllo     wOrld");
        assertEquals(capitalize3("A lyrics"), "A lYrics");
        assertEquals(capitalize3(" hz"), " hZ");
        System.out.println(System.nanoTime() - startTime);
    }

    @Test
    public void testTime() {
        long startTime, sum = 0;
                    String temp1 = "There are subtle differences among greedy, reluctant, and possessive quantifiers.\n" +
                    "\n" +
                    "Greedy quantifiers are considered \"greedy\" because they force the matcher to read in, or eat, the entire input string prior to attempting the first match. If the first match attempt (the entire input string) fails, the matcher backs off the input string by one character and tries again, repeating the process until a match is found or there are no more characters left to back off from. Depending on the quantifier used in the expression, the last thing it will try matching against is 1 or 0 characters.\n" +
                    "\n" +
                    "The reluctant quantifiers, however, take the opposite approach: They start at the beginning of the input string, then reluctantly eat one character at a time looking for a match. The last thing they try is the entire input string.\n" +
                    "\n" +
                    "Finally, the possessive quantifiers always eat the entire input string, trying once (and only once) for a match. Unlike the greedy quantifiers, possessive quantifiers never back off, even if doing so would allow the overall match to succeed.\n" +
                    "\n" +
                    "my.Problem4836 illustrate, consider the input string xfooxxxxxxfoo.\n" +
                    "\n" +
                    " \n" +
                    "Enter your regex: .*foo  // greedy quantifier\n" +
                    "Enter input string to search: xfooxxxxxxfoo\n" +
                    "I found the text \"xfooxxxxxxfoo\" starting at index 0 and ending at index 13.\n" +
                    "\n" +
                    "Enter your regex: .*?foo  // reluctant quantifier\n" +
                    "Enter input string to search: xfooxxxxxxfoo\n" +
                    "I found the text \"xfoo\" starting at index 0 and ending at index 4.\n" +
                    "I found the text \"xxxxxxfoo\" starting at index 4 and ending at index 13.\n" +
                    "\n" +
                    "Enter your regex: .*+foo // possessive quantifier\n" +
                    "Enter input string to search: xfooxxxxxxfoo\n" +
                    "No match found.\n" +
                    "The first example uses the greedy quantifier .* to find \"anything\", zero or more times, followed by the letters \"f\" \"o\" \"o\". Because the quantifier is greedy, the .* portion of the expression first eats the entire input string. At this point, the overall expression cannot succeed, because the last three letters (\"f\" \"o\" \"o\") have already been consumed. So the matcher slowly backs off one letter at a time until the rightmost occurrence of \"foo\" has been regurgitated, at which point the match succeeds and the search ends.\n" +
                    "\n" +
                    "The second example, however, is reluctant, so it starts by first consuming \"nothing\". Because \"foo\" doesn't appear at the beginning of the string, it's forced to swallow the first letter (an \"x\"), which triggers the first match at 0 and 4. Our test harness continues the process until the input string is exhausted. It finds another match at 4 and 13.\n" +
                    "\n" +
                    "The third example fails to find a match because the quantifier is possessive. In this case, the entire input string is consumed by .*+, leaving nothing left over to satisfy the \"foo\" at the end of the expression. Use a possessive quantifier for situations where you want to seize all of something without ever backing off; it will outperform the equivalent greedy quantifier in cases where the match is not immediately found.";
        String temp2 ="THere aRe sUbtle dIfferences aMong gReedy, rEluctant, aNd pOssessive qUantifiers.\n" +
                    "\n" +
                    "GReedy qUantifiers aRe cOnsidered \"Greedy\" bEcause tHey fOrce tHe mAtcher tO rEad iN, oR eAt, tHe eNtire iNput sTring pRior tO aTtempting tHe fIrst mAtch. IF tHe fIrst mAtch aTtempt (The eNtire iNput sTring) fAils, tHe mAtcher bAcks oFf tHe iNput sTring bY oNe cHaracter aNd tRies aGain, rEpeating tHe pRocess uNtil a mAtch iS fOund oR tHere aRe nO mOre cHaracters lEft tO bAck oFf fRom. DEpending oN tHe qUantifier uSed iN tHe eXpression, tHe lAst tHing iT wIll tRy mAtching aGainst iS 1 oR 0 cHaracters.\n" +
                    "\n" +
                    "THe rEluctant qUantifiers, hOwever, tAke tHe oPposite aPproach: THey sTart aT tHe bEginning oF tHe iNput sTring, tHen rEluctantly eAt oNe cHaracter aT a tIme lOoking fOr a mAtch. THe lAst tHing tHey tRy iS tHe eNtire iNput sTring.\n" +
                    "\n" +
                    "FInally, tHe pOssessive qUantifiers aLways eAt tHe eNtire iNput sTring, tRying oNce (And oNly oNce) fOr a mAtch. UNlike tHe gReedy qUantifiers, pOssessive qUantifiers nEver bAck oFf, eVen iF dOing sO wOuld aLlow tHe oVerall mAtch tO sUcceed.\n" +
                    "\n" +
                    "TO iLlustrate, cOnsider tHe iNput sTring xFooxxxxxxfoo.\n" +
                    "\n" +
                    " \n" +
                    "ENter yOur rEgex: .*foo  // gReedy qUantifier\n" +
                    "ENter iNput sTring tO sEarch: xFooxxxxxxfoo\n" +
                    "I fOund tHe tExt \"Xfooxxxxxxfoo\" sTarting aT iNdex 0 aNd eNding aT iNdex 13.\n" +
                    "\n" +
                    "ENter yOur rEgex: .*?foo  // rEluctant qUantifier\n" +
                    "ENter iNput sTring tO sEarch: xFooxxxxxxfoo\n" +
                    "I fOund tHe tExt \"Xfoo\" sTarting aT iNdex 0 aNd eNding aT iNdex 4.\n" +
                    "I fOund tHe tExt \"Xxxxxxfoo\" sTarting aT iNdex 4 aNd eNding aT iNdex 13.\n" +
                    "\n" +
                    "ENter yOur rEgex: .*+foo // pOssessive qUantifier\n" +
                    "ENter iNput sTring tO sEarch: xFooxxxxxxfoo\n" +
                    "NO mAtch fOund.\n" +
                    "THe fIrst eXample uSes tHe gReedy qUantifier .* tO fInd \"Anything\", zEro oR mOre tImes, fOllowed bY tHe lEtters \"F\" \"O\" \"O\". BEcause tHe qUantifier iS gReedy, tHe .* pOrtion oF tHe eXpression fIrst eAts tHe eNtire iNput sTring. AT tHis pOint, tHe oVerall eXpression cAnnot sUcceed, bEcause tHe lAst tHree lEtters (\"f\" \"O\" \"O\") hAve aLready bEen cOnsumed. SO tHe mAtcher sLowly bAcks oFf oNe lEtter aT a tIme uNtil tHe rIghtmost oCcurrence oF \"Foo\" hAs bEen rEgurgitated, aT wHich pOint tHe mAtch sUcceeds aNd tHe sEarch eNds.\n" +
                    "\n" +
                    "THe sEcond eXample, hOwever, iS rEluctant, sO iT sTarts bY fIrst cOnsuming \"Nothing\". BEcause \"Foo\" dOesn't aPpear aT tHe bEginning oF tHe sTring, iT's fOrced tO sWallow tHe fIrst lEtter (An \"X\"), wHich tRiggers tHe fIrst mAtch aT 0 aNd 4. OUr tEst hArness cOntinues tHe pRocess uNtil tHe iNput sTring iS eXhausted. IT fInds aNother mAtch aT 4 aNd 13.\n" +
                    "\n" +
                    "THe tHird eXample fAils tO fInd a mAtch bEcause tHe qUantifier iS pOssessive. IN tHis cAse, tHe eNtire iNput sTring iS cOnsumed bY .*+, lEaving nOthing lEft oVer tO sAtisfy tHe \"Foo\" aT tHe eNd oF tHe eXpression. USe a pOssessive qUantifier fOr sItuations wHere yOu wAnt tO sEize aLl oF sOmething wIthout eVer bAcking oFf; iT wIll oUtperform tHe eQuivalent gReedy qUantifier iN cAses wHere tHe mAtch iS nOt iMmediately fOund.";


        startTime = System.nanoTime();
        assertEquals(capitalize(temp1),temp2);
        sum += System.nanoTime() - startTime;
        System.out.println("for 1: " + sum );
        sum = 0;
            startTime = System.nanoTime();
            assertEquals(capitalize3(temp1),temp2);
            sum += System.nanoTime() - startTime;

        System.out.println("for 3: " + sum );
    }
}