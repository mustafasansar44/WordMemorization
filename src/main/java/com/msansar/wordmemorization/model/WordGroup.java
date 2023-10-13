package com.msansar.wordmemorization.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.msansar.wordmemorization.util.CascadeSave;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("wordGroup")
public class WordGroup extends BaseEntity{
    private String foreignWord;
    private String localWord;
    private boolean isActive;
}
