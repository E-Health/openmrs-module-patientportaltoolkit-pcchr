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
import org.openmrs.module.patientportaltoolkit.Pcchr;
import org.openmrs.module.patientportaltoolkit.api.PcchrService;
import org.openmrs.Patient;

import java.util.List;

/**
 *  Database methods for {@link PcchrService}.
 */
@Repository
public interface PcchrDAO {
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrService#getAllPcchrs(org.openmrs.Patient)
     */
    List<Pcchr> getAllPcchrs(Patient patient);
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrService#getPcchr(java.lang.Integer)
     */
    Pcchr getPcchr(Integer pcchrId);
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrService#savePcchr(org.openmrs.module.patientportaltoolkit.Pcchr)
     */
    Pcchr savePcchr(Pcchr pcchr);
    /**
     * @see org.openmrs.module.patientportaltoolkit.api.PcchrService#purgePcchr(org.openmrs.module.patientportaltoolkit.Pcchr)
     */
    void purgePcchr(Pcchr pcchr);

}