package lor.project.repository;

import lor.project.domain.Summoner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaSummonerRepositoryTest {

    @Autowired
    SummonerRepository summonerRepository;

    @Test
    public void joinTest(){
        //given
        Summoner summoner = new Summoner("1","1","1","1",1,1L,1);
        summoner.setName("룰 룽");
        //when
        summonerRepository.save(summoner);
        Optional<Summoner> find = summonerRepository.findByName("룰 룽");
        //then
        Assertions.assertThat(summoner).isEqualTo(find.get());
    }
}