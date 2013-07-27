package com.mofirouz.prank;

import com.google.common.io.Files;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static java.nio.charset.Charset.defaultCharset;

public class Main {
    private final static File configFile = new File(SambaFileMonitor.class.getResource("prank.config").getFile());
    private static String[] configs;

    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
        configs = Files.toString(Main.configFile, defaultCharset()).split(File.separator);
        SambaFileMonitor sambaFileMonitor = new SambaFileMonitor(configs[0], configs[1]);
        Properties prop = new Properties();
        prop.load(sambaFileMonitor.getFile().getInputStream());
        MouseMover mouseMover = new MouseMover();

        while (true) {
            if (sambaFileMonitor.exists()) {

                mouseMover.move(100, 10);
            }

            Thread.sleep(5000);
        }


    }
}
