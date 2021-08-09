package lor.project.repository;

import lor.project.domain.Summoner;

import java.util.Optional;

public class MemorySummonerRepository implements SummonerRepository{
    @Override
    public Summoner save(Summoner summoner) {
        return null;
    }

    @Override
    public Optional<Summoner> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Summoner> findByPuuid(String puuid) {
        return Optional.empty();
    }

    @Override
    public Optional<Summoner> findByName(String name) {
        return Optional.empty();
    }
}
