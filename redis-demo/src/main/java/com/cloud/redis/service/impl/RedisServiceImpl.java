package com.cloud.redis.service.impl;

import com.cloud.common.domain.Payment;
import com.cloud.redis.mapper.TestMapper;
import com.cloud.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class RedisServiceImpl implements RedisService {

    @Autowired
    private TestMapper mapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //缓存填充
    @Override
    @Cacheable(value = "payment", key = "#id", unless = "#result == null")
    public Payment selectPaymentById(Long id) {
        System.out.println("走了数据库方法......");
        return mapper.selectPaymentById(id);
    }

    @Override
    @CachePut(value = "payment", key = "#payment.id")
    public Payment insert(Payment payment) {
        System.out.println("走了数据库方法......");
        int id = mapper.save(payment);
        return mapper.selectPaymentById(payment.getId());
    }

    @Override
    @CacheEvict(value = "payment", key = "#id")
    public Payment update(Long id) {
        System.out.println("走了数据库方法......");
        mapper.update(id);
        return mapper.selectPaymentById(id);
    }

    @Override
    @CacheEvict(value = "payment", key = "#id")
    public int delete(Long id) {
        System.out.println("走了数据库方法......");
        return mapper.delete(id);
    }


}
