/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.patientportaltoolkit.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Patient;
import org.openmrs.Patient;
import org.openmrs.module.patientportaltoolkit.Pcchr;
import org.openmrs.module.patientportaltoolkit.api.db.PcchrDAO;


import java.util.List;

/**
 * It is a default implementation of  {@link PcchrDAO}.
 */

public class HibernatePcchrDAO implements PcchrDAO {
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
	 * @see org.openmrs.module.patientportaltoolkit.api.db.PcchrDAO#getAllPcchrs(org.openmrs.Patient)
	 */
	@Override
	public List<Pcchr> getAllPcchrs(Patient patient) {
		return sessionFactory.getCurrentSession().createCriteria(Pcchr.class).add(Restrictions.eq("patient", patient)).list();
		//return sessionFactory.getCurrentSession().createCriteria(Pcchr.class).list();
	}
	/**
	 * @see org.openmrs.module.patientportaltoolkit.api.PcchrService#getPcchr(java.lang.Integer)
	 */
	@Override
	public Pcchr getPcchr(Integer pcchrId) {
		return (Pcchr) sessionFactory.getCurrentSession().get(Pcchr.class, pcchrId);
	}
	/**
	 * @see org.openmrs.module.patientportaltoolkit.api.db.PcchrDAO#savePcchr(org.openmrs.module.patientportaltoolkit.Pcchr)
	 */
	@Override
	public Pcchr savePcchr(Pcchr pcchr) {
		sessionFactory.getCurrentSession().save(pcchr);
		return pcchr;
	}
	/**
	 * @see org.openmrs.module.patientportaltoolkit.api.db.PcchrDAO#purgePcchr(org.openmrs.module.patientportaltoolkit.Pcchr)
	 */
	@Override
	public void purgePcchr(Pcchr pcchr) {
		sessionFactory.getCurrentSession().delete(pcchr);
	}
}