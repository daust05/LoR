package lor.project.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
public class Deck {
    @Id @GeneratedValue
    @Column(name = "deck_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="summoner_id")
    private Summoner summoner;

    private String code;
    private int totalGame;
    private int winGame;
}
