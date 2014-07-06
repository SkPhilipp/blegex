package com.hileco.blegex.server.controller;

import com.hileco.blegex.server.model.ContentGroup;
import com.hileco.blegex.server.repository.ContentGroupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Iterator;

@RestController
@RequestMapping("/services/content/groups")
public class ContentGroupController {

    private final ContentGroupRepository contentGroupRepository;

    @Inject
    public ContentGroupController(ContentGroupRepository contentGroupRepository) {
        this.contentGroupRepository = contentGroupRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ContentGroup create(@RequestBody @Valid ContentGroup contentGroup) {
        return this.contentGroupRepository.save(contentGroup);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterator<ContentGroup> list() {
        return this.contentGroupRepository.findAll().iterator();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ContentGroup get(@PathVariable("id") String id) {
        return this.contentGroupRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ContentGroup update(@PathVariable("id") String id, @RequestBody @Valid ContentGroup contentGroup) {
        contentGroup.setId(id);
        return contentGroupRepository.save(contentGroup);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
        this.contentGroupRepository.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}
