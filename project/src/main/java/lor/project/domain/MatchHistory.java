package lor.project.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MatchHistory {
    @Id @GeneratedValue
    @Column(name = "history_id")
    private Long id;

    @OneToOne
    @JoinColumn(name="summoner_id")
    private Summoner summoner;

    @OneToMany(mappedBy = "history")
    private List<Match> matches;

    private int totalGame;
    private int winGame;
}
