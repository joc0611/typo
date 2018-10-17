package com.github.jolangbein;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomTypoGenerator
{
	private static final int HIGHEST_ASCII_CHAR = 126;
	private static final int LOWEST_ASCI_CHAR = 33;

	private Random random;

	public RandomTypoGenerator() {
		this(new SecureRandom());
	}

	private RandomTypoGenerator(Random random) {
		this.random = random;
	}

	public String getTypo(final String input)
	{
		final int typoIndex = random.nextInt(input.length());
		final char randomCharacter = randomCharacter();

		// If the random character is already the same as the one on the random index ->
		// try again.
		if (randomCharacter == input.charAt(typoIndex))
		{
			return getTypo(input);
		}

		return input.substring(0, typoIndex) + randomCharacter + input.substring(typoIndex + 1);
	}

	private char randomCharacter()
	{
		return (char) (random.nextInt(HIGHEST_ASCII_CHAR - LOWEST_ASCI_CHAR) + LOWEST_ASCI_CHAR);
	}
}
