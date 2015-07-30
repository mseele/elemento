package org.jboss.gwt.elemento.sample.gin.client;

import com.google.inject.Provider;

import javax.inject.Inject;
import javax.annotation.Generated;

/*
* WARNING! This class is generated. Do not modify.
*/
@Generated("org.jboss.gwt.elemento.processor.TemplatedProviderProcessor")
public class Templated_ApplicationElement_Provider implements Provider<ApplicationElement> {

    private final org.jboss.gwt.elemento.sample.common.TodoItemRepository repository;
    private final org.jboss.gwt.elemento.sample.common.TodoMessages messages;
    private final com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.TodoItemElement> itemElement;

    @Inject
    public Templated_ApplicationElement_Provider(org.jboss.gwt.elemento.sample.common.TodoItemRepository repository, org.jboss.gwt.elemento.sample.common.TodoMessages messages, com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.TodoItemElement> itemElement) {
        this.repository = repository;
        this.messages = messages;
        this.itemElement = itemElement;
    }

    @Override
    public ApplicationElement get() {
        return ApplicationElement.create(repository, messages, itemElement);
    }
}
