package org.openmrs.module.patientportaltoolkit.rest.controller;

import org.openmrs.module.patientportaltoolkit.Pcchr;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.MainResourceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        SimpleObject response = new SimpleObject();
        response.put("message", "success");
        return response;
    }
}
