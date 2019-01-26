package com.naya.gameofthrones.signuterdecoderinformer.services;

import com.naya.gameofthrones.signuterdecoderinformer.model.DecodedLetter;
import com.naya.gameofthrones.signuterdecoderinformer.model.Letter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
@Service
@Slf4j
public class LetterDecoderImpl implements LetterDecoder {

    @Override
    @SneakyThrows
    public DecodedLetter decode(Letter letter) {

        Thread.sleep(letter.getTimeToProcess());
        Field field = Letter.class.getDeclaredField("signature");
        field.setAccessible(true);
        String author = (String) field.get(letter);
        return DecodedLetter.builder().author(author).location(letter.getLocation()).content(letter.getContent()).build();
    }
}
