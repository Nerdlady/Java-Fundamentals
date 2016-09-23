package com.company._05IntegrationTests.events;

import com.company._05IntegrationTests.interfaces.Category;

import java.util.EventObject;

public class UserEvent extends EventObject {
    private Category category;

    public UserEvent(Category source) {
        super(source);
        this.category = source;
    }

    public Category getCategory() {
        return category;
    }
}
