package com.epam.at.sportshop.command.concreteCommands;

import com.epam.at.sportshop.command.ShopReceiver;

/**
 * Represents the command to display the information about all free goods in the shop.
 *
 * @author Eugeny Titenkov
 */
public class DisplayFreeGoodsCommand extends ShopCommand {

    public DisplayFreeGoodsCommand(ShopReceiver shopReceiver) {
        super(shopReceiver);
    }

    public void execute() {
        shopReceiver.displayFreeGoods();
    }
}
