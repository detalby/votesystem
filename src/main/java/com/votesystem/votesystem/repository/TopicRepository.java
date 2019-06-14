package com.votesystem.votesystem.repository;

import com.votesystem.votesystem.model.Topic;

import java.util.List;

public interface TopicRepository {
    Topic save(Topic entity);
    Topic get(int id);
    //List<Topic> getAll();
}
