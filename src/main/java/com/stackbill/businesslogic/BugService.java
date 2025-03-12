package com.stackbill.businesslogic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackbill.entitys.BugEntity;
import com.stackbill.repositories.BugRepository;

@Service
public class BugService {
	@Autowired
	private BugRepository daobug;
	

    public List<BugEntity> getAllPojo2s() {
        return daobug.findAll();
    }
    public Optional<BugEntity> getPojo2ById(int id) {
        return daobug.findById(id);
    }

    public BugEntity createPojo2(BugEntity pojo) {
        return daobug.save(pojo);
    }
	
    public BugEntity updateBug(int id, BugEntity bugDetails) {
        BugEntity bug = daobug.findById(id).orElseThrow(() -> new RuntimeException("Bug not found"));
        bug.setDescription(bugDetails.getDescription());
        bug.setStatus(bugDetails.getStatus());
        // Update other properties as needed
        return daobug.save(bug);
    }
   
    public void deletePojo(int id) {
        daobug.deleteById(id);
    }
}
