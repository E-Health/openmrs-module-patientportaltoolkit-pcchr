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

     public void controller(FragmentModel model) {
        Patient patient= Context.getPatientService().getPatientByUuid(Context.getAuthenticatedUser().getPerson().getUuid());
        PcchrService service = Context.getService(PcchrService.class);
        List<Pcchr> pcchrs = service.getAllPcchrs(patient);
        SimpleObject s = new SimpleObject();
        for (Pcchr pcchr : pcchrs){
            if(s.containsKey(pcchr.getDataName())){
                Double this_value = pcchr.getNumData();
                Object o = s.get(pcchr.getDataName());
                Double old_value = (Double) o;
                Double new_value = (this_value + old_value) / 2;
                s.put(pcchr.getDataName(), new_value);
            }else{
                s.put(pcchr.getDataName(),pcchr.getNumData());
            }
        }
        model.addAttribute("pcchrs", s);
    }

}
