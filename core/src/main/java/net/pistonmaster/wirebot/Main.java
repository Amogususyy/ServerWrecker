package net.pistonmaster.wirebot;

import net.pistonmaster.wirebot.gui.MainGui;
import org.apache.commons.cli.ParseException;

import java.awt.*;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            WireBot.getLogger().log(Level.SEVERE, throwable.getMessage(), throwable);
        });

        if (GraphicsEnvironment.isHeadless() || args.length > 0) {
            runHeadless(args);
        } else {
            new MainGui(WireBot.getInstance());
        }
    }

    private static void runHeadless(String[] args) {
        if (args.length == 0) {
            CommandLineParser.printHelp();
            return;
        }

        // parse the command line args
        CommandLineParser.ParseResult result;
        try {
            result = CommandLineParser.parse(args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            CommandLineParser.printHelp();
            return;
        }

        if (result.showHelp) {
            CommandLineParser.printHelp();
            return;
        }

        WireBot.getInstance().start(result.options);
    }
}