package com.hileco.blegex.server.controller;

import com.hileco.blegex.core.model.UserDocument;
import com.hileco.blegex.core.repository.es.UserDocumentRepository;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/services/userdocuments")
public class UserDocumentService {

    private final UserDocumentRepository userDocumentRepository;

    @Inject
    public UserDocumentService(UserDocumentRepository userDocumentRepository) {
        this.userDocumentRepository = userDocumentRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody @Valid final UserDocument userDocument) {
        this.userDocumentRepository.save(userDocument);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<UserDocument> findAll() {
        return userDocumentRepository.findAll();
    }

    @RequestMapping(value = "/find-id", method = RequestMethod.GET)
    public UserDocument findById(@RequestParam("id") String id) {
        return this.userDocumentRepository.findOne(id);
    }

    @RequestMapping(value = "/find-content", method = RequestMethod.GET)
    public List<UserDocument> findByContent(@RequestParam("content") String content) {
        return this.userDocumentRepository.findByContent(content);
    }

}