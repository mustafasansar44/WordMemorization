package com.msansar.wordmemorization.util;

import com.msansar.wordmemorization.model.User;
import com.msansar.wordmemorization.model.WordGroup;
import com.msansar.wordmemorization.repository.UserRepository;
import com.msansar.wordmemorization.repository.WordGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.util.ReflectionUtils;

import java.util.List;

public class CascadingMongoEventListener extends AbstractMongoEventListener<Object> {

    @Autowired
    private MongoOperations mongoOperations;
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> sourceObj) {
        Object source = sourceObj.getSource();

        ReflectionUtils.doWithFields(source.getClass(), field -> {
            ReflectionUtils.makeAccessible(field);
            if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(CascadeSave.class)) {
                if ((source instanceof User) && !(((User) source).getWordGroupList().isEmpty())) {
                    ((User) source).getWordGroupList().forEach(wordGroup -> {
                        mongoOperations.save(wordGroup);
                    });
                }
            }
        });
    }
}
