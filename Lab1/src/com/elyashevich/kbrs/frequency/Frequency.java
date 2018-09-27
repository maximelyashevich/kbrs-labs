package com.elyashevich.kbrs.frequency;

public class Frequency {
    // угадывает сдвиг, предполагая, что самая часто встречающаяся бука должна быть E
    public int frequencyGetOffset(String s) {
        double[] m = calculateFrequency(s);
        double max = 0.0;
        int maxi = -1;
        for (int i = 0; i < 26; i++) {
            if (m[i] > max) {
                maxi = i;
                max = m[i];
            }
        }
        int len = ('E' - 'A') - maxi;

        return (26 - len) % 26;
    }

    private double[] calculateFrequency(String s) {
        double[] m = new double[26];
        int n = 0;
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                n++;
                m[c - 'A']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            m[i] = m[i] / n;
        }
        return m;
    }
}