package lor.project.repository;

import lombok.RequiredArgsConstructor;
import lor.project.domain.Summoner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaSummonerRepository implements SummonerRepository{

    private final EntityManager em;

    @Override
    public Summoner save(Summoner summoner) {
        em.persist(summoner);
        return summoner;
    }

    @Override
    public Optional<Summoner> findById(String id) {
        Summoner summoner = em.find(Summoner.class, id);
        return Optional.ofNullable(summoner);
    }

    @Override
    public Optional<Summoner> findByPuuid(String puuid) {
        List<Summoner> resultList = em.createQuery("select s from Summoner s where s.puuid = :puuid", Summoner.class)
                .setParameter("puuid", puuid)
                .getResultList();
        return resultList.stream().findAny();
    }

    @Override
    public Optional<Summoner> findByName(String name) {
        List<Summoner> resultList = em.createQuery("select s from Summoner s where s.name = :name", Summoner.class)
                .setParameter("name", name)
                .getResultList();
        return resultList.stream().findAny();
    }
}
