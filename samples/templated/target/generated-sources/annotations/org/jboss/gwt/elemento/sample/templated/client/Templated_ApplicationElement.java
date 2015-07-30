package org.jboss.gwt.elemento.sample.templated.client;

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
final class Templated_ApplicationElement extends ApplicationElement {

    static interface InnerHtml extends SafeHtmlTemplates {
        @Template("<header class=\"header\">  <h1>todos</h1>  <input data-element=\"newTodo\" class=\"new-todo\" placeholder=\"What needs to be done?\" autofocus> </header> <section data-element=\"main\" class=\"main\">  <input data-element=\"toggleAll\" class=\"toggle-all\" id=\"toggle-all\" type=\"checkbox\">  <label for=\"toggle-all\">Mark all as complete</label>  <ul data-element=\"list\" class=\"todo-list\">   <li data-element=\"item\">    <div class=\"view\">     <input data-element=\"toggle\" class=\"toggle\" type=\"checkbox\" checked>     <label data-element=\"label\">Taste JavaScript</label>     <button data-element=\"destroy\" class=\"destroy\"></button>    </div> <input data-element=\"input\" class=\"edit\" value=\"Create a TodoMVC template\"> </li>   <li class=\"completed\">    <div class=\"view\">     <input class=\"toggle\" type=\"checkbox\">     <label>Buy a unicorn</label>     <button class=\"destroy\"></button>    </div> <input class=\"edit\" value=\"Rule the web\"> </li>  </ul> </section> <footer data-element=\"footer\" class=\"footer\">  <span data-element=\"count\" class=\"todo-count\"><strong>0</strong> item left</span>  <ul class=\"filters\">   <li> <a data-element=\"all\" href=\"#/\">All</a> </li>   <li> <a data-element=\"active\" href=\"#/active\">Active</a> </li>   <li> <a data-element=\"completed\" href=\"#/completed\">Completed</a> </li>  </ul>  <button data-element=\"clearCompleted\" class=\"clear-completed\">Clear completed</button> </footer>")
        SafeHtml value();
    }

    private final static InnerHtml INNER_HTML = GWT.create(InnerHtml.class);
    private final org.jboss.gwt.elemento.sample.common.TodoItemRepository repository;
    private final org.jboss.gwt.elemento.sample.common.TodoMessages messages;
    private final Element templated_applicationelement_root_element;

    Templated_ApplicationElement(org.jboss.gwt.elemento.sample.common.TodoItemRepository repository, org.jboss.gwt.elemento.sample.common.TodoMessages messages) {
        this.repository = repository;
        this.messages = messages;

        this.templated_applicationelement_root_element = Browser.getDocument().createElement("section");
        this.templated_applicationelement_root_element.setAttribute("class", "todoapp");
        this.templated_applicationelement_root_element.setInnerHTML(INNER_HTML.value().asString());

        if (this.newTodo == null) {
            this.newTodo = TemplateUtil.<elemental.html.InputElement>resolveElementAs(templated_applicationelement_root_element, "newTodo");
        } else {
            TemplateUtil.replaceElement(templated_applicationelement_root_element, "newTodo", newTodo);
        }
        if (this.main == null) {
            this.main = TemplateUtil.resolveElement(templated_applicationelement_root_element, "main");
        } else {
            TemplateUtil.replaceElement(templated_applicationelement_root_element, "main", main);
        }
        if (this.toggleAll == null) {
            this.toggleAll = TemplateUtil.<elemental.html.InputElement>resolveElementAs(templated_applicationelement_root_element, "toggleAll");
        } else {
            TemplateUtil.replaceElement(templated_applicationelement_root_element, "toggleAll", toggleAll);
        }
        if (this.list == null) {
            this.list = TemplateUtil.resolveElement(templated_applicationelement_root_element, "list");
        } else {
            TemplateUtil.replaceElement(templated_applicationelement_root_element, "list", list);
        }
        if (this.footer == null) {
            this.footer = TemplateUtil.resolveElement(templated_applicationelement_root_element, "footer");
        } else {
            TemplateUtil.replaceElement(templated_applicationelement_root_element, "footer", footer);
        }
        if (this.count == null) {
            this.count = TemplateUtil.resolveElement(templated_applicationelement_root_element, "count");
        } else {
            TemplateUtil.replaceElement(templated_applicationelement_root_element, "count", count);
        }
        if (this.filterAll == null) {
            this.filterAll = TemplateUtil.resolveElement(templated_applicationelement_root_element, "all");
        } else {
            TemplateUtil.replaceElement(templated_applicationelement_root_element, "all", filterAll);
        }
        if (this.filterActive == null) {
            this.filterActive = TemplateUtil.resolveElement(templated_applicationelement_root_element, "active");
        } else {
            TemplateUtil.replaceElement(templated_applicationelement_root_element, "active", filterActive);
        }
        if (this.filterCompleted == null) {
            this.filterCompleted = TemplateUtil.resolveElement(templated_applicationelement_root_element, "completed");
        } else {
            TemplateUtil.replaceElement(templated_applicationelement_root_element, "completed", filterCompleted);
        }
        if (this.clearCompleted == null) {
            this.clearCompleted = TemplateUtil.<elemental.html.ButtonElement>resolveElementAs(templated_applicationelement_root_element, "clearCompleted");
        } else {
            TemplateUtil.replaceElement(templated_applicationelement_root_element, "clearCompleted", clearCompleted);
        }
        TemplateUtil.registerEventHandler(templated_applicationelement_root_element, "newTodo", org.jboss.gwt.elemento.core.EventType.keydown, event -> newTodo((elemental.events.KeyboardEvent) event));
        TemplateUtil.registerEventHandler(templated_applicationelement_root_element, "toggleAll", org.jboss.gwt.elemento.core.EventType.change, event -> toggleAll());
        TemplateUtil.registerEventHandler(templated_applicationelement_root_element, "clearCompleted", org.jboss.gwt.elemento.core.EventType.click, event -> clearCompleted());
        init();
    }

    @Override
    public Element asElement() {
        return templated_applicationelement_root_element;
    }

    @Override
    org.jboss.gwt.elemento.sample.common.TodoItemRepository repository() {
        return repository;
    }

    @Override
    org.jboss.gwt.elemento.sample.common.TodoMessages messages() {
        return messages;
    }
}
