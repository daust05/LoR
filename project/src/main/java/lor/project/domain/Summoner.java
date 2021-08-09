package lor.project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Summoner {
    @Id
    String id;
    String accountId;
    String puuid;
    String name;
    Integer profileIconId;
    Long revisionDate;
    Integer summonerLevel;
}
