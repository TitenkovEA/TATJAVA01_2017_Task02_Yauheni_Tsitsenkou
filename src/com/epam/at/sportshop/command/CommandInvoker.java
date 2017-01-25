package com.epam.at.sportshop.command;

import com.epam.at.sportshop.command.concreteCommands.Command;

/**
 * Represents the command invoker.
 *
 * @author Eugeny Titenkov
 */
public class CommandInvoker {
    /**
     * Executes the specified command.
     *
     * @param command - specified command.
     */
    public void invokeCommand(Command command) throws Exception {
        command.execute();
    }
}
