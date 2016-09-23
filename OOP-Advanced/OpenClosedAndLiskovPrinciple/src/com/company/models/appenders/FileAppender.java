package com.company.models.appenders;

import com.company.enums.ReportLevel;
import com.company.interfaces.File;
import com.company.interfaces.Layout;

public class FileAppender extends AbstractAppender {
    private File file;
    public FileAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if (reportLevel.ordinal() >= super.getReportLevel().ordinal()) {
            super.messageCount++;
            this.writeOnFile(time, message, reportLevel);
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    private void writeOnFile(String time, String message, ReportLevel reportLevel) {
        String output = super.getLayout().format(time, reportLevel, message);
        this.file.write(output);
    }

    @Override
    public String toString() {
        return "Appender type: " + this.getClass().getSimpleName()
                + super.toString()
                + ", File size: " + this.file.getSize();
    }
}
