package hexlet.code.Formatter;

public class Plain {
    public static String plainResult(String result) {
        if (result == null) {
            return null;
        }

        StringBuilder formattedResult = new StringBuilder();

        String[] lines = result.split("\n");

        for (String line : lines) {
            String[] parts = line.split(": ", 2);

            if (parts.length == 2) {
                String property = parts[0];
                String value = parts[1];

                if ("null".equals(value)) {
                    formattedResult.append("Property '").append(property).append("' was removed");
                } else if ("null".equals(property)) {
                    if ("[complex value]".equals(value)) {
                        formattedResult.append("Property '").append(parts[1])
                                .append("' was added with value: ").append(value);
                    } else {
                        formattedResult.append("Property '").append(parts[1]).append("' was added with value: '")
                                .append(value).append("'");
                    }
                } else {
                    if ("[complex value]".equals(value)) {
                        formattedResult.append("Property '").append(property)
                                .append("' was updated. From [complex value]");
                    } else {
                        formattedResult.append("Property '").append(property)
                                .append("' was updated. From '").append(value).append("'");
                    }
                }
                formattedResult.append("\n");
            }
        }

        return formattedResult.toString().trim();
    }
}








