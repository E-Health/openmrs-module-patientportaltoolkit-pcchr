
/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.patientportaltoolkit.api.impl;

import org.openmrs.Patient;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.patientportaltoolkit.PcchrPlanner;
import org.openmrs.module.patientportaltoolkit.api.PcchrPlannerService;
import org.openmrs.module.patientportaltoolkit.api.db.PcchrPlannerDAO;

import java.util.List;

/**
 * It is a default implementation of {@link PcchrPlannerService}.
 */
public class PcchrPlannerServiceImpl extends BaseOpenmrsService implements PcchrPlannerService {

    protected final Log log = LogFactory.getLog(this.getClass());
    private PcchrPlannerDAO dao;
    /**
     * @param dao the dao to set
     */
    public void setDao(PcchrPlannerDAO dao) {
        this.dao = dao;
    }
    /**
     * @return the dao
     */
    public PcchrPlannerDAO getDao() {
        return dao;
    }
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrPlannerService#getAllPcchrPlanners(org.openmrs.Patient)
     */
    @Override
    public List<PcchrPlanner> getAllPcchrPlanners(Patient patient) {
        return dao.getAllPcchrPlanners(patient);
    }
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrPlannerService#getPcchrPlanner(java.lang.Integer)
     */
    @Override
    public PcchrPlanner getPcchrPlanner(Integer pcchrId) {
        return dao.getPcchrPlanner(pcchrId);
    }
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrPlannerService#savePcchrPlanner(org.openmrs.module.patientportaltoolkit.PcchrPlanner)
     */
    @Override
    public PcchrPlanner savePcchrPlanner(PcchrPlanner pcchr) {
        return dao.savePcchrPlanner(pcchr);
    }
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrPlannerService#purgePcchrPlanner(org.openmrs.module.patientportaltoolkit.PcchrPlanner)
     */
    @Override
    public void purgePcchrPlanner(PcchrPlanner pcchr) {
        dao.purgePcchrPlanner(pcchr);
    }
}