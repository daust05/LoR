package lor.project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lor.project.domain.Metadata;
import lor.project.domain.Summoner;
import lor.project.repository.SummonerRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RiotApiService {
    private static Metadata metadata = new Metadata();
    private final SummonerRepository summonerRepository;

    private static String locale = "kr";
    private static String continent = "asia";
    private static String localeUrl = "https://"+locale+".api.riotgames.com";
    private static String conUrl = "https://"+continent+".api.riotgames.com";


    Summoner findSummonerByName(String name) throws IOException {
        String encodeName = URLEncoder.encode(name, StandardCharsets.UTF_8);
        String searchPath = "/lol/summoner/v4/summoners/by-name/";
        String apiUrl = localeUrl +searchPath+encodeName;
        URL url = new URL(apiUrl);

        HttpURLConnection con = getHttpURLConnection(url);
        BufferedReader br = getResponse(con);
        Summoner summoner = getSummonerFromJson(br);
        br.close();

        return summoner;
    }

    List<String> findMatchesByPuuid(String puuid) throws Exception {
        String searchPath = "/lor/match/v1/matches/by-puuid/";
        String apiUrl = conUrl + searchPath + puuid;
        URL url = new URL(apiUrl);
        
        HttpURLConnection con = getHttpURLConnection(url);
        BufferedReader br = getResponse(con);
        
    }


    private Summoner getSummonerFromJson(BufferedReader br) throws JsonProcessingException {
        String jsonString = br.lines().collect(Collectors.joining());
        ObjectMapper objectMapper =new ObjectMapper();
        return objectMapper.readValue(jsonString, Summoner.class);
    }
    
    private List<String> getMatchesFromJson(BufferedReader br) throws JsonProcessingException{
        String jsonString = br.lines().collect(Collectors.joining());
        ObjectMapper objectMapper = new ObjectMapper();
        return null;
    }

    private BufferedReader getResponse(HttpURLConnection con) throws IOException {
        BufferedReader br;
        int responseCode = con.getResponseCode();
        if(responseCode ==200) { // 정상 호출
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } else {  // 에러 발생
            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }
        return br;
    }

    private HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty( "X-Riot-Token", metadata.getDeveloperCode());
        return con;
    }


}
