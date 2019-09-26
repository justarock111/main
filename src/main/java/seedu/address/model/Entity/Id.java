package seedu.address.model.Entity;

import java.util.Objects;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Id {

    private static final String TYPE_CHARACTERS = "PDIMT";

    public static final String MESSAGE_CONSTRAINTS_INVALID_NUMBER = "Number should be of the format integer,"
            + "and adhere to the following constraints: \n"
            + "1. It should  number which can be any digit."
            + "The number must: \n"
            + "    -be at least one digit long\n"
            + "    -contain only digits from 0 to 9\n";

    public static final String MESSAGE_CONSTRAINTS_INVALID_PREFIX = "Prefix should adhere to the following constraints:\n"
            + "1. The prefix is an instance of PrefixType, which can be either one of these characters, excluding parentheses,"
            + "(" + TYPE_CHARACTERS + ") to indicate what type of entity it is. \n";


    private static final String NUMBER_REGEX = "^\\d+$";

    private PrefixType prefix;
    private final int number;

    /**
     * Constructs an {@code Id}.
     * @param prefix PrefixType to indicate type of entity.
     * @param number Index number of entity.
     */
    public Id(PrefixType prefix, int number) {
        requireNonNull(number);
        checkArgument(prefix instanceof PrefixType, MESSAGE_CONSTRAINTS_INVALID_PREFIX);
        checkArgument(isValidNumber(number), MESSAGE_CONSTRAINTS_INVALID_NUMBER);
        this.prefix = prefix;
        this.number = number;

    }

    /**
     * Returns if number is a valid number.
     * @param number Number.
     * @return boolean Whether number is in valid format.
     */
    public static boolean isValidNumber(int number) {
        return Integer.toString(number).matches(NUMBER_REGEX);
    }



    public PrefixType getPrefix() {
        return prefix;
    }


    public int getNumber() {
        return number;
    }



    public void setPrefix(PrefixType prefix) {
        this.prefix = prefix;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.prefix, this.number);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Id)) {
            return false;
        }

        Id otherId = ((Id) other);
        return otherId.getPrefix() == this.getPrefix()
                && otherId.getNumber() == this.getNumber();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getPrefix())
                .append("-")
                .append(getNumber());
        return builder.toString();
    }


    public String toStorageValue() {
        return this.toString();
    }
}

