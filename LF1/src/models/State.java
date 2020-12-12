/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gabriel
 */
public class State {
    private static int id = 0;
    private String name;
    Map<String,State> transition;
    private boolean start;
    private boolean end;
    
    public State(){
        this.name = "q"+id;
        start = false;
        end = false;
        transition = new HashMap<>();
        id ++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public Map<String, State> getTransition() {
        return transition;
    }

    public void setTransition(Map<String, State> transition) {
        this.transition = transition;
    }

  
    
    
    
}
