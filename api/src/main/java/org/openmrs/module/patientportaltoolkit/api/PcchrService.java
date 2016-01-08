
/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.patientportaltoolkit.api;

        import org.openmrs.Patient;
        import org.openmrs.Person;
        import org.openmrs.api.OpenmrsService;
        import org.openmrs.module.patientportaltoolkit.Pcchr;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;

/**
 * This service exposes module's core functionality. It is a Spring managed bean which is configured in moduleApplicationContext.xml.
 * <p>
 * It can be accessed only via Context:<br>
 * <code>
 * Context.getService(${module-name-no-spaces}Service.class).someMethod();
 * </code>
 *
 * @see org.openmrs.api.context.Context
 */
@Transactional
public interface PcchrService extends OpenmrsService {

    /**
     * Gets a list of pcchr.
     *
     * @param user from org.openmrs.Person
     * @return the pcchr list.
     */
    @Transactional(readOnly = true)
    List<Pcchr> getAllPcchrs(Person user);
    /**
     * Gets a pcchr for a given id.
     *
     * @param id the pcchr id
     * @return the pcchr with the given id
     */
    @Transactional(readOnly = true)
    Pcchr getPcchr(Integer pcchrId);
    /**
     * Saves a new or existing pcchr.
     *
     * @param pcchr the pcchr to save.
     * @return the saved pcchr.
     */
    Pcchr savePcchr(Pcchr pcchr);
    /**
     * Deletes a pcchr from the database.
     *
     * @param pcchr the pcchr to delete.
     */
    void purgePcchr(Pcchr pcchr);
}