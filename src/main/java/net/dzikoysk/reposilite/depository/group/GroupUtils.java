package net.dzikoysk.reposilite.depository.group;

import org.panda_lang.panda.utilities.commons.text.ContentJoiner;

public class GroupUtils {

    public static String toString(GroupUnit[] units) {
        return ContentJoiner.on(".").join(units, GroupUnit::getName).toString();
    }

}
