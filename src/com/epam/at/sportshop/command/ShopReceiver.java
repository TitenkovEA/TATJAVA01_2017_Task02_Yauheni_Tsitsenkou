package com.epam.at.sportshop.command;

import com.epam.at.sportshop.beans.Client;
import com.epam.at.sportshop.data.ClientList;
import com.epam.at.sportshop.data.Shop;
import com.epam.at.sportshop.beans.SportEquipment;

/**
 * Represents the receiver of the shop commands.
 *
 * @author Eugeny Titenkov
 */
public class ShopReceiver {
    /**
     * Displays the information about all rented goods in the shop.
     */
    public void displayRentInfo() {
        ClientList.getClientList().displayRentClientsInfo();
    }

    /**
     * Displays the information about all free goods in the shop.
     */
    public void displayFreeGoods() {
        Shop.getShop().displayGoodsInfo();
    }

    /**
     * Displays information according to the search query.
     *
     * @param request - search query.
     */
    public void searchGoods(String request) {
        for (String goodsInfo : Shop.getShop().searchGoods(request)) {
            System.out.println(goodsInfo);
        }
    }

    /**
     * Rent some product from the shop.
     *
     * @param client - renter.
     * @param sportEquipment - product.
     * @throws Exception if renter have maximum of rent units.
     */
    public void rent(Client client, SportEquipment sportEquipment) throws Exception {
        Client existingClient = ClientList.getClientList().getClient(client);
        if (existingClient == null) {
            client.getRentUnit().addUnit(sportEquipment);
            Shop.getShop().deleteGoods(sportEquipment, 1);
            ClientList.getClientList().addClient(client);
        } else {
            existingClient.getRentUnit().addUnit(sportEquipment);
            Shop.getShop().deleteGoods(sportEquipment, 1);
        }
    }
}
