package com.itcm.structural_design.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBModel extends SQLiteOpenHelper {

    public DBModel(Context context) { super(context, DB_FILE_NAME, null, DB_VERSION); }

    private static final String DB_FILE_NAME = "structural_design.db";
    private static final int DB_VERSION = 1;

    public static final String USERS_TABLE = "users_table";
    public static final String VALUES_TABLE = "values_table";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_AUTH_OPTION = "auth_option";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PROFILE_IMAGE_LOCAL_PATH = "profile_image_local_path";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_MODULE_ID = "module_id";
    public static final String COLUMN_CATEGORY_ID = "category_id";
    public static final String COLUMN_SUB_CATEGORY_POSITION = "sub_category_position";
    public static final String COLUMN_VAL_ID_1 = "val_id_1"; public static final String COLUMN_VAL_ID_2 = "val_id_2";
    public static final String COLUMN_VAL_ID_3 = "val_id_3"; public static final String COLUMN_VAL_ID_4 = "val_id_4";
    public static final String COLUMN_VAL_ID_5 = "val_id_5"; public static final String COLUMN_VAL_ID_6 = "val_id_6";
    public static final String COLUMN_VAL_ID_7 = "val_id_7"; public static final String COLUMN_VAL_ID_8 = "val_id_8";
    public static final String COLUMN_VAL_ID_9 = "val_id_9"; public static final String COLUMN_VAL_ID_10 = "val_id_10";
    public static final String COLUMN_VAL_ID_11 = "val_id_11";public static final String COLUMN_VAL_ID_12 = "val_id_12";
    public static final String COLUMN_VAL_ID_13 = "val_id_13";public static final String COLUMN_VAL_ID_14 = "val_id_14";
    public static final String COLUMN_VAL_ID_15 = "val_id_15"; public static final String COLUMN_VAL_ID_16 = "val_id_16";
    public static final String COLUMN_VAL_ID_17 = "val_id_17";
    public static final String COLUMN_VAL_ID_18 = "val_id_18"; public static final String COLUMN_VAL_ID_19 = "val_id_19";
    public static final String COLUMN_VAL_ID_20 = "val_id_20"; public static final String COLUMN_VAL_ID_21 = "val_id_21";
    public static final String COLUMN_VAL_ID_22 = "val_id_22"; public static final String COLUMN_VAL_ID_23 = "val_id_23";
    public static final String COLUMN_VAL_ID_24 = "val_id_24"; public static final String COLUMN_VAL_ID_25 = "val_id_25";
    public static final String COLUMN_VAL_ID_26 = "val_id_26"; public static final String COLUMN_VAL_ID_27 = "val_id_27";
    public static final String COLUMN_VAL_ID_28 = "val_id_28"; public static final String COLUMN_VAL_ID_29 = "val_id_29";
    public static final String COLUMN_VAL_ID_30 = "val_id_30";
    public static final String COLUMN_VAL_ID_34 = "val_id_34"; public static final String COLUMN_VAL_ID_35 = "val_id_35";
    public static final String COLUMN_VAL_ID_36 = "val_id_36"; public static final String COLUMN_VAL_ID_38 = "val_id_38";
    public static final String COLUMN_VAL_ID_39 = "val_id_39"; public static final String COLUMN_VAL_ID_40 = "val_id_40";
    public static final String COLUMN_VAL_ID_41 = "val_id_41"; public static final String COLUMN_VAL_ID_42 = "val_id_42";
    public static final String COLUMN_VAL_ID_43 = "val_id_43"; public static final String COLUMN_VAL_ID_44 = "val_id_44";
    public static final String COLUMN_VAL_ID_45 = "val_id_45";
    public static final String COLUMN_VAL_ID_47 = "val_id_47"; public static final String COLUMN_VAL_ID_48 = "val_id_48";
    public static final String COLUMN_VAL_ID_49 = "val_id_49";public static final String COLUMN_VAL_ID_50 = "val_id_50";
    public static final String COLUMN_VAL_ID_52 = "val_id_52"; public static final String COLUMN_VAL_ID_53 = "val_id_53";
    public static final String COLUMN_VAL_ID_54 = "val_id_54"; public static final String COLUMN_VAL_ID_55 = "val_id_55";
    public static final String COLUMN_VAL_ID_56 = "val_id_56"; public static final String COLUMN_VAL_ID_57 = "val_id_57";
    public static final String COLUMN_VAL_ID_58 = "val_id_58"; public static final String COLUMN_VAL_ID_59 = "val_id_59";
    public static final String COLUMN_VAL_ID_60 = "val_id_60"; public static final String COLUMN_VAL_ID_61 = "val_id_61";
    public static final String COLUMN_VAL_ID_62 = "val_id_62"; public static final String COLUMN_VAL_ID_63 = "val_id_63";
    public static final String COLUMN_VAL_ID_64 = "val_id_64"; public static final String COLUMN_VAL_ID_65 = "val_id_65";
    public static final String COLUMN_VAL_ID_66 = "val_id_66"; public static final String COLUMN_VAL_ID_67 = "val_id_67";
    public static final String COLUMN_VAL_ID_68 = "val_id_68";public static final String COLUMN_VAL_ID_69 = "val_id_69";
    public static final String COLUMN_VAL_ID_70 = "val_id_70"; public static final String COLUMN_VAL_ID_71 = "val_id_71";
    public static final String COLUMN_VAL_ID_72 = "val_id_72";
    public static final String COLUMN_VAL_ID_73 = "val_id_73"; public static final String COLUMN_VAL_ID_74 = "val_id_74";
    public static final String COLUMN_VAL_ID_75 = "val_id_75"; public static final String COLUMN_VAL_ID_76 = "val_id_76";
    public static final String COLUMN_VAL_ID_77 = "val_id_77"; public static final String COLUMN_VAL_ID_78 = "val_id_78";
    public static final String COLUMN_VAL_ID_80 = "val_id_80"; public static final String COLUMN_VAL_ID_81 = "val_id_81";
    public static final String COLUMN_VAL_ID_82 = "val_id_82";
    public static final String COLUMN_VAL_ID_87 = "val_id_87"; public static final String COLUMN_VAL_ID_88 = "val_id_88";
    public static final String COLUMN_VAL_ID_89 = "val_id_89"; public static final String COLUMN_VAL_ID_90 = "val_id_90";
    public static final String COLUMN_VAL_ID_91 = "val_id_91"; public static final String COLUMN_VAL_ID_92 = "val_id_92";
    public static final String COLUMN_VAL_ID_96 = "val_id_96"; public static final String COLUMN_VAL_ID_97 = "val_id_97";
    public static final String COLUMN_VAL_ID_100 = "val_id_100"; public static final String COLUMN_VAL_ID_101 = "val_id_101";
    public static final String COLUMN_VAL_ID_103 = "val_id_103"; public static final String COLUMN_VAL_ID_104 = "val_id_104";
    public static final String COLUMN_VAL_ID_105 = "val_id_105";public static final String COLUMN_VAL_ID_106 = "val_id_106";
    public static final String COLUMN_VAL_ID_107 = "val_id_107";public static final String COLUMN_VAL_ID_108 = "val_id_108";
    public static final String COLUMN_VAL_ID_115 = "val_id_115";public static final String COLUMN_VAL_ID_116 = "val_id_116";
    public static final String COLUMN_VAL_ID_122 = "val_id_122";
    public static final String COLUMN_VAL_ID_123 = "val_id_123"; public static final String COLUMN_VAL_ID_125 = "val_id_125";
    public static final String COLUMN_VAL_ID_270 = "val_id_270";
    public static final String COLUMN_VAL_ID_400 = "val_id_400";
    public static final String COLUMN_VAL_ID_1001 = "val_id_1001";
    public static final String COLUMN_VAL_ID_1002 = "val_id_1002";
    public static final String COLUMN_VAL_ID_2026 = "val_id_2026"; public static final String COLUMN_VAL_ID_2027 = "val_id_2027";
    public static final String COLUMN_VAL_ID_2034 = "val_id_2034"; public static final String COLUMN_VAL_ID_2035 = "val_id_2035";
    public static final String COLUMN_VAL_ID_2042 = "val_id_2042"; public static final String COLUMN_VAL_ID_2043 = "val_id_2043";
    public static final String COLUMN_VAL_ID_2048 = "val_id_2048"; public static final String COLUMN_VAL_ID_2049 = "val_id_2049";
    public static final String COLUMN_VAL_ID_4001 = "val_id_4001";
    public static final String COLUMN_VAL_ID_4002 = "val_id_4002";
    public static final String COLUMN_VAL_ID_4003 = "val_id_4003";
    public static final String COLUMN_VAL_ID_4004 = "val_id_4004";
    public static final String COLUMN_VAL_ID_4005 = "val_id_4005";
    public static final String COLUMN_VAL_ID_4006 = "val_id_4006";
    public static final String COLUMN_VAL_ID_4007 = "val_id_4007";
    public static final String COLUMN_VAL_ID_4008 = "val_id_4008";
    public static final String COLUMN_VAL_ID_4009 = "val_id_4009";
    public static final String COLUMN_VAL_ID_4010 = "val_id_4010";
    public static final String COLUMN_ID_1000_POSITION = "id_1000_position";
    public static final String COLUMN_ID_1_POSITION = "id_1_position";
    public static final String COLUMN_ID_4_POSITION = "id_4_position";
    public static final String COLUMN_ID_10_POSITION = "id_10_position";
    public static final String COLUMN_ID_17_POSITION = "id_17_position";
    public static final String COLUMN_ID_30_POSITION = "id_30_position";
    public static final String COLUMN_ID_37_POSITION = "id_37_position";
    public static final String COLUMN_ID_42_POSITION = "id_42_position";
    public static final String COLUMN_ID_47_POSITION = "id_47_position";
    public static final String COLUMN_ID_51_POSITION = "id_51_position";
    public static final String COLUMN_ID_58_POSITION = "id_58_position";
    public static final String COLUMN_ID_59_POSITION = "id_59_position";
    public static final String COLUMN_ID_70_POSITION = "id_70_position";
    public static final String COLUMN_ID_77_POSITION = "id_77_position";
    public static final String COLUMN_ID_85_POSITION = "id_85_position";
    public static final String COLUMN_ID_86_POSITION = "id_86_position";
    public static final String COLUMN_ID_94_POSITION = "id_94_position";
    public static final String COLUMN_ID_102_POSITION = "id_102_position";
    public static final String COLUMN_ID_69_POSITION = "id_69_position";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(USERS_TABLE_SQL);
        sqLiteDatabase.execSQL(VALUES_TABLE_SQL);
    }

    private static final String USERS_TABLE_SQL = "CREATE TABLE " + USERS_TABLE + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_EMAIL + " TEXT UNIQUE, " +
            COLUMN_PROFILE_IMAGE_LOCAL_PATH + " TEXT, " +
            COLUMN_AUTH_OPTION + " INTEGER DEFAULT 0" + ")";

    private static final String VALUES_TABLE_SQL = "CREATE TABLE " + VALUES_TABLE + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_EMAIL + " TEXT, " +
            COLUMN_TITLE + " TEXT, " +
            COLUMN_MODULE_ID + " INTEGER DEFAULT 0, " +
            COLUMN_CATEGORY_ID + " INTEGER DEFAULT 0, " +
            COLUMN_SUB_CATEGORY_POSITION + " INTEGER DEFAULT 0, " +
            COLUMN_VAL_ID_1 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_2 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_3 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_4 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_5 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_6 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_7 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_8 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_9 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_10 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_11 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_12 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_13 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_14 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_15 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_16 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_17 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_18 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_19 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_20 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_21 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_22 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_23 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_24 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_25 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_26 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_27 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_28 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_29 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_30 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_34 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_35 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_36 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_38 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_39 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_40 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_41 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_42 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_43 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_44 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_45 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_47 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_48 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_49 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_50 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_52 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_53 + " DOUBLE DEFAULT 1, " +  COLUMN_VAL_ID_54 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_55 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_56 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_57 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_58 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_59 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_60 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_61 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_62 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_63 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_64 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_65 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_66 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_67 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_68 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_69 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_70 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_71 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_72 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_73 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_74 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_75 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_76 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_77 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_78 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_80 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_81 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_82 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_87 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_88 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_89 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_90 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_91 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_92 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_96 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_97 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_100 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_101 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_103 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_104 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_105 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_106 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_107 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_108 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_115 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_116 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_122 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_123 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_125 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_270 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_400 + " DOUBLE DEFAULT 1, "
            + COLUMN_VAL_ID_1001 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_1002 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_2026 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_2027 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_2034 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_2035 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_2042 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_2043 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_2048 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_2049 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_4001 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_4002 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_4003 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_4004 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_4005 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_4006 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_4007 + " DOUBLE DEFAULT 1, " +
            COLUMN_VAL_ID_4008 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_4009 + " DOUBLE DEFAULT 1, " + COLUMN_VAL_ID_4010 + " DOUBLE DEFAULT 1, " +
            COLUMN_ID_1000_POSITION + " INTEGER DEFAULT 0, " + COLUMN_ID_1_POSITION + " INTEGER DEFAULT 0, " + COLUMN_ID_4_POSITION + " INTEGER DEFAULT 0, " +
            COLUMN_ID_10_POSITION + " INTEGER DEFAULT 0, " + COLUMN_ID_17_POSITION + " INTEGER DEFAULT 0, " + COLUMN_ID_30_POSITION + " INTEGER DEFAULT 0, " +
            COLUMN_ID_37_POSITION + " INTEGER DEFAULT 0, " + COLUMN_ID_42_POSITION + " INTEGER DEFAULT 0, " + COLUMN_ID_47_POSITION + " INTEGER DEFAULT 0, " + COLUMN_ID_51_POSITION + " INTEGER DEFAULT 0, " +
            COLUMN_ID_58_POSITION + " INTEGER DEFAULT 0, " + COLUMN_ID_59_POSITION + " INTEGER DEFAULT 0, " + COLUMN_ID_70_POSITION + " INTEGER DEFAULT 0, " + COLUMN_ID_77_POSITION + " INTEGER DEFAULT 0, " +
            COLUMN_ID_102_POSITION + " INTEGER DEFAULT 0, " + COLUMN_ID_69_POSITION + " INTEGER DEFAULT 0, " + COLUMN_ID_85_POSITION + " INTEGER DEFAULT 0, " +
            COLUMN_ID_86_POSITION + " INTEGER DEFAULT 0, " + COLUMN_ID_94_POSITION + " INTEGER DEFAULT 0" + ")";

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
