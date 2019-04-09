package com.lovejava.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author:tianyao
 * @date:2019-04-09 17:09
 * 配置类
 * 取代bean.xml
 */
@Configuration
@ComponentScan(basePackages = {"com.lovejava"})//包扫描
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {
    @Value("${driverClass}")
    private String driverClass;
    @Value("${jdbcUrl}")
    private String jdbcUrl;
    @Value("${password}")
    private String password;
    @Value("${user}")
    private String user;

    /**
     * 创建数据源对象
     *
     * @Bean 用在方法上，将方法创建的对象的返回值注入到springIOC容器中,相当于bean标签，默认的id是方法的名字,使用name属性重新定义id
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setPassword(password);
        dataSource.setUser(user);
        return dataSource;
    }

    /**
     * 创建数据源对象
     *
     * @Bean 用在方法上，将方法创建的对象的返回值注入到springIOC容器中,
     * 相当于bean标签，默认的id是方法的名字,使用name属性重新定义id
     * 方法的参数会从IOC中查找注入，默认byType 否则byName
     */
    @Bean(name = "runner")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        QueryRunner runner = new QueryRunner(dataSource);
        return runner;
    }

}
