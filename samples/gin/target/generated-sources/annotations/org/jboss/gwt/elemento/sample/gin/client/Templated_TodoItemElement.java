package org.jboss.gwt.elemento.sample.gin.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import elemental.client.Browser;
import elemental.dom.Element;
import org.jboss.gwt.elemento.core.TemplateUtil;

import javax.annotation.Generated;

/*
* WARNING! This class is generated. Do not modify.
*/
@Generated("org.jboss.gwt.elemento.processor.TemplatedProcessor")
final class Templated_TodoItemElement extends TodoItemElement {

    static interface InnerHtml extends SafeHtmlTemplates {
        @Template("<div class=\"view\">  <input data-element=\"toggle\" class=\"toggle\" type=\"checkbox\" checked>  <label data-element=\"label\">Taste JavaScript</label>  <button data-element=\"destroy\" class=\"destroy\"></button> </div> <input data-element=\"input\" class=\"edit\" value=\"Create a TodoMVC template\">")
        SafeHtml value();
    }

    private final static InnerHtml INNER_HTML = GWT.create(InnerHtml.class);
    private final com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.ApplicationElement> application;
    private final org.jboss.gwt.elemento.sample.common.TodoItemRepository repository;
    private final Element templated_todoitemelement_root_element;

    Templated_TodoItemElement(com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.ApplicationElement> application, org.jboss.gwt.elemento.sample.common.TodoItemRepository repository) {
        this.application = application;
        this.repository = repository;

        this.templated_todoitemelement_root_element = Browser.getDocument().createElement("li");
        this.templated_todoitemelement_root_element.setInnerHTML(INNER_HTML.value().asString());

        if (this.toggle == null) {
            this.toggle = TemplateUtil.<elemental.html.InputElement>resolveElementAs(templated_todoitemelement_root_element, "toggle");
        } else {
            TemplateUtil.replaceElement(templated_todoitemelement_root_element, "toggle", toggle);
        }
        if (this.label == null) {
            this.label = TemplateUtil.resolveElement(templated_todoitemelement_root_element, "label");
        } else {
            TemplateUtil.replaceElement(templated_todoitemelement_root_element, "label", label);
        }
        if (this.input == null) {
            this.input = TemplateUtil.<elemental.html.InputElement>resolveElementAs(templated_todoitemelement_root_element, "input");
        } else {
            TemplateUtil.replaceElement(templated_todoitemelement_root_element, "input", input);
        }
        TemplateUtil.registerEventHandler(templated_todoitemelement_root_element, "toggle", org.jboss.gwt.elemento.core.EventType.change, event -> toggle());
        TemplateUtil.registerEventHandler(templated_todoitemelement_root_element, "label", org.jboss.gwt.elemento.core.EventType.dblclick, event -> edit());
        TemplateUtil.registerEventHandler(templated_todoitemelement_root_element, "destroy", org.jboss.gwt.elemento.core.EventType.click, event -> destroy());
        TemplateUtil.registerEventHandler(templated_todoitemelement_root_element, "input", org.jboss.gwt.elemento.core.EventType.keydown, event -> keyDown((elemental.events.KeyboardEvent) event));
        TemplateUtil.registerEventHandler(templated_todoitemelement_root_element, "input", org.jboss.gwt.elemento.core.EventType.blur, event -> blur());
    }

    @Override
    public Element asElement() {
        return templated_todoitemelement_root_element;
    }

    @Override
    com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.ApplicationElement> application() {
        return application;
    }

    @Override
    org.jboss.gwt.elemento.sample.common.TodoItemRepository repository() {
        return repository;
    }
}
