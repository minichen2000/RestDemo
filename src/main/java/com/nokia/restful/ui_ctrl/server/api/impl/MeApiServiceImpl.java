package com.nokia.restful.ui_ctrl.server.api.impl;

import com.nokia.restful.ui_ctrl.server.api.*;
import com.nokia.restful.ui_ctrl.server.model.*;

import com.nokia.restful.ui_ctrl.server.model.Error;
import com.nokia.restful.ui_ctrl.server.model.Profile;

import java.util.List;
import com.nokia.restful.ui_ctrl.server.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T12:58:41.778+08:00")
public class MeApiServiceImpl extends MeApiService {
    @Override
    public Response meGet(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
