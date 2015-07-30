package org.jboss.gwt.elemento.sample.common;

public class BeanFactoryImpl extends com.google.web.bindery.autobean.gwt.client.impl.AbstractAutoBeanFactory implements org.jboss.gwt.elemento.sample.common.BeanFactory {
  @Override protected void initializeCreatorMap(com.google.web.bindery.autobean.gwt.client.impl.JsniCreatorMap map) {
    map.add(org.jboss.gwt.elemento.sample.common.TodoItem.class, getConstructors_org_jboss_gwt_elemento_sample_common_TodoItem());
  }
  private native com.google.gwt.core.client.JsArray<com.google.gwt.core.client.JavaScriptObject> getConstructors_org_jboss_gwt_elemento_sample_common_TodoItem() /*-{
    return [
      @org.jboss.gwt.elemento.sample.common.TodoItemAutoBean::new(Lcom/google/web/bindery/autobean/shared/AutoBeanFactory;),
      @org.jboss.gwt.elemento.sample.common.TodoItemAutoBean::new(Lcom/google/web/bindery/autobean/shared/AutoBeanFactory;Lorg/jboss/gwt/elemento/sample/common/TodoItem;)
    ];
  }-*/;
  @Override protected void initializeEnumMap() {
  }
  public com.google.web.bindery.autobean.shared.AutoBean todoItem() {
    return new org.jboss.gwt.elemento.sample.common.TodoItemAutoBean(BeanFactoryImpl.this);
  }
}
