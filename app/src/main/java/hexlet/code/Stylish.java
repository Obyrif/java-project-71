package hexlet.code;

public class Stylish {

    public static String stylishResult(String result) {
        StringBuilder formattedResult = new StringBuilder();

        String[] lines = result.split("\n");

        for (String line : lines) {
            formattedResult.append("  ");  // Отступ
            formattedResult.append(line);  // Добавление строки
            formattedResult.append("\n");  // Перенос строки
        }

        formattedResult.append("");

        return formattedResult.toString();
    }
}
