package com.github.jolangbein;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/typo")
public class TypoController
{
    @RequestMapping(params = "word", method= RequestMethod.GET)
    public String getTypo(@RequestParam("word") final String word)
    {
        return word;
    }
}
