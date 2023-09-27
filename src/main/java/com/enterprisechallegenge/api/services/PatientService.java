package com.enterprisechallegenge.api.services;

import com.enterprisechallegenge.api.entities.Patient;
import com.enterprisechallegenge.api.repositories.PatientRepository;
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
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public List<Patient> findAll() {
        return repository.findAll();
    }

    public Patient findById(Long id) {
        Optional<Patient> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Patient insert(Patient obj) {
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

    public Patient update(Long id, Patient obj) {
        try {
            Patient entity = repository.getById(id);
            updateData(entity, obj);

            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Patient entity, Patient obj) {
        entity.setDs_peso(obj.getDs_peso());
        entity.setDs_altura(obj.getDs_altura());
        entity.setDs_sexo(obj.getDs_sexo());
        entity.setDt_nascimento(obj.getDt_nascimento());
        entity.setNm_paciente(obj.getNm_paciente());
        entity.setOffice(obj.getOffice());

    }

}
