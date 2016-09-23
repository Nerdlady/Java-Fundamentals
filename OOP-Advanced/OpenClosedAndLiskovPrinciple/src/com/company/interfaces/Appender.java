package com.company.interfaces;

import com.company.enums.ReportLevel;

public interface Appender {
    Layout getLayout();
    void setReportLevel(ReportLevel reportLevel);
    ReportLevel getReportLevel();
    void append(String time, String message, ReportLevel reportLevel);
}
