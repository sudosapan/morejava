package com.sapan.command;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author svashish
 */
public interface Executable extends Serializable {

    /**
     * Get id of concrete command; can be used for sotring command results in a map.
     *
     * @return unique id for this command,
     */
    String getId();

    /**
     * @return the command string to execute. does not include parameters
     */
    String getCommand();

    /**
     * Returns arguments to be supplied to command
     *
     * @return arguments in expected command syntax
     */
    String getArguments();

    /**
     * key-value pairs for the command arguments
     *
     * @param arguments
     */
    void setArguments(Map<String, String> arguments);

    /**
     * list of command arguments for the command
     *
     * @param arguments
     */
    void setArguments(List<CommandArgument> arguments);


    /**
     * Executable command can be of form do_command arg1=123 arg2=345
     * <br>or<br>
     * do_command arg1 123 arg2 345
     * <p>
     * this is based on implementor
     *
     * @return Complete command to be executed, with parameters applied,
     */
    String getExecutableCommand();


}
