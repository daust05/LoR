package lor.project.repository;

import lor.project.domain.Summoner;

import java.util.Optional;

public interface SummonerRepository {
    Summoner save(Summoner summoner);
    Optional<Summoner> findById(String id);
    Optional<Summoner> findByPuuid(String puuid);
    Optional<Summoner> findByName(String name);
}
