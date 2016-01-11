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
public class Pcchr extends BaseOpenmrsObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Patient patient;
    private String patientUuid;
    private String profilerId;
    private String profilerUuid;
    private Date startTime;
    private Date endTime;
    private DataType dataType;
    private String dataName;
    private String dataCode;
    private String dataNs = "SNOMED-CT";
    private String dataUnit;
    private String dataUnitNs = "SI";
    private String charData;
    private Double numData;
    private Boolean boolData;
    private Date dateTimeData;
    private String segmentName;
    private String segmentCode;
    private String segmentNs;
    private int index = 0;
    private String prevUuid;
    private String status;

    // Constructors for various data types
    public Pcchr(Patient patient) {
        this.patient = patient;
        setTime();
    }
    public Pcchr(Patient patient, String data) {
        this.patient = patient;
        this.charData = data;
        setTime();
    }

    public Pcchr(Patient patient, double data) {
        this.patient = patient;
        this.numData = data;
        setTime();
    }

    public Pcchr(Patient patient, boolean data) {
        this.patient = patient;
        this.boolData = data;
        setTime();
    }

    public Pcchr(Patient patient, Date data) {
        this.patient = patient;
        this.dateTimeData = data;
        setTime();
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    //Set the Time to current
    public void setTime() {
        Calendar cal = Calendar.getInstance();
        startTime = cal.getTime();
        endTime = cal.getTime();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid;
    }

    public String getProfilerId() {
        return profilerId;
    }

    public void setProfilerId(String profilerId) {
        this.profilerId = profilerId;
    }

    public String getProfilerUuid() {
        return profilerUuid;
    }

    public void setProfilerUuid(String profilerUuid) {
        this.profilerUuid = profilerUuid;
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

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getDataNs() {
        return dataNs;
    }

    public void setDataNs(String dataNs) {
        this.dataNs = dataNs;
    }

    public String getDataUnit() {
        return dataUnit;
    }

    public void setDataUnit(String dataUnit) {
        this.dataUnit = dataUnit;
    }

    public String getDataUnitNs() {
        return dataUnitNs;
    }

    public void setDataUnitNs(String dataUnitNs) {
        this.dataUnitNs = dataUnitNs;
    }

    public String getCharData() {
        return charData;
    }

    public void setCharData(String charData) {
        this.charData = charData;
    }

    public Double getNumData() {
        return numData;
    }

    public void setNumData(Double numData) {
        this.numData = numData;
    }

    public Boolean getBoolData() {
        return boolData;
    }

    public void setBoolData(Boolean boolData) {
        this.boolData = boolData;
    }

    public Date getDateTimeData() {
        return dateTimeData;
    }

    public void setDateTimeData(Date dateTimeData) {
        this.dateTimeData = dateTimeData;
    }

    public String getSegmentName() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

    public String getSegmentCode() {
        return segmentCode;
    }

    public void setSegmentCode(String segmentCode) {
        this.segmentCode = segmentCode;
    }

    public String getSegmentNs() {
        return segmentNs;
    }

    public void setSegmentNs(String segmentNs) {
        this.segmentNs = segmentNs;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getPrevUuid() {
        return prevUuid;
    }

    public void setPrevUuid(String prevUuid) {
        this.prevUuid = prevUuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public enum DataType {
        C, N, B, D
    }
}