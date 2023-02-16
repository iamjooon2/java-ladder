package domain;

public class Name {
    private static final int NAME_MAX_LENGTH_INCLUSIVE = 5;
    private static final int NAME_MIN_LENGTH_INCLUSIVE = 1;

    private final String value;

    public Name(final String name) {
        validateNameSize(name);
        this.value = name;
    }

    private static void validateNameSize(String name) {
        if (name.length() < NAME_MIN_LENGTH_INCLUSIVE
                || name.length() > NAME_MAX_LENGTH_INCLUSIVE) {
            throw new IllegalArgumentException();
        }
    }

    public String getValue() {
        return value;
    }
}
