package com.example.fsm_als.Service;

import com.example.fsm_als.FSM;
import com.example.fsm_als.model.Event;
import com.example.fsm_als.model.Mode;

public interface FSMServiceImpl {

    FSM getFsm();

    void setMode(Mode mode);

    void letsGO(Event event);
}
