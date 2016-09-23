package com.company._05IntegrationTests.interfaces;

import java.util.Set;

public interface Category {
    void addChildCategoty(Category category);
    void removeChildCategory(Category category);
    String getName();
    void assignUsers(Set<User> users);
    Set<User> getUsers();
    void unsignUsers(Set<User> users);
}
