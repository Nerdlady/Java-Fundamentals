package com.company._07_1984.interfaces;

import java.util.List;

public interface Observer extends Nameable,Identifiable {
    public void handleChange(Event event);
    public List<String> getChanges();
}
