package io.pragra.learning.jdbcapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Blog {
    private int blodId;
    private int userId;
    private String blogName;
    private int blogCategory;
    private String blogText;


}
