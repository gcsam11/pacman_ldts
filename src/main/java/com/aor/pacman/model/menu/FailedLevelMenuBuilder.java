package com.aor.pacman.model.menu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FailedLevelMenuBuilder extends MenuBuilder{
    @Override
    protected List<String> createEntriesS() {
        return Arrays.asList("Try again [T]","Quit      [Q]");
    }

    @Override
    protected List<String> createEntriesN() {
        return Arrays.asList("      oooooo      ",
                "    oo------oo    ",
                "   o----------o   ",
                "  o------------o  ",
                " o--------------o ",
                " o--------------o ",
                "o----uu----uu----o",
                "o---uouu--uouu---o",
                "o----uu----uu----o",
                "o----------------o",
                "o----------------o",
                "o----------------o",
                " o------uu------o ",
                " o-----u--u-----o ",
                "  o------------o  ",
                "   o----------o   ",
                "    oo------oo    ",
                "      oooooo      ", "", "You've failed :(");
    }

    @Override
    protected String createMessage() {
        return null;
    }

    @Override
    protected String getReference() {
        return "FailedLevelMenu";
    }
}
