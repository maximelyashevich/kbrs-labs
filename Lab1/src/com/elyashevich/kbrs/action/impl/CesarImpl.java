package com.elyashevich.kbrs.action.impl;

import com.elyashevich.kbrs.action.Cesar;

import java.util.Optional;

public class CesarImpl implements Cesar {
    @Override
    public String encryptCesar(Optional<String> text, int l) {

        return text.orElseThrow(RuntimeException::new).
                    toUpperCase().chars().
                        mapToObj(i -> encryptChar((char) i, 1))
                            .collect( StringBuilder::new,
                                StringBuilder::appendCodePoint,
                                StringBuilder::append )
                                .toString();
    }

    @Override
    public String decryptCesar(Optional<String> text, int l) {
        return encryptCesar(text, -l);
    }
}
