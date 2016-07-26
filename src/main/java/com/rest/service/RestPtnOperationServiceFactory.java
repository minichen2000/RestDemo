package com.rest.service;

/**
 * Created by junyuel on 7/26/2016.
 */
public class RestPtnOperationServiceFactory {
    private static RestPtnOperationService service;
    public static void setService(RestPtnOperationService service) {
        RestPtnOperationServiceFactory.service = service;
    }

    public static RestPtnOperationService getService() {
        return service;
    }

}
