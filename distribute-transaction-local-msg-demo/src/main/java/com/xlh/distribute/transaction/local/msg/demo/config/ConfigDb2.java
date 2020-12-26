package com.xlh.distribute.transaction.local.msg.demo.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年12月19日 21:36 胡晓磊 Exp $
 */
@Configuration
@MapperScan(value = "com.xlh.distribute.transaction.local.msg.demo.db2.dao", sqlSessionFactoryRef = "sqlSessionFactoryBean2")
public class ConfigDb2 {
    @Bean("db2")
    public DataSource db1() {
        MysqlXADataSource xaDataSource = new MysqlXADataSource();
        xaDataSource.setUser("root");
        xaDataSource.setPassword("123456");
        xaDataSource.setUrl("jdbc:mysql://192.168.3.137:3306/xa_2?useUnicode=true&characterEncoding=utf8");

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(xaDataSource);
        return atomikosDataSourceBean;
    }

    @Bean("sqlSessionFactoryBean2")
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("db2") DataSource dataSource) throws IOException {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.
        sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("mybatis/db2/**/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean("tm2")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("db2") DataSource dataSource) {

        return new DataSourceTransactionManager(dataSource);
    }
}
