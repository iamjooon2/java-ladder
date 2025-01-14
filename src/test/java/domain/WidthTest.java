package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Width 는")
public class WidthTest {

    @ParameterizedTest(name = "너비가 1 이상이어야 한다 width = {0}")
    @ValueSource(ints = {-1, 0, -100})
    void 높이가_1_이상이어야_한다(final int width) {
        assertThatThrownBy(() -> new Width(width))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "생성 시 파라미터로 받은 너비를 값으로 가진다")
    @ValueSource(ints = {2, 5, 100})
    void 생성_시_파라미터로_받은_너비를_값으로_가진다(final int parsedWidth) {
        Width width = new Width(parsedWidth);
        Assertions.assertThat(width.getValue()).isEqualTo(parsedWidth);
    }
}
