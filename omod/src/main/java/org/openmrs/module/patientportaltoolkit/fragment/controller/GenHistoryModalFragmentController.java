package org.openmrs.module.patientportaltoolkit.fragment.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.api.ConceptService;
import org.openmrs.api.EncounterService;
import org.openmrs.api.ObsService;
import org.openmrs.api.context.Context;
import org.openmrs.module.patientportaltoolkit.PatientPortalToolkitConstants;
import org.openmrs.module.patientportaltoolkit.api.PatientPortalFormService;
import org.openmrs.module.patientportaltoolkit.api.util.GenerateTreatmentClassesUtil;
import org.openmrs.ui.framework.fragment.FragmentModel;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Maurya on 16/07/2015.
 */
public class GenHistoryModalFragmentController {

    protected final Log log = LogFactory.getLog(getClass());

    public void controller(PageModel model) {
        Patient patient = null;
        patient = Context.getPatientService().getPatientByUuid(Context.getAuthenticatedUser().getPerson().getUuid());
        PatientPortalFormService patientPortalFormService = Context.getService(PatientPortalFormService.class);
        if (patient != null) {
            model.addAttribute("surgeryConcepts", patientPortalFormService.getPatientPortalFormByFormType(PatientPortalToolkitConstants.SURGERY_ENCOUNTER));
            model.addAttribute("chemotherapyConcepts", patientPortalFormService.getPatientPortalFormByFormType(PatientPortalToolkitConstants.CHEMOTHERAPY_ENCOUNTER));
            model.addAttribute("radiationConcepts", patientPortalFormService.getPatientPortalFormByFormType(PatientPortalToolkitConstants.RADIATION_ENCOUNTER));
            model.addAttribute("latestTreatmentSummary", GenerateTreatmentClassesUtil.generateLatestGeneralHistory(patient));
            model.addAttribute("treatmentsummary", GenerateTreatmentClassesUtil.generateGeneralHistory(patient));
            model.addAttribute("radiationencounters", GenerateTreatmentClassesUtil.generateRadiations(patient));
            model.addAttribute("surgeryencounters", GenerateTreatmentClassesUtil.generateSurgeries(patient));
            model.addAttribute("chemotherapyencounters", GenerateTreatmentClassesUtil.generateChemotherapies(patient));
        } else {
            model.addAttribute("treatmentsummary", null);
            model.addAttribute("latestTreatmentSummary", null);
            model.addAttribute("radiationencounters", null);
            model.addAttribute("surgeryencounters", null);
            model.addAttribute("chemotherapyencounters", null);
        }
    }

    public void saveGenHistoryForm(FragmentModel model,  @RequestParam(value = "encounterId", required = true) String encounterId,
                                   @RequestParam(value = "cancerType", required = true) String cancerType,
                                   @RequestParam(value = "cancerStage", required = true) String cancerStage,
                                   @RequestParam(value = "cancerDate", required = true) String cancerDate,
                                   @RequestParam(value = "cancerAbnormalityBool", required = true) String cancerAbnormalityBool,
                                   @RequestParam(value = "cancerAbnormalityType", required = true) String cancerAbnormalityType,
                                   @RequestParam(value = "genHistoryCancerPcpName", required = true) String genHistoryCancerPcpName,
                                   @RequestParam(value = "genHistoryCancerPcpEmail", required = true) String genHistoryCancerPcpEmail,
                                   @RequestParam(value = "genHistoryCancerPcpPhone", required = true) String genHistoryCancerPcpPhone) throws ParseException {

        EncounterService encounterService=Context.getEncounterService();
        ConceptService conceptService=Context.getConceptService();
        Encounter genHistoryEncounter = encounterService.getEncounterByUuid(encounterId);
        List<String> allTheEnteredValues = new ArrayList<>();
        allTheEnteredValues.add("cancerType");
        allTheEnteredValues.add("cancerStage");
        allTheEnteredValues.add("cancerDate");
        allTheEnteredValues.add("cancerAbnormalityBool");
        allTheEnteredValues.add("cancerAbnormalityType");
        allTheEnteredValues.add("genHistoryCancerPcpName");
        allTheEnteredValues.add("genHistoryCancerPcpEmail");
        allTheEnteredValues.add("genHistoryCancerPcpPhone");
        if(encounterId !=null) {
            Encounter generalEncounter = encounterService.getEncounterByUuid(encounterId);
            Map<String,List<Obs>> observationConceptUUIDToObsMap = new HashMap<>();
            for (Obs o:generalEncounter.getObs()){
                if(observationConceptUUIDToObsMap.get(o.getConcept().getUuid())== null) {
                    List<Obs> newObsList=new ArrayList<>();
                    newObsList.add(o);
                    observationConceptUUIDToObsMap.put(o.getConcept().getUuid(),newObsList);
                }
                else
                {
                    List<Obs> existingObsList= observationConceptUUIDToObsMap.get(o.getConcept().getUuid());
                    existingObsList.add(o);
                    observationConceptUUIDToObsMap.put(o.getConcept().getUuid(),existingObsList);
                }
            }
            for (String entry : allTheEnteredValues)
            {
                if(entry !=null) {
                    switch (entry) {
                        case "cancerType":
                            if (observationConceptUUIDToObsMap.get("cdf6d767-2aa3-40b6-ae78-0386eebe2411") != null) {
                                Obs o = observationConceptUUIDToObsMap.get("cdf6d767-2aa3-40b6-ae78-0386eebe2411").get(0);
                                o.setValueCoded(conceptService.getConceptByUuid(cancerType));
                            } else {
                                Obs o = new Obs();
                                o.setConcept(conceptService.getConceptByUuid("cdf6d767-2aa3-40b6-ae78-0386eebe2411"));
                                o.setValueCoded(conceptService.getConceptByUuid(cancerType));
                                generalEncounter.addObs(o);
                            }
                            break;
                        case "cancerStage":
                            if (observationConceptUUIDToObsMap.get("efa3f9eb-ade4-4ddb-92c9-0fc1119d112d") != null) {
                                Obs o = observationConceptUUIDToObsMap.get("efa3f9eb-ade4-4ddb-92c9-0fc1119d112d").get(0);
                                o.setValueCoded(conceptService.getConceptByUuid(cancerStage));
                            } else {
                                Obs o = new Obs();
                                o.setConcept(conceptService.getConceptByUuid("efa3f9eb-ade4-4ddb-92c9-0fc1119d112d"));
                                o.setValueCoded(conceptService.getConceptByUuid(cancerStage));
                                generalEncounter.addObs(o);
                            }
                            break;
                        case "cancerDate":
                            if (observationConceptUUIDToObsMap.get("654e32f0-8b57-4d1f-845e-500922e800f6") != null) {
                                Obs o = observationConceptUUIDToObsMap.get("654e32f0-8b57-4d1f-845e-500922e800f6").get(0);
                                if (cancerDate != null && cancerDate != "") {
                                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                    Date parsedDate = formatter.parse(cancerDate);
                                    if (o.getValueDate() != parsedDate)
                                        o.setValueDate(parsedDate);
                                }
                            } else {
                                if (cancerDate != null && cancerDate != "") {
                                    Obs o = new Obs();
                                    o.setConcept(conceptService.getConceptByUuid("654e32f0-8b57-4d1f-845e-500922e800f6"));
                                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                    Date parsedDate = formatter.parse(cancerDate);
                                    o.setValueDate(parsedDate);
                                    generalEncounter.addObs(o);
                                }
                            }
                            break;
                        case "cancerAbnormalityBool":
                            if (observationConceptUUIDToObsMap.get("395878ae-5108-4aad-8ad8-9b88e812d278") != null) {
                                Obs o = observationConceptUUIDToObsMap.get("395878ae-5108-4aad-8ad8-9b88e812d278").get(0);
                                o.setValueCoded(conceptService.getConceptByUuid(cancerAbnormalityBool));
                            } else {
                                Obs o = new Obs();
                                o.setConcept(conceptService.getConceptByUuid("395878ae-5108-4aad-8ad8-9b88e812d278"));
                                o.setValueCoded(conceptService.getConceptByUuid(cancerAbnormalityBool));
                                generalEncounter.addObs(o);
                            }
                            break;
                        case "cancerAbnormalityType":
                            if (observationConceptUUIDToObsMap.get("8719adbe-0975-477f-a95f-2fae4d6cbdae") != null) {
                                Obs o = observationConceptUUIDToObsMap.get("8719adbe-0975-477f-a95f-2fae4d6cbdae").get(0);
                                o.setValueCoded(conceptService.getConceptByUuid(cancerAbnormalityType));
                            } else {
                                Obs o = new Obs();
                                o.setConcept(conceptService.getConceptByUuid("8719adbe-0975-477f-a95f-2fae4d6cbdae"));
                                o.setValueCoded(conceptService.getConceptByUuid(cancerAbnormalityType));
                                generalEncounter.addObs(o);
                            }
                            break;
                        case "genHistoryCancerPcpName":
                            if (observationConceptUUIDToObsMap.get("c2cb2220-c07d-47c6-a4df-e5918aac3fc2") != null) {
                                Obs o = observationConceptUUIDToObsMap.get("c2cb2220-c07d-47c6-a4df-e5918aac3fc2").get(0);
                                if (o.getValueText() != genHistoryCancerPcpName)
                                    o.setValueText(genHistoryCancerPcpName);
                            } else {
                                if (genHistoryCancerPcpName != null && genHistoryCancerPcpName != "") {
                                    Obs o = new Obs();
                                    o.setConcept(conceptService.getConceptByUuid("c2cb2220-c07d-47c6-a4df-e5918aac3fc2"));
                                    o.setValueText(genHistoryCancerPcpName);
                                    generalEncounter.addObs(o);
                                }
                            }
                            break;
                        case "genHistoryCancerPcpEmail":
                            if (observationConceptUUIDToObsMap.get("898a0028-8c65-4db9-a802-1577fce59864") != null) {
                                Obs o = observationConceptUUIDToObsMap.get("898a0028-8c65-4db9-a802-1577fce59864").get(0);
                                if (o.getValueText() != genHistoryCancerPcpEmail)
                                    o.setValueText(genHistoryCancerPcpEmail);
                            } else {
                                if (genHistoryCancerPcpEmail != null && genHistoryCancerPcpEmail != "") {
                                    Obs o = new Obs();
                                    o.setConcept(conceptService.getConceptByUuid("898a0028-8c65-4db9-a802-1577fce59864"));
                                    o.setValueText(genHistoryCancerPcpEmail);
                                    generalEncounter.addObs(o);
                                }
                            }
                            break;
                        case "genHistoryCancerPcpPhone":
                            if (observationConceptUUIDToObsMap.get("9285b227-4054-4830-ac32-5ea78462e8c4") != null) {
                                Obs o = observationConceptUUIDToObsMap.get("9285b227-4054-4830-ac32-5ea78462e8c4").get(0);
                                if (o.getValueText() != genHistoryCancerPcpPhone)
                                    o.setValueText(genHistoryCancerPcpPhone);
                            } else {
                                if (genHistoryCancerPcpPhone != null && genHistoryCancerPcpPhone != "") {
                                    Obs o = new Obs();
                                    o.setConcept(conceptService.getConceptByUuid("9285b227-4054-4830-ac32-5ea78462e8c4"));
                                    o.setValueText(genHistoryCancerPcpPhone);
                                    generalEncounter.addObs(o);
                                }
                            }
                            break;

                    }
                }
            }
        }
        encounterService.saveEncounter(genHistoryEncounter);
    }
}
