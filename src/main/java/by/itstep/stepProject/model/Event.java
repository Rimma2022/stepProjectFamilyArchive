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
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nameEvent") //Vactination: гепатит В, коклюш и т.д ImpotantEvent: день рождения, начал ходить. Illness: Грипп, ковид
    private String name;
    @Column(name = "dataEvent")
    private LocalDate date;
    @Column(name = "descriptionOfEvent")
    private String descriptionOfEvent; // прививался там_то тем-то/ пошел в 10 месяцев/ болел так-то столько-то дней
    @Enumerated(EnumType.STRING)
    private TypeEvent typeEvent;

}
