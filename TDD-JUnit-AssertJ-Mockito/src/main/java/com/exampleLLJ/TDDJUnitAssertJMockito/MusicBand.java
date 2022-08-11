package com.exampleLLJ.TDDJUnitAssertJMockito;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MusicBand {
    @Id
    private Long bandId;
    private String name;
    private Long price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MusicBand musicBand = (MusicBand) o;
        return bandId != null && Objects.equals(bandId, musicBand.bandId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
