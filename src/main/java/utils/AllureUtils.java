package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class AllureUtils {
    public static void cleanAllureResults() {
        // Clean allure results folder
        //deleteQuietly to wait for the file when it is opened or used by another process
        FileUtils.deleteQuietly(new File("test-output/allure-results"));
    }


}
