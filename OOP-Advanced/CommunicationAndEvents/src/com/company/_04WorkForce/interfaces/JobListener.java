package com.company._04WorkForce.interfaces;

import com.company._04WorkForce.models.events.JobCompletedEvent;

public interface JobListener {
    void handleJobComplated(JobCompletedEvent event);
}
