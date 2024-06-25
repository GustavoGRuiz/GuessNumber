package scaffolding.demo.controllers;


import org.apache.coyote.Response;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import scaffolding.demo.dto.DummyDto;
import scaffolding.demo.models.Dummy;
import scaffolding.demo.services.DummyService;

import java.util.List;

@RestController
@RequestMapping("/dummy")
public class DummyController {

    @Autowired
    private DummyService dummyService;

    @GetMapping("/dummy")
    public ResponseEntity<DummyDto> getDummyList(){
        List<Dummy> dummyList = dummyService.getDummyList();
        return null;
    }
    @GetMapping("/dummy/{id}")
    public ResponseEntity<DummyDto> getDummyList(@PathVariable Long id){
        Dummy dummy = dummyService.getDummy(id);
        return null;
    }
    @PostMapping("/dummy")
    public ResponseEntity<DummyDto> createDummy(DummyDto dummyDto){
        Dummy dummy = dummyService.createDummy(null);
        return null;
    }
    @PutMapping("/dummy")
    public ResponseEntity<DummyDto> updateDummy(DummyDto dummyDto){
        Dummy dummy = dummyService.updateDummy(null);
        return null;
    }
    @DeleteMapping("/dummy")
    public ResponseEntity<Void> deleteDummy(DummyDto dummyDto){
        dummyService.deleteDummy(null);
        return null;
    }
}
