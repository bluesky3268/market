package korit.market.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminNo;

    @Column(length = 25, nullable = false)
    private String adminId;

    @Column(length = 25, nullable = false)
    private String adminPwd;

}
