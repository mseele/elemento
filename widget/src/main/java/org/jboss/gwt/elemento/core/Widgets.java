/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.gwt.elemento.core;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;

/**
 * Helper methods for working with {@link com.google.gwt.user.client.ui.Widget}s.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element">https://developer.mozilla.org/en-US/docs/Web/HTML/Element</a>
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public final class Widgets {

    /** Converts from {@link IsElement} &rarr; {@link Widget}. */
    public static Widget asWidget(IsElement element) {
        return asWidget(element.asElement());
    }

    /** Converts from {@link HTMLElement} &rarr; {@link Widget}. */
    public static Widget asWidget(HTMLElement element) {
        return new ElementWidget(element);
    }

    /** Converts from {@link IsWidget} &rarr; {@link HTMLElement}. */
    public static HTMLElement asElement(IsWidget widget) {
        return asElement(widget.asWidget());
    }

    /** Converts from {@link Widget} &rarr; {@link HTMLElement}. */
    public static HTMLElement asElement(Widget widget) {
        return asElement(widget.getElement());
    }

    /** Converts from {@link com.google.gwt.dom.client.Element} &rarr; {@link HTMLElement}. */
    public static HTMLElement asElement(com.google.gwt.dom.client.Element element) {
        return Js.cast(element);
    }


    // this is a static helper class which must never be instantiated!
    private Widgets() {
    }

    private static class ElementWidget extends Widget {

        ElementWidget(HTMLElement element) {
            setElement(com.google.gwt.dom.client.Element.as(Js.cast(element)));
        }
    }
}
