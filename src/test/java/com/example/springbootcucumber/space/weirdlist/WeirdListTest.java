package com.example.springbootcucumber.space.weirdlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WeirdListTest {
    @Test
    void testList() {
        Collection<Integer> myList = new ArrayList<>(List.of(5, 15, 25, 35, 45, 55, 65));
        System.out.println("Brutto list:" + myList);
        myList.remove(5);
        System.out.println("Netto list:" + myList);
    }

    @Test
    void testShuffle() {
        List<Integer> myList = new ArrayList<>(List.of(5, 15, 25, 35, 45, 55, 65));
        for (int i = 0; i < 100; i++) {
            Collections.shuffle(myList);
            System.out.println(myList);
        }

    }


}
