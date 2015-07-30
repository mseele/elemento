package org.jboss.gwt.elemento.sample.common;

public class TodoMessages_ implements org.jboss.gwt.elemento.sample.common.TodoMessages {
  
  public com.google.gwt.safehtml.shared.SafeHtml items(int arg0) {
    com.google.gwt.safehtml.shared.SafeHtml returnVal = null;
    int arg0_form = new com.google.gwt.i18n.client.impl.plurals.DefaultRule().select(arg0);
    switch (arg0) {
      case 1:  // =1
        returnVal = new com.google.gwt.safehtml.shared.SafeHtmlBuilder().appendHtmlConstant("<strong>").append(arg0).appendHtmlConstant("</strong> item left").toSafeHtml();
        break;
    }
    if (returnVal != null) {
      return returnVal;
    }
    return new com.google.gwt.safehtml.shared.SafeHtmlBuilder().appendHtmlConstant("<strong>").append(arg0).appendHtmlConstant("</strong> items left").toSafeHtml();
  }
}
