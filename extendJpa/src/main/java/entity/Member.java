package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    private Long id;

    private String name;

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
