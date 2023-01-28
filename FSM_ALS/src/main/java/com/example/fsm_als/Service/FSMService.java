package com.example.fsm_als.Service;

import com.example.fsm_als.FSM;
import com.example.fsm_als.model.Event;
import com.example.fsm_als.model.Mode;
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
