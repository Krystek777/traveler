package com.opitz.controller;


import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping("/all")
    public @ResponseBody
    ResponseEntity<List<Claim>> getClaims() {
        try {
            return new ResponseEntity<>(claimService.getClaims(), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @GetMapping("/find/{id}")
    public @ResponseBody
    ResponseEntity<Claim> findClaim(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(claimService.findClaim(id), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public @ResponseStatus
    HttpStatus saveClaim(@RequestBody Claim claim) {
        try {
            claimService.saveClaim(claim);
            return HttpStatus.OK;
        } catch (Exception ex) {
            ex.printStackTrace();
            return HttpStatus.NOT_ACCEPTABLE;
        }

    }

    @PostMapping("/delete")
    public @ResponseStatus
    HttpStatus deleteClaim(@RequestBody Claim claim) {
        try {
            claimService.remove(claim);
            return HttpStatus.OK;
        } catch (Exception ex) {
            ex.printStackTrace();
            return HttpStatus.NOT_FOUND;
        }

    }

    @PutMapping("approve/{id}")
    public @ResponseStatus
    HttpStatus approveClaim(@PathVariable Long id) {
        try {
            claimService.setStatus(id, ClaimStatus.APPROVED);
            return HttpStatus.OK;
        } catch (Exception ex) {
            ex.printStackTrace();
            return HttpStatus.NOT_FOUND;
        }

    }

    @PutMapping("reject/{id}")
    public @ResponseStatus
    HttpStatus rejectClaim(@PathVariable Long id) {
        try {
            claimService.setStatus(id, ClaimStatus.REJECTED);
            return HttpStatus.OK;
        } catch (Exception ex) {
            ex.printStackTrace();
            return HttpStatus.NOT_FOUND;
        }

    }


}
