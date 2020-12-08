package com.sapan.command;

/**
 * Arguments to be supplied to a command. Concrete command classes using this class should parse the contents as
 * supported by command they execute
 *
 * @author svashish
 */
public class CommandArgument {
    private final String argumentName;
    private final String argumentValue;


    public CommandArgument(String argumentName, String argumentValue) {
        this.argumentName = argumentName;
        this.argumentValue = argumentValue;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommandArgument that = (CommandArgument) o;

        if (argumentName != null ? !argumentName.equals(that.argumentName) : that.argumentName != null) return false;
        return argumentValue != null ? argumentValue.equals(that.argumentValue) : that.argumentValue == null;
    }

    @Override
    public int hashCode() {
        int result = argumentName != null ? argumentName.hashCode() : 0;
        result = 31 * result + (argumentValue != null ? argumentValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommandArgument{");
        sb.append("argumentName='").append(argumentName).append('\'');
        sb.append(", argumentValue='").append(argumentValue).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
