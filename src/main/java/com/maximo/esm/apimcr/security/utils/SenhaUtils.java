package com.maximo.esm.apimcr.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {

    // Gera um hash utilizando o BCrypt.
    public static String gerarBCrypt(String senha){
        if (senha == null){
            return senha;
        }
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.encode(senha);
    }

    //Verifica se a senha é válida.

    public static boolean senhaValida (String senha, String senhaEncoded){
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
            return bCryptEncoder.matches(senha,senhaEncoded);
    }
}
