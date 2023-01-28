package com.example.fsm_st_m.Service;

import com.example.fsm_st_m.model.Event;
import com.example.fsm_st_m.FSM;
import com.example.fsm_st_m.model.Mode;

public interface FSMServiceImpl {

    FSM getFsm();

    void setMode(Mode mode);

    void letsGO(Event event);
}
