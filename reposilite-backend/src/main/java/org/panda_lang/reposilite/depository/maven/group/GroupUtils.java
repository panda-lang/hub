package org.panda_lang.reposilite.depository.maven.group;

import org.panda_lang.panda.utilities.commons.text.ContentJoiner;

public class GroupUtils {

    public static String toString(GroupUnit[] units) {
        return ContentJoiner.on(".").join(units, GroupUnit::getName).toString();
    }

}
