package io.pragra.learning.jdbcapp;

import io.pragra.learning.jdbcapp.dao.BlogDao;
import io.pragra.learning.jdbcapp.dao.UserDao;
import io.pragra.learning.jdbcapp.domain.Blog;
import io.pragra.learning.jdbcapp.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;


@SpringBootApplication
public class JdbcAppApplication {

    private UserDao userDao;
    private BlogDao blogDao;

    public JdbcAppApplication(UserDao userDao, BlogDao blogDao) {
        this.userDao = userDao;
        this.blogDao = blogDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(JdbcAppApplication.class,args);
    }

    @Bean
    CommandLineRunner runner(){
        return args ->{
            User user = new User(2,"subash","s1u2b3a4s5h6", Instant.now());
           // userDao.deleteUser(1);
          //userDao.createUser(user);
            Blog blog = new Blog(4,4,"Learning Java",101,"Something");
          blogDao.createBlog(blog);
        };
}

}
