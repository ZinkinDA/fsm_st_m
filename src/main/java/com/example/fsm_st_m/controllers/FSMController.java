package com.example.fsm_st_m.controllers;

import com.example.fsm_st_m.Service.FSMServiceImpl;
import com.example.fsm_st_m.model.Event;
import com.example.fsm_st_m.model.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/controller")
public class FSMController {
    private final FSMServiceImpl fsmService;

    @Autowired
    public FSMController(FSMServiceImpl fsmService) {
        this.fsmService = fsmService;
    }
    @GetMapping("/")
    public ResponseEntity<?> getFsm(){
        return ResponseEntity.ok(fsmService.getFsm());
    }

    @PostMapping("/modeHot")
    public ResponseEntity<?> setModeHot(){
        try {
            fsmService.setMode(Mode.Hot);
            return ResponseEntity.ok("Mode установлен!");
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/modeCold")
    public ResponseEntity<?> setModeCold(){
        try {
            fsmService.setMode(Mode.Cold);
            return ResponseEntity.ok("Mode установлен!");
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/turnOn")
    public ResponseEntity<?> turnOn(){
        try {
            fsmService.letsGO(Event.TurnOn);
            return ResponseEntity.ok("Машина включена!");
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/turnOff")
    public ResponseEntity<?> turnOff(){
        try {
            fsmService.letsGO(Event.TurnOff);
            return ResponseEntity.ok("Машина выключена!");
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/go")
    public ResponseEntity<?> go(){
        try {
            fsmService.letsGO(Event.GO_ERASING);
            return ResponseEntity.ok().body("Стирка начата!\n Ожидайте!");
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
