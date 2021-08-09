package lor.project.service;

import lor.project.domain.Summoner;

import java.util.Optional;

public interface SummonerService {
    String join(Summoner summoner);
    Optional<Summoner> findOne(String id);
}
