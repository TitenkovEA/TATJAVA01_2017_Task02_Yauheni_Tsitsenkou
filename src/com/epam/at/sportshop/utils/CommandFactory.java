package com.epam.at.sportshop.utils;

import com.epam.at.sportshop.beans.Client;
import com.epam.at.sportshop.beans.SportEquipment;
import com.epam.at.sportshop.command.*;
import com.epam.at.sportshop.command.concreteCommands.*;

/**
 * Represents the command factory.
 *
 * @author Eugeny Titenkov
 */
public class CommandFactory {
    /**
     * Returns object of command according to command line.
     *
     * @param command - command line.
     * @return object of command
     * @throws Exception if command line is not recognized.
     */
    public Command getCommand(String command) throws Exception {
        if (command.equals("display free goods")) {
            return new DisplayFreeGoodsCommand(new ShopReceiver());
        } else if (command.equals("display rent info")) {
            return new DisplayRentInfoCommand(new ShopReceiver());
        } else if (command.matches("search\\s.+")) {
            String request = command.substring(7);
            return new SearchGoodsCommand(new ShopReceiver(), request);
        } else if (command.matches("rent|.+|.+|.+|.+|.+")) {
            String[] fullCommand = command.split("\\|");

            String clientName = fullCommand[1];
            String clientPhone = fullCommand[2];
            Client client = new Client(clientName, clientPhone);

            String sportEquipmentCategory = fullCommand[3];
            String sportEquipmentTitle = fullCommand[4];
            int sportEquipmentPrice = Integer.parseInt(fullCommand[5]);
            SportEquipment sportEquipment =
                    new SportEquipment(
                            sportEquipmentCategory,
                            sportEquipmentTitle,
                            sportEquipmentPrice
                    );

            return new RentCommand(new ShopReceiver(), client, sportEquipment);
        } else {
            throw new Exception("Incorrect command!");
        }
    }
}
