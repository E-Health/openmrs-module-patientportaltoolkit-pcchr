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
        Patient patient;
        patient= Context.getPatientService().getPatientByUuid(Context.getAuthenticatedUser().getPerson().getUuid());
        if (patient == null) {
            patient= Context.getPatientService().getPatient(7); //For Testing
        }
        String[] properties = new String[] {"dataName", "dataCode", "dataType", "charData", "numData", "boolData", "dateTimeData"};

        PcchrService service = Context.getService(PcchrService.class);


        properties = new String[] {"id", "dataName", "dataCode", "dataType", "charData", "numData", "boolData", "dateTimeData"};
        List<Pcchr> pcchrs = service.getAllPcchrs(patient);
        model.addAttribute("patient", patient);
        model.addAttribute("pcchrs", SimpleObject.fromCollection(pcchrs, ui, properties));
    }


    /**
     *
     * @param patientId PatientId
     * @param patientUuid as String
     * @return Object with Message: Added
     * @should return object with the message added
     */

    public Object getAllHl10(@RequestParam(value = "patientId", required=true) int patientId,
                             @RequestParam(value = "patientUuid", required=false) String patientUuid,
                             @RequestParam(value = "profilerId", required=false) String profilerId,
                             @RequestParam(value = "profilerUuid", required=false) String profilerUuid,
                             @RequestParam(value = "startTime", required=false) Date startTime,
                             @RequestParam(value = "endTime", required=false) Date endTime,
                             @RequestParam(value = "dataType", required=false) String dataType,
                             @RequestParam(value = "dataName", required=false) String dataName,
                             @RequestParam(value = "dataCode", required=false) String dataCode,
                             @RequestParam(value = "dataNs", required=false) String dataNs,
                             @RequestParam(value = "dataUnit", required=false) String dataUnit,
                             @RequestParam(value = "dataUnitNs", required=false) String dataUnitNs,
                             @RequestParam(value = "charData", required=false) String charData,
                             @RequestParam(value = "numData", required=false) Double numData,
                             @RequestParam(value = "boolData", required=false) Boolean boolData,
                             @RequestParam(value = "dateTimeData", required=false) Date dateTimeData,
                             @RequestParam(value = "segmentName", required=false) String segmentName,
                             @RequestParam(value = "segmentCode", required=false) String segmentCode,
                             @RequestParam(value = "segmentNs", required=false) String segmentNs,
                             @RequestParam(value = "segmentIndex", required=false) int segmentIndex,
                             @RequestParam(value = "prevUuid", required=false) String prevUuid,
                             @RequestParam(value = "dataStatus", required=false) String dataStatus,
                             @RequestParam(value = "properties", required = false) String[] properties,
                             UiUtils ui) {

        PcchrService service = Context.getService(PcchrService.class);
        PatientService patientService = Context.getPatientService();
        Patient patient = patientService.getPatient(patientId);
        Pcchr pcchr = new Pcchr();

        if(properties == null)
            properties = new String[] {"dataName", "dataCode", "dataType", "charData", "numData", "boolData", "dateTimeData"};
        List<Pcchr> pcchrs = service.getAllPcchrs(patient);
        return SimpleObject.fromCollection(pcchrs, ui, properties);
    }


}
