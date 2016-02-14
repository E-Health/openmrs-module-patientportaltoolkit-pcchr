package org.openmrs.module.patientportaltoolkit.rest.controller;

import org.openmrs.Patient;
import org.openmrs.api.PatientService;
import org.openmrs.api.context.Context;
import org.openmrs.module.patientportaltoolkit.Pcchr;
import org.openmrs.module.patientportaltoolkit.api.PcchrService;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.MainResourceController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by beapen on 05/02/16.
 * see: https://github.com/openmrs/openmrs-module-ebolaexample/blob/
 * bd7ae3fc4a74c9df7959afeb93808aa3da9e3293/omod/src/main/java/org/openmrs/
 * module/ebolaexample/rest/controller/IvFluidOrderStatusController.java
 */

@Controller
@RequestMapping("/rest/" + RestConstants.VERSION_1 + "/pcchr/profiler")
public class PcchrProfilerRestController extends MainResourceController {

    //@Autowired
    //Pcchr pcchr;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Object get(@RequestParam(value="uuid", required=false) String Uuid) throws Exception {
        SimpleObject response = new SimpleObject();
        response.put("message", "success");
        return response;
    }


    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Object post(@RequestBody Map<String, Object> map) throws Exception {
        int patientId = (int) map.get("patientId");
        String patientUuid = (String) map.get("patientUuid");
        String profilerId = (String) map.get("profilerId");
        String profilerUuid = (String) map.get("profilerUuid");
        Date startTime = (Date) map.get("startTime");
        Date endTime = (Date) map.get("endTime");
        String dataType = (String) map.get("dataType");
        String dataName = (String) map.get("dataName");
        String dataCode = (String) map.get("dataCode");
        String dataNs = (String) map.get("dataNs");
        String dataUnit = (String) map.get("dataUnit");
        String dataUnitNs = (String) map.get("dataUnitNs");
        String charData = (String) map.get("charData");
        Double numData = (Double) map.get("numData");
        Boolean boolData = (Boolean) map.get("boolData");
        Date dateTimeData = (Date) map.get("dateTimeData");
        String segmentName = (String) map.get("segmentName");
        String segmentCode = (String) map.get("segmentCode");
        String segmentNs = (String) map.get("segmentNs");
        Boolean hasMore = (Boolean) map.get("hasMore");
        String prevUuid = (String) map.get("prevUuid");
        String dataStatus = (String) map.get("dataStatus");

        PcchrService service = Context.getService(PcchrService.class);
        PatientService patientService = Context.getPatientService();
        Patient patient = patientService.getPatient(patientId);
        Pcchr pcchr = new Pcchr();
        String message;

        if (startTime == null)
            startTime = Calendar.getInstance().getTime();
        if (endTime == null)
            endTime = Calendar.getInstance().getTime();
        if(dataType == null)
            dataType = "C";
        if(hasMore == null)
            hasMore = false;

        if(patient != null) {
            pcchr.setPatient(patient);
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
            if(charData != null && dataType.equalsIgnoreCase("C"))
                pcchr.setCharData(charData);
            if(dataType.equalsIgnoreCase("N"))
                pcchr.setNumData(numData);
            if(dataType.equalsIgnoreCase("B"))
                pcchr.setBoolData(boolData);
            if(dateTimeData != null && dataType.equalsIgnoreCase("D"))
                pcchr.setDateTimeData(dateTimeData);
            if(segmentName != null)
                pcchr.setSegmentName(segmentName);
            if(segmentCode != null)
                pcchr.setSegmentCode(segmentCode);
            if(segmentNs != null)
                pcchr.setSegmentNs(segmentNs);
            if(hasMore)
                pcchr.setHasMore(hasMore);
            if(prevUuid != null)
                pcchr.setPrevUuid(prevUuid);
            if(dataStatus != null)
                pcchr.setDataStatus(dataStatus);
            service.savePcchr(pcchr);
            message = "Added";
        }else{
            message = "Error";
        }

        SimpleObject response = new SimpleObject();
        response.put("message", message);
        return response;
    }
}
