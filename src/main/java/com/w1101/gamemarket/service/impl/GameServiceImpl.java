package com.w1101.gamemarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w1101.gamemarket.entity.Factory;
import com.w1101.gamemarket.entity.Game;
import com.w1101.gamemarket.mapper.FactoryMapper;
import com.w1101.gamemarket.mapper.GameMapper;
import com.w1101.gamemarket.mapper.LibraryMapper;
import com.w1101.gamemarket.entity.Gameimage;
import com.w1101.gamemarket.entity.Gametype;
import com.w1101.gamemarket.mapper.*;
import com.w1101.gamemarket.service.IGameService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.w1101.gamemarket.vo.carouselVo;
import com.w1101.gamemarket.vo.gameselectvo;
import com.w1101.gamemarket.vo.gamevo;
import com.w1101.gamemarket.vo.pageVo;
import com.w1101.gamemarket.vo.typevo;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qihui
 * @since 2024-12-22
 */
@Service
public class GameServiceImpl extends ServiceImpl<GameMapper, Game> implements IGameService {
    @Resource
    private GameMapper mapper;
    @Resource
    private FactoryMapper factoryMapper;
    @Override
    public List<Game> selectMainList() {
//        Page<Game> page =new Page<>(1,6);
        QueryWrapper<Game> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("volume");
        wrapper.last("limit 8");
        List<Game> list = mapper.selectList(wrapper);
        //随机选出5条不重复的数据
        List<Game> newList =new ArrayList<Game>();
        List<Integer> tempList = new ArrayList<Integer>();

        Random random = new Random();
        int index = 0;
        for (int i = 0 ;i < 5 ;i++){
            index = random.nextInt(list.size());
            if (!tempList.contains(index)){
                tempList.add(index);
                newList.add(list.get(index));
            }
            else i--;
        }
        return newList;
    }

    @Override
    public List<carouselVo> selectCarouselList() {
        Page<Game> page1 = new Page<>(1,6);
        Page<Game> page2 = new Page<>(2,6);
        QueryWrapper<Game> wrapper = new QueryWrapper<>();
        wrapper.apply("cost != price");
        wrapper.orderByDesc("volume");

        List<Game> list1 = mapper.selectPage(page1,wrapper).getRecords();
        List<Game> list2 = mapper.selectPage(page2,wrapper).getRecords();
        for (int i=0;i< 6;i++){
            BigDecimal discount = list1.get(i).getCost().divide(list1.get(0).getPrice());
            BigDecimal num = BigDecimal.valueOf(1);
            discount = num.subtract(discount).multiply(BigDecimal.valueOf(100));
            String result="-"+discount+"%";
            list1.get(i).setDiscountRate(result);
        }
        for (int i=0;i< 6;i++){
            BigDecimal discount = list2.get(i).getCost().divide(list2.get(0).getPrice());
            BigDecimal num = BigDecimal.valueOf(1);
            discount = num.subtract(discount).multiply(BigDecimal.valueOf(100));
            String result="-"+discount+"%";
            list2.get(i).setDiscountRate(result);
        }
        carouselVo vo = new carouselVo();
        carouselVo vo1 = new carouselVo();

        List<carouselVo> list = new ArrayList<>();
        vo.setIndex(1);
        vo.setCards(list1);
        list.add(vo);
        vo1.setIndex(2);
        vo1.setCards(list2);
        list.add(vo1);
        return list;
    }


    @Override
    public pageVo selectUserGameList(pageVo vo) {

        Page<Game> page = new Page<>(vo.getPageNum(),vo.getPageSize());
//        QueryWrapper<Game> wrapper = new QueryWrapper<>();
//        QueryWrapper<Game> wrapper1 = new QueryWrapper<>();
//        wrapper.eq("user_id",vo.getUserId());

        Page<Game> page1 = mapper.selectByPage(page, vo.getUserId());

//        int total = mapper.selectPageTotal(vo);
        int total = (int) page1.getTotal();
        vo.setTotal(total);
        vo.setList(page1.getRecords());

        return vo;
    }


    @Override
    public Page<Game> selectlist(gamevo vo) {
        Page<Game> page = new Page<>(vo.getPageNum(),vo.getPageSize());
        Page<Game> page1 = mapper.selectPage(page, vo.getSelectedTags(), vo.getSelectedpratforms(), vo.getOrder(), vo.getTitle());

        return  page1;
    }
    @Override
    public typevo selecttypelist(typevo vo) {
        Page<Game> page = new Page<>(vo.getPageNum(),vo.getPageSize());
        Page<Game> page1 = mapper.selectTypeList(page, vo.getSelectedTags());
        vo.setList(page1.getRecords());
        vo.setTotal((int) page1.getTotal());

        return vo;
    }

    @Override
    public int addGame() {
        QueryWrapper<Factory> factoryWrapper = new QueryWrapper<>();

        factoryWrapper.eq("factory_name","RockStar");
        Factory factory = factoryMapper.selectOne(factoryWrapper);

        if (factory.getFactoryId()==null){
            Factory temp = new Factory();
            factoryMapper.insert(temp);
            factory = factoryMapper.selectOne(factoryWrapper);
        }
//        game.setFactoryId(factory.getFactoryId());
//
//        mapper.insert(game);

        return factory.getFactoryId();
    }

    @Override
    public gameselectvo gameselect(gameselectvo vo) {

        QueryWrapper<Game> wrapper1 = new QueryWrapper<>();
//        QueryWrapper<Gameimage> wrapper2 = new QueryWrapper<>();
//        QueryWrapper<Gametype> wrapper3 = new QueryWrapper<>();
        wrapper1.eq("game_id",vo.getGameId());
//        wrapper2.eq("game_id",vo.getGameId());
//        wrapper3.eq("game_id",vo.getGameId());

        Game game = mapper.selectOne(wrapper1);
//        List<Gameimage> image =imageMapper.selectList(wrapper2);
//
//        List<Gametype> type = typeMapper.selectList(wrapper3);

        vo.setA(game);
//        vo.setImage(image);
//        vo.setType(type);

        return vo;
    }

    @Override
    public String getFactoryNameByGameId(Integer gameId) {
        // 查询游戏信息，获取工厂 ID
        Integer factoryId = mapper.findFactoryIdByGameId(gameId);

        // 如果未找到游戏，直接返回 null
        if (factoryId == null) {
            return null;
        }

        // 根据工厂 ID 查询工厂名称
        String factoryName = factoryMapper.findFactoryNameById(factoryId);

        // 返回工厂名称（可能为 null）
        return factoryName;
    }


}
