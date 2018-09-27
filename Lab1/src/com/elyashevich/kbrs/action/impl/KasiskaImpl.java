package com.elyashevich.kbrs.action.impl;

import com.elyashevich.kbrs.action.Kasiska;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class KasiskaImpl implements Kasiska {
    @Override
    public int identifyLengthOfSecretWord(Optional<String> str, int len) {
        Map<String, Integer> m = new HashMap<>(); // lgram + колчиество повторений
        String s = str.orElseThrow(RuntimeException::new);
        for (int i = 0; i < s.length() - len + 1; i++) {
            String lgram = s.substring(i, i + len);
            boolean flag = true;
            for (char c : lgram.toCharArray()) {
                if (!(c >= 'A' && c <= 'Z')) {
                    flag = false;
                }
            }
            if (!flag) {
                continue;
            }
            if (m.containsKey(lgram)) {
                continue;
            }

            int index = i;
            int count = 1;
            while ((index = s.indexOf(lgram, index + 1)) != -1) {
                count++;
            }
            if (count >= 2) {
                m.put(lgram, count);
            }
        }

        // сортируем по количеству вхождений
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(m.entrySet());
        list.sort((p1, p2) -> p2.getValue() - p1.getValue());
        //System.out.println(list.toString());

        int res = -1;
        for (Map.Entry<String, Integer> aList : list) { // смотрим самые частые л-граммы
            String lgram = aList.getKey();
            int prevIndex = s.indexOf(lgram);
            int index = s.indexOf(lgram, prevIndex + 1);
            int a = index - prevIndex;
            for (; index != -1; prevIndex = index, index = s.indexOf(lgram, index + 1)) {
                int b = index - prevIndex;
                a = nod(a, b);
            }
            res = a;
            if (res > 2) {
                break;
            }
        }
        return res;
    }
}
