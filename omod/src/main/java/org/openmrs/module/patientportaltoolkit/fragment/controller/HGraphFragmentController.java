package org.openmrs.module.patientportaltoolkit.fragment.controller;


import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.patientportaltoolkit.Pcchr;
import org.openmrs.module.patientportaltoolkit.api.PcchrService;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.fragment.FragmentModel;

import java.util.List;

/**
 * Created by Bell on 10/01/2016.
 */
public class HGraphFragmentController {

     public void controller(FragmentModel model, UiUtils ui) {
        Patient patient= Context.getPatientService().getPatientByUuid(Context.getAuthenticatedUser().getPerson().getUuid());
       //String[] properties = new String[] {"dataName", "dataCode", "dataType", "charData", "numData", "boolData", "dateTimeData"};

        PcchrService service = Context.getService(PcchrService.class);


        String[] properties = new String[] {"id", "dataName", "dataCode", "dataType", "charData", "numData", "boolData", "dateTimeData"};
        List<Pcchr> pcchrs = service.getAllPcchrs(patient);
        //model.addAttribute("patient", patient);
        model.addAttribute("pcchrs", SimpleObject.fromCollection(pcchrs, ui, properties));
    }

}
