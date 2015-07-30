package org.jboss.gwt.elemento.sample.templated.client;

public class Templated_ApplicationElement_InnerHtmlImpl implements org.jboss.gwt.elemento.sample.templated.client.Templated_ApplicationElement.InnerHtml {
  
  public com.google.gwt.safehtml.shared.SafeHtml value() {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<header class=\"header\">  <h1>todos</h1>  <input data-element=\"newTodo\" class=\"new-todo\" placeholder=\"What needs to be done?\" autofocus> </header> <section data-element=\"main\" class=\"main\">  <input data-element=\"toggleAll\" class=\"toggle-all\" id=\"toggle-all\" type=\"checkbox\">  <label for=\"toggle-all\">Mark all as complete</label>  <ul data-element=\"list\" class=\"todo-list\">   <li data-element=\"item\">    <div class=\"view\">     <input data-element=\"toggle\" class=\"toggle\" type=\"checkbox\" checked>     <label data-element=\"label\">Taste JavaScript</label>     <button data-element=\"destroy\" class=\"destroy\"></button>    </div> <input data-element=\"input\" class=\"edit\" value=\"Create a TodoMVC template\"> </li>   <li class=\"completed\">    <div class=\"view\">     <input class=\"toggle\" type=\"checkbox\">     <label>Buy a unicorn</label>     <button class=\"destroy\"></button>    </div> <input class=\"edit\" value=\"Rule the web\"> </li>  </ul> </section> <footer data-element=\"footer\" class=\"footer\">  <span data-element=\"count\" class=\"todo-count\"><strong>0</strong> item left</span>  <ul class=\"filters\">   <li> <a data-element=\"all\" href=\"#/\">All</a> </li>   <li> <a data-element=\"active\" href=\"#/active\">Active</a> </li>   <li> <a data-element=\"completed\" href=\"#/completed\">Completed</a> </li>  </ul>  <button data-element=\"clearCompleted\" class=\"clear-completed\">Clear completed</button> </footer>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
