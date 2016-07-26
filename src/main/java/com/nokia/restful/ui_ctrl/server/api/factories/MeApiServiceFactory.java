package com.nokia.restful.ui_ctrl.server.api.factories;

import com.nokia.restful.ui_ctrl.server.api.MeApiService;
import com.nokia.restful.ui_ctrl.server.api.impl.MeApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T12:58:41.778+08:00")
public class MeApiServiceFactory {
    private final static MeApiService service = new MeApiServiceImpl();

    public static MeApiService getMeApi() {
        return service;
    }
}
