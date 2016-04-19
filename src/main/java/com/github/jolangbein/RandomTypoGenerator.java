package com.github.jolangbein;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomTypoGenerator
{
    private static final int HIGHEST_ASCII_CHAR = 126;
    private static final int LOWEST_ASCI_CHAR = 33;

    private Random random = new Random();

    public String getTypo(final String input)
    {
        final int typoIndex = random.nextInt(input.length());
        return input.substring(0, typoIndex) + randomCharacter() + input.substring(typoIndex + 1);
    }

    private char randomCharacter()
    {
        return (char) (random.nextInt(HIGHEST_ASCII_CHAR - LOWEST_ASCI_CHAR) + LOWEST_ASCI_CHAR);
    }
}
