/*
 * Copyright (c) 2018-2019 Reposilite Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.reposilite.builtin;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static j2html.TagCreator.a;
import static j2html.TagCreator.body;
import static j2html.TagCreator.h2;
import static j2html.TagCreator.li;
import static j2html.TagCreator.p;
import static j2html.TagCreator.ul;

@RestController
@ConditionalOnProperty(
        value = "reposilite.built-in-frontend",
        havingValue = "on"
)
class BuiltInIndexController {

    @RequestMapping("/")
    protected String index() {
        return BuiltInLayout.content("Home", body(
                h2("Reposilite"),
                p("Repository management software mainly dedicated for Maven and Panda-based artifacts"),
                ul(
                        li(a("Repositories").withHref("/repositories")),
                        li(a("Contribute").withHref("https://github.com/panda-lang/reposilite"))
                )
        ));
    }

}
