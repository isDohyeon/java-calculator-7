package calculator.controller;

import static calculator.constants.Regex.CUSTOM_DELIMITER_PATTERN;
import static calculator.constants.Regex.DELIMITER;
import static calculator.validate.Validator.validateMatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    public String extractDelimiter(String input) {
        if (isContainDelimiter(input)) {
            String customDelimiter = findGroupByRegex(input).group(1);
            return DELIMITER + "|" + Pattern.quote(customDelimiter);
        }
        return DELIMITER;
    }

    public String extractNumberContent(String input) {
        if (isContainDelimiter(input)) {
            return findGroupByRegex(input).group(2);
        }
        return input;
    }

    private static boolean isContainDelimiter(String input) {
        return input.startsWith("//");
    }

    private static Matcher findGroupByRegex(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        validateMatcher(matcher);
        return matcher;
    }
}
