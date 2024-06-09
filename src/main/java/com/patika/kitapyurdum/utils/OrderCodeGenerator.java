package com.patika.kitapyurdum.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderCodeGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 10;
    private static final Random random = new Random();

    public static String generateOrderCode() {
        StringBuilder code = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return code.toString();
    }

}
