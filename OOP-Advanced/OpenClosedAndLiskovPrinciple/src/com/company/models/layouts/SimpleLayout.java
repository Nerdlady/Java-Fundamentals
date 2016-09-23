package com.company.models.layouts;

import com.company.enums.ReportLevel;
import com.company.interfaces.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String format(String dateTime, ReportLevel reportLevel, String message) {
        return dateTime + " - " + reportLevel + " - " + message;
    }
}
