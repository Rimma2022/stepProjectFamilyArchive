package by.itstep.stepProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ImpotantEvent extends BaseEntityEvent{
    @Column(name = "descriptionOfEvent")
    private String descriptionOfEvent;
}
