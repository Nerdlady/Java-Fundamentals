package com.company._05IntegrationTests.interfaces;

import com.company._05IntegrationTests.events.UserEvent;

public interface AssignListener {
    void handleAssignUser(UserEvent event);
    void handeUnsignUser(UserEvent event);
}
