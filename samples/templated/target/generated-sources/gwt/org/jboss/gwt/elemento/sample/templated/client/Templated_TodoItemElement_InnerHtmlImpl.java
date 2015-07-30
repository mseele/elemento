package org.jboss.gwt.elemento.sample.templated.client;

public class Templated_TodoItemElement_InnerHtmlImpl implements org.jboss.gwt.elemento.sample.templated.client.Templated_TodoItemElement.InnerHtml {
  
  public com.google.gwt.safehtml.shared.SafeHtml value() {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<div class=\"view\">  <input data-element=\"toggle\" class=\"toggle\" type=\"checkbox\" checked>  <label data-element=\"label\">Taste JavaScript</label>  <button data-element=\"destroy\" class=\"destroy\"></button> </div> <input data-element=\"input\" class=\"edit\" value=\"Create a TodoMVC template\">");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
