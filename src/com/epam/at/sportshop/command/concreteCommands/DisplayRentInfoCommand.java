package com.epam.at.sportshop.command.concreteCommands;

import com.epam.at.sportshop.command.ShopReceiver;

/**
 * Represents the command to display the information about all rented goods in the shop.
 *
 * @author Eugeny Titenkov
 */
public class DisplayRentInfoCommand extends ShopCommand {

    public DisplayRentInfoCommand(ShopReceiver shopReceiver) {
        super(shopReceiver);
    }

    public void execute() {
        shopReceiver.displayRentInfo();
    }
}
