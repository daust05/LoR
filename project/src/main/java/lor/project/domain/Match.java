package lor.project.domain;

import javax.persistence.*;

@Entity
public class Match {
    @Id
    @Column(name = "match_id")
    private String id;

    @Enumerated(EnumType.STRING)
    private GameMode mode;

    @Enumerated(EnumType.STRING)
    private GameType type;

    @Enumerated(EnumType.STRING)
    private GameOutcome outcome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="deck_id")
    private Deck hostDeck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="deck_id")
    private Deck opponentDeck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "history_id")
    private MatchHistory history;

    private int turnCount;
}
