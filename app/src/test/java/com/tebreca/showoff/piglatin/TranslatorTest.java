package com.tebreca.showoff.piglatin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {

    @Test
    public void test1() {
        assertEquals("avehay", Translator.translate("have"));
    }

    @Test
    public void test2() {
        assertEquals("amcray", Translator.translate("cram"));
    }

    @Test
    public void test3() {
        assertEquals("aketay", Translator.translate("take"));
    }

    @Test
    public void test4() {
        assertEquals("Atcay", Translator.translate("Cat"));
    }

    @Test
    public void test5() {
        assertEquals("Impshray", Translator.translate("Shrimp"));
    }

    @Test
    public void test6() {
        assertEquals("ebuchettray", Translator.translate("trebuchet"));
    }

    @Test
    public void test7() {
        assertEquals("ateyay", Translator.translate("ate"));
    }

    @Test
    public void test8() {
        assertEquals("Appleyay", Translator.translate("Apple"));
    }

    @Test
    public void test9() {
        assertEquals("oakenyay", Translator.translate("oaken"));
    }

    @Test
    public void test10() {
        assertEquals("eagleyay", Translator.translate("eagle"));
    }

    @Test
    public void test11() {
        assertEquals("inkyay", Translator.translate("ink"));
    }

    @Test
    public void test12() {
        assertEquals("unicornyay", Translator.translate("unicorn"));
    }

    @Test
    public void test13() {
        assertEquals("", Translator.translate(""));
    }

    @Test
    public void test14() {
        assertEquals("Iyay ikelay otay eatyay oneyhay afflesway", Translator.translate("I like to eat honey waffles"));
    }

    @Test
    public void test15() {
        assertEquals("Oday ouyay inkthay ityay isyay oinggay otay ainray odaytay?", Translator.translate("Do you think it is going to rain today?"));
    }

    @Test
    public void test16() {
        assertEquals("Ehay aidsay, \"Enwhay illway isthay allyay endyay?\"", Translator.translate("He said, \"When will this all end?\""));
    }

    @Test
    public void test17() {
        assertEquals("", Translator.translate(""));
    }
}