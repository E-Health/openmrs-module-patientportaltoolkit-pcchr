/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.skinhelpdesk.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Patient;
import org.openmrs.module.skinhelpdesk.SkinHelpDesk;
import org.openmrs.module.skinhelpdesk.api.db.SkinHelpDeskDAO;

/**
 * It is a default implementation of  {@link SkinHelpDeskDAO}.
 */

public class HibernatePcchrDAO implements SkinHelpDeskDAO {
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	/**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
    }
    
	/**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
	    return sessionFactory;
    }

	/**
	 * @see org.openmrs.module.skinhelpdesk.api.db.SkinHelpDeskDAO#getLesionmap(org.openmrs.Patient)
	 */
	@Override
	public SkinHelpDesk getLesionmap(Patient patient) {
        //return (SkinHelpDesk) sessionFactory.getCurrentSession().createQuery("from skinhelpdesk where patientid = " + patientId).uniqueResult();
		return (SkinHelpDesk) sessionFactory.getCurrentSession().createCriteria(SkinHelpDesk.class).add(Restrictions.eq("patient", patient)).uniqueResult();

    }
	/**
	 * @see org.openmrs.module.skinhelpdesk.api.db.SkinHelpDeskDAO#saveLesionmap(org.openmrs.module.skinhelpdesk.SkinHelpDesk)
	 */
	@Override
	public SkinHelpDesk saveLesionmap(SkinHelpDesk lesionmap) {
		sessionFactory.getCurrentSession().saveOrUpdate(lesionmap);
		return lesionmap;
	}
	/**
	 * @see org.openmrs.module.skinhelpdesk.api.db.SkinHelpDeskDAO#purgeLesionmap(org.openmrs.module.skinhelpdesk.SkinHelpDesk)
	 */
	@Override
	public void purgeLesionmap(SkinHelpDesk lesionmap) {
		sessionFactory.getCurrentSession().delete(lesionmap);
	}
}