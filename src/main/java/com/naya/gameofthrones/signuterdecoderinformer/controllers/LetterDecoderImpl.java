package com.naya.gameofthrones.signuterdecoderinformer.controllers;

import com.naya.gameofthrones.signuterdecoderinformer.model.DecodedLetter;
import com.naya.gameofthrones.signuterdecoderinformer.model.Letter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
@Service
public class LetterDecoderImpl implements LetterDecoder {
    @Setter
    private long delay=1;

    @Override
    @SneakyThrows
    public DecodedLetter decode(Letter letter) {
        Thread.sleep(delay);
        Field field = Letter.class.getDeclaredField("signature");
        field.setAccessible(true);
        String author = (String) field.get(letter);
        return DecodedLetter.builder().author(author).location(letter.getLocation()).content(letter.getContent()).build();
    }
}
