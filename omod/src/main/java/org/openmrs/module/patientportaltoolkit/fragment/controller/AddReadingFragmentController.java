package org.openmrs.module.patientportaltoolkit.fragment.controller;


import org.openmrs.Patient;
import org.openmrs.api.PatientService;
import org.openmrs.api.context.Context;
import org.openmrs.module.patientportaltoolkit.Pcchr;
import org.openmrs.module.patientportaltoolkit.api.PcchrService;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Bell on 10/01/2016.
 */
public class AddReadingFragmentController {

    public void controller(PageModel model) {
        Patient patient;
        patient= Context.getPatientService().getPatientByUuid(Context.getAuthenticatedUser().getPerson().getUuid());
        if (patient == null) {
            patient= Context.getPatientService().getPatient(7); //For Testing
        }
        model.addAttribute("patient", patient);

    }

        /**
     *
     * @param identifier PatientId
     * @param imagemap as String
     * @return Object with Message: Added
     * @should return object with the message added
     */

    public Object saveHl10(@RequestParam(value = "patientId", required=true) int patientId,
                           @RequestParam(value = "patientUuid", required=false) String patientUuid,
                           @RequestParam(value = "profilerId", required=false) int profilerId,
                           @RequestParam(value = "profilerUuid", required=false) String profilerUuid,
                           @RequestParam(value = "startTime", required=false) Date startTime,
                           @RequestParam(value = "endTime", required=false) Date endTime,
                           @RequestParam(value = "dataType", required=false) Pcchr.DataType dataType,
                           @RequestParam(value = "dataName", required=false) String dataName,
                           @RequestParam(value = "dataCode", required=false) String dataCode,
                           @RequestParam(value = "dataNs", required=false) String dataNs,
                           @RequestParam(value = "charData", required=false) String charData,
                           @RequestParam(value = "numData", required=false) Double numData,
                           @RequestParam(value = "boolData", required=false) Boolean boolData,
                           @RequestParam(value = "dateTimeData", required=false) Date dateTimeData,
                           @RequestParam(value = "segmentName", required=false) String segmentName,
                           @RequestParam(value = "segmentCode", required=false) String segmentCode,
                           @RequestParam(value = "segmentNs", required=false) String segmentNs,
                           @RequestParam(value = "index", required=false) int index,
                           @RequestParam(value = "prevUuid", required=false) String prevUuid,
                           @RequestParam(value = "status", required=false) String status) {

       if (startTime == null)
           Calendar.getInstance().getTime();
       if (endTime == null)
           Calendar.getInstance().getTime();

        PcchrService pcchrService = Context.getService(PcchrService.class);
        PatientService patientService = Context.getPatientService();
        Patient patient = patientService.getPatient(patientId);
        Pcchr pcchr = new Pcchr();
        String message;
        if(patient != null) {
            pcchr.setUser(patient);
            pcchr.setU
            message = "Added";
        }else{
            message = "Error";
        }

        return SimpleObject.create("message", message);
        /*

        X2connectService service = Context.getService(X2connectService.class);
        PatientService patientService = Context.getPatientService();
        Patient patient = patientService.getPatient(identifier);
        X2connect x2connect;
        String message;
        if(patient != null) {
            x2connect = service.getX2connect(patient);
            if(x2connect != null) {
                x2connect.setBackgroundInfo(background);
                x2connect.setFirstName(patient.getGivenName());
                x2connect.setLastName(patient.getFamilyName());
                x2connect.setAddress(patient.getAddresses().toString());
                service.saveX2connect(x2connect);
            }else{
                x2connect = new X2connect();
                x2connect.setPatient(patient);
                x2connect.setBackgroundInfo(background);
                x2connect.setFirstName(patient.getGivenName());
                x2connect.setLastName(patient.getFamilyName());
                x2connect.setAddress(patient.getAddresses().toString());
                service.saveX2connect(x2connect);
            }
            message = "Added";
        }else{
            message = "Error";
        }

        return SimpleObject.create("message", message);
    }
        */
    }


}
