package domain;

import java.util.ArrayList;
import java.util.List;

public class Names {
    private static final int MIN_NAME_INCLUSIVE = 2;
    private static final String ERROR_MIN_PEOPLE = "[ERROR] " + MIN_NAME_INCLUSIVE + "명 이상의 사람들을 입력해주세요";

    private final List<Name> names;

    public Names(final List<Name> names) {
        validateNames(names);
        this.names = new ArrayList<>(names);
    }

    private void validateNames(final List<Name> names) {
        if (names.size() < MIN_NAME_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MIN_PEOPLE);
        }
    }

    public int size() {
        return names.size();
    }

    public boolean hasName(String targetName) {
        return names.stream()
                .anyMatch(name -> name.getValue().equals(targetName));
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }
}