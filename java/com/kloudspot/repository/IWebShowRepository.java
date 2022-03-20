package com.kloudspot.repository;

import com.kloudspot.model.WebShow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWebShowRepository extends MongoRepository<WebShow,Integer> {

    List<WebShow> findByWebshowName(String name);
    List<WebShow> findByMaleactorName(String MaleActorName);
    List<WebShow> findByFemaleactorName(String femaleActorName);
    List<WebShow> findByDirectorName(String directorName);

    //custom query
    @Query("{IMDBRating: {$gte:5}}")
    List<WebShow> getByIMDBRating(double IMDBRating);

    List<WebShow> findByMaleactorNameAndFemaleactorName(String MaleactorName,String FemaleactorName);
}
