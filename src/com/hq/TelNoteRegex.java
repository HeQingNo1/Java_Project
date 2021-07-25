package com.hq;

import java.util.Scanner;

/**
 * 数据校验类
 */
public class TelNoteRegex {
    /**
     * 对菜单输入选项的校验
     * @param min
     * @param max
     * @return
     */
    public int menuItemValidate(int min,int max){
        String regex = "\\d";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入正确数字，最小是："+min+" 最大是："+max);
            String input = scanner.nextLine();
            if(input.matches(regex)){
                int inputNum = Integer.parseInt(input);
                if(inputNum >= min && inputNum <= max ){
                    return inputNum;
                }else{
                    System.out.println("输入数字不符，请重新输入！");
                }
            }else{
                System.out.println("您输入的数字错误，请检查！");
            }
        }
    }

    /**
     * 对输入姓名的校验
     * 字母可以是大写或者小写，长度 1-10
     * @return
     */
    public String nameValidate(){
        String regex = "[a-zA-Z]{1,10}";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("请输入姓名,格式为：1-10个大写或小写字母");
            String input = scanner.nextLine();
            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println("您输入的姓名错误，请重新输入！");
            }
        }
    }

    /**
     * 对输入年龄的校验
     * 年龄格式要求：10-99之间的整数
     * @return
     */
    public String ageValidate(){
        String regex = "[1-9][0-9]?";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入年龄,年龄格式：10-99");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("您输入的年龄格式有误，请重新输入！");
            }
        }
    }

    /**
     * 对输入性别的校验
     * 性别的输入要求：男（m 或 M） 女（f 或 F）
     * @return
     */
    public String sexValidate(){
        String regex = "[m|M|f|F]";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入性别,性别格式：男(m 或 M) 女(f 或 F)");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("您输入的性别格式有误，请重新输入！");
            }
        }
    }

    /**
     * 对输入电话号码的校验
     * 电话号码要求：允许带有区号的座机号，允许手机号
     * @return
     */
    public String telNumValidate(){
        String regex = "(\\d{3,4}-\\d{7,8})|([1]\\d{10})";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入电话号码,可以是座机号或者是手机号:");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("您输入的电话号码格式有误，请重新输入！");
            }
        }
    }

    /**
     * 对输入地址的校验
     * 地址格式要求：字母或者数字，长度 1-50
     * @return
     */
    public String addressValidate(){
        String regex = "\\w{1,50}";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入地址,地址格式(字母或者数字，长度 1-50):");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("您输入的地址格式有误，请重新输入！");
            }
        }
    }
}
