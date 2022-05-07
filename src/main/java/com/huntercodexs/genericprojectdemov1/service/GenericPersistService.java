package com.huntercodexs.genericprojectdemov1.service;

import com.huntercodexs.genericprojectdemov1.errors.GenericErrors;
import com.huntercodexs.genericprojectdemov1.exception.MMBISExceptionGeneric;
import com.huntercodexs.genericprojectdemov1.model.GenericEntity;
import com.huntercodexs.genericprojectdemov1.repository.GenericRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class GenericPersistService {

    private static final Logger LOG = LoggerFactory.getLogger(GenericService.class);

    @Autowired
    GenericRepository genericRepository;

    public void save() {

        LOG.info("save is calling");

        Date now = new Date();
        String currentDate = new SimpleDateFormat("dd/MM/yyy HH:mm:ss").format(now);

        try {

            GenericEntity genericEntity = new GenericEntity();
            genericEntity.setName(null);
            genericRepository.save(genericEntity);

            LOG.info("claimShareSave executed with successfully");

        } catch (RuntimeException re) {

            LOG.error("claimShareSave executed with error: " + re.getMessage());
            throw new MMBISExceptionGeneric(
                    GenericErrors.GENERIC_ERROR_EXCEPTION,
                    "claimShareSave executed with error: " + re.getMessage());

        }

    }

    public void update() {

        LOG.info("save is calling");

        Date now = new Date();
        String currentDate = new SimpleDateFormat("dd/MM/yyy HH:mm:ss").format(now);

        try {

            GenericEntity genericEntity = new GenericEntity();
            genericEntity.setName(null);
            genericRepository.save(genericEntity);

            LOG.info("claimShareSave executed with successfully");

        } catch (RuntimeException re) {

            LOG.error("claimShareSave executed with error: " + re.getMessage());
            throw new MMBISExceptionGeneric(
                    GenericErrors.GENERIC_ERROR_EXCEPTION,
                    "claimShareSave executed with error: " + re.getMessage());

        }

    }

}
