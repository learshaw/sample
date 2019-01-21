/*
 * 文 件 名:  DataSourceConfig.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/05 09:57
 */
package com.eral.brain.simple.common;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * $数据源配置
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2018/11/05 09:57]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Configuration
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {
    static final String PACKAGE = "com.ztesoft.brain.simple.mapper";
    static final String MAPPER_LOCATION = "classpath*:mapper/*.xml";
    static final String MYBATIS_CONFIG_LOCATION = "classpath:mybatis-config.xml";

    @Value("${spring.datasource.default.url}")
    private String url;

    @Value("${spring.datasource.default.username}")
    private String user;

    @Value("${spring.datasource.default.password}")
    private String password;

    @Value("${spring.datasource.default.driver-class-name}")
    private String driverClass;

    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSourceConfig.MAPPER_LOCATION));
        sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(DataSourceConfig.MYBATIS_CONFIG_LOCATION));

        return sessionFactory.getObject();
    }
}
