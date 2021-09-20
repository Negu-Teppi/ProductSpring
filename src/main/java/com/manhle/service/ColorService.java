package com.manhle.service;

import com.manhle.entities.ColorEntity;
import com.manhle.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    public List<ColorEntity> getColors() {
        return (List<ColorEntity>) colorRepository.findAll();
    }

    public ColorEntity findColorById(int id) {
        Optional<ColorEntity> optionalC = colorRepository.findById(id);

        if (optionalC.isPresent()) {
            return optionalC.get();
        }
        return null;
    }
}
