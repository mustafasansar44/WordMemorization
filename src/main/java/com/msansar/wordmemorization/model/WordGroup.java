package com.msansar.wordmemorization.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "wordGroups")
public class WordGroup extends BaseEntity{

    private String foreignWord;
    private String localWord;
    private boolean isActive;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordGroup wordGroup = (WordGroup) o;
        return isActive == wordGroup.isActive && Objects.equals(foreignWord, wordGroup.foreignWord) && Objects.equals(localWord, wordGroup.localWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foreignWord, localWord, isActive);
    }
}
