package com.github.jolangbein;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypoService
{
    @Autowired
    private RandomTypoGenerator randomTypoGenerator;

    public String typonize(final String word)
    {
        return randomTypoGenerator.getTypo(word);
    }
}
