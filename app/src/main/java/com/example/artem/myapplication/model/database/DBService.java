package com.example.artem.myapplication.model.database;

import com.example.artem.myapplication.model.database.model.News;
import com.example.artem.myapplication.model.database.model.NewsSource;
import com.example.artem.myapplication.model.database.model.User;

import java.util.List;

public interface DBService {
    //User
    void registerUser(User user);
    User findUserByLogin(String email);
    void deleteUserByLogin(String email);

    //NewsSource
    List<NewsSource> findAllNewsSource();
    void addNewsSource(NewsSource newsSource);
    void deleteNewsSource(NewsSource newsSource);

    //News
    List<News> findAllNewsByNewsSource(NewsSource newsSource);
    void addNews(News news);
    void deleteNews(News news);
}
