package com.stackbill.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stackbill.businesslogic.BugService;
import com.stackbill.entitys.BugEntity;

import java.util.List;

@RestController
@RequestMapping("/api/bug")  // Base URI for Pojo2 (Bug) entity
@CrossOrigin(origins = "*")
public class BugControl {

    @Autowired
    private BugService servicebug;

    // Endpoint to fetch all bugs
    @GetMapping
    public ResponseEntity<List<BugEntity>> getAllbugs() {
        List<BugEntity> bugs = servicebug.getAllPojo2s();
        return new ResponseEntity<>(bugs, HttpStatus.OK);
    }

    // Endpoint to fetch bug by ID
    @GetMapping("/{id}")
    public ResponseEntity<BugEntity> getBugById(@PathVariable int id) {
        BugEntity bug = servicebug.getPojo2ById(id).orElse(null);
        if (bug != null) {
            return new ResponseEntity<>(bug, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to create a new bug
    @PostMapping
    public ResponseEntity<BugEntity> createBug(@RequestBody BugEntity bug) {
        BugEntity createdBug = servicebug.createPojo2(bug);
        return new ResponseEntity<>(createdBug, HttpStatus.CREATED);
    }

    // Endpoint to update an existing bug
    @PutMapping("/{id}")
    public ResponseEntity<BugEntity> updateBug(@PathVariable int id, @RequestBody BugEntity bugDetails) {
        BugEntity updatedBug = servicebug.updateBug(id, bugDetails);
        if (updatedBug != null) {
            return new ResponseEntity<>(updatedBug, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a bug by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBug(@PathVariable int id) {
        servicebug.deletePojo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



