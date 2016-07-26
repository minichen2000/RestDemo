package com.nokia.restful.ui_ctrl.server.api.factories;

import com.nokia.restful.ui_ctrl.server.api.EstimatesApiService;
import com.nokia.restful.ui_ctrl.server.api.impl.EstimatesApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T12:58:41.778+08:00")
public class EstimatesApiServiceFactory {
    private final static EstimatesApiService service = new EstimatesApiServiceImpl();

    public static EstimatesApiService getEstimatesApi() {
        return service;
    }
}
