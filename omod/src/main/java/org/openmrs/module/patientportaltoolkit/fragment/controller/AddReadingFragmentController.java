package org.openmrs.module.patientportaltoolkit.fragment.controller;


import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.ui.framework.page.PageModel;

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

    public Object putHl10(@RequestParam("patientId") int patientId,
                         @RequestParam("lesionmap") String imagemap) {
        Patient patient;
        SkinHelpDesk lesionmap;
        SkinHelpDeskService service = Context.getService(SkinHelpDeskService.class);
        PatientService patientService = Context.getPatientService();
        patient = patientService.getPatient(identifier);
        Object o;
        String m;
        if(patient != null) {

            lesionmap = service.getLesionmap(patient);
            if(lesionmap != null) {
                lesionmap.setLesionMap(imagemap);
                service.saveLesionmap(lesionmap);
            }else{
                SkinHelpDesk lm = new SkinHelpDesk();
                lm.setPatient(patient);
                lm.setLesionMap(imagemap);
                service.saveLesionmap(lm);
            }
            m = "Added";
        }else{
            m = "Error";
        }

        o = SimpleObject.create("message",m);
        return o;
    }


}
