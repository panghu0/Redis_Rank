package cn.redis;


import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * @author pang hu
 * @date 2019/12/27 19:42
 */
public class RedisTest {

    private Random random;

    private RestTemplate restTemplate;

    @Before
    public void init() {
        random = new Random();
        restTemplate = new RestTemplate();
    }

    private int genUserId() {
        return random.nextInt(1024);
    }

    private double genScore() {
        return random.nextInt(1024) * 10;
    }

    @Test
    public void initRank() {
        for (int i = 0; i < 50; i++) {
            restTemplate.getForObject("http://localhost:8080/rank/add/" + genUserId() + "/" + genScore(),
                    String.class);
        }
    }
}
