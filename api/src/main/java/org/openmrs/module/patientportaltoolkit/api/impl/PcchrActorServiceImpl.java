
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
import org.openmrs.module.patientportaltoolkit.PcchrActor;
import org.openmrs.module.patientportaltoolkit.api.PcchrActorService;
import org.openmrs.module.patientportaltoolkit.api.db.PcchrActorDAO;

import java.util.List;

/**
 * It is a default implementation of {@link PcchrActorService}.
 */
public class PcchrActorServiceImpl extends BaseOpenmrsService implements PcchrActorService {

    protected final Log log = LogFactory.getLog(this.getClass());
    private PcchrActorDAO dao;
    /**
     * @param dao the dao to set
     */
    public void setDao(PcchrActorDAO dao) {
        this.dao = dao;
    }
    /**
     * @return the dao
     */
    public PcchrActorDAO getDao() {
        return dao;
    }
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrActorService#getAllPcchrActors(org.openmrs.Patient)
     */
    @Override
    public List<PcchrActor> getAllPcchrActors(Patient patient) {
        return dao.getAllPcchrActors(patient);
    }
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrActorService#getPcchrActor(java.lang.Integer)
     */
    @Override
    public PcchrActor getPcchrActor(Integer pcchrId) {
        return dao.getPcchrActor(pcchrId);
    }
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrActorService#savePcchrActor(org.openmrs.module.patientportaltoolkit.PcchrActor)
     */
    @Override
    public PcchrActor savePcchrActor(PcchrActor pcchr) {
        return dao.savePcchrActor(pcchr);
    }
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrActorService#purgePcchrActor(org.openmrs.module.patientportaltoolkit.PcchrActor)
     */
    @Override
    public void purgePcchrActor(PcchrActor pcchr) {
        dao.purgePcchrActor(pcchr);
    }
}