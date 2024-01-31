package com.nimit.edumanager.documenttemplategenerator.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.nimit.edumanager.trainermanager.entity.Trainer;
import com.nimit.edumanager.trainermanager.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GenerateTrainerPaySlipService {

    @Autowired
    private TrainerService trainerService;

    public void generatePayslipsForTrainers() throws FileNotFoundException, DocumentException {
        List<Trainer> trainers = trainerService.fetchAllTrainers();
        for (Trainer trainer : trainers) {
            generatePdf(trainer);
        }
    }

    public void generatePdf(Trainer trainer) throws FileNotFoundException, DocumentException {
        String path = "temp/" + trainer.getId() + "_" + trainer.getFirstName() + "_PaySlip.pdf";

        Document document = new Document();
        FileOutputStream outputStream = new FileOutputStream(path);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.open();

            // Title Section
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD);
            Paragraph titleParagraph = new Paragraph("PAY SLIP", titleFont);
            titleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(titleParagraph);

            // Trainer Information Section
            Font infoFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            PdfPTable infoTable = new PdfPTable(2);
            infoTable.setWidthPercentage(100);
            infoTable.setSpacingBefore(15f);
            infoTable.setSpacingAfter(15f);
            addCell(infoTable, "Trainer Name:", infoFont, true);
            addCell(infoTable, combineNames(trainer), infoFont, false);
            addCell(infoTable, "Salary:", infoFont, true);
            addCell(infoTable, String.valueOf(trainer.getSalary()), infoFont, false);
            document.add(infoTable);

            // Date and Time Section (Bottom Right Corner)
            Font dateFont = FontFactory.getFont(FontFactory.HELVETICA, 10);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String currentDate = dateFormat.format(new Date());
            Paragraph dateParagraph = new Paragraph("Generated on: " + currentDate, dateFont);
            dateParagraph.setAlignment(Element.ALIGN_RIGHT);

            PdfContentByte canvas = writer.getDirectContent();
            ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, new Phrase(dateParagraph), document.right() - 10, document.bottom() + 10, 0);

        } finally {
            document.close();
        }
    }

    private void addCell(PdfPTable table, String text, Font font, boolean isHeader) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorder(isHeader ? PdfPCell.BOTTOM : PdfPCell.NO_BORDER);
        cell.setPaddingBottom(isHeader ? 8f : 5f);
        table.addCell(cell);
    }

    private String combineNames(Trainer trainer) {
        // Combine first name and last name with a space in between
        return trainer.getFirstName() + " " + trainer.getLastName();
    }

}
