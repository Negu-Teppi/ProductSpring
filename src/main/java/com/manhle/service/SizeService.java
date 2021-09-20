package com.manhle.service;

import com.manhle.entities.ColorEntity;
import com.manhle.entities.SizeEntity;
import com.manhle.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    public List<SizeEntity> getColors() {
        return (List<SizeEntity>) sizeRepository.findAll();
    }

    public SizeEntity findSizeById(int id) {
        Optional<SizeEntity> optionalC = sizeRepository.findById(id);

        if (optionalC.isPresent()) {
            return optionalC.get();
        }
        return null;
    }
}
