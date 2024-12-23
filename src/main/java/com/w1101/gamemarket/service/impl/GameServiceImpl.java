package com.w1101.gamemarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w1101.gamemarket.entity.Game;
import com.w1101.gamemarket.mapper.GameMapper;
import com.w1101.gamemarket.service.IGameService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.w1101.gamemarket.vo.carouselVo;
import jakarta.annotation.Resource;
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
}
