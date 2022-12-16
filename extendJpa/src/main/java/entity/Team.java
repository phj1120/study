package entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Team {

    @Id
    private Long id;

    public Team(Long id) {
        this.id = id;
    }
}
