package com.github.jolangbein;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/typo")
public class TypoController
{
	private final TypoService typoService;

	@Autowired
	public TypoController(final TypoService typoService)
	{
		this.typoService = typoService;
	}

	@GetMapping(params = "word")
	public String getTypo(@RequestParam("word") final String word)
	{
		return typoService.typonize(word);
	}
}
