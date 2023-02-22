package view;

import domain.Ladder;
import domain.Line;
import domain.Name;
import domain.Names;
import domain.Prize;
import domain.Prizes;
import domain.Scaffold;
import java.util.Map;
import java.util.regex.Pattern;

public class OutputView {
    private static final int FIRST_NAME_INDEX = 0;
    private static final double INIT_SPAN = 0.0;
    private static final int ONE_BLOCK_SIZE = 10;
    private static final double KOREAN_SPAN = 1.5;
    private static final double OTHER_SPAN = 1.0;
    private static final int BLOCK_SIZE_EXCEPT_DELIMITER = 9;
    private static final String KOREAN_MATCH_REGEX = "[ㄱ-ㅎㅏ-ㅣ가-힣]";
    private static final String EXIST_SCAFFOLD_MATERIAL = "-";
    private static final String NON_EXIST_SCAFFOLD_MATERIAL = " ";
    private static final String BAR = "|";
    private static final String BLANK = " ";

    private OutputView() {
    }

    public static void printResult(final Ladder ladder, final Names playerNames, final Prizes prizes) {
        printNames(playerNames);
        printLadder(ladder);
        printPrizes(prizes);
    }

    private static void printNames(Names names) {
        for (Name name : names.getNames()) {
            System.out.print(BLANK.repeat(ONE_BLOCK_SIZE - calculateNameBlank(name)));
            System.out.printf("%s", name.getValue());
        }
        System.out.println();
    }

    private static int calculateNameBlank(Name name) {
        double userNameSpan = INIT_SPAN;
        for (Character nameLetter : name.getValue().toCharArray()) {
            userNameSpan += userNameSpanSize(nameLetter);
        }
        return (int) Math.round(userNameSpan);
    }

    private static double userNameSpanSize(Character name) {
        String detectingLetter = String.valueOf(name);
        if (Pattern.matches(KOREAN_MATCH_REGEX, detectingLetter)) {
            return KOREAN_SPAN;
        }
        return OTHER_SPAN;
    }

    private static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
            System.out.println();
        }
    }

    private static void printLine(Line line) {
        System.out.print(BLANK.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
        System.out.print(BAR);
        for (Scaffold scaffold : line.getScaffolds()) {
            printScaffold(scaffold);
        }
    }

    private static void printScaffold(Scaffold scaffold) {
        if (scaffold.getStatus()) {
            System.out.print(EXIST_SCAFFOLD_MATERIAL.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
            System.out.print(BAR);
            return;
        }
        System.out.print(NON_EXIST_SCAFFOLD_MATERIAL.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
        System.out.print(BAR);
    }

    private static void printPrizes(Prizes prizes) {
        for (Prize prize : prizes.getPrizes()) {
            System.out.print(BLANK.repeat(ONE_BLOCK_SIZE - calculatePrizeBlank(prize)));
            System.out.printf("%s", prize.getValue());
        }
        System.out.println();
    }

    private static int calculatePrizeBlank(Prize prize) {
        double prizeSpan = INIT_SPAN;
        for (Character prizeLetter : prize.getValue().toCharArray()) {
            prizeSpan += prizeSpanSize(prizeLetter);
        }
        return (int) Math.round(prizeSpan);
    }

    private static double prizeSpanSize(Character name) {
        String detectingLetter = String.valueOf(name);
        if (Pattern.matches(KOREAN_MATCH_REGEX, detectingLetter)) {
            return KOREAN_SPAN;
        }
        return OTHER_SPAN;
    }
}
