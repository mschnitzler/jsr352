/*
 * Copyright (c) 2015 Red Hat, Inc. and/or its affiliates.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Cheng Fang - Initial API and implementation
 */

package org.jberet.rest.entity;

import java.io.Serializable;
import java.util.List;
import javax.batch.runtime.JobExecution;
import javax.batch.runtime.JobInstance;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = "instanceId, jobName, jobExecutions, latestJobExecutionId")
public final class JobInstanceEntity implements JobInstance, Serializable {
    private static final long serialVersionUID = 2427272964201557394L;

    private long instanceId;
    private String jobName;
    private int numberOfJobExecutions;
    private long latestJobExecutionId;

    public JobInstanceEntity() {
    }

    public JobInstanceEntity(final JobInstance jobInstance, final List<JobExecution> jobExecutions) {
        this.instanceId = jobInstance.getInstanceId();
        this.jobName = jobInstance.getJobName();
        this.numberOfJobExecutions = jobExecutions.size();
        if (this.numberOfJobExecutions > 0) {
            this.latestJobExecutionId = jobExecutions.get(this.numberOfJobExecutions - 1).getExecutionId();
        }
    }

    public long getInstanceId() {
        return instanceId;
    }

    public String getJobName() {
        return jobName;
    }

    public int getNumberOfJobExecutions() {
        return numberOfJobExecutions;
    }

    public long getLatestJobExecutionId() {
        return latestJobExecutionId;
    }
}
