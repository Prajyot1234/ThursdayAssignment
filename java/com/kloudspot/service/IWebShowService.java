package com.kloudspot.service;

import com.kloudspot.exceptions.WebShowNotFoundException;
import com.kloudspot.model.WebShow;

import java.util.List;

public interface IWebShowService {
    void addWebShow(WebShow webShow);
    void updateWebShow(WebShow webShow);
    void deleteWebShow(int webShowID);
    List<WebShow> getAllWebShow();
    WebShow getById(int id) throws WebShowNotFoundException;
    List<WebShow> getByWebshowName(String webshowName) throws WebShowNotFoundException;
    List<WebShow> getByMaleactorName(String maleactorName) throws WebShowNotFoundException;
    List<WebShow> getByFemaleactorName(String femaleactorName) throws WebShowNotFoundException;
    List<WebShow> getByDirectorName(String directorName) throws WebShowNotFoundException;

    List<WebShow> getByMaleactorNameAndFemaleactorName(String maleactorName,String femaleactorName) throws WebShowNotFoundException;
    List<WebShow> getByIMDBRating(double IMDBRating) throws WebShowNotFoundException;
}
