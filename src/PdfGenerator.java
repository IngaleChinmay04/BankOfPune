import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;


import java.awt.*;
import java.io.OutputStream;

public class PdfGenerator {

    public static void generatePdf(Component component, OutputStream outputStream) {
        Document document = new Document(new Rectangle(400, 300)); // Set custom page size
        try {
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.open();

            // Create a Graphics2D object for PDF
            @SuppressWarnings("deprecation")
			Graphics2D g2d = writer.getDirectContent().createGraphics(400, 300);

            // Adjust origin point to bottom left corner
//            g2d.translate(0, 300); // Translate to bottom-left corner
//            g2d.scale(1, -1); // Flip vertically

            // Draw the Swing component onto the PDF
            component.paint(g2d);
            g2d.dispose();
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
