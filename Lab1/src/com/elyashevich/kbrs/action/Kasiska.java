package com.elyashevich.kbrs.action;

import com.elyashevich.kbrs.frequency.Frequency;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public interface Kasiska {
    int identifyLengthOfSecretWord(Optional<String> str, int len);
    default String vigenerGuessKey(String s, int keywordlength) {
        Frequency frequency = new Frequency();
        StringBuilder keyword = new StringBuilder();

        // для каждой подстрочки делаем частотный анализ
        for (int i = 0; i < keywordlength; i++) {
            String subStr = getSubStringEveryL(s, keywordlength, i);
            keyword.append((char)(frequency.frequencyGetOffset(subStr) + 'A'));
        }
        return keyword.toString();
    }

    // дает строчку с каждым l-ым символом начиная с оффсета
    default String getSubStringEveryL(String s, int l, int offset) {
        StringBuilder sb = new StringBuilder();
        for (int i = offset; i < s.length(); i += l) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    default int nod(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (a != 0 && b != 0) {
            a = a % b;
            if (a<b) {
                int temp = a;
                a = b;
                b = temp;
            }
        }
        return a;
    }
}
