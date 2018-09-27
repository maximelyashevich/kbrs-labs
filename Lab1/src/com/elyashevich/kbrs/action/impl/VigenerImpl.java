package com.elyashevich.kbrs.action.impl;

import com.elyashevich.kbrs.action.Vigener;

import java.util.Optional;

public class VigenerImpl implements Vigener {
    @Override
    public String encryptVigener(Optional<String> str, String keyword) {
        StringBuilder sb = new StringBuilder(str.orElseThrow(RuntimeException::new).toUpperCase());
        for (int i = 0, j = 0; i < sb.length(); i++, j = (j + 1) % keyword.length()) {
            sb.setCharAt(i, encryptChar(sb.charAt(i), keyword.charAt(j) - 'A'));
        }
        return sb.toString();
    }

    @Override
    public String decryptVigener(Optional<String> s, String keyword) {
        StringBuilder sb = new StringBuilder(s.orElseThrow(RuntimeException::new).toUpperCase());
        for (int i = 0, j = 0; i < sb.length(); i++, j = (j + 1) % keyword.length()) {
            sb.setCharAt(i, encryptChar(sb.charAt(i), -(keyword.charAt(j) - 'A')));
        }
        return sb.toString();
    }
}
