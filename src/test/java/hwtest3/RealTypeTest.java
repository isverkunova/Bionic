package hwtest3;

import hw3.RealType;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RealTypeTest {

	@Test
	public void check() {
		double num = 9.3;
		boolean expected = true;

		RealType rt = new RealType();
		boolean result = rt.verification(num);

		Assert.assertEquals(result, expected);
	}
}
