package lor.project.service;

import lor.project.domain.Summoner;
import lor.project.repository.MemorySummonerRepository;
import lor.project.repository.SummonerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class RiotApiServiceImplTest {

    SummonerRepository summonerRepository = new MemorySummonerRepository();
    RiotApiService riotApiService = new RiotApiService(summonerRepository);

    @Test
    public void findSummonerByName() throws IOException {
        Summoner summoner = riotApiService.findSummonerByName("룰 룽");
        Assertions.assertThat(summoner.getName()).isEqualTo("룰 룽");
    }

    @Test
    public void findMatchesByPuuid() throws IOException {
        Summoner summoner = riotApiService.findSummonerByName("룰 룽");
    }

}