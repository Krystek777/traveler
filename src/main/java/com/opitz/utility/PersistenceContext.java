package com.opitz.utility;

import com.opitz.action.ClaimAction;
import com.opitz.action.UpdateClaimAction;
import com.opitz.action.UserAction;
import com.opitz.model.Claim;
import com.opitz.repository.ClaimRepository;
import com.opitz.repository.HibernateClaimRepository;
import com.opitz.repository.HibernateUserRepository;
import com.opitz.repository.UserRepository;
import com.opitz.service.ClaimService;
import com.opitz.service.ClaimServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan("com.opitz")
@WebAppConfiguration
public class PersistenceContext {


    @Bean(name="/login")
    UserAction login() {
        return new UserAction();
    }

    @Bean(name="/loginSubmit")
    UserAction loginSubmit() {
        return new UserAction();
    }

    @Bean(name="/signUp")
    UserAction signUp() {
        return new UserAction();
    }

    @Bean("/saveUser")
    UserAction saveUser() {
        return new UserAction();
    }

    @Bean("/addClaimSubmit")
    ClaimAction addClaimSubmit() {
        return new ClaimAction();
    }

    @Bean("/allClaims")
    ClaimAction claimAction() {
        return new ClaimAction();
    }

    @Bean("/approveClaim")
    UpdateClaimAction approveClaim() {
        return new UpdateClaimAction();
    }

    @Bean("/rejectClaim")
    UpdateClaimAction rejectClaim(){
        return new UpdateClaimAction();
    }

    @Bean
    ClaimService claimService() {
        return new ClaimServiceImpl();
    }

    @Bean
    @Qualifier("HibernateClaimRepository")
    ClaimRepository hibernateClaimRepository() {
        return new HibernateClaimRepository();
    }

    @Bean
    @Qualifier("HibernateUserRepository")
    UserRepository hibernateUserRepository() {
        return new HibernateUserRepository();
    }

    @Bean(destroyMethod = "close")
    DataSource dataSource(Environment env) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/traveldb");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                Environment env) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.opitz.model");

        Properties jpaProperties = new Properties();

        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        jpaProperties.put("hibernate.hbm2ddl.auto", "update");

        jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");

        jpaProperties.put("hibernate.show_sql", "false");

        jpaProperties.put("hibernate.format_sql", "true");

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }


}
