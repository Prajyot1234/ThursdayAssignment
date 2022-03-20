package com.kloudspot.service;

import com.kloudspot.exceptions.WebShowNotFoundException;
import com.kloudspot.model.WebShow;
import com.kloudspot.repository.IWebShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebShowServiceImpl implements  IWebShowService{
    private IWebShowRepository webShowRepository;

    @Autowired
    public void setWebShowRepository(IWebShowRepository iWebShowRepository){ this.webShowRepository = iWebShowRepository;}

    @Override
    public void addWebShow(WebShow webShow) {
        webShowRepository.insert(webShow);
    }

    @Override
    public void updateWebShow(WebShow webShow) {
        webShowRepository.save(webShow);
    }

    @Override
    public void deleteWebShow(int webShowID) {
        webShowRepository.deleteById(webShowID);
    }

    @Override
    public List<WebShow> getAllWebShow() {
        return webShowRepository.findAll();
    }

    @Override
    public WebShow getById(int id) throws WebShowNotFoundException {
        return webShowRepository.findById(id).orElseThrow(() -> new WebShowNotFoundException("Not found webshow with given ID"));
    }

    @Override
    public List<WebShow> getByWebshowName(String webshowName) throws WebShowNotFoundException {
        List<WebShow> webShows = webShowRepository.findByWebshowName(webshowName);
        if(webShows.isEmpty()) throw new WebShowNotFoundException("Not found webshow with given webshow name");
        return webShows;
    }

    @Override
    public List<WebShow> getByMaleactorName(String maleactorName) throws WebShowNotFoundException {
        List<WebShow> webShows = webShowRepository.findByMaleactorName(maleactorName);
        if(webShows.isEmpty()) throw new WebShowNotFoundException("Not found webshow with given maleactor name");
        return webShows;
    }

    @Override
    public List<WebShow> getByFemaleactorName(String femaleactorName) throws WebShowNotFoundException {
        List<WebShow> webShows = webShowRepository.findByFemaleactorName(femaleactorName);
        if(webShows.isEmpty()) throw new WebShowNotFoundException("Not found webshow with given femaleactor name");
        return webShows;
    }

    @Override
    public List<WebShow> getByDirectorName(String directorName) throws WebShowNotFoundException {
        List<WebShow> webShows = webShowRepository.findByDirectorName(directorName);
        if(webShows.isEmpty()) throw new WebShowNotFoundException("Not found webshow with given director name");
        return webShows;
    }

    @Override
    public List<WebShow> getByMaleactorNameAndFemaleactorName(String maleactorName, String femaleactorName) throws WebShowNotFoundException {
        List<WebShow> webShows = webShowRepository.findByMaleactorNameAndFemaleactorName(maleactorName,femaleactorName);
        if(webShows.isEmpty()) throw new WebShowNotFoundException("Not found webshow with given male and female actor name");
        return webShows;
    }

    @Override
    public List<WebShow> getByIMDBRating(double IMDBRating) throws WebShowNotFoundException {
        List<WebShow> webShows = webShowRepository.getByIMDBRating(IMDBRating);
        if(webShows.isEmpty()) throw new WebShowNotFoundException("Not found webshow with given IMDBRating");
        return webShows;
    }
}
