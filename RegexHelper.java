package com.example.pike.payment001.helper;

import java.util.regex.Pattern;

public class RegexHelper {
    //----------- 싱글톤 객체 생성 시작 ----------
    private static RegexHelper current = null;

    public static RegexHelper getInstance() {
        if (current == null) {
            current = new RegexHelper();
        }
        return current;
    }

    public static void freeInstance() {
        current = null;
    }

    // 생성자를 private으로 작성하면 new에 의한 객체 생성이 불가능해 진다.
    private RegexHelper() {
        super();
    }
    //----------- 싱글톤 객체 생성 끝 ----------

    /**
     * 주어진 문자열이 공백이거나 null인지를 검사
     * @param   str - 검사할 문자열
     * @return  boolean - 공백,null이 아닐 경우 true 리턴
     */
    public boolean isValue(String str) {
        boolean result = false;
        if (str != null) {
            result = !str.trim().equals("");
        }
        return result;
    }
    /**
     * 숫자 모양에 대한 형식 검사
     * @param   str - 검사할 문자열
     * @return  boolean - 형식에 맞을 경우 true, 맞지 않을 경우 false
     */
    public boolean isNum(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^[0-9]*$", str);
        }
        return result;
    }

    /**
     * 영문으로만 구성되었는지에 대한 형식 검사
     * @param   str - 검사할 문자열
     * @return  boolean - 형식에 맞을 경우 true, 맞지 않을 경우 false
     */
    public boolean isEng(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^[a-zA-Z]*$", str);
        }
        return result;
    }

    /**
     * 한글로만 구성되었는지에 대한 형식 검사
     * @param   str - 검사할 문자열
     * @return  boolean - 형식에 맞을 경우 true, 맞지 않을 경우 false
     */
    public boolean isKor(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", str);
        }
        return result;
    }

    /**
     * 영문과 숫자로만 구성되었는지에 대한 형식 검사
     * @param   str - 검사할 문자열
     * @return  boolean - 형식에 맞을 경우 true, 맞지 않을 경우 false
     */
    public boolean isEngNum(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^[a-zA-Z0-9]*$", str);
        }
        return result;
    }


    /**
     * 한글과 숫자로만 구성되었는지에 대한 형식 검사
     * @param   str - 검사할 문자열
     * @return  boolean - 형식에 맞을 경우 true, 맞지 않을 경우 false
     */
    public boolean isKorNum(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^[ㄱ-ㅎ가-힣0-9]*$", str);
        }
        return result;
    }

    /**
     * 이메일 형식인지에 대한 검사. "아이디@도메인"의 형식을 충족해야 한다.
     * @param   str - 검사할 문자열
     * @return  boolean - 형식에 맞을 경우 true, 맞지 않을 경우 false
     */
    public boolean isEmail(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", str);
        }
        return result;
    }

    /**
     * "-"없이 핸드폰번호인지에 대한 형식검사.
     * @param   str - 검사할 문자열
     * @return  boolean - 형식에 맞을 경우 true, 맞지 않을 경우 false
     */
    public boolean isCellPhone(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str);
        }
        return result;
    }

    /**
     * "-"없이 전화번호인지에 대한 형식검사. 각 부분에 대한 자리수도 충족시켜야 한다.
     * @param   str - 검사할 문자열
     * @return  boolean - 형식에 맞을 경우 true, 맞지 않을 경우 false
     */
    public boolean isTel(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^\\d{2,3}\\d{3,4}\\d{4}$", str);
        }
        return result;
    }

    /**
     * "-"없이 주민번호에 대한 글자수 및 뒷자리 첫글자가 1~4의 범위에 있는지에 대한 검사
     * @param   str - 검사할 문자열
     * @return  boolean - 형식에 맞을 경우 true, 맞지 않을 경우 false
     */
    public boolean isJumin1(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))", str);
        }
        return result;
    }
    public boolean isJumin2(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^[1-4]\\d{6}", str);
        }
        return result;
    }
    public boolean isVaidyear(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^[1-2][0][1-5]\\d{1}", str);
        }
        return result;
    }
    public boolean isVaidmonth(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^[0]\\d{1}|[1][0-2]", str);
        }
        return result;
    }
    public boolean isCardNo(String str){
        boolean result = false;
        if (isValue(str)){
            result = Pattern.matches("^\\d{4}", str);
        }
        return result;
    }
    public boolean isCvc(String str){
        boolean result = false;
        if (isValue(str)){
            result = Pattern.matches("^\\d{3}", str);
        }
        return result;
    }
    public boolean isPw(String str){
        boolean result = false;
        if (isValue(str)){
            result = Pattern.matches("^\\d{2}", str);
        }
        return result;
    }
}

