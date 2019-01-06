package com.todo.util;

/**
 * 检查各类格式
 *
 * @author Lcy
 * @date 2019/1/6 11:33
 */
public class CheckForm {

    /**
     * 密码限制，大小写字母、数字、特殊符号 四选三
     * @param password
     * @return
     */
    public static boolean checkPassword(String password) {
        String patten = "^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\\W_]+$)(?![a-z0-9]+$)" +
                "(?![a-z\\W_]+$)(?![0-9\\W_]+$)[a-zA-Z0-9\\W_]{8,}$";

        return password.matches(patten);
    }
}
