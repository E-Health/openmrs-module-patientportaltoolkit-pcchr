
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
        import org.openmrs.Person;
        import org.openmrs.api.impl.BaseOpenmrsService;
        import org.apache.commons.logging.Log;
        import org.apache.commons.logging.LogFactory;
        import org.openmrs.module.patientportaltoolkit.Pcchr;
        import org.openmrs.module.patientportaltoolkit.api.PcchrService;
        import org.openmrs.module.patientportaltoolkit.api.SkinHelpDeskService;
        import org.openmrs.module.patientportaltoolkit.api.db.PcchrDAO;
        import org.openmrs.module.patientportaltoolkit.api.db.SkinHelpDeskDAO;

        import java.util.List;

/**
 * It is a default implementation of {@link PcchrService}.
 */
public class PcchrServiceImpl extends BaseOpenmrsService implements PcchrService {

    protected final Log log = LogFactory.getLog(this.getClass());
    private PcchrDAO dao;
    /**
     * @param dao the dao to set
     */
    public void setDao(PcchrDAO dao) {
        this.dao = dao;
    }
    /**
     * @return the dao
     */
    public PcchrDAO getDao() {
        return dao;
    }
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrService#getAllPcchrs(org.openmrs.Person)
     */
    @Override
    public List<Pcchr> getAllPcchrs(Person user) {
        return dao.getAllPcchrs(user);
    }
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrService#getPcchr(java.lang.Integer)
     */
    @Override
    public Pcchr getPcchr(Integer pcchrId) {
        return dao.getPcchr(pcchrId);
    }
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrService#savePcchr(org.openmrs.module.patientportaltoolkit.Pcchr)
     */
    @Override
    public Pcchr savePcchr(Pcchr pcchr) {
        return dao.savePcchr(pcchr);
    }
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrService#purgePcchr(org.openmrs.module.patientportaltoolkit.Pcchr)
     */
    @Override
    public void purgePcchr(Pcchr pcchr) {
        dao.purgePcchr(pcchr);
    }
}