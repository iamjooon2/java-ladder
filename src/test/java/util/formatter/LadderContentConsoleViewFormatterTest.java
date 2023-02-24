package util.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.util.formatter.LadderContentConsoleViewFormatter;

class LadderContentConsoleViewFormatterTest {

    @Test
    @DisplayName("사다리 게임 내 크기가 짝수인 컨텐츠 출력 형식 테스트")
    void ladderContentEvenFormat() {
        String content = "50";
        String expected = " 50  ";

        String formatContent = LadderContentConsoleViewFormatter.formatContent(content);
        assertThat(formatContent).isEqualTo(expected);
    }

    @Test
    @DisplayName("사다리 게임 내 크기가 홀수인 컨텐츠 출력 형식 테스트")
    void ladderContentOddFormatTest() {
        String content = "꽝";
        String expected = "  꽝  ";

        String formatContent = LadderContentConsoleViewFormatter.formatContent(content);
        assertThat(formatContent).isEqualTo(expected);
    }

}