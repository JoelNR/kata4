
package App;


import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.loader.MailListLoader;

public class Kata4 {

    private static final String fileName = "email.txt";
    private static List<Mail> mailList;
    private static Histogram<String> histogram;
    private static HistogramDisplay histogramDisplay;

    public static void main(String[] args) throws IOException {
        execute();
    }

    private static void execute() throws IOException {
        mailList = MailListLoader.read(fileName);
        histogram = build(mailList);
        new HistogramDisplay(histogram).display();
    }
    
    public static Histogram<String> build(List<Mail> mailList){
        Histogram<String> histo = new Histogram();
        for (Mail mail : mailList) {
            histo.increment(mail.getDomain());
        }
        
        return histo;
    }

}
