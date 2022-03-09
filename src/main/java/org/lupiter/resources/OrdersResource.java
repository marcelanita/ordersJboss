package org.lupiter.resources;


import org.lupiter.dto.OrderRequest;
import org.lupiter.dto.OrderResponse;
import org.lupiter.services.OrderService;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("/v1")
public class OrdersResource {

    @Inject
    private OrderService orderService;



    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }

    @POST
    @Path("/{customerId}/addorder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrder(OrderRequest orderRequest){

        String response =  orderService.addOrder(orderRequest);
        return Response
                .status(200)
                .entity(response).build();
    }


    @GET
    @Path("/{customerId}/getorders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderResponse> orders(@PathParam("customerId") int customerId){
        return orderService.getOrderByCustomerId(customerId);
    }
}
