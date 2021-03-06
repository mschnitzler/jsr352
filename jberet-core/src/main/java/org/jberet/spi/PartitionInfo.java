/*
 * Copyright (c) 2017 Red Hat, Inc. and/or its affiliates.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.jberet.spi;

import java.io.Serializable;

import org.jberet.job.model.Step;
import org.jberet.runtime.JobExecutionImpl;
import org.jberet.runtime.PartitionExecutionImpl;

public class PartitionInfo implements Serializable {
    private static final long serialVersionUID = -8906466052166191853L;

    public static final String PARTITION_QUEUE = "jberet.partition";
    public static final String COLLECTOR_QUEUE = "jberet.collector";
    public static final String STOP_REQUEST_TOPIC = "jberet.stop";

    PartitionExecutionImpl partitionExecution;
    Step step;
    JobExecutionImpl jobExecution;

    public PartitionInfo(final PartitionExecutionImpl partitionExecution,
                         final Step step,
                         final JobExecutionImpl jobExecution) {
        this.partitionExecution = partitionExecution;
        this.step = step;
        this.jobExecution = jobExecution;
    }

    /**
     * Returns the name of the queue for sending and receiving partition execution
     * collector data.
     *
     * @param stepExecutionId the step execution id used to uniquely identify the step execution
     * @return the name of the queue for sending and receiving partition execution collector data
     */
    public static String getCollectorQueueName(final long stepExecutionId) {
        return COLLECTOR_QUEUE + stepExecutionId;
    }

    public static String getStopRequestTopicName(final long jobExecutionId) {
        return STOP_REQUEST_TOPIC + jobExecutionId;
    }

    public PartitionExecutionImpl getPartitionExecution() {
        return partitionExecution;
    }

    public Step getStep() {
        return step;
    }

    public JobExecutionImpl getJobExecution() {
        return jobExecution;
    }

    @Override
    public String toString() {
        return "PartitionInfo{" +
                "partitionExecution=" + partitionExecution.getPartitionId() +
                ", step=" + step.getId() +
                ", stepExecution=" + partitionExecution.getStepExecutionId() +
                ", jobExecution=" + jobExecution.getExecutionId() +
                ", jobName=" + jobExecution.getJobName() +
                '}';
    }
}
