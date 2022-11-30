package me.silvernine.tutorial.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "authority")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private AuthorityType authorityType;

    public Authority(User user, AuthorityType authorityType) {
        this.user = user;
        this.authorityType = authorityType;

        // 연관관계 편의 메서드 대신
        user.getAuthorities().add(this);
    }

}
