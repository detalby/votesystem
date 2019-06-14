package com.votesystem.votesystem.repository.datajpa;

import com.votesystem.votesystem.model.Topic;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface TopicDataJpa extends PagingAndSortingRepository<Topic, Integer> {

}
