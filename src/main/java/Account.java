import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */

        String regex = "(?=^.{3,19}$)\\S+\\s\\S+$";

        if (name != null) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);
            return matcher.matches();
        } else {
            return false;
        }

    }

}
