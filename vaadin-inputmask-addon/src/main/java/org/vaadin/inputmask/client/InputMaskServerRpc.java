package org.vaadin.inputmask.client;

import com.vaadin.shared.communication.ServerRpc;

public interface InputMaskServerRpc extends ServerRpc {

    public void onComplete();
    public void onIncomplete();
}
