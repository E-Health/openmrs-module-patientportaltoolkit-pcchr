/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 * <p>
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.patientportaltoolkit;

import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Patient;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * It is a model class. It should extend either {@link BaseOpenmrsObject} or {@link BaseOpenmrsMetadata}.
 * Call with Param User and data
 */
public class PcchrPlanner extends BaseOpenmrsObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Patient patient;
    private String patientUuid;
    private String plannerId;
    private String plannerUuid;
    private Date startTime;
    private Date endTime;
    private String plan;
    private Boolean delivered;
    private String lastRecipientId;
    private String lastRecipientUuid;    
    private String dataStatus;



    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    //Set the Time to current
    private void setTime() {
        Calendar cal = Calendar.getInstance();
        startTime = cal.getTime();
        endTime = cal.getTime();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        setTime();
    }

    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid;
    }

    public String getPlannerId() {
        return plannerId;
    }

    public void setPlannerId(String plannerId) {
        this.plannerId = plannerId;
    }

    public String getPlannerUuid() {
        return plannerUuid;
    }

    public void setPlannerUuid(String plannerUuid) {
        this.plannerUuid = plannerUuid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    public String getLastRecipientId() {
        return lastRecipientId;
    }

    public void setLastRecipientId(String lastRecipientId) {
        this.lastRecipientId = lastRecipientId;
    }

    public String getLastRecipientUuid() {
        return lastRecipientUuid;
    }

    public void setLastRecipientUuid(String lastRecipientUuid) {
        this.lastRecipientUuid = lastRecipientUuid;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }
}