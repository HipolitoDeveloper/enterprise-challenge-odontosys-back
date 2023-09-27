package com.enterprisechallegenge.api.services;

import com.enterprisechallegenge.api.entities.Procedure;
import com.enterprisechallegenge.api.repositories.ProcedureRepository;
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
public class ProcedureService {

    @Autowired
    private ProcedureRepository repository;

    public List<Procedure> findAll() {
        return repository.findAll();
    }

    public Procedure findById(Long id) {
        Optional<Procedure> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Procedure insert(Procedure obj) {
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

    public Procedure update(Long id, Procedure obj) {
        try {
            Procedure entity = repository.getById(id);
            updateData(entity, obj);

            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Procedure entity, Procedure obj) {
        entity.setNm_procedimento(obj.getNm_procedimento());

    }

}
