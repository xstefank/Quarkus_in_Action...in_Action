package org.acme;

import io.quarkus.logging.Log;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/reservation")
public class ReservationResource {

    @GET
    public List<Reservation> getAll() {
        return Reservation.listAll();
    }

    /*
http POST :8080/reservation <<< '{
    "customerName": "John Doe",
    "carLicensePlate": "ABC123",
    "startDate": "2030-01-01",
    "endDate": "2030-01-10"
    }'
 */
    @POST
    @Consumes("application/json")
    @Transactional
    public Response create(Reservation reservation) {
        if(reservation.customerName == null || reservation.customerName.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
        }

        reservation.persist();
        Log.info("Reservation created: " + reservation);

        return Response.ok(reservation).build();
    }

}
