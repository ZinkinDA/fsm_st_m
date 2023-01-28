package com.example.fsm_st_m;

import com.example.fsm_st_m.model.Event;
import com.example.fsm_st_m.model.Mode;
import com.example.fsm_st_m.model.Statement;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class FSM {

    private static FSM fsm;

    private Statement statement = Statement.OFF;

    private Boolean isWater = false;

    private Boolean isHeating = false;

    private Mode mode;


    public FSM() {
    }

    public Boolean getWater() {
        return isWater;
    }

    public void setWater(Boolean water) {
        isWater = water;
    }

    public Statement getStatement() {
        return statement;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        if(statement == Statement.READY) {
            this.mode = mode;
        } else {
            throw new RuntimeException("FSM is not READY!");
        }
    }

    public Boolean getHeating() {
        return isHeating;
    }

    public void setHeating(Boolean heating) {
        this.isHeating = heating;
    }

    @SneakyThrows
    public void startWashing(Event event){
        /** Начало **/

            switch (event){

                case TurnOn :
                    if(statement == Statement.OFF){
                        statement = Statement.ON;
                        System.out.println("ON");
                        Thread.sleep(3000);
                        statement = Statement.READY;
                    } else {
                        throw new RuntimeException("FSM ERROR!");
                    }
                    break;
                case TurnOff:
                    if(statement == Statement.READY){
                        Thread.sleep(2000);
                        statement = Statement.OFF;
                        System.out.println("OFF");
                    } else {
                        throw new RuntimeException("FSM ERROR!");
                    }
                    break;
                case GO_ERASING:
                    if(mode == null){
                        throw new RuntimeException("FSM is not READY!");
                    }
                    if(statement == Statement.READY) {
                        statement = Statement.ERASING;
                        System.out.println("Water is being poured!");
                        Thread.sleep(2000);
                        isWater = true;
                        if (mode == Mode.Hot) {
                            System.out.println("Heating is on!");
                            isHeating = true;
                            Thread.sleep(3000);
                            System.out.println("The water is heated");
                            isHeating = false;

                        }
                        System.out.println("LAUNDRY!\n" +
                                "Please wait");
                        Thread.sleep(5000);
                        System.out.println("Pumping out water");
                        Thread.sleep(2000);
                        isWater = false;
                    } else {
                        throw new RuntimeException("FSM is not READY!");
                    }
                case GO_SQUEEZE:
                    if(statement == Statement.ERASING) {
                        System.out.println("SPIN!");
                        statement = Statement.SQUEEZE;
                        Thread.sleep(4000);
                        System.out.println("READY!");
                        statement = Statement.READY;
                    } else {
                        throw new RuntimeException("FSM is not READY!");
                    }
                    break;
            }
    }

    public static FSM getFSM(){
        if(fsm == null){
            fsm = new FSM();
            return fsm;
        }
        return fsm;
    }

}
