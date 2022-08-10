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

    private final static StringBuilder circleString = new StringBuilder("<circle cx=\"?\" cy=\"?\" r=\"?\" style=\"fill:?;stroke:?\"/>");
    private final static StringBuilder rectString = new StringBuilder("<rect x=\"?\" y=\"?\" width=\"?\" height=\"?\" style=\"fill:?;stroke:?\"/>");
    private final static StringBuilder ellipseString = new StringBuilder("<ellipse cx=\"?\" cy=\"?\" rx=\"?\" ry=\"?\" style=\"fill:?;stroke:?\"/>");

    public int subjectsWeight = 10;
    public int subjectHeight = 800;
    public int containersWeight = 10;
    public int containersHeight = 250;

    public SVGWriter(String fileName) throws IOException {
        this.fileName = fileName;
        this.writeHeader();
    }

    public StringBuilder getCircleString(){
        return circleString;
    }
    public StringBuilder getRectString(){
        return rectString;
    }
    public StringBuilder getEllipseString(){
        return ellipseString;
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
            fileWriter.write("<svg width=\"1500\" height=\"930\" viewBox=\"0 0 1500 930\" \n xmlns=\"http://www.w3.org/2000/svg\">" +
                    "\n<rect width=\"100%\" height=\"100%\" fill=\"gray\" fill-opacity=\"0.25\"/>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeShape(StringBuilder writeString, String ... arrayLists) throws IOException {
        StringBuilder localSB = new StringBuilder(writeString);
        Pattern pattern = Pattern.compile("[?]");
        Matcher matcher = pattern.matcher(localSB);
        int i = 0;
        while (matcher.find(0)) {
            localSB.insert(matcher.start()+1, arrayLists[i++]);
            localSB.deleteCharAt(matcher.start());
        }
        fileWriter.write(localSB.toString());
    }

//    public void writeCircle(String ... arrayLists) throws IOException {
//        StringBuilder circleWriteString = new StringBuilder("");
//        Pattern pattern = Pattern.compile("[?]");
//        Matcher matcher = pattern.matcher(circleWriteString);
//        System.out.println(circleWriteString.toString());
//        int i = 0;
//        while (matcher.find(0)) {
//            circleWriteString.insert(matcher.start()+1, arrayLists[i++]);
//            circleWriteString.deleteCharAt(matcher.start());
//            System.out.println(circleWriteString);
//        }
//        fileWriter.write(circleWriteString.toString());
//    }
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
