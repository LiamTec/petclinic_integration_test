package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OwnerServiceTest {

    @Autowired
    private OwnerService ownerService;

    @Test
    void testCreateAndFindOwner() throws OwnerNotFoundException {
        Owner owner = new Owner("Carlos", "Perez", "Lima", "Av. Rosales", "132456754");
        Owner created = ownerService.create(owner);
        assertNotNull(created.getId());

        Owner found = ownerService.findById(created.getId());
        assertEquals("Carlos", found.getFirstName());
    }

    @Test
    void testFindByFirstName() {
        List<Owner> owners = ownerService.findByFirstName("Carlos");
        assertNotNull(owners);
    }


    @Test
    void testFindByCity() {
        List<Owner> owners = ownerService.findByCity("Madison");
        assertNotNull(owners);
    }

}