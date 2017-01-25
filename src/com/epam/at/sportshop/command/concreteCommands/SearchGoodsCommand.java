package com.epam.at.sportshop.command.concreteCommands;

import com.epam.at.sportshop.command.ShopReceiver;

/**
 * Represents the command to search some products from the shop.
 *
 * @author Eugeny Titenkov
 */
public class SearchGoodsCommand extends ShopCommand {
    private String request;

    public SearchGoodsCommand(ShopReceiver shopReceiver, String request) {
        super(shopReceiver);
        this.request = request;
    }

    public void execute() {
        shopReceiver.searchGoods(request);
    }
}
