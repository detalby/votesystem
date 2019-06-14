package com.votesystem.votesystem.service;

import com.votesystem.votesystem.model.Topic;


public interface TopicService {
    Topic save(Topic entity);
    Topic start(Topic entity);
    Topic stop(Topic entity);
    Topic get(int id);
}
