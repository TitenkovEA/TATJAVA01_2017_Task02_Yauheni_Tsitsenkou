package com.epam.at.sportshop.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents information model about clients rented units.
 * Count of rented units can't be more than three.
 *
 * @author Eugeny Titenkov
 */
public class RentUnit {
    private List<SportEquipment> units;

    RentUnit() {
        units = new ArrayList<>();
    }

    /**
     * Add SportEquipment to rent units.
     *
     * @param sportEquipment - unit to rent.
     * @return list of rent units.
     * @throws Exception if rented unit is full.
     */
    public RentUnit addUnit(SportEquipment sportEquipment) throws Exception {
        if (units.size() == 3) {
            throw new Exception("You can't rent more than three units.");
        }
        units.add(sportEquipment);
        return this;
    }

    public RentUnit deleteUnit(SportEquipment sportEquipment) {
        units.remove(sportEquipment);
        return this;
    }

    public String toString() {
        return "RentUnit{" +
                "units=" + units +
                '}';
    }
}
