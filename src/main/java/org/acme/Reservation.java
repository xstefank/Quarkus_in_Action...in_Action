package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Reservation extends PanacheEntity {

    public String customerName;

    public String carLicensePlate;

    public LocalDate startDate;

    public LocalDate endDate;
}
