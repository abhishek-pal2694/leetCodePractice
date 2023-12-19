package com.example.leetCodeProbs;

import java.util.Arrays;
import java.util.List;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(Arrays.asList(2,3,2,4,2,1)));
    }

    public static int majorityElement(final List<Integer> list) {
        int idx = 0;
        int count = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(idx))) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    idx = i;
                    count = 1;
                }
            }
        }
        return list.get(idx);
    }

}
