package com.epam.at.sportshop.command.concreteCommands;

/**
 * Represents command interface.
 *
 * @author Eugeny Titenkov
 */
public interface Command {
    /**
     * Executes the command.
     */
    void execute() throws Exception;
}
