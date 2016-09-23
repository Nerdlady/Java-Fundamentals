package com.company._05IntegrationTests;

import com.company._05IntegrationTests.events.UserEvent;
import com.company._05IntegrationTests.interfaces.Category;
import com.company._05IntegrationTests.interfaces.User;

import java.util.HashSet;
import java.util.Set;

public class CategoryImpl implements Category {
    private String name;
    private Set<User> users;
    private Set<Category> childrenCategories;

    public CategoryImpl(String name) {
        this.name = name;
        this.users = new HashSet<>();
        this.childrenCategories = new HashSet<>();
    }

    public void addChildCategoty(Category category) {
        this.childrenCategories.add(category);
    }

    public void removeChildCategory(Category category) {
        this.childrenCategories.remove(category);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void assignUsers(Set<User> users) {
        for (User user : users) {
            this.users.add(user);
            this.fireUserIsAssigned(user);
        }
    }

    @Override
    public Set<User> getUsers() {
        return this.users;
    }

    @Override
    public void unsignUsers(Set<User> users) {
        for (User user : users) {
            this.users.add(user);
            this.fireUserIsUnsigned(user);
        }
    }

    private void fireUserIsAssigned(User user) {
        UserEvent event = new UserEvent(this);
        user.handleAssignUser(event);
    }

    private void fireUserIsUnsigned(User user){
        UserEvent event = new UserEvent(this);
        user.handeUnsignUser(event);
    }
}
