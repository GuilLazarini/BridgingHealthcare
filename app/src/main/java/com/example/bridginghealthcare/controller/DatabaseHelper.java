package com.example.bridginghealthcare.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bridging_healthcare.db";  // nome do arquivo que vai guardar dados do app
    private static final int DATABASE_VERSION = 2;                      // Versao do banco





    private static final String CREATE_TABLE_USUARIO =
            "CREATE TABLE tb_usuario (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT, " +
                    "sobrenome TEXT, " +
                    "email TEXT, " +
                    "datanascimento TEXT, " +
                    "sexo TEXT, " +
                    "senha TEXT " + ")";

    private static final String CREATE_TABLE_PACIENTE =
            "CREATE TABLE tb_paciente (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT, " +
                    "sobrenome TEXT, " +
                    "datanascimento TEXT " + ")";

    private static final String CREATE_TABLE_LOCATE =
            "CREATE TABLE tb_locate (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "latitude TEXT, " +
                    "longitude TEXT " + ")";






    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {       //execução dos scrips dp DB
        db.execSQL(CREATE_TABLE_USUARIO);
        db.execSQL("INSERT INTO tb_usuario (nome,sobrenome,email,datanascimento,sexo,senha) values ('João','da Silva','admin','01/01/2001','M','e10adc3949ba59abbe56e057f20f883e')");
        db.execSQL(CREATE_TABLE_PACIENTE);
        db.execSQL(CREATE_TABLE_LOCATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE tb_usuario");
        db.execSQL("DROP TABLE tb_paciente");
        db.execSQL("DROP TABLE tb_locate");
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}