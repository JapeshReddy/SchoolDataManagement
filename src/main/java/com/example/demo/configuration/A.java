import ch.qos.logback.classic.html.DefaultCssBuilder;
import ch.qos.logback.classic.html.HTMLLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class CustomHTMLLayout extends HTMLLayout {

    public CustomHTMLLayout() {
        this.setCssBuilder(new DefaultCssBuilder());
    }

    @Override
    public String getFileHeader() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html><head>");
        sb.append("<title>Logback Log Messages</title>");
        sb.append("<style>");
        sb.append("table { width: 100%; border-collapse: collapse; }");
        sb.append("th, td { border: 1px solid black; padding: 8px; text-align: left; }");
        sb.append("th { background-color: #f2f2f2; }");
        sb.append("</style>");
        sb.append("</head><body>");
        sb.append("<h1>Logback Log Messages</h1>");
        sb.append("<table>");
        sb.append("<tr><th>Timestamp</th><th>Thread</th><th>Level</th><th>Class</th><th>Line</th><th>Message</th></tr>");
        return sb.toString();
    }

    @Override
    public String doLayout(ILoggingEvent event) {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>");
        sb.append("<td>").append(new java.util.Date(event.getTimeStamp())).append("</td>");
        sb.append("<td>").append(event.getThreadName()).append("</td>");
        sb.append("<td>").append(event.getLevel()).append("</td>");
        sb.append("<td>").append(event.getLoggerName()).append("</td>");
        sb.append("<td>").append(event.getCallerData()[0].getLineNumber()).append("</td>");
        sb.append("<td>").append(event.getFormattedMessage()).append("</td>");
        sb.append("</tr>");
        return sb.toString();
    }

    @Override
    public String getFileFooter() {
        return "</table></body></html>";
    }
}
