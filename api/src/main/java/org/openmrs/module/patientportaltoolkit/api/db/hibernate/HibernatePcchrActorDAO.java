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
import org.openmrs.module.patientportaltoolkit.PcchrActor;
import org.openmrs.module.patientportaltoolkit.api.db.PcchrActorDAO;


import java.util.List;

/**
 * It is a default implementation of  {@link PcchrActorDAO}.
 */

public class HibernatePcchrActorDAO implements PcchrActorDAO {
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
	 * @see org.openmrs.module.patientportaltoolkit.api.db.PcchrActorDAO#getAllPcchrActors(org.openmrs.Patient)
	 */
	@Override
	public List<PcchrActor> getAllPcchrActors(Patient patient) {
		return sessionFactory.getCurrentSession().createCriteria(PcchrActor.class).add(Restrictions.eq("patient", patient)).list();
		//return sessionFactory.getCurrentSession().createCriteria(PcchrActor.class).list();
	}
	/**
	 * @see org.openmrs.module.patientportaltoolkit.api.PcchrActorService#getPcchrActor(java.lang.Integer)
	 */
	@Override
	public PcchrActor getPcchrActor(Integer pcchrId) {
		return (PcchrActor) sessionFactory.getCurrentSession().get(PcchrActor.class, pcchrId);
	}
	/**
	 * @see org.openmrs.module.patientportaltoolkit.api.db.PcchrActorDAO#savePcchrActor(org.openmrs.module.patientportaltoolkit.PcchrActor)
	 */
	@Override
	public PcchrActor savePcchrActor(PcchrActor pcchr) {
		sessionFactory.getCurrentSession().save(pcchr);
		return pcchr;
	}
	/**
	 * @see org.openmrs.module.patientportaltoolkit.api.db.PcchrActorDAO#purgePcchrActor(org.openmrs.module.patientportaltoolkit.PcchrActor)
	 */
	@Override
	public void purgePcchrActor(PcchrActor pcchr) {
		sessionFactory.getCurrentSession().delete(pcchr);
	}
}