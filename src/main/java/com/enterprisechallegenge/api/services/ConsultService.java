package com.enterprisechallegenge.api.services;

import com.enterprisechallegenge.api.entities.Consult;
import com.enterprisechallegenge.api.repositories.ConsultRepository;
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
public class ConsultService {

    @Autowired
    private ConsultRepository repository;

    public List<Consult> findAll() {
        return repository.findAll();
    }

    public Consult findById(Long id) {
        Optional<Consult> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Consult insert(Consult obj) {
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
    public Consult update(Long id, Consult obj) {
        try {
            Consult entity = repository.getById(id);
            updateData(entity, obj);

            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Consult entity, Consult obj) {
      entity.setDoctor(obj.getDoctor());
        entity.setPatient(obj.getPatient());
        entity.setProcedure(obj.getProcedure());
      entity.setDt_hr_consulta(obj.getDt_hr_consulta());
      entity.setNr_consultorio(obj.getNr_consultorio());
    }

}
