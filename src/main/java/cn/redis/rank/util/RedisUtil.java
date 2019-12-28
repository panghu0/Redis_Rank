package cn.redis.rank.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author pang hu
 * @date 2019/12/27 18:40
 */
@Component
public class RedisUtil {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 添加一个元素zadd
     */
    public void add(String key, String value, double score) {
        redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * 删除元素 zrem
     */
    public void remove(String key, String value) {
        redisTemplate.opsForZSet().remove(key, value);
    }

    /**
     * score的增加or减少 zincrby
     */
    public Double incrScore(String key, String value, double score) {
        return redisTemplate.opsForZSet().incrementScore(key, value, score);
    }

    /**
     * 查询value对应的score   zscore
     */
    public Double score(String key, String value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

    /**
     * 判断value在zset中的排名  zrank
     */
    public Long rank(String key, String value) {
        return redisTemplate.opsForZSet().rank(key, value);
    }

    /**
     * 查询集合中指定顺序的值， 0 -1 表示获取全部的集合内容  zrange
     * 返回有序的集合，score小的在前面
     */
    public Set<String> range(String key, long start, long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    /**
     * 查询集合中指定顺序的值和score，0, -1 表示获取全部的集合内容
     */
    public Set<ZSetOperations.TypedTuple<String>> rangeWithScore(String key, long start, long end) {
        return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
    }

    /**
     * 查询集合中指定顺序的值  zrevrange
     *
     * 返回有序的集合中，score大的在前面
     */
    public Set<String> revRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().reverseRange(key, start, end);
    }

    /**
     * 根据score的值，来获取满足条件的集合  zrangebyscore
     */
    public Set<String> sortRange(String key, long min, long max) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    /**
     * 返回集合的长度
     */
    public Long size(String key) {
        return redisTemplate.opsForZSet().zCard(key);
    }

}
