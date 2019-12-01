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

package org.panda_lang.reposilite.user;

import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.Buildable;
import org.panda_lang.reposilite.utils.entity.IdentifiableEntity;

import java.io.Serializable;

public interface Owner extends IdentifiableEntity<ObjectId>, Serializable {

    void setName(String name);

    void setDisplayName(String displayName);

    void setDescription(String description);

    void setEmail(String email);

    void setAvatar(String avatar);

    void setSite(String site);

    String getName();

    String getDisplayName();

    String getDescription();

    String getEmail();

    String getSite();

    String getAvatar();

    abstract class AbstractProjectOwnerBuilder<T extends Buildable<? extends Owner>> {

        protected String name;
        protected String displayName;
        protected String description;
        protected String email;
        protected String avatar;
        protected String site;

        public T withName(String name) {
            this.name = name;
            return returnThis();
        }

        public T withDisplayName(String displayName) {
            this.displayName = displayName;
            return returnThis();
        }

        public T withDescription(String description) {
            this.description = description;
            return returnThis();
        }

        public T withEmail(String email) {
            this.email = email;
            return returnThis();
        }

        public T withAvatar(String avatar) {
            this.avatar = avatar;
            return returnThis();
        }

        public T withSite(String site) {
            this.site = site;
            return returnThis();
        }

        @SuppressWarnings("unchecked")
        private T returnThis() {
            return (T) this;
        }

    }

}
