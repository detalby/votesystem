package com.votesystem.votesystem.component;

import com.votesystem.votesystem.model.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
@RequiredArgsConstructor
public class TopicResourceProcessor implements ResourceProcessor<Resource<Topic>> {

    private final RepositoryEntityLinks links;

    @Override
    public Resource<Topic> process(Resource<Topic> resource) {
        Topic topic = resource.getContent();
        if (topic.isStatus()==false){
            resource.add(linkTo(methodOn(TopicResourceController.class).start(topic.getId())).withRel("starting"));
        }
        if (topic.isStatus()==true){
            resource.add(linkTo(methodOn(TopicResourceController.class).stop(topic.getId())).withRel("stop"));
            resource.add(linkTo(methodOn(TopicResourceController.class).vote(topic.getId())).withRel("vote"));
        }
        resource.add(linkTo(methodOn(TopicResourceController.class).statistics(topic.getId())).withRel("statistics"));
        return resource;
    }
}

