package com.example.hackerrank;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public  static void main(String[] args) {
        //        System.out.println(mergedStrings("abcfrtq", "dsaddw"));

//       System.out.println(fibonacci(0));

//        System.out.println(maxDifferenceWithMin(Arrays.asList(2, 3, 10, 2, 4, 8, 1 )));

        System.out.println(easyStrings("abcba", "cbbaa")); // cbbaa -> abbca -> abcba
        System.out.println(easyStrings("aab", "baa"));
        System.out.println(easyStrings(
                "wszauoffphsyyyrvcfsewdrdwpocydurpzvsmfzcpiwwvhrjvwfsresfbckiubyhkulwigowqggznidxleylyqhwms",
                "qagrsoehismggrurufqzlckfzwwwoslrvuuhpesyvcrcixyozpbjkfhywzbvpynilmcyhdywiwwvdfswdefwpfyssd"));
        System.out.println(easyStrings(
                "cirxfapfkspwmecqwvgbyiutrwupvljddtcqjokhmbsulezcghtxfagtrhzaptxlydghunduviliicnncnbcykpdkxadatayryvqgdbjewzrnyhximjkcujyucfpsaofoledeuunrctocqhxgykbpsznlvdjgcfqkhtqvdilflmmzffajehqljxtwbywtbtcbchawqnp",
                "bjudxxuyqxkilgzivbfeqpjutcrztcfwmdtfrjtpqygdrqvicvokflrscpvfimcntjnqhcxenwahjcwabunsclturmfopdkpaydyzrfculywokjneybzccaxbdagpkykpvvbuxjtcypbawihhlleltifalnuycgkcwixdneqsqodhhttmtuhqwddhsaelhmbazgjfngg"));
    }


    private static String mergedStrings(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i;
        for (i = 0; i < a.length(); i++) {
            sb.append(a.charAt(i));
            if (i < b.length()) {
                sb.append(b.charAt(i));
            }
        }

        if (i < b.length()) {
            sb.append(b.substring(i));
        }
        return sb.toString();
    }

    private static List<Integer> fibonacci(int n) {
        int prev = 0, next = 1, result;
        List<Integer> numbers = new LinkedList<>();
        numbers.add(prev);
        numbers.add(next);
        if (n < 1 || n > 10) {
            return numbers;
        }

        for (int i = 0; i < n - 2; i++) {
            result = prev + next;
            prev = next;
            next = result;
            numbers.add(next);
        }
        return numbers;
    }

    static int maxDifferenceWithMin(List<Integer> a) {
        int min, maxDiff = -1;
        if (a.size() == 0) {
            return -1;
        }
        min = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            maxDiff = Math.max(maxDiff, a.get(i) - min);
            min = Math.min(min, a.get(i));
        }
        return maxDiff;
    }

    /*static int easyStrings(String a, String b) {

        Map<Character, Integer> Q = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            Q.put(b.charAt(i), i);
        }

        List<Integer> temp = Collections.nCopies(Q.size(), 0);

        Map<Integer, Integer> P = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            P.put(i + 1, 1 + Q.get(a.charAt(i)))
        }


        *//*for ( int i = 0; i < s1.size(); ++i )
            Q[ s2[i] ].push_back(i); // basically, Q is a vector [0 .. 25] of lists

        temp[0 .. 25] = {0}
        for ( int i = 0; i < s1.size(); ++i )
            P[i + 1] = 1 + Q[ s1[i] ][ temp[ s1[i] ]++ ];*//*
    }*/

    static int easyStrings(String A, String B) {

        // This parts checks whether conversion is
        // possible or not
        if (A.length() != B.length()) { return -1; }

        int i, j, res = 0;
        int count[] = new int[256];

        // count characters in A

        // subtract count for every character in B
        for (i = 0; i < A.length(); i++) {
            count[A.charAt(i)]++;
            count[B.charAt(i)]--;
        }

        // Check if all counts become 0
        for (i = 0; i < 256; i++) { if (count[i] != 0) { return -1; } }

        i = A.length() - 1;
        j = B.length() - 1;

        char[] charArrB = B.toCharArray();

        while (i >= 0) {
            // If there is a mismatch, then
            // keep incrementing result 'res'
            // until B[j] is not found in A[0..i]
            if (A.charAt(i) != B.charAt(j)) {
                char tmp = charArrB[j];
                charArrB[j] = charArrB[i];
                charArrB[i] = tmp;
                res++;
            } else {
                j--;
            }
            i--;
        }
        System.out.println(A);
        System.out.println(new String(charArrB));
        return res;
    }

    /*static int easyStrings(String A, String B) {

        System.out.println("started");
        char[] aChar = A.toCharArray();
        char[] bChar = B.toCharArray();
        System.out.println("A: " + String.valueOf(aChar));
        System.out.println("B: " + String.valueOf(bChar));
        int numMoves = 0;
        int numPos=0;
        for(int i=0;i<=aChar.length-1;i++)
        {
            if(aChar[i]!=bChar[i]){
                numPos=FindPos(aChar[i],bChar);
                if(numPos<i){
                    bChar=MoveRight(bChar,numPos,i);
                }
                if(numPos>i){
                    bChar=MoveLeft(bChar,numPos,i);
                }
                numMoves=numMoves+(numPos);
            }
        }
        System.out.println("-----------------------------");
        System.out.println("A: " + String.valueOf(aChar));
        System.out.println("B: " + String.valueOf(bChar));
        System.out.println("Number of swaps: " + numMoves);
        return numMoves;
    }*/

    public static int FindPos(char letter, char[] str) {
        int retPos = 0;
        for (int i = 0; i <= str.length - 1; i++) {
            if (str[i] == letter) {
                retPos = i;
                break;
            }
        }
        return (retPos);
    }

    public static char[] MoveRight(char[] str, int pos, int npos) {
        char[] retArray;
        char chTemp;
        retArray = str.clone();
        for (int i = pos; i < npos; i = i + 1) {
            chTemp = retArray[i];
            retArray[i] = retArray[i + 1];
            retArray[i + 1] = chTemp;
        }
        return (retArray);
    }

    public static char[] MoveLeft(char[] str, int pos, int npos) {
        char[] retArray;
        char chTemp;
        retArray = str.clone();
        for (int i = pos; i > npos; i = i - 1) {
            chTemp = retArray[i];
            retArray[i] = retArray[i - 1];
            retArray[i - 1] = chTemp;
        }
        return (retArray);
    }
}
