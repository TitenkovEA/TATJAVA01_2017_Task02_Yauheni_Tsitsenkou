package com.epam.at.sportshop;

import com.epam.at.sportshop.beans.SportEquipment;
import com.epam.at.sportshop.command.CommandInvoker;
import com.epam.at.sportshop.data.Shop;
import com.epam.at.sportshop.utils.CommandFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Contains application entry point.
 *
 * @author Eugeny Titenkov
 */
public class Main {
    private static final String INPUT_FILE = "shop.txt";
    private static final String EXIT_COMMAND = "exit";
    private static final String RENT_COMMAND = "rent";
    private static final String HELP_COMMAND = "help";
    private static final String HELP_INFO = "Commands:\n" +
                    "[display free goods]\n" +
                    "[display rent info]\n" +
                    "[search 'search query']\n" +
                    "[rent]";
    private static final String COMMAND_SEPARATOR = "|";
    private static final String START_MESSAGE = "Hello, enter \"help\" to see all commands";

    /**
     * Application entry point.
     * initializes data store, after this it works based on user's commands.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        try {
            initializeShop(INPUT_FILE);
            CommandFactory commandFactory = new CommandFactory();
            CommandInvoker commandInvoker = new CommandInvoker();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(START_MESSAGE);
            StringBuilder line = new StringBuilder();
            line.append(reader.readLine());
            while (!line.toString().equals(EXIT_COMMAND)) {
                if (line.toString().equals(HELP_COMMAND)) {
                    System.out.println(HELP_INFO);
                } else {
                    if (line.toString().equals(RENT_COMMAND)) {
                        line.append(COMMAND_SEPARATOR);
                        System.out.println("Enter client's name:");
                        line.append(reader.readLine()).append(COMMAND_SEPARATOR);
                        System.out.println("Enter client's phone:");
                        line.append(reader.readLine()).append(COMMAND_SEPARATOR);
                        System.out.println("Enter product's category:");
                        line.append(reader.readLine()).append(COMMAND_SEPARATOR);
                        System.out.println("Enter product's title:");
                        line.append(reader.readLine()).append(COMMAND_SEPARATOR);
                        System.out.println("Enter product's price:");
                        line.append(reader.readLine());
                    }
                    try {
                        commandInvoker.invokeCommand(commandFactory.getCommand(line.toString()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                line.delete(0, line.length());
                line.append(reader.readLine());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void initializeShop(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE));

        String[] parseLine;
        String sportEquipmentCategory;
        String sportEquipmentTitle;
        int sportEquipmentPrice;
        int sportEquipmentCount;
        String line = bufferedReader.readLine();
        while (line != null) {
            parseLine = line.split("\\|");
            sportEquipmentCategory = parseLine[0];
            sportEquipmentTitle = parseLine[1];
            sportEquipmentPrice = Integer.parseInt(parseLine[2]);
            sportEquipmentCount = Integer.parseInt(parseLine[3]);
            Shop.getShop().addGoods(
                    new SportEquipment(
                            sportEquipmentCategory,
                            sportEquipmentTitle,
                            sportEquipmentPrice
                    ),
                    sportEquipmentCount
            );

            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
}
