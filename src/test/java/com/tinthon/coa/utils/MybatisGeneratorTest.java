package com.tinthon.coa.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sidne on 2017/7/13.
 */
public class MybatisGeneratorTest{
    private static final Logger logger = LoggerFactory.getLogger(MybatisGeneratorTest.class);

    @Test
    public void mybatisGenerate() {
        String path = MybatisGeneratorTest.class.getResource("/generatorConfig.xml").getPath();
        logger.info(path);
        logger.info("Mapper 生成成功");
        MybatisGenerators.generator(path);
    }
}
