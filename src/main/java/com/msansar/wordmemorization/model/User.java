package com.msansar.wordmemorization.model;

import com.msansar.wordmemorization.util.CascadeSave;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Document("user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends BaseEntity{
    private String username;
    private String password;
    private String email;
    @DBRef
    @CascadeSave
    List<WordGroup> wordGroupList = new ArrayList<>();

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public User(String id, Date createdAt, Date updatedAt, String username, String password, String email) {
        super(id, createdAt, updatedAt);
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
// TODO: CascadeSave yap
