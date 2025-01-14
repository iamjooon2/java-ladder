package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";
    private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(" + DELIMITER + ")로 구분하세요)";
    private static final String INPUT_PRIZES = "실행 결과를 입력하세요. (결과는 쉼표(" + DELIMITER + ")로 구분하세요)";
    private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_TARGET_NAME = "결과를 보고 싶은 사람은?";
    private static final String ERROR_NOT_NUMBER = "[ERROR] 사다리의 높이는 2 이상의 수를 입력해주세요";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> inputNames() {
        System.out.println(INPUT_NAMES);
        String input = scanner.nextLine();
        String[] split = input.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(split));
    }

    public static int inputHeight() {
        System.out.println(INPUT_HEIGHT);
        String input = scanner.nextLine();
        validateInt(input);
        return Integer.parseInt(input);
    }

    private static void validateInt(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    public static List<String> inputPrizes() {
        System.out.println(INPUT_PRIZES);
        String input = scanner.nextLine();
        String[] split = input.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(split));
    }

    public static String inputTargetName() {
        System.out.println(INPUT_TARGET_NAME);
        return scanner.nextLine();
    }
}
