package org.panda_lang.reposilite.builtin;

import j2html.tags.DomContent;

import static j2html.TagCreator.head;
import static j2html.TagCreator.html;
import static j2html.TagCreator.title;

final class BuiltInLayout {

    private BuiltInLayout() { }

    protected static String content(String page, DomContent content) {
        return html(head(title("Reposilite - " + page)), content).render();
    }

}
