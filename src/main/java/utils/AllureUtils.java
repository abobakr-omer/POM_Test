package utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Path;

import static java.nio.file.Files.newInputStream;

public class AllureUtils {
    public static void cleanAllureResults() {
        // Clean allure results folder
        //deleteQuietly to wait for the file when it is opened or used by another process
        FileUtils.deleteQuietly(new File("test-output/allure-results"));
    }

    public static void attachScreenshotsToAllure(String screenName, String screenPath) {
        try {
            Allure.addAttachment(screenName,newInputStream(Path.of(screenPath)));

        } catch (Exception e) {
            System.out.println("Error attaching screenshot to Allure");
        }

    }


}
