import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return  LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        var  city= new String[]{"Москва","Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала", "Магас",
                "Нальчик", "Элиста", "Ростов-на-Дону", "Ярославль", "Санкт-Петербург", "Черкесск" ,"Петрозаводск",
                "Псков"};
        return city[new Random().nextInt(city.length)];
    }

    public static String generateName(String locale) {
       var faker = new Faker(new Locale(locale));
       return faker.name().lastName() + " " + faker.name().firstName();

    }

    public static String generatePhone(String locale) {
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();

    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)

            return new UserInfo(generateCity(locale),generateName(locale),generatePhone(locale));

        }
    }

    @Value
    public static class UserInfo {
        String city;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserInfo userInfo = (UserInfo) o;
            return Objects.equals(city, userInfo.city) && Objects.equals(name, userInfo.name) && Objects.equals(phone, userInfo.phone);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, name, phone);
        }

        String name;
        String phone;

    }


}