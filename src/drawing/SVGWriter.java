package drawing;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SVGWriter {

    private FileWriter fileWriter;
    private File file;
    private final String fileName;

    public SVGWriter(String fileName) throws IOException {
        this.fileName = fileName;
        this.writeHeader();
        this.writeRect("50", "50", "300", "100", "YELLOW", "BLACK");
        this.writeFooter();
    }

    private void writeHeader(){
        file = new File(fileName);
        try {
            boolean isFileCreated = file.createNewFile();
            if(isFileCreated){
                System.out.println("Файл создан\n");
            }
            fileWriter = new FileWriter(file);
            fileWriter.write("<?xml version=\"1.0\"?>\n");
            fileWriter.write("<svg width=\"1000\" height=\"1000\" viewBox=\"0 0 1000 1000\"\n xmlns=\"http://www.w3.org/2000/svg\">");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //public void writeRect(int x, int y, int width, int height, String fillColor, String strokeColor) throws IOException {
    public void writeRect(String ... arrayLists) throws IOException {
        StringBuilder rectWriteString = new StringBuilder("<rect x=\"?\" y=\"?\" width=\"?\" height=\"?\" style=\"fill:?;stroke:BLACK\"/>");
        Pattern pattern = Pattern.compile("[?]");
        Matcher matcher = pattern.matcher(rectWriteString);
        int i = 0;
        while (matcher.find()) {
            rectWriteString.deleteCharAt(matcher.start());
            rectWriteString.insert(matcher.start(), arrayLists[i++]);
            System.out.println(rectWriteString);
        }
        fileWriter.write(rectWriteString.toString());
    }
    //writeRoundRect(x,y,w,h,r1,r2,color1,color2),

    public void writeFooter(){
        try {
            //fileWriter.write("<text x=\"80\" y=\"200\">ellipse</text>\n");
            fileWriter.write("</svg>");
            fileWriter.flush();
            Desktop.getDesktop().open(file);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
