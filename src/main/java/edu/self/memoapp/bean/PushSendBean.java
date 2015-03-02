/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.self.memoapp.bean;

import edu.self.memoapp.ejb.PushSendFacade;
import edu.self.memoapp.entity.PushSend;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author user
 */
@Named(value = "pushSendBean")
@ViewScoped
public class PushSendBean implements Serializable {

    @Setter @Getter
    private String employeeId;
    
    @Setter @Getter
    private String message;
    
    @Setter @Getter
    private List<PushSend> pushSendList;
    
    @Inject
    private PushSendFacade pushSendFacade;
    
    @PostConstruct
    public void init() {
        findAllPushMessage();
    }
    
    /**
     * Creates a new instance of PushSendBean
     */
    public PushSendBean() {
    }
    
    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void save() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Welcome " + employeeId));
        
        PushSend pushSend = new PushSend();
        pushSend.setEmployeeId(employeeId);
        pushSend.setMessage(message);
        pushSendFacade.create(pushSend);
        findAllPushMessage();
    }
    
    private void findAllPushMessage() {
        pushSendList = pushSendFacade.findAll();
    }
}
