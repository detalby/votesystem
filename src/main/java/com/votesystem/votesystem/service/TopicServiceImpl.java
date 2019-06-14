package com.votesystem.votesystem.service;

import com.votesystem.votesystem.repository.TopicRepository;
import com.votesystem.votesystem.model.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Override
    public Topic save(Topic entity) {
        return topicRepository.save(entity);
    }

    @Override
    public Topic start(Topic entity) {
        entity.setStatus(true);
        return topicRepository.save(entity);
    }

    @Override
    public Topic stop(Topic entity) {
        entity.setStatus(false);
        return topicRepository.save(entity);
    }

    @Override
    public Topic get(int id) {
        return topicRepository.get(id);
    }

}
