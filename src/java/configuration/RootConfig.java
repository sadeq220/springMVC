package configuration;

import model.News;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({"repository","service"})
public class RootConfig {
    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/simple");
        dataSource.setUsername("root");
        dataSource.setPassword("RootPassword");
        dataSource.setInitialSize(1);
        dataSource.setMaxTotal(5);
        dataSource.setMaxIdle(5);
        dataSource.setMaxWaitMillis(10999);
        return  dataSource;
    }
    @Bean(name = {"properties"})
    public Properties hibernateProperties(){
        Properties property=new Properties();
        property.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        //property.put("javax.persistence.validation.mode","none");

        property.setProperty("hibernate.hbm2ddl.auto","update");
            return property;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource,@Qualifier(value = "properties")Properties properties){
        LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
       sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setAnnotatedClasses(News.class);
        sessionFactoryBean.setHibernateProperties(properties);
      // sessionFactoryBean.setConfigLocation( "classpath:hibernate.cfg.xml");
        return sessionFactoryBean;

    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager(LocalSessionFactoryBean sessionFactoryBean){
        HibernateTransactionManager transactionManager=new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactoryBean.getObject());
        return transactionManager;

    }
    @Bean
    public PersistenceAnnotationBeanPostProcessor postProcessor(){
        return new PersistenceAnnotationBeanPostProcessor();

    }
    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
}
