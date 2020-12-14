/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import models.State;

/**
 *
 * @author gabriel
 */
public class ControllerTransitions {
    private List<State> states;
    private List<String> alphabet;
    private State stateInitial;
    private List<State> statesFinals;
    private List<State> statesAlcanced;
    private List<State> statesDead;
    private List<State> statesUnreachable;
    public ControllerTransitions() {
        states = new ArrayList<>();
        alphabet = new ArrayList<>();
        statesFinals = new ArrayList<>();
        statesAlcanced = new ArrayList<>();
        statesDead = new ArrayList<>();
        statesUnreachable = new ArrayList<>();
        
        
    }
    public boolean transition(String[] word) {
        initStateInitial();
        initStatesFinals();
        
        State currentState = stateInitial;
        statesAlcanced.add(currentState);
        
        
        for (int i = 0; i < word.length; i++) {
            if (alphabet.contains(word[i])) {
                    if (currentState.getTransition().get(word[i]) != null) {                       
                        currentState = currentState.getTransition().get(word[i]);
                       
                    } else {
                        return false;
                    }
            } else {
                return false;
            }
        }
        if (statesFinals.contains(currentState)) {
            return true;
        } else {
            return false;
        }

    }
   
    public void statesAlcanced(){
        initStateInitial();
        initStatesFinals();
        initUnreachable();
        statesUnreachable.remove(stateInitial);
        for(State state : states){
            for(String s : alphabet){
                if(state.getTransition().get(s) != null){
                    State nextState = state.getTransition().get(s);
                    if(!statesAlcanced.contains(nextState)){
                        statesAlcanced.add(nextState);
                        statesUnreachable.remove(nextState);
                    }
                }
            }
        }
    }
    
    public void statesDead(){
        initDead();
        statesDead.remove(stateInitial);
        for(State state : states){
            
            for(String s : alphabet){
                
                if(state.getTransition().get(s) != null && state.getTransition().get(s) != state ){
                    statesDead.remove(state);
                    
                }
            }
        }
        for(State state: statesUnreachable){
            statesDead.remove(state);
        }
    }
    
    
    private void initUnreachable(){
        for(State state : states){
            statesUnreachable.add(state);
        }
    }
    private void initDead(){
        for(State state : states){
            statesDead.add(state);
        }
    }

    private void initStateInitial() {
        for (State state : states) {
            if (state.isStart()) {
                stateInitial = state;
            }
        }
    }

    private void initStatesFinals() {
        for (State state : states) {
            if (state.isEnd()) {
                statesFinals.add(state);
            }
        }
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    public List<String> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(List<String> alphabet) {
        this.alphabet = alphabet;
    }

    public State getStateInitial() {
        return stateInitial;
    }

    public void setStateInitial(State stateInitial) {
        this.stateInitial = stateInitial;
    }

    public List<State> getStatesFinals() {
        return statesFinals;
    }

    public void setStatesFinals(List<State> statesFinals) {
        this.statesFinals = statesFinals;
    }

    public List<State> getStatesAlcanced() {
        return statesAlcanced;
    }

    public void setStatesAlcanced(List<State> statesAlcanced) {
        this.statesAlcanced = statesAlcanced;
    }

    public List<State> getStatesDead() {
        return statesDead;
    }

    public void setStatesDead(List<State> statesDead) {
        this.statesDead = statesDead;
    }

    public List<State> getStatesUnreachable() {
        return statesUnreachable;
    }

    public void setStatesUnreachable(List<State> statesUnreachable) {
        this.statesUnreachable = statesUnreachable;
    }

    

}
