package com.example.fsm_st_m.Service;

import com.example.fsm_st_m.model.Event;
import com.example.fsm_st_m.FSM;
import com.example.fsm_st_m.model.Mode;
import org.springframework.stereotype.Service;

@Service
public class FSMService implements FSMServiceImpl{

    private final FSM fsm;

    public FSMService() {
        this.fsm = FSM.getFSM();
    }

    @Override
    public FSM getFsm() {
        return fsm;
    }

    @Override
    public void setMode(Mode mode) {
        fsm.setMode(mode);
    }

    @Override
    public void letsGO(Event event) {
        fsm.startWashing(event);
    }
}
