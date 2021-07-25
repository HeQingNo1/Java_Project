package com.hq;

/**
 * 电话本项目入口类
 */
public class App {
    public static void main(String[] args) {
        /**
         * 启动电话本项目
         */
        App app = new App();
        app.start();
    }

    /**
     * 控制主菜单
     */
    public void start(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        Operate operate = new Operate();
        while(true){
            menu.mainMenu();
            int item = regex.menuItemValidate(1,6);
            switch (item){
                case 1:
                    operate.addLogic();
                    break;
                case 2:
                    operate.searchLogic();
                    break;
                case 3:
                    operate.modifyLogic();
                    break;
                case 4:
                    operate.deleteLogic();
                    break;
                case 5:
                    operate.orderLogic();
                    break;
                case 6:
                    operate.exit();
            }
        }
    }

}
