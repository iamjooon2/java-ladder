package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("방향 일치 확인 테스트")
    void matchDirectionSuccess() {
        Direction straight = Direction.STRAIGHT_DOWN;
        Point down = new Point(straight);

        assertThat(down.matchDirection(straight)).isTrue();
    }

}