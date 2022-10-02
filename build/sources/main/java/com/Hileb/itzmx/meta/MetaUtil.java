package com.Hileb.itzmx.meta;

import net.minecraftforge.fml.common.Loader;

public class MetaUtil {
    public static boolean isIDLLoaded = false;
    public static boolean isLoaded_AOA3 = false;
    public static boolean isLoaded_GOG = false;

    public static boolean isLoaded_Momostories = false;

    //extra difficulty
    public static int HARD_AOA3 = 5;
    public static int HARD_GOG = 4;

    //static int modListDifficulty = 0;
    static int modListExtraDifficulty = 0;

    public static int getModListExtraDifficulty() {
        return modListExtraDifficulty;
    }

    public static void CalcModListDifficulty()
    {
       //modListDifficulty = CommonFunctions.GetModCount();
    }

    public static int GetModCount()
    {
        return Loader.instance().getActiveModList().size();
    }
}
