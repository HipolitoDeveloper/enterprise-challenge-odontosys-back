package com.enterprisechallegenge.api.services;

import com.enterprisechallegenge.api.entities.Office;
import com.enterprisechallegenge.api.repositories.OfficeRepository;
import com.enterprisechallegenge.api.services.exceptions.DatabaseException;
import com.enterprisechallegenge.api.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class OfficeService {

    @Autowired
    private OfficeRepository repository;

    public List<Office> findAll() {
        return repository.findAll();
    }

    public Office findById(Long id) {
        Optional<Office> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Office insert(Office obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
    public Office update(Long id, Office obj) {
        try {
            Office entity = repository.getById(id);
            updateData(entity, obj);

            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Office entity, Office obj) {
      entity.setNm_bairro(obj.getNm_bairro());
      entity.setNm_rua(obj.getNm_rua());
      entity.setNm_bairro(obj.getNm_bairro());
    }

}
