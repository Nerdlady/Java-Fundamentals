package com.company.models.appenders;

import com.company.enums.ReportLevel;
import com.company.interfaces.Layout;

public class ConsoleAppender extends AbstractAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if (reportLevel.ordinal() >= super.getReportLevel().ordinal()) {
            super.messageCount++;
            String output = super.getLayout().format(time, reportLevel, message);
            System.out.println(output);
        }
    }

    @Override
    public String toString() {
        return "Appender type: " + this.getClass().getSimpleName()
                + super.toString();
    }
}
