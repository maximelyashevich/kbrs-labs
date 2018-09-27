package com.elyashevich.kbrs.action;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public interface Vigener {
    String encryptVigener(Optional<String> str, String keyword);
    String decryptVigener(Optional<String> s, String keyword);
    default char encryptChar(char c, int length) {
        char res = c;
        length %= 26;

        if (c >= 'A' && c <= 'Z') {
            res = (char) ((res - 'A' + length + 26) % 26 + 'A');
        }
        return res;
    }
}
