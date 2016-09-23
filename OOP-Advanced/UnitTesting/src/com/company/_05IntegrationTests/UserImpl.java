package com.company._05IntegrationTests;

import com.company._05IntegrationTests.events.UserEvent;
import com.company._05IntegrationTests.interfaces.Category;
import com.company._05IntegrationTests.interfaces.User;

import java.util.Set;

public class UserImpl implements User {
    private String name;
    private Set<Category> categories;

    public UserImpl(String name) {
        this.name = name;
    }

    @Override
    public void handleAssignUser(UserEvent event) {
        this.categories.add(event.getCategory());
    }

    @Override
    public void handeUnsignUser(UserEvent event) {
        this.categories.remove(event.getCategory());
    }

    @Override
    public String getName() {
        return this.name;
    }
}
