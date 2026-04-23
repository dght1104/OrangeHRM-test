package com.OrangeHRM.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.nio.file.Path;

public class PdfUtils {

    public static String getPdfText(Path pdfPath) {
        try (PDDocument document = PDDocument.load(pdfPath.toFile())) {

            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);

        } catch (Exception e) {
            throw new RuntimeException("Failed to read PDF", e);
        }
    }

    public static String getFirstPageText(Path path) {
        try (PDDocument doc = PDDocument.load(path.toFile())) {

            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setStartPage(1);
            stripper.setEndPage(1);

            return stripper.getText(doc);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
