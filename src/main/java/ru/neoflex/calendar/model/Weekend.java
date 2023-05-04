package ru.neoflex.calendar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "weekend_dates")
@Entity
public class Weekend {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weekend weekend = (Weekend) o;

        return date != null ? date.equals(weekend.date) : weekend.date == null;
    }

    @Override
    public int hashCode() {
        return date != null ? date.hashCode() : 0;
    }
}
