package com.fredriksonsound.iot_backoffice_auth.data;

import com.fredriksonsound.iot_backoffice_auth.model.Agency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Database interaction interface.
 */
@Repository
public interface AgencyRepository extends CrudRepository<Agency, String> { }
