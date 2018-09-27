package com.elyashevich.kbrs.action;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public interface Cesar {
    String encryptCesar(Optional<String> text, int l);
    String decryptCesar(Optional<String> text, int l);
    default char encryptChar(char c, int step) {
        char res = c;
        step %= 26;

        if (c >= 'A' && c <= 'Z') {
            res = (char) ((res - 'A' + step + 26) % 26 + 'A');
        }
        return res;
    }
}
