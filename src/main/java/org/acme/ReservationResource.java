package org.acme;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/reservation")
public class ReservationResource {

    @POST
    @Consumes("application/json")
    public Response create(Reservation reservation) {
        if(reservation.userId == null || reservation.userId.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
        }
        // TODO: persist the reservation
        return Response.ok(reservation).build();
    }

}
