package pl.pawelszczerbicki.smarthome.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 28.09.13
 * Time: 14:16
 * To change this template use File | Settings | File Templates.
 */
@Repository
@SuppressWarnings("unchecked")
public abstract class GenericDao<T> {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private Class<T> clazz;


    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T get(Long id){
        return mongoTemplate.findById(id, clazz);
    }

    public void save(T entity){
        mongoTemplate.save(entity);
    }
}

