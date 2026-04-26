package OrangeHRM.listeners;

import org.testng.IExecutionListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AllureListener implements IExecutionListener, ISuiteListener {

    private String suiteFileName = "report"; // 👉 dùng biến này

    @Override
    public void onStart(ISuite suite) {
        if (suite.getXmlSuite().getFileName() != null) {
            String fullPath = suite.getXmlSuite().getFileName();

            // Lấy tên file XML
            suiteFileName = new File(fullPath).getName();

            // Bỏ .xml
            suiteFileName = suiteFileName.replace(".xml", "");
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        // không cần
    }

    @Override
    public void onExecutionFinish() {
        try {
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String reportDir = "report/" + date;

            // Generate report
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c",
                    "allure generate target/allure-results --clean -o " + reportDir);

            builder.inheritIO();
            Process process = builder.start();
            process.waitFor();

            // Rename file
            Path source = Paths.get(reportDir + "/index.html");
            Path target = Paths.get(reportDir + "/" + suiteFileName + ".html");

            if (Files.exists(source)) {
                Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("✅ Report created: " + target);
            } else {
                System.out.println("❌ index.html not found!");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}