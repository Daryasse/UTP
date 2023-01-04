import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Date;

public class PESELTest {
    private static final Date[] correctBirthDate = {new Date(59, 6, 28)};
    private static final String[] correctInput = {"59072805738"};
    private static final String[] wrongInput = {"59072805739"};

    private static Method validateMethod;
    private static Method validateChecksumMethod;
    private static Method getBirthDateMethod;
    private static Method getSexMethod;

    static {
        try {
            validateMethod = PESEL.class
                    .getDeclaredMethod("validate", String.class, Boolean.TYPE);
            validateMethod.setAccessible(true);

            validateChecksumMethod = PESEL.class
                    .getDeclaredMethod("validateControlDigit");
            validateChecksumMethod.setAccessible(true);

            getBirthDateMethod = PESEL.class
                    .getDeclaredMethod("getBirthDate", String.class, Boolean.TYPE);
            getBirthDateMethod.setAccessible(true);

            getSexMethod = PESEL.class
                    .getDeclaredMethod("getSex", String.class);
            getSexMethod.setAccessible(true);

        } catch (Throwable exception) {
            exception.getStackTrace();
        }
    }

    @Test
    public void getBirthDate() {
        try {
            for (int i = 0; i < correctInput.length; i++) {
                String correctP = correctInput[i];
                Date correctD = correctBirthDate[i];
                Assert.assertEquals(correctD, getBirthDateMethod.invoke(null, correctP, false));
            }
        } catch (Throwable exception) {
            exception.getStackTrace();
        }
    }

    @Test
    public void getSex() {
        try {
            for (String correctP : correctInput) {
                Assert.assertEquals(Sex.male, getSexMethod.invoke(null, correctP));
            }
        } catch (Throwable exception) {
            exception.getStackTrace();
        }
    }

    @Test
    public void validateCheckSum() {
      try {
          for (String correctP : correctInput) {
              Assert.assertTrue((boolean)validateChecksumMethod.invoke(null, correctP));
          }
          for (String wrongP : wrongInput) {
              Assert.assertTrue((boolean)validateChecksumMethod.invoke(null, wrongP));
          }
      } catch (Throwable exception) {
          exception.getStackTrace();
      }
    }

    @Test
    public void validate() {
        try {
            for (String correctP : correctInput) {
                Assert.assertTrue((boolean) validateMethod.invoke(null, correctP, false));
            }
            for (String wrongP : wrongInput) {
                Assert.assertTrue((boolean) validateMethod.invoke(null, wrongP, false));
            }
        } catch (Throwable exception) {
            exception.getStackTrace();
        }
    }

}