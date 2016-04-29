package io.ingenieux.getmylambdas.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Consumes("*/*")
@Produces("text/plain")
@Path("/get-my-lambdas/facebook/{apiId}/{region}/{stageName}/{path: .*}")
public class APIGatewayValidationSub {
    final Logger log = LoggerFactory.getLogger(APIGatewayValidationSub.class);

    @PathParam("region")
    String region;

    @PathParam("apiId")
    String apiId;

    @PathParam("stageName")
    String stageName;

    @PathParam("path")
    List<PathParam> requestPath;

    @Context
    UriInfo uriInfo;

    @GET
    public Response doRequest() throws Exception {
        String challenge = uriInfo.getQueryParameters().getFirst("hub.challenge");

        return Response.ok(challenge).build();
    }
}
