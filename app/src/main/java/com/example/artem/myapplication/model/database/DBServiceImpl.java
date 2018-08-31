package com.example.artem.myapplication.model.database;

import com.example.artem.myapplication.model.database.model.News;
import com.example.artem.myapplication.model.database.model.NewsSource;
import com.example.artem.myapplication.model.database.model.User;
import com.example.artem.myapplication.presenter.util.PasswordEncoder;

import java.util.List;

public class DBServiceImpl implements DBService {
    @Override
    public void registerUser(User user) {

    }

    @Override
    public User findUserByLogin(String email) {
        if (email.equals("test@gmail.com")){
            return new User(email, PasswordEncoder.encryptPassword("12345"));
        }
        return null;
    }

    @Override
    public void deleteUserByLogin(String login) {

    }

    @Override
    public List<NewsSource> findAllNewsSource() {
        return null;
    }

    @Override
    public void addNewsSource(NewsSource newsSource) {

    }

    @Override
    public void deleteNewsSource(NewsSource newsSource) {

    }

    @Override
    public List<News> findAllNewsByNewsSource(NewsSource newsSource) {
        return null;
    }

    @Override
    public void addNews(News news) {

    }

    @Override
    public void deleteNews(News news) {

    }
}
