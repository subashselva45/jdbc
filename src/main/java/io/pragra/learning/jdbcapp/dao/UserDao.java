package io.pragra.learning.jdbcapp.dao;

import io.pragra.learning.jdbcapp.constants.SQLs;
import io.pragra.learning.jdbcapp.domain.User;
import io.pragra.learning.jdbcapp.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Slf4j
public class UserDao {
    private JdbcTemplate template;

    public UserDao(JdbcTemplate template) {

        this.template = template;
       // createTable();
    }

    public void createTable(){
        log.info("Creating table USER");
        template.execute(SQLs.USER_SQL);
    }

    public User createUser(User user){
        String sql = "INSERT INTO USER VALUES(?,?,?,?)";
        template.update(sql, new Object[]{ user.getId(),user.getUserName(),user.getCreateDate(),user.getUserPass()});
        return user;
    }

    public User updateUserName(User user){
        String sql = "UPDATE USER SET USER_NAME = ? WHERE USER_ID = ?";
        this.template.update(sql,new Object[]{ user.getUserName(),user.getId()});
        return user;
    }

    public User getUser(int userId) {
        String sql = "SELECT * FROM USER WHERE USER_ID = ?";
            return this.template.queryForObject(sql, new Object[]{userId}, new BeanPropertyRowMapper<User>(User.class));
    }

    public List<User> getAllUser(){
        String sql = "SELECT * FROM USER";
        return this.template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    public void  deleteUser(int userId){
       log.info("DELETING TABLW FROM USER WITH ID",userId);
       int update = this.template.update("DELETE FROM USER WHERE USER_ID=?", userId);
       if(update==0){
           log.error("USER_ID {} doesn't exists in Database");
           throw new UserNotFoundException("No such user");
       }
    }
    public void a(){
        System.out.println("nothing");
    }
}


