package com.github.jolangbein;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypoService
{
    private final RandomTypoGenerator randomTypoGenerator;

    @Autowired
    public TypoService(final RandomTypoGenerator randomTypoGenerator)
    {
    	this.randomTypoGenerator = randomTypoGenerator;
    }

    public String typonize(final String word)
    {
        return randomTypoGenerator.getTypo(word);
    }
}
