package com.epam.at.sportshop.command.concreteCommands;

import com.epam.at.sportshop.beans.Client;
import com.epam.at.sportshop.beans.SportEquipment;
import com.epam.at.sportshop.command.ShopReceiver;

/**
 * Represents the command to rent some product from the shop.
 *
 * @author Eugeny Titenkov
 */
public class RentCommand extends ShopCommand {
    private Client client;
    private SportEquipment sportEquipment;

    public RentCommand(ShopReceiver shopReceiver, Client client, SportEquipment sportEquipment) {
        super(shopReceiver);
        this.client = client;
        this.sportEquipment = sportEquipment;
    }

    public void execute() throws Exception {
        shopReceiver.rent(client, sportEquipment);
    }
}
