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
    private List<State> statesDeath;
    public ControllerTransitions() {
        states = new ArrayList<>();
        alphabet = new ArrayList<>();
        statesFinals = new ArrayList<>();
        statesAlcanced = new ArrayList<>();
        statesDeath = new ArrayList<>();
    }
    public boolean transition(String[] word) {
        initStateInitial();
        initStatesFinals();
        State currentState = stateInitial;
        statesAlcanced.add(currentState);
        states.remove(currentState);

        for (int i = 0; i < word.length; i++) {
            if (alphabet.contains(word[i])) {
                    if (currentState.getTransition().get(word[i]) != null) {                       
                        currentState = currentState.getTransition().get(word[i]);
                        states.remove(currentState);
                        if(!statesAlcanced.contains(currentState)){
                            System.out.println("current "+currentState);
                            statesAlcanced.add(currentState);
                        }
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
    public List<State> getStatesAlcanded(){
        return statesAlcanced;
    }
    public List<State> getDeathStates(){
        return statesDeath;
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

}
