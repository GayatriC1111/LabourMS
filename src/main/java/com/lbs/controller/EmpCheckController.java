package com.lbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lbs.entities.EmpCheckInCheckOut;
import com.lbs.services.EmpCheckService;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class EmpCheckController {

    @Autowired
    private EmpCheckService empCheckService;

      
    
    @PostMapping("/checkin/{id}")
    public ResponseEntity<EmpCheckInCheckOut> checkIn(@PathVariable Long id) {
        EmpCheckInCheckOut checkInRecord = empCheckService.checkIn(id);
        return ResponseEntity.ok(checkInRecord);
    }

    @PostMapping("/checkout/{employeeId}")
    public ResponseEntity<String> checkOut(@PathVariable Long employeeId) {
        EmpCheckInCheckOut checkOutRecord = empCheckService.checkOut(employeeId);
        String totalHours = checkOutRecord.getTotalHoursWorked(); 
        return ResponseEntity.ok("Employee checked out. Total hours worked: " + totalHours);
    }

    @GetMapping("/records")
    public ResponseEntity<List<EmpCheckInCheckOut>> getAllRecords() {
        List<EmpCheckInCheckOut> records = empCheckService.getAllRecords();
        return ResponseEntity.ok(records);
    }

}
