package com.votesystem.votesystem.repository.impl;

import com.votesystem.votesystem.repository.datajpa.TopicDataJpa;
import com.votesystem.votesystem.repository.TopicRepository;
import com.votesystem.votesystem.model.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TopicRepositoryImpl implements TopicRepository {
    private final TopicDataJpa topicDataJpa;

    @Override
    public Topic save(Topic entity) {
        return topicDataJpa.save(entity);
    }

    @Override
    public Topic get(int id) {
        return topicDataJpa.findById(id).get();
    }

}
