package cn.redis.rank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author pang hu
 * @date 2019/12/27 18:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rank implements Serializable {

    long userId;
    long rank;
    int score;
}
