package org.jboss.gwt.elemento.sample.gin.client;

import com.google.inject.Provider;

import javax.inject.Inject;
import javax.annotation.Generated;

/*
* WARNING! This class is generated. Do not modify.
*/
@Generated("org.jboss.gwt.elemento.processor.TemplatedProviderProcessor")
public class Templated_TodoItemElement_Provider implements Provider<TodoItemElement> {

    private final com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.ApplicationElement> application;
    private final org.jboss.gwt.elemento.sample.common.TodoItemRepository repository;

    @Inject
    public Templated_TodoItemElement_Provider(com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.ApplicationElement> application, org.jboss.gwt.elemento.sample.common.TodoItemRepository repository) {
        this.application = application;
        this.repository = repository;
    }

    @Override
    public TodoItemElement get() {
        return TodoItemElement.create(application, repository);
    }
}
