package com.techelevator.controller;

import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.OfficeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Doctor;
import com.techelevator.model.Office;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/offices")
//@PreAuthorize("isAuthenticated()")
public class OfficeController {

    private UserDao userDao;
    private DoctorDao doctorDao;
    private OfficeDao officeDao;

    public OfficeController(UserDao userDao, DoctorDao doctorDao, OfficeDao officeDao) {
        this.userDao = userDao;
        this.doctorDao = doctorDao;
        this.officeDao = officeDao;
    }


    // Get All Offices *************************************
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Office> getAllOffices() {
        try {
            List<Office> offices = officeDao.getAllOffices();
            return offices;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "There are no offices here...Bummer..." + e);
        }
    }

    // Get Office By Office Id *************************************
    @RequestMapping(path = "/{officeId}", method = RequestMethod.GET)
    public Office getOfficeByOfficeId(@PathVariable int officeId) {
        try {
            Office office = officeDao.getOfficeById(officeId);
            return office;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "There is no office with this ID." + e);
        }
    }

    // POST Create New Office *************************************
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Office createOffice(@Valid @RequestBody Office newOffice) {
        Office office;
        try {
            office = officeDao.createOffice(newOffice);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Error creating new office." + e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Scientfic Postgres goes boink..! " + e);
        }
        return office;
    }

    // PUT Update Office Information *************************************
    @CrossOrigin
    @RequestMapping(path = "/{officeId}", method = RequestMethod.PUT)
    public Office updateOfficeInfo(@Valid @RequestBody Office office, @PathVariable int officeId) {
        office.setOfficeId(officeId);
        try {
            Office updatedOfficeInfo = officeDao.updateOfficeById(office);
            return updatedOfficeInfo;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "There is no office with this ID. Please try again, or contact your system administrator." + e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Scientfic Postgres goes boink " + e);
        }
    }
}
