package org.openmrs.module.patientportaltoolkit.rest;

import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.MainResourceController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by beapen on 05/02/16.
 */
@Controller
@RequestMapping("/rest/" + RestConstants.VERSION_1 + "/pcchr")
public class PcchrExampleRestController extends MainResourceController {
    @Override
    public String getNamespace() {
        return RestConstants.VERSION_1 + "/pcchr";
    }

}
