package com.wayne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Usually when you buy something, you're asked whether your credit card number,
 * phone number or answer to your most secret question is still correct.
 * However, since someone could look over your shoulder, you don't want that shown on your screen.
 * Instead, we mask it.
 *
 * Your task is to write a function maskify, which changes all but the last four characters into '#'.
 * @author wayne
 */
public class Maskify {

    public static String maskify(String str) {
        int len = str.length();
        if(len < 4){
            return str;
        }
        String tail = str.substring(len-4);
        StringBuilder head = new StringBuilder();
        for(int i = 0; i < len-4; i++){
            head.append("#");
        }
        return head.append(tail).toString();
    }

    public static String maskifyNew(String str){
        return str.replaceAll(".(?=.{4})","#");
    }


    @Test
    public void testSolution() {
        assertEquals("############5616", Maskify.maskifyNew("4556364607935616"));
        assertEquals("#######5616",      Maskify.maskify(     "64607935616"));
        assertEquals("1",                Maskify.maskify(               "1"));
        assertEquals("",                 Maskify.maskify(                ""));

        // "What was the name of your first pet?"
        assertEquals("##ippy",                                    Maskify.maskify("Skippy")                                  );
        assertEquals("####################################man!",  Maskify.maskify("Nananananananananananananananana Batman!"));
    }
}
