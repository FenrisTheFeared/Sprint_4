import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {
    private String name;
    private boolean expectedResult;

    public AccountTest(String name, boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getName() {
        return new Object[][] {
                {"Timothee Chalamet", true},
                {"Тимоти Шаламе", true},
                {"Тимотити Шаламемеме", true},
                {"Т Ш", true},
                {"Тимоти Шаламе1", true},
                {"TШ", false},
                {"Тимотити Шалапермеее", false},
                {"ТимотиШаламе", false},
                {"Тимоти  Шаламе", false},
                {"Тимоти ", false},
                {" Тимоти", false},
                {" ", false},
                {null, false}
        };
    }

    @Test
    public void accountTest() {
        Account account = new Account(name);
        assertEquals("Некорректное имя", account.checkNameToEmboss(), expectedResult);
    }
}