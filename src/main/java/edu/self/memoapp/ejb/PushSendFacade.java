/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.self.memoapp.ejb;

import edu.self.memoapp.entity.PushSend;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author user
 */
@Stateless
public class PushSendFacade extends AbstractFacade<PushSend> {
    @PersistenceContext(unitName = "edu.self_MemoApp_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PushSendFacade() {
        super(PushSend.class);
    }
    
}
