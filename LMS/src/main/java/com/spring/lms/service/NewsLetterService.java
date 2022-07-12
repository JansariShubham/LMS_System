package com.spring.lms.service;

import com.spring.lms.model.NewsLetter;
import com.spring.lms.repository.NewsLetterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewsLetterService {

    @Autowired
    private NewsLetterRepository newsLetterRepository;

    private Logger logger = LoggerFactory.getLogger(NewsLetterService.class);

    public NewsLetter addEmailToNewsLetterList(String email) {
        logger.info("--- Service = Adding Email ID TO News Letter List: {}", email);
        return newsLetterRepository.save(
                new NewsLetter(email)
        );
    }

    public boolean checkUserExistsInNewsLetter(String email) {
        Optional<NewsLetter> optionalNewsLetter
                = newsLetterRepository.findByEmail(email);

        return optionalNewsLetter.isPresent();
    }

    public void removeUserFromNewsLetter(String email){
        newsLetterRepository.deleteByEmail(email);
    }
}
