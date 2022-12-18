package telran.validation.constraints;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

class ValidatorTest {

	private static final String NAME_1 = "Vasya";
	private static final double SALARY_1 = 10000;
	private static final String EMAIL_1 = "vasya@gmail.com";
	private static final String PHONE_NUMBER_1 = "0501231212";
	
	private static final String NAME_2 = null;
	private static final double SALARY_2 = -1;
	private static final String EMAIL_2 = "fvesv";
	private static final String PHONE_NUMBER_2 = "0505";

	@Test
	void validatorTest1() {
		PersonObj person = new PersonObj(NAME_1, SALARY_1, EMAIL_1, PHONE_NUMBER_1);
		List<String> list = Validator.validate(person);
		assertEquals(0, list.size());
	}
	@Test
	void validatorTest2() {
		PersonObj person = new PersonObj(NAME_2, SALARY_2, EMAIL_2, PHONE_NUMBER_2);
		List<String> list = Validator.validate(person);
		for(String str: list) {
			System.out.println(str);
		}
		assertEquals(5, list.size());
	}

}
