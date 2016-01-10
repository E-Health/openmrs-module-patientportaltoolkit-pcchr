package org.openmrs.module.patientportaltoolkit.fragment.controller;


import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.ui.framework.page.PageModel;

/**
 * Created by Bell on 10/01/2016.
 */
public class AddReadingFragmentController {

    public void controller(PageModel model) {
        Patient patient = null;
        patient= Context.getPatientService().getPatientByUuid(Context.getAuthenticatedUser().getPerson().getUuid());
        if (patient == null) {
            patient = new Patient();
        }
        model.addAttribute("patient", patient));

    }

}
