package org.acme;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/reservation")
public class ReservationResource {

    /*
http POST :8080/reservation <<< '{
    "id": 1,
    "customerName": "John Doe",
    "carLicensePlate": "ABC123",
    "startDate": "2030-01-01",
    "endDate": "2030-01-10"
    }'
 */
    @POST
    @Consumes("application/json")
    public Response create(Reservation reservation) {
        if(reservation.customerName == null || reservation.customerName.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
        }
        // TODO: persist the reservation
        return Response.ok(reservation).build();
    }

}
