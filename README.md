[![TC Build](https://ci.wildfly.org/app/rest/builds/buildType:(id:hal_Elemento)/statusIcon.svg)](https://ci.wildfly.org/viewType.html?buildTypeId=hal_Elemento&guest=1) ![GWT3/J2CL compatible](https://img.shields.io/badge/GWT3/J2CL-compatible-brightgreen.svg) [![License](https://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html) [![Chat on Gitter](https://badges.gitter.im/hal/elemento.svg)](https://gitter.im/hal/elemento)

# Elemento

Elemento simplifies working with GWT [Elemental2](https://github.com/google/elemental2). In a nutshell Elemento brings the following features to the table:

- Type safe [builders](#builder-api) and [event handlers](#event-handlers)
- [HTML templates](#html-templates) with support for expressions
- Easy integration with other libraries such as [Errai](#errai), [RxGWT](#rxgwt) or [Dagger and GIN](#dagger-and-gin)
- [Helper methods](#helper-methods) to safely append, insert & remove elements

**TOC**  
* [Get Started](#get-started)
* [Builder API](#builder-api)
  * [References](#references)
  * [Event Handlers](#event-handlers)
  * [Custom Elements](#custom-elements)
* [HTML Templates](#html-templates)
  * [Get Started](#get-started-1)
  * [Prepare HTML](#prepare-html)
  * [Template Class](#template-class)
  * [Data Elements](#data-elements)
  * [Dependencies](#dependencies)
  * [PostConstruct](#postconstruct)
  * [Expressions](#expressions)
* [Integrations](#integrations)
  * [Errai](#errai)
  * [RxGWT](#rxgwt)
  * [Dagger and GIN](#dagger-and-gin)
* [Helper Methods](#helper-methods)
* [J2CL / GWT3](#j2cl--gwt3)
* [Samples](#samples)
* [Contributing](#contributing)
* [Get Help](#get-help)

# Get Started

Elemento is available in [Maven Central](https://maven-badges.herokuapp.com/maven-central/org.jboss.gwt.elemento/elemento-parent). To use it add the following dependency to your POM:

```xml
<dependency>
    <groupId>org.jboss.gwt.elemento</groupId>
    <artifactId>elemento-core</artifactId>
    <version>HEAD-SNAPSHOT</version>
</dependency>
```
 
In your GWT module inherit from `org.jboss.gwt.elemento.Core`:

```xml
<module>
    <inherits name="org.jboss.gwt.elemento.Core"/>
</module>
```

# Builder API

When working with GWT Elemental it is often awkward and cumbersome to create an hierarchy of elements. Even simple structures like

```html
<section class="main">
    <input class="toggle-all" type="checkbox">
    <label for="toggle-all">Mark all as complete</label>
    <ul class="todo-list">
        <li>
            <div class="view">
                <input class="toggle" type="checkbox" checked>
                <label>Taste Elemento</label>
                <button class="destroy"></button>
            </div>
            <input class="edit">
        </li>
    </ul>
</section>
```

lead to a vast amount of `Document.createElement()` and chained `Node.appendChild()` calls. With Elemento creating the above structure is as easy as

```java
import static org.jboss.gwt.elemento.core.Elements.*;
import static org.jboss.gwt.elemento.core.InputType.checkbox;
import static org.jboss.gwt.elemento.core.InputType.text;

HTMLElement section = section().css("main")
        .add(input(checkbox).id("toggle-all").css("toggle-all"))
        .add(label()
                .apply(l -> l.htmlFor = "toggle-all")
                .textContent("Mark all as complete"))
        .add(ul().css("todo-list")
                .add(li()
                        .add(div().css("view")
                                .add(input(checkbox)
                                        .css("toggle")
                                        .apply(cb -> cb.checked = true))
                                .add(label().textContent("Taste Elemento"))
                                .add(button().css("destroy")))
                        .add(input(text).css("edit"))))
        .asElement();
```

The class `Elements` provides convenience methods to create the most common elements. It uses a fluent API to create and append elements on the fly. Take a look at the [API documentation](http://rawgit.com/hal/elemento/site/apidocs/org/jboss/gwt/elemento/core/Elements.html) for more details.

## References

When creating large hierarchies of elements you often need to assign an element somewhere in the tree. Use an inline assignment together with `asElement()` to create and assign the element in one go:

```java
final HTMLElement count;
final HTMLElement footer = footer()
        .add(count = span().css("todo-count").asElement())
        .asElement();
```

## Event Handlers

Elemento provides methods to easily register event handlers. There are [constants](http://rawgit.com/hal/elemento/site/apidocs/org/jboss/gwt/elemento/core/EventType.html) for most of the known event types. 

You can either add event handlers when building the element hierarchy:

```java
import static org.jboss.gwt.elemento.core.Elements.*;
import static org.jboss.gwt.elemento.core.EventType.*;
import static org.jboss.gwt.elemento.core.InputType.checkbox;
import static org.jboss.gwt.elemento.core.InputType.text;

HTMLLIElement listItem = li()
        .add(div().css("view")
                .add(input(checkbox)
                        .css("toggle")
                        .apply(cb -> cb.checked = true)
                        .on(change, event -> toggle()))
                .add(label()
                        .textContent("Taste Elemento")
                        .on(dblclick, event -> edit()))
                .add(button()
                        .css("destroy")
                        .on(click, event -> destroy())))
        .add(input(text)
                .css("edit")
                .on(keydown, this::keyDown)
                .on(blur, event -> blur()))
        .asElement();
```

or register them later using `EventType.bind()`: 

```java
EventType.bind(listItem, click, event -> DomGlobal.alert("Clicked"));
```

The latter approach returns `org.gwtproject.event.shared.HandlerRegistration` which you can use to remove the handler again.

In order to make it easier to work with keyboard events, Elemento provides an [enum](http://rawgit.com/hal/elemento/site/apidocs/org/jboss/gwt/elemento/core/Key.html) with the most common keyboard codes:

```java
import static org.jboss.gwt.elemento.core.Key.Escape;
import static org.jboss.gwt.elemento.core.Key.Enter;

void keyDown(KeyboardEvent event) {
    if (Escape.match(event)) {
        ...
    } else if (Enter.match(event)) {
        ...
    }
}
```

## Custom Elements

Elemento makes it easy to create custom elements. As for Elemento custom elements are a composite of HTML elements and/or other custom elements. They're ordinary classes which can hold state or register event handlers. The only requirement is to implement `IsElement<E extends HTMLElement>` and return a root element:

```java
import static org.jboss.gwt.elemento.core.Elements.*;

class TodoItemElement implements IsElement<HTMLElement> {
    
    private final HTMLElement root;
    private final HTMLInputElement toggle;
    private final HTMLElement label;
    private final HTMLInputElement summary;

    TodoItemElement(TodoItem item) {
        this.root = li().data("item", item.id)
                .add(div().css("view")
                        .add(toggle = input(checkbox).css("toggle").asElement())
                        .add(label = label().textContent(item.text).asElement())
                        .add(destroy = button().css("destroy").asElement()))
                .add(summary = input(text).css("edit").asElement())
                .asElement();
        this.root.classList.toggle("completed", item.completed);
        this.toggle.checked = item.completed;
    }
    
    @Override
    public HTMLElement asElement() {
        return root;
    }
    
    // event handlers omitted
}
```

The builder API has support for `IsElement<E extends HTMLElement>` which makes it easy to use custom elements when building the element hierarchy:

```java
import static org.jboss.gwt.elemento.core.Elements.ul;

TodoItemRepository repository = ...;
TodoItemElement[] itemElements = repository.items().stream()
        .map(TodoItemElement::new)
        .toArray();
HTMLUListElement ul = ul().addAll(itemElements).asElement();
``` 

# HTML Templates

Elemento provides an easy way to take existing HTML content and use it in your application. Templates can be either HTML snippets or full HTML documents where you select an element and its children. This allows you to preview your templates more easily during design without running the application. 

HTML templates rely on annotation processing. The annotation processors are configured in `META-INF/services/javax.annotation.processing.Processor` and should be detected automatically. They pick the HTML content from your template and generate a subclass of your annotated class. This code generation is inspired by Google's [AutoValue](https://github.com/google/auto/tree/master/value#how-to-use-autovalue) and it might take some time to get used to it. 

## Get Started

To use HTML templates add the following maven dependency to your POM:

```xml
<dependency>
    <groupId>org.jboss.gwt.elemento</groupId>
    <artifactId>elemento-template</artifactId>
    <version>HEAD-SNAPSHOT</version>
</dependency>
```

In your GWT module inherit from `org.jboss.gwt.elemento.Template`:

```xml
<module>
    <inherits name="org.jboss.gwt.elemento.Template"/>
</module>
```

## Prepare HTML

Let's say you've got the following HTML document called `Todo.html`:
 
```html
<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href="<path-to>/node_modules/todomvc-common/base.css">
    <link rel="stylesheet" href="<path-to>/node_modules/todomvc-app-css/index.css">
</head>
<body>
<section data-element="todos" class="todoapp">
    <header class="header">
        <h1>todos</h1>
        <input data-element="newTodo" class="new-todo" placeholder="What needs to be done?" autofocus>
    </header>
    <section data-element="main" class="main">
        <input data-element="toggleAll" class="toggle-all" id="toggle-all" type="checkbox">
        <label for="toggle-all">Mark all as complete</label>
        <ul data-element="list" class="todo-list">
            <!-- Todo items are mapped to an extra template class -->
        </ul>
    </section>
    <footer data-element="footer" class="footer">
        <span data-element="count" class="todo-count"><strong>0</strong> item left</span>
        <ul class="filters">
            <li><a data-element="all" href="#/">All</a></li>
            <li><a data-element="active" href="#/active">Active</a></li>
            <li><a data-element="completed" href="#/completed">Completed</a></li>
        </ul>
        <button data-element="clearCompleted" class="clear-completed">Clear completed</button>
    </footer>
</section>
[...]
</body>
</html>
```

The HTML is enriched with `data-element` attributes. Elemento needs these attributes to select the root element and to map specific HTML elements to fields in the template class. 

## Template Class

To create a template class which maps to the `<section data-element="todos"/>` element, create an abstract class and annotate it with `@Templated`:

```java
@Templated("Todo.html#todos")
abstract class ApplicationElement implements IsElement<HTMLElement> {

    static ApplicationElement create() {
        return new Templated_ApplicationElement();
    }
}
```

The `@Templated` annotation selects the root element. Without specifying a selector, Elemento looks in the current package for a parallel ".html" template next to the template class and use the first child of the `<body>` as root element. 

The static method `static ApplicationElement create()` might look strange at first and it will most likely be marked as an error if you haven't run the annotation processor so far. But that's the central idea behind Elemento's code generation: You create an abstract base class that has one reasonable implementation. This implementation is generated by the annotation processor and is named `Templated_<YourClassName>`. That's the class you need to create in the static factory method.
   
Finally your template class needs to implement `IsElement<E extends HTMLElement>`. The generated code implements the method `E asElement()` and returns the selected root element of your HTML template. 

To sum it up here are the steps necessary to create and use an HTML template

1. Place `data-element` attributes in your HTML markup
1. Create an abstract class annotated with `@Templated` which implements `IsElement<HTMLElement>`
1. Add a static factory method (name does not matter) which returns the template class and calls the generated constructor `Templated_<YourClassName>`
1. Run the annotation processor to get rid of compile errors

Besides these rules you're free to implement additional interfaces or extend from arbitrary base classes. 

## Data Elements

To map specific elements from the HTML to your template class use the `@DataElement` annotation:
 
```java
@Templated("Todo.html#todos")
abstract class ApplicationElement implements IsElement<HTMLElement> {
    
    @DataElement HTMLInputElement newTodo;
    @DataElement HTMLElement main;
    @DataElement HTMLInputElement toggleAll;
    @DataElement HTMLElement list;
    @DataElement HTMLElement footer;
    @DataElement HTMLElement count;
    @DataElement("all") HTMLElement filterAll;
    @DataElement("active") HTMLElement filterActive;
    @DataElement("completed") HTMLElement filterCompleted;
    @DataElement HTMLButtonElement clearCompleted;
}
```

If no value is provided for the `@DataElement` annotation, the name of the field / method is taken as default. Elemento uses the following CSS selector to pick elements from the HTML template: 

```css
[data-element=<value()>]
```

The `@DataElement` can be applied to fields and methods. Those fields and methods must not be private. Elemento defines three simple rules for the mapping between the HTML template and the related class:
 
| Java Element | Direction |
| --- | --- |
| **1. Fields w/o an initializer**<br/>The element, its attributes and all children are mapped from the HTML template to the annotated field. The type of the field should be `elemental2.dom.HTMLElement` or a subclass of `elemental2.dom.HTMLElement`. | HTML&nbsp;&rarr;&nbsp;Java |
| **2. Fields w/ an initializer**<br/>The element in the HTML template is replaced with the initializer. The type of the field should be one of: `elemental2.dom.HTMLElement` or `IsElement`. | Java &rarr; HTML |
| **3. Methods**<br/>The element in the HTML template is replaced with the return value of the method. The method should return one of: `elemental2.dom.HTMLElement` or `IsElement` and must not have any parameters. | Java &rarr; HTML |

You're also free to use custom types when mapping fields and methods. In this case the generated code will use `Js.cast()`. It's up to you to make sure the cast works. Otherwise this can lead to strange errors which are hard to detect.

## Dependencies

Now what if your template class has dependencies which you want to pass as constructor arguments? In that case change the signature of the static factory method to accept your dependencies:
  
```java
@Templated("Todo.html#todos")
abstract class ApplicationElement implements IsElement<HTMLElement> {

    static ApplicationElement create(TodoItemRepository repository, I18n i18n) {
        return new Templated_ApplicationElement(repository, i18n);
    }

    abstract TodoItemRepository repository();
    abstract I18n i18n();
}
```

For each constructor parameter you can define an abstract accessor method which returns the dependency and does not accept parameters. The generated code will implement these methods. Please make sure that parameters are passed to the auto-generated constructor in the same order the corresponding accessor methods are defined in the file. Take extra care that the order remains valid if you refactor your code!
  
## PostConstruct
Since templated classes cannot have a constructor it's possible to annotate a method with `javax.annotation.PostConstruct`. This method will be called from the generated constructor **after** all initialization steps (element mapping, expressions). So it's safe to use the abstract accessor methods and data elements from the initialization method:
 
```java
@Templated("Todo.html#todos")
abstract class ApplicationElement implements IsElement<HTMLElement> {

    static ApplicationElement create(TodoItemRepository repository, I18n i18n) {
        return new Templated_ApplicationElement(repository, i18n);
    }

    abstract TodoItemRepository repository();
    abstract I18n i18n();

    @DataElement HTMLElement list;

    @PostConstruct
    void init() {
        // load the todo items from local storage
        Elements.removeChildrenFrom(list); 
        for (TodoItem item : repository().items()) {
            // TodoItemElement is another template class
            list.appendChild(TodoItemElement.create(this, repository(), item).asElement());
        }
    }
}
```

The method annotated with `javax.annotation.PostConstruct` must not be private, return void and must not have any parameters. 

## Expressions

Elemento supports expressions like `${foo}` in HTML templates:
 
```html
<section data-element="todos" class="todoapp">
    <header class="header">
        <h1>${i18n().constants().todos()}</h1>
        <input data-element="newTodo" class="new-todo" placeholder="${i18n().constants().new_todo()}" autofocus>
    </header>
</section>
```

The expressions between `${` and `}` need to be valid Java expressions. They're executed in the scope of the generated class. `${<expression>}` is replaced with the safe HTML result of `String.valueOf(<expression>)`. The example above makes use of the template's `i18n()` method (see example above) and inserts the language specific header. But you could also use any other valid expressions like `${com.google.gwt.i18n.client.DateTimeFormat.getShortDateFormat().format(new java.util.Date())}`.

Expressions are supported in text nodes and attribute values. 

# Integrations

## Errai

[Errai](http://erraiframework.org/) is a very powerful, general-purpose framework for writing rich web applications using next-generation web technologies. You can use many EE related technologies such as CDI, JPA or JAX-RS on the client side. As such Errai is particularly useful when you want to develop large RIAs. 

Elemento on the other hand is very focused around [Elemental2](https://github.com/google/elemental2). The main goal is to provide a type safe API for working with HTML elements.  
 
Although there are overlapping parts like HTML templates you can still use Elemento's builder API as part of an Errai application. This can also be combined with Errai HTML templates. Since Errai UI is API agnostic when it comes to the DOM, you can use *any* native JS type DOM wrapper in an Errai UI template. However I would not recommend using Elemento's HTML templates in an Errai application.

The [samples](#samples) section contains an Errai version of the TodoMVC app using Errai for dependency injection and the builder API to create the elements. 

## RxGWT

[RxGWT](https://github.com/intendia-oss/rxgwt) provides reactive extensions for GWT. It enables you to use [RxJava](https://github.com/ReactiveX/RxJava) on the client. RxJava is a library for composing asynchronous and event-based programs by using observable sequences.

Speaking of Elemento you can use RxGWT to bind events and turn them into an observable. To use RxGWT inherit from `com.intendia.rxgwt.RxElemento`: 

```xml
<module rename-to="elemental2">
    <inherits name="com.intendia.rxgwt.RxElemento"/>
</module>
```

Then use `<T extends Event> Observable<T> fromEvent(EventTarget src, EventType<T, ?> type)` to listen for events and turn them into an observable:

```java
HTMLElement info; 
document.body.appendChild(info = span().asElement());

Observable<double[]> touch$ = RxElemento.fromEvent(document, touchmove)
        .map(ev -> ev.touches.item(0))
        .map(touch -> new double[] { touch.clientX, touch.clientY });
Observable<double[]> mouse$ = RxElemento.fromEvent(document, mousemove)
        .map(ev -> new double[] { ev.clientX, ev.clientY });
Observable.merge(touch$, mouse$)
        .map(p -> "position (" + p[0] + "," + p[1] + ")")
        .forEach(n -> info.textContent = n);
```

## Dagger and GIN

Elemento provides support for dependency injection in HTML templates using [Dagger](https://google.github.io/dagger/) or [GIN](https://code.google.com/p/google-gin/). If one of these libraries is on the classpath, the annotation processor will place a `@javax.inject.Inject` annotation on the generated constructor. 

See the [samples](#samples) how this works and how you can inject the templates classes into other classes.

# Helper Methods

Besides the builder API and the HTML templates, Elemento comes with a bunch of static helper methods that roughly fall into four categories:

1. Element iterator / stream methods
1. Element append, insert & remove methods
1. Misc element helper methods (show, hide, toggle CSS classes)

See the API documentation of [Elements](http://rawgit.com/hal/elemento/site/apidocs/org/jboss/gwt/elemento/core/Elements.html) for more details.

# J2CL / GWT3

Elemento is ready to be used with J2CL and GWT 3. It has no dependencies to `gwt-user`. There are methods that use safe HTML classes. But these classes are taken from [`org.gwtproject.safehtml:safehtml`](https://github.com/Vertispan/gwt-safehtml/). In case you still need to use the safe HTML classes from `gwt-user`, you can switch to versions `GWT2-SNAPSHOT` resp. `x.y.z-gwt2`. In general Elemento provides different branches which produce the following versions: 

- The main branches `develop` and `master` have no `gwt-user` dependency. They use safe HTML classes from `org.gwtproject.safehtml:safehtml`. These branches produce versions `HEAD-SNAPSHOT` resp. `x.y.z`
- The branch `gwt2` use safe HTML classes from `gwt-user`. This branch produces versions `GWT2-SNAPSHOT` resp. `x.y.z-gwt2`

Methods to convert from `com.google.gwt.user.client.ui.Widget` and `com.google.gwt.dom.client.Element` to `elemental2.dom.HTMLElement` and vice versa are part of class `org.jboss.gwt.elemento.core.Widgets` in module `elemento-widget`. This module is available in all versions and branches and has obvisiouly a dependeny to `gwt-user`.  

# Samples

Elemento comes with five different [implementations](https://hal.github.io/elemento/index.html) of the [TodoMVC](http://todomvc.com/) sample app. 

- Builder API: [Source](samples/builder) | [Demo](http://hal.github.io/elemento/builder/index.html)
- HTML templates: [Source](samples/templated) | [Demo](http://hal.github.io/elemento/templated/index.html)
- Errai DI and builder API: [Source](samples/errai) | [Demo](http://hal.github.io/elemento/errai/index.html)
- Dagger DI and HTML templates: [Source](samples/dagger) | [Demo](http://hal.github.io/elemento/dagger/index.html)
- GIN DI and HTML templates: [Source](samples/gin) | [Demo](http://hal.github.io/elemento/gin/index.html)

All samples use the same key to persist the todo items in the local storage. So you can switch between the samples and continue working on your tasks seamlessly ;-)

# Contributing

If you want to contribute to Elemento, please follow the steps in [contribution](CONTRIBUTING.md).

# Get Help

If you need help feel free to contact us at Gitter, browse the API documentation or file an issue.

- [Gitter Channel](https://gitter.im/hal/elemento)
- [API documentation](http://rawgit.com/hal/elemento/site/apidocs/index.html)
- [Issues](https://github.com/hal/elemento/issues)
