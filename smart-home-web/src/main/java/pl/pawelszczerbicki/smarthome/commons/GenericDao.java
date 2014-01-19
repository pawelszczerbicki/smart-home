package pl.pawelszczerbicki.smarthome.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public T get(String id){
        return mongoTemplate.findById(id, clazz);
    }

    public List<T> findAll(){
        return mongoTemplate.findAll(clazz);
    }

    public void save(T entity){
        mongoTemplate.save(entity);
    }

    public void remove(String id){
        mongoTemplate.remove(Query.query(Criteria.where("id").is(id)), clazz);
    }
}

