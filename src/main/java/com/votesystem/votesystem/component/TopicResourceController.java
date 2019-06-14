package com.votesystem.votesystem.component;

import com.votesystem.votesystem.model.Topic;
import com.votesystem.votesystem.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;


@RepositoryRestController
@RequiredArgsConstructor
public class TopicResourceController {
    private final TopicService topicService;

    @PutMapping(value = "/topics/{id}/starting", produces = "application/hal+json")
    @ResponseBody
    public Resource<Topic> start(@PathVariable("id") int id){
        Topic topic = topicService.get(id);
        //return asm.toFullResource(topicService.start(topic));
        return new Resource<>(topicService.start(topic));
    }

    @PutMapping(value = "/topics/{id}/stop")
    @ResponseBody
    public Resource<Topic>  stop(@PathVariable int id){
        Topic topic = topicService.get(id);
        return new Resource<> (topicService.stop(topic));
    }

    @PostMapping(value = "/topics/{id}/vote")
    @ResponseBody
    public Resource<Topic> vote(@PathVariable int id){
        Topic topic = topicService.get(id);
        topic.setCount(topic.getCount()+1);
        return new Resource<>(topicService.save(topic));
    }
    @GetMapping(value = "/topics/{id}/statistics")
    @ResponseBody
    public Resource<Topic> statistics(@PathVariable int id){
        Topic topic = topicService.get(id);
        return new Resource<>(topic);
    }
}
