package com.seata.storage.service.impl;

import com.seata.storage.mapper.StorageMapper;
import com.seata.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void deduct(String commodityCode, Integer count) {
        storageMapper.deduct(commodityCode, count);
    }
}
