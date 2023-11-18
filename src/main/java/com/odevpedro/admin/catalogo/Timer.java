package com.odevpedro.admin.catalogo;

import com.odevpedro.admin.catalogo.enums.PomodoroType;
import com.odevpedro.admin.catalogo.enums.TimerState;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Timer {
        private PomodoroType totalTime;
        private Integer remaningTime;
        private TimerState status;

        //to countTime
        private ScheduledExecutorService executorService;


        public Timer(PomodoroType totalTime){
            this.totalTime = totalTime;
            this.remaningTime = totalTime.ordinal();
            this.status = TimerState.PAUSED;

        }

    public void start() {
            if (status == TimerState.STOPPED || status == TimerState.PAUSED){
                status = TimerState.COUTING;
                executorService = Executors.newSingleThreadScheduledExecutor();
                executorService.scheduleAtFixedRate(this::tick, 0, 1)
            }
        //start count
    }
    public void  pause(){
            if (status == TimerState.ACTIVE){
                status = TimerState.PAUSED;
                executorService.shutdown();
            }
        // pauses the clock
    }

    public void reset(){
            status = TimerState.STOPPED;
            remaningTime = PomodoroType.MEDIUM.getDurationMinutes();
            if (executorService != null){
                executorService.shutdown();
            }
    }

    public void  longPause(){
        // long pause
    }


    public void  finish(){
        // just finish the pomodoro
    }
}