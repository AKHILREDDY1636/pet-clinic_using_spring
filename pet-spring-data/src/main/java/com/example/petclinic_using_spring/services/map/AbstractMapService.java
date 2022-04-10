package com.example.petclinic_using_spring.services.map;

import com.example.petclinic_using_spring.models.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {
    protected Map<Long,T> map=new HashMap<>();
    Set<T> findAll(){
        return new HashSet(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if(object!=null){
            if(Long.toString(object.getId())== null){
                object.setId(getNextId());
            }
            map.put(object.getId(),object);
        }
        else {
            throw new RuntimeException("The Object can not Null.");
        }
        return object;
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteById(ID id){
        map.remove(id);
    }

    Long getNextId(){
        Long next_id=null;
        try{
            next_id= Collections.max(map.keySet())+1;
        }
        catch (NullPointerException e){
            next_id=1L;
        }
        return next_id;
    }


}
