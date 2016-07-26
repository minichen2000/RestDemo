package com.nokia.restful.ui_ctrl.server.api.factories;

import com.nokia.restful.ui_ctrl.server.api.ProductsApiService;
import com.nokia.restful.ui_ctrl.server.api.impl.ProductsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T12:58:41.778+08:00")
public class ProductsApiServiceFactory {
    private final static ProductsApiService service = new ProductsApiServiceImpl();

    public static ProductsApiService getProductsApi() {
        return service;
    }
}
