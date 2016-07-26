package com.nokia.restful.ui_ctrl.server.api.factories;

import com.nokia.restful.ui_ctrl.server.api.HistoryApiService;
import com.nokia.restful.ui_ctrl.server.api.impl.HistoryApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T12:58:41.778+08:00")
public class HistoryApiServiceFactory {
    private final static HistoryApiService service = new HistoryApiServiceImpl();

    public static HistoryApiService getHistoryApi() {
        return service;
    }
}
