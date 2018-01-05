package kata5P2.main;

import java.io.IOException;
import java.util.List;
import kata5P2.model.Histogram;
import kata5P2.model.Mail;
import kata5P2.view.HistogramDisplay;
import kata5P2.view.MailHistogramBuilder;
import kata5P2.view.MailListReader;

public class Kata5P2 {
    
    private String fileName;
    private List<Mail> mailList;
    Histogram<String> histogram;
    HistogramDisplay histoDisplay;
            
    public static void main(String[] args) throws IOException {
        Kata5P2 kata4 = new Kata5P2();
        kata4.execute();
    }
    
    private void input() throws IOException {
        fileName = "C:\\Users\\Gabriel\\Documents\\NetBeansProjects\\Kata4\\emailsfile.txt"; 
        mailList = MailListReader.read(fileName);
    }
    
    private void process() throws IOException {
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    private void output() {
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.excute();
    }
    
    private void execute() throws IOException {
        input();
        process();
        output();       
    }
}
