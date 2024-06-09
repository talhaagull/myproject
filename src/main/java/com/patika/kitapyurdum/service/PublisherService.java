package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.PublisherConverter;
import com.patika.kitapyurdum.dto.request.PublisherSaveRequest;
import com.patika.kitapyurdum.repository.PublisherRepository;
import com.patika.kitapyurdum.model.Publisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public void save(PublisherSaveRequest request) {

        Publisher publisher = PublisherConverter.toPublisher(request);
        publisherRepository.save(publisher);
        log.info("Publisher saved -> ", publisher.toString());

    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Optional<Publisher> getByName(String publisherName) {
        return getAllPublishers().stream()
                .filter(publisher -> publisher.getName().equals(publisherName))
                .findFirst();
    }
}
