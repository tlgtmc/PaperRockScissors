package com.imc.prs.constant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author tatmaca
 *
 * Messages class manages the game messages.
 */

public class Messages {

    private static final String BANNER_PATH = "src/main/resources/banner.txt";

    public static final ResourceBundle GAME_MESSAGES = ResourceBundle.getBundle("messages");

    private Messages() {
    }

    public static String getBanner() {
        StringBuilder banner = new StringBuilder();
        try (FileInputStream inputStream = new FileInputStream(BANNER_PATH)) {
            try (Scanner scanner = new Scanner(inputStream)) {
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    banner.append(line);
                    banner.append("\n");
                }
            }
        } catch (IOException e) {
            banner.append(GAME_MESSAGES.getString("welcomeMessage"));
        }

        return banner.toString();
    }

}
