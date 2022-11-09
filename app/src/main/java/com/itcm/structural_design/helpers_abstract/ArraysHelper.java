package com.itcm.structural_design.helpers_abstract;

import static com.itcm.structural_design.activities.BasicActivity.context;

import java.util.ArrayList;
import java.util.Collections;

public abstract class ArraysHelper {

    public static ArrayList<String> getResourceAList(int arrayResID) {
        ArrayList<String> relevantArray = new ArrayList<>();
        Collections.addAll(relevantArray, context.getResources().getStringArray(arrayResID));
        return relevantArray;
    }
}
