package com.hileco.blegex.server.controller;

import com.hileco.blegex.server.model.ContentElement;
import com.hileco.blegex.server.repository.ContentElementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Iterator;

@RestController
@RequestMapping("/services/content/elements")
@PreAuthorize("isAuthenticated()")
public class ContentElementController {

    private final ContentElementRepository contentElementRepository;

    @Inject
    public ContentElementController(ContentElementRepository contentElementRepository) {
        this.contentElementRepository = contentElementRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ContentElement create(@RequestBody @Valid ContentElement contentElement) {
        return this.contentElementRepository.save(contentElement);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterator<ContentElement> list() {
        return this.contentElementRepository.findAll().iterator();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ContentElement get(@PathVariable("id") String id) {
        return this.contentElementRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ContentElement update(@PathVariable("id") String id, @RequestBody @Valid ContentElement contentElement) {
        contentElement.setId(id);
        return contentElementRepository.save(contentElement);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
        this.contentElementRepository.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}
