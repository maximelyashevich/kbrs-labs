package com.elyashevich.kbrs.input;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileProcessing {
    public String readFile(String path) throws IOException {
            return new String(Files.readAllBytes(Paths.get(path)), Charset.defaultCharset()).toUpperCase();
    }

    public void writeFile(String path, String s) throws IOException {
            Files.write(Paths.get(path), s.getBytes(Charset.defaultCharset()));
    }
}
