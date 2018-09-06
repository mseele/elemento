/*
 * Copyright 2015-2016 Red Hat, Inc, and individual contributors.
 *
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

package org.jboss.gwt.elemento.testsuite.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import elemental2.dom.Node;
import org.gwtproject.safehtml.shared.SafeHtmlUtils;
import org.junit.Before;
import org.junit.Test;

import static java.util.stream.Collectors.toList;
import static org.jboss.gwt.elemento.core.Elements.iterator;
import static org.jboss.gwt.elemento.core.Elements.stream;
import static org.jboss.gwt.elemento.testsuite.TestPage.builder;
import static org.jboss.gwt.elemento.testsuite.TestPage.childNodes;
import static org.jboss.gwt.elemento.testsuite.client.Assert.assertNodes;
import static org.jboss.gwt.elemento.testsuite.client.Fixtures.HTML;

public class ArrayLikeTest {

    @Before
    public void setUp() {
        builder().innerHtml(SafeHtmlUtils.fromTrustedString(HTML));
    }

    @Test
    public void arrayLikeIterator() {
        List<Node> elements = new ArrayList<>();
        Iterator<Node> iterator = iterator(childNodes());
        while (iterator.hasNext()) {
            elements.add(iterator.next());
        }
        assertNodes(elements);
    }

    @Test
    public void arrayLikeStream() {
        List<Node> nodes = stream(childNodes()).collect(toList());
        assertNodes(nodes);
    }
}
