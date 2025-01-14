package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Names 는")
public class NamesTest {

    @Test
    void Name_의_List_를_통해_생성된다() {
        final List<Name> successNames = List.of(new Name("찰리"), new Name("가비"), new Name("포비"));
        assertDoesNotThrow(() -> new Names(successNames));
    }

    @Test
    void Name_이_둘_미만이면_에러를_던진다() {
        final List<Name> failNames = List.of(new Name("포비"));
        assertThatThrownBy(() -> new Names(failNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 크기를_알_수_있다() {
        final Name charlieName = new Name("찰리");
        final Names names = new Names(List.of(charlieName, new Name("가비")));

        assertThat(names.size()).isEqualTo(2);
    }

    @Test
    void 해당_value을_가진_Name_이_있는지_알_수_있다() {
        final Name charlieName = new Name("찰리");
        final Names names = new Names(List.of(charlieName, new Name("가비")));

        assertThat(names.isNonExistenceUser("찰리")).isEqualTo(false);
    }

    @Test
    void value_를_가진_Name의_index_를_알_수_있다() {
        final Name charlieName = new Name("찰리");
        final Names names = new Names(List.of(charlieName, new Name("가비")));

        assertThat(names.getNameIndexByValue("찰리")).isEqualTo(0);
    }

    @Test
    void name_의_순서를_알_수_있다() {
        final Name charlieName = new Name("찰리");
        final Names names = new Names(List.of(charlieName, new Name("가비")));

        assertThat(names.getNameByIndex(0)).isEqualTo(charlieName);
    }

    @Test
    void name_의_개수를_알_수_있다() {
        final Names names = new Names(List.of(new Name("찰리"),new Name("구구"), new Name("가비")));

        assertThat(names.size()).isEqualTo(3);
    }
}
