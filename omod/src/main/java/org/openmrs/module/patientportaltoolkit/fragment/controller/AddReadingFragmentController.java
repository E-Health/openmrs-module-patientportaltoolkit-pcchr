package org.openmrs.module.patientportaltoolkit.fragment.controller;


import org.openmrs.Patient;
import org.openmrs.api.PatientService;
import org.openmrs.api.context.Context;
import org.openmrs.module.patientportaltoolkit.Pcchr;
import org.openmrs.module.patientportaltoolkit.api.PcchrService;
import org.openmrs.ui.framework.SimpleObject;
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
     * @param patientId PatientId
     * @param patientUuid as String
     * @return Object with Message: Added
     * @should return object with the message added
     */

    public Object saveHl10(@RequestParam(value = "patientId", required=true) int patientId,
                           @RequestParam(value = "patientUuid", required=false) String patientUuid,
                           @RequestParam(value = "profilerId", required=false) String profilerId,
                           @RequestParam(value = "profilerUuid", required=false) String profilerUuid,
                           @RequestParam(value = "startTime", required=false) Date startTime,
                           @RequestParam(value = "endTime", required=false) Date endTime,
                           @RequestParam(value = "dataType", required=false) Pcchr.DataType dataType,
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
                           @RequestParam(value = "index", required=false) int index,
                           @RequestParam(value = "prevUuid", required=false) String prevUuid,
                           @RequestParam(value = "status", required=false) String status) {

       if (startTime == null)
           startTime = Calendar.getInstance().getTime();
       if (endTime == null)
           endTime = Calendar.getInstance().getTime();
       if(dataType == null)
           dataType = Pcchr.DataType.C;

        PcchrService pcchrService = Context.getService(PcchrService.class);
        PatientService patientService = Context.getPatientService();
        Patient patient = patientService.getPatient(patientId);
        Pcchr pcchr = new Pcchr(patient);
        String message;
        if(patient != null) {
            if(patientUuid != null)
                pcchr.setPatientUuid(patientUuid);
            if(profilerId != null)
                pcchr.setProfilerId(profilerId);
            if(profilerUuid != null)
                pcchr.setProfilerUuid(profilerUuid);
            pcchr.setStartTime(startTime);
            pcchr.setEndTime(endTime);
            pcchr.setDataType(dataType);
            if(dataName != null)
                pcchr.setDataName(dataName);
            if(dataCode != null)
                pcchr.setDataCode(dataCode);
            if(dataNs != null)
                pcchr.setDataNs(dataNs);
            if(dataUnit != null)
                pcchr.setDataUnit(dataUnit);
            if(dataUnitNs != null)
                pcchr.setDataUnitNs(dataUnitNs);
            if(charData != null && dataType == Pcchr.DataType.C)
                pcchr.setCharData(charData);
            if(dataType == Pcchr.DataType.N)
                pcchr.setNumData(numData);
            if(dataType == Pcchr.DataType.B)
                pcchr.setBoolData(boolData);
            if(dateTimeData != null && dataType == Pcchr.DataType.D)
                pcchr.setDateTimeData(dateTimeData);
            if(segmentName != null)
                pcchr.setSegmentName(segmentName);
            if(segmentCode != null)
                pcchr.setSegmentCode(segmentCode);
            if(segmentNs != null)
                pcchr.setSegmentNs(segmentNs);
            if(index > 0)
                pcchr.setIndex(index);
            if(prevUuid != null)
                pcchr.setPrevUuid(prevUuid);
            if(status != null)
                pcchr.setStatus(status);
            pcchrService.savePcchr(pcchr);
            message = "Added";
        }else{
            message = "Error";
        }

        return SimpleObject.create("message", message);

    }


}
