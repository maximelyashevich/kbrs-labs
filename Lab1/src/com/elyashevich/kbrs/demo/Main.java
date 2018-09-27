package com.elyashevich.kbrs.demo;

import com.elyashevich.kbrs.action.Cesar;
import com.elyashevich.kbrs.action.Vigener;
import com.elyashevich.kbrs.action.impl.CesarImpl;
import com.elyashevich.kbrs.action.impl.VigenerImpl;
import com.elyashevich.kbrs.input.FileProcessing;
import com.elyashevich.kbrs.test.TestTextLength;

import java.io.IOException;
import java.util.Optional;

import static com.elyashevich.kbrs.util.LabTextConstant.KEYWORD_VIGENER;
import static com.elyashevich.kbrs.util.LabTextConstant.POSITION_CESAR_L;

public class Main {

    public static void main(String[] args) throws IOException {
        Cesar cesarAlgorithm = new CesarImpl();
        FileProcessing fileProcessing = new FileProcessing();
        Vigener vigenerAlgorithm = new VigenerImpl();
        TestTextLength testTextLength = new TestTextLength();

        String text = fileProcessing.readFile("test.txt");
        String cesarEncodingText = cesarAlgorithm.encryptCesar(Optional.ofNullable(text), POSITION_CESAR_L);
        fileProcessing.writeFile("CesarEncode.txt", cesarEncodingText);

        String cesarDecodingText = cesarAlgorithm.decryptCesar(Optional.ofNullable(cesarEncodingText), POSITION_CESAR_L);
        fileProcessing.writeFile("CesarDecode.txt", cesarDecodingText);

        String vigenerEncodingText = vigenerAlgorithm.encryptVigener(Optional.ofNullable(text), KEYWORD_VIGENER);
        fileProcessing.writeFile("VigenerEncode.txt", vigenerEncodingText);

        String vigenerDecodingText = vigenerAlgorithm.decryptVigener(Optional.ofNullable(vigenerEncodingText), KEYWORD_VIGENER);
        fileProcessing.writeFile("VigenerDecode.txt", vigenerDecodingText);

        testTextLength.testTextLengthByKasiskaTask3(30, 0.4, 12);
        testTextLength.testKeywordLengthByKasiskaTask4(30, 0.4, 1000);
    }
}
