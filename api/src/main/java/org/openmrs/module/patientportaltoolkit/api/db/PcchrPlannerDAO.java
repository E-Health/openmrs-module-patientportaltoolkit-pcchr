/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.patientportaltoolkit.api.db;

import org.springframework.stereotype.Repository;
import org.openmrs.module.patientportaltoolkit.PcchrPlanner;
import org.openmrs.module.patientportaltoolkit.api.PcchrPlannerService;
import org.openmrs.Patient;

import java.util.List;

/**
 *  Database methods for {@link PcchrPlannerService}.
 */
@Repository
public interface PcchrPlannerDAO {
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrPlannerService#getAllPcchrPlanners(org.openmrs.Patient)
     */
    List<PcchrPlanner> getAllPcchrPlanners(Patient patient);
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrPlannerService#getPcchrPlanner(java.lang.Integer)
     */
    PcchrPlanner getPcchrPlanner(Integer pcchrId);
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrPlannerService#savePcchrPlanner(org.openmrs.module.patientportaltoolkit.PcchrPlanner)
     */
    PcchrPlanner savePcchrPlanner(PcchrPlanner pcchr);
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrPlannerService#purgePcchrPlanner(org.openmrs.module.patientportaltoolkit.PcchrPlanner)
     */
    void purgePcchrPlanner(PcchrPlanner pcchr);

}