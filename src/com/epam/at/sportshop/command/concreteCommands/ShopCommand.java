package com.epam.at.sportshop.command.concreteCommands;

import com.epam.at.sportshop.command.ShopReceiver;

/**
 * Represents abstract class of shop commands.
 *
 * @author Eugeny Titenkov
 */
abstract class ShopCommand implements Command {
    protected ShopReceiver shopReceiver;

    public ShopCommand(ShopReceiver shopReceiver) {
        this.shopReceiver = shopReceiver;
    }
}
