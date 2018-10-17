package com.github.jolangbein;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RandomTypoGeneratorTest {
	private static final String INPUT_STRING = "Joc rulez";
	private static final String TYPO_STRING = "Joe rulez";
	private static final int RANGE_OF_ASCII_CHARS = 126 - 33;
	private static final int RANDOM_FOR_ASCII_LOWERCASE_E = 101 - 33;
	private static final int RANDOM_FOR_ASCII_LOWERCASE_C = 99 - 33;

	@Mock
	private Random random;

	@InjectMocks
	private RandomTypoGenerator randomTypoGenerator;

	@Test
	public void generatesTypo() {
		when(random.nextInt(INPUT_STRING.length())).thenReturn(2);
		when(random.nextInt(RANGE_OF_ASCII_CHARS)).thenReturn(RANDOM_FOR_ASCII_LOWERCASE_E);

		assertThat(randomTypoGenerator.getTypo(INPUT_STRING), equalTo(TYPO_STRING));
	}

	@Test
	public void typoIsGuaranteed() {
		when(random.nextInt(INPUT_STRING.length())).thenReturn(2);
		when(random.nextInt(RANGE_OF_ASCII_CHARS))
				.thenReturn(RANDOM_FOR_ASCII_LOWERCASE_C)
				.thenReturn(RANDOM_FOR_ASCII_LOWERCASE_E);

		assertThat(randomTypoGenerator.getTypo(INPUT_STRING), equalTo(TYPO_STRING));
	}
}
