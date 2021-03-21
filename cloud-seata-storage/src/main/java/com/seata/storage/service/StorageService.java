package com.seata.storage.service;

public interface StorageService {

    void deduct(String commodityCode, Integer count);
}
