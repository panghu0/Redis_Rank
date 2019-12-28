package cn.redis.rank.controller;

import cn.redis.rank.entity.Rank;
import cn.redis.rank.util.RankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pang hu
 * @date 2019/12/27 19:17
 */
@RestController
@RequestMapping("rank")
public class RankController {

    @Autowired
    private RankUtil rankUtil;

    //排行榜前几名
    @RequestMapping(value="/top/{n}", method = RequestMethod.GET)
    public List<Rank> showTopN(@PathVariable int n) {
        return rankUtil.getTopNRanks(n);
    }

    //更新积分
    @RequestMapping(value = "/update/{userId}/{score}", method = RequestMethod.GET)
    public Rank updateScore(@PathVariable long userId,@PathVariable int score) {
        return rankUtil.updateRank(userId, score);
    }

    //个人排名
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Rank queryRank(@PathVariable long userId) {
        return rankUtil.getRank(userId);
    }

    //前后n名排名
    @RequestMapping(value = "/around/{userId}/{n}", method = RequestMethod.GET)
    public List<Rank> around(@PathVariable long userId,@PathVariable int n) {
        return rankUtil.getRankAroundUser(userId, n);
    }

    //用于生成初始数据
    @RequestMapping(value = "/add/{userId}/{score}", method = RequestMethod.GET)
    public Rank add(@PathVariable long userId,@PathVariable int score) {
        return rankUtil.add(userId, score);
    }
}
