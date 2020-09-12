package service;

import model.Inventory;
import model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import repository.ProxyContainer;
import repository.UserDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Service

public class Service {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ProxyContainer container;


    @Transactional(readOnly = true)
    public News find(int id)
    {
        return userDAO.find(id);
    }

    @Transactional
    public void delete(int id){
        userDAO.delete(id);
    }
    @Transactional
    public void update(News news){
        userDAO.update(news);
    }

    @Transactional
    public List<News> allNews(){

        return userDAO.allNews();
    }
    @Transactional
    public String saveNews(News news){

        Integer id=(Integer)userDAO.saveNews(news);
         String s=String.format("pic%d.jpg",id);
         news.setImagePath(s);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return s;
    }
}
