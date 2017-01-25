package com.epam.at.sportshop.data;

import com.epam.at.sportshop.beans.SportEquipment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the information shop model.
 * Singleton pattern.
 *
 * @author Eugeny Titenkov
 */
public class Shop {
    private Map<SportEquipment, Integer> goods;
    private static Shop shop;

    private Shop() {
        goods = new HashMap<>();
    }

    public static Shop getShop() {
        if (shop == null) {
            shop = new Shop();
        }
        return shop;
    }

    /**
     * Adds goods to map.
     *
     * @param sportEquipment - sport equipment to add.
     * @param count - count of sport equipment.
     * @return object of shop.
     */
    public Shop addGoods(SportEquipment sportEquipment, int count) {
        if (goods.size() == 0) {
            goods.put(sportEquipment, count);
        } else {
            for (Map.Entry<SportEquipment, Integer> sportEquipmentEntry : goods.entrySet()) {
                if (sportEquipmentEntry.getKey().equals(sportEquipment)) {
                    sportEquipmentEntry.setValue(sportEquipmentEntry.getValue() + count);
                }
            }
            goods.put(sportEquipment, count);
        }
        return shop;
    }

    /**
     * Removes goods from map.
     *
     * @param sportEquipment - sport equipment to delete.
     * @param count - count of sport equipment.
     * @return object of shop.
     */
    public Shop deleteGoods(SportEquipment sportEquipment, int count) {
        for (Map.Entry<SportEquipment, Integer> sportEquipmentEntry : goods.entrySet()) {
            if (sportEquipmentEntry.getKey().equals(sportEquipment)) {
                if (sportEquipmentEntry.getValue() <= count) {
                    goods.remove(sportEquipment);
                }
                sportEquipmentEntry.setValue(sportEquipmentEntry.getValue() - count);
            }
        }
        return shop;
    }

    /**
     * Display the information about all goods in the shop.
     */
    public void displayGoodsInfo() {
        for (Map.Entry<SportEquipment, Integer> sportEquipmentEntry : goods.entrySet()) {
            System.out.printf(
                    "%s count='%s' \n", sportEquipmentEntry.getKey(), sportEquipmentEntry.getValue()
            );
        }
    }

    /**
     * Search some products from the shop according to the search query,
     * and adds all found information to list.
     *
     * @param request - search query.
     * @return list with information about found goods.
     */
    public List<String> searchGoods(String request) {
        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<SportEquipment, Integer> sportEquipmentEntry : goods.entrySet()) {
            if (sportEquipmentEntry.getKey().getCategory().contains(request) ||
                    sportEquipmentEntry.getKey().getTitle().contains(request)) {
                result.add(sportEquipmentEntry.getKey().toString());
            }
        }
        return result;
    }
}
