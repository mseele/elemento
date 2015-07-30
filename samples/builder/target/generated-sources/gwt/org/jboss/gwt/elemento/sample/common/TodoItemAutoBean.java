package org.jboss.gwt.elemento.sample.common;

public class TodoItemAutoBean extends com.google.web.bindery.autobean.shared.impl.AbstractAutoBean<org.jboss.gwt.elemento.sample.common.TodoItem> {
  private final org.jboss.gwt.elemento.sample.common.TodoItem shim = new org.jboss.gwt.elemento.sample.common.TodoItem() {
    public boolean isCompleted()  {
      boolean toReturn = TodoItemAutoBean.this.getWrapped().isCompleted();
      return toReturn;
    }
    public java.lang.String getId()  {
      java.lang.String toReturn = TodoItemAutoBean.this.getWrapped().getId();
      return toReturn;
    }
    public java.lang.String getText()  {
      java.lang.String toReturn = TodoItemAutoBean.this.getWrapped().getText();
      return toReturn;
    }
    public void setCompleted(boolean completed)  {
      TodoItemAutoBean.this.getWrapped().setCompleted(completed);
      TodoItemAutoBean.this.set("setCompleted", completed);
    }
    public void setId(java.lang.String id)  {
      TodoItemAutoBean.this.getWrapped().setId(id);
      TodoItemAutoBean.this.set("setId", id);
    }
    public void setText(java.lang.String text)  {
      TodoItemAutoBean.this.getWrapped().setText(text);
      TodoItemAutoBean.this.set("setText", text);
    }
    @Override public boolean equals(Object o) {
      return this == o || getWrapped().equals(o);
    }
    @Override public int hashCode() {
      return getWrapped().hashCode();
    }
    @Override public String toString() {
      return getWrapped().toString();
    }
  };
  { com.google.gwt.core.client.impl.WeakMapping.set(shim, com.google.web.bindery.autobean.shared.AutoBean.class.getName(), this); }
  public TodoItemAutoBean(com.google.web.bindery.autobean.shared.AutoBeanFactory factory) {super(factory);}
  public TodoItemAutoBean(com.google.web.bindery.autobean.shared.AutoBeanFactory factory, org.jboss.gwt.elemento.sample.common.TodoItem wrapped) {
    super(wrapped, factory);
  }
  public org.jboss.gwt.elemento.sample.common.TodoItem as() {return shim;}
  public Class<org.jboss.gwt.elemento.sample.common.TodoItem> getType() {return org.jboss.gwt.elemento.sample.common.TodoItem.class;}
  @Override protected org.jboss.gwt.elemento.sample.common.TodoItem createSimplePeer() {
    return new org.jboss.gwt.elemento.sample.common.TodoItem() {
      private final com.google.web.bindery.autobean.shared.Splittable data = org.jboss.gwt.elemento.sample.common.TodoItemAutoBean.this.data;
      public boolean isCompleted()  {
        java.lang.Boolean toReturn = TodoItemAutoBean.this.getOrReify("completed");
        return toReturn == null ? false : toReturn;
      }
      public java.lang.String getId()  {
        return (java.lang.String) TodoItemAutoBean.this.getOrReify("id");
      }
      public java.lang.String getText()  {
        return (java.lang.String) TodoItemAutoBean.this.getOrReify("text");
      }
      public void setCompleted(boolean completed)  {
        TodoItemAutoBean.this.setProperty("completed", completed);
      }
      public void setId(java.lang.String id)  {
        TodoItemAutoBean.this.setProperty("id", id);
      }
      public void setText(java.lang.String text)  {
        TodoItemAutoBean.this.setProperty("text", text);
      }
    };
  }
  @Override protected void traverseProperties(com.google.web.bindery.autobean.shared.AutoBeanVisitor visitor, com.google.web.bindery.autobean.shared.impl.AbstractAutoBean.OneShotContext ctx) {
    com.google.web.bindery.autobean.shared.impl.AbstractAutoBean bean;
    Object value;
    com.google.web.bindery.autobean.gwt.client.impl.ClientPropertyContext propertyContext;
    org.jboss.gwt.elemento.sample.common.TodoItem as = as();
    value = as.isCompleted();
    propertyContext = new com.google.web.bindery.autobean.gwt.client.impl.ClientPropertyContext(
      as,
      com.google.web.bindery.autobean.gwt.client.impl.ClientPropertyContext.Setter.beanSetter(TodoItemAutoBean.this, "completed"),
      boolean.class
    );
    if (visitor.visitValueProperty("completed", value, propertyContext)) {
    }
    visitor.endVisitValueProperty("completed", value, propertyContext);
    value = as.getId();
    propertyContext = new com.google.web.bindery.autobean.gwt.client.impl.ClientPropertyContext(
      as,
      com.google.web.bindery.autobean.gwt.client.impl.ClientPropertyContext.Setter.beanSetter(TodoItemAutoBean.this, "id"),
      java.lang.String.class
    );
    if (visitor.visitValueProperty("id", value, propertyContext)) {
    }
    visitor.endVisitValueProperty("id", value, propertyContext);
    value = as.getText();
    propertyContext = new com.google.web.bindery.autobean.gwt.client.impl.ClientPropertyContext(
      as,
      com.google.web.bindery.autobean.gwt.client.impl.ClientPropertyContext.Setter.beanSetter(TodoItemAutoBean.this, "text"),
      java.lang.String.class
    );
    if (visitor.visitValueProperty("text", value, propertyContext)) {
    }
    visitor.endVisitValueProperty("text", value, propertyContext);
  }
}
