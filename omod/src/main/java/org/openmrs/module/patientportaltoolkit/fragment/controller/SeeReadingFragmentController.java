package org.openmrs.module.patientportaltoolkit.fragment.controller;


import org.apache.commons.beanutils.PropertyUtils;
import org.openmrs.Patient;
import org.openmrs.api.PatientService;
import org.openmrs.api.context.Context;
import org.openmrs.module.patientportaltoolkit.Pcchr;
import org.openmrs.module.patientportaltoolkit.api.PcchrService;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentConfiguration;
import org.openmrs.ui.framework.fragment.FragmentModel;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Bell on 10/01/2016.
 */
public class SeeReadingFragmentController {


    public void controller(FragmentModel model, UiUtils ui) {
        Patient patient= Context.getPatientService().getPatientByUuid(Context.getAuthenticatedUser().getPerson().getUuid());
       //String[] properties = new String[] {"dataName", "dataCode", "dataType", "charData", "numData", "boolData", "dateTimeData"};

        PcchrService service = Context.getService(PcchrService.class);


        String[] properties = new String[] {"id", "dataName", "dataCode", "dataType", "charData", "numData", "boolData", "dateTimeData"};
        List<Pcchr> pcchrs = service.getAllPcchrs(patient);
        //model.addAttribute("patient", patient);
        model.addAttribute("pcchrs", SimpleObject.fromCollection(pcchrs, ui, properties));
        if (patient != null)
            model.addAttribute("patient", patient);
        else
            model.addAttribute("patient", null);

    }


    /**
     *
     * @param patientId PatientId
     * @param patientUuid as String
     * @return Object with Message: Added
     * @should return object with the message added
     */

    public Object getAllHl10(@RequestParam(value = "patientId", required=true) int patientId,
                             //@RequestParam(value = "patientUuid", required=false) String patientUuid,
                             //@RequestParam(value = "properties", required = false) String[] properties,
                             UiUtils ui) {

        PcchrService service = Context.getService(PcchrService.class);
        PatientService patientService = Context.getPatientService();
        Patient patient = patientService.getPatient(patientId);
        Pcchr pcchr = new Pcchr();

        //if(properties == null)
        String[] properties = new String[] {"dataName", "dataCode", "numData"};
        List<Pcchr> pcchrs = service.getAllPcchrs(patient);
        return SimpleObject.fromCollection(pcchrs, ui, properties);
    }

    /**
     *
     * @param hl10Id
     * @return Object with Message: Added
     * @should return object with the message added
     */

    public Object purgeHl10(@RequestParam(value = "id", required=true) int hl10Id) {

        PcchrService service = Context.getService(PcchrService.class);
        Pcchr pcchr = service.getPcchr(hl10Id);
        service.purgePcchr(pcchr);
        String message = "Added";
        return SimpleObject.create("message", message);

    }
}
