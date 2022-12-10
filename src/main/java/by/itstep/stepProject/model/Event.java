package by.itstep.stepProject.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nameEvent")
    private String name;
    @Column(name = "dataEvent")
    private LocalDate date;
    @Column(name = "descriptionOfEvent")
    private String descriptionOfEvent;

}
